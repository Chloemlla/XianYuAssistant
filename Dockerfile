# syntax=docker/dockerfile:1
# ===== 多阶段构建 =====

ARG APP_VERSION=2.0.3

# 阶段1: 构建前端
FROM node:20-alpine AS frontend-build

WORKDIR /app/vue-code

# 设置 npm 镜像源
RUN npm config set registry https://registry.npmmirror.com

# 先复制依赖文件，利用缓存
COPY vue-code/package.json vue-code/package-lock.json ./
RUN npm ci

# 复制前端源码并构建
COPY vue-code/ ./
RUN npm run build:spring

# 阶段2: 构建后端 JAR
FROM eclipse-temurin:21-jdk-alpine AS backend-build

ARG APP_VERSION

WORKDIR /app

# 配置阿里云 Maven 镜像
RUN mkdir -p /root/.m2 && echo '<?xml version="1.0" encoding="UTF-8"?><settings xmlns="http://maven.apache.org/SETTINGS/1.2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd"><mirrors><mirror><id>aliyun</id><mirrorOf>central</mirrorOf><name>Aliyun Maven</name><url>https://maven.aliyun.com/repository/public</url></mirror></mirrors></settings>' > /root/.m2/settings.xml

# 先复制 Maven 配置和 pom.xml，利用缓存
COPY .mvn/ .mvn/
COPY mvnw mvnw.cmd pom.xml ./
RUN chmod +x mvnw

# 复制后端源码
COPY src/ src/

# committed static 不是发布制品来源；只保留本次前端构建结果
RUN rm -rf src/main/resources/static && mkdir -p src/main/resources/static
COPY --from=frontend-build /app/src/main/resources/static/ src/main/resources/static/
RUN test -f src/main/resources/static/index.html

# 构建 JAR（跳过测试）
RUN ./mvnw clean package -DskipTests && \
    test -f "target/XianYuAssistant-${APP_VERSION}.jar" && \
    cp "target/XianYuAssistant-${APP_VERSION}.jar" target/app.jar

# 阶段3: 运行时镜像
FROM mcr.microsoft.com/playwright/java:v1.40.0-jammy

ARG APP_VERSION

LABEL maintainer="IAMLZY"
LABEL description="XianYuAssistant - 闲鱼自动化管理系统"
LABEL org.opencontainers.image.version="${APP_VERSION}"
LABEL org.opencontainers.image.source="https://github.com/Chloemlla/XianYuAssistant"

WORKDIR /app

# 官方 Playwright 运行镜像已包含与 Java 依赖同版本的 Chromium 及系统库。
# 应用固定从 JAR 同目录的 ms-playwright 查找浏览器，因此建立稳定链接。
RUN mkdir -p /app/logs && \
    ln -s /ms-playwright /app/ms-playwright && \
    test -d /ms-playwright

# 从构建阶段复制 JAR
COPY --from=backend-build /app/target/app.jar app.jar

# 暴露端口
EXPOSE 12400

# 环境变量
ENV JAVA_OPTS="-Xms256m -Xmx512m"
ENV SERVER_PORT=12400
ENV ALI_API_KEY=""
ENV SPRING_DATA_MONGODB_URI="mongodb://mongo:27017/xianyu_assistant"

# 启动命令
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Dserver.port=${SERVER_PORT} -jar app.jar"]
