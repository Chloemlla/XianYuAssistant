#!/usr/bin/env bash
# XianYuAssistant GHCR installer (release 2.0.3)

set -euo pipefail

IMAGE="${IMAGE:-ghcr.io/chloemlla/xianyuassistant:latest}"
CONTAINER_NAME="${CONTAINER_NAME:-xianyu-assistant}"
INSTALL_DIR="${INSTALL_DIR:-${HOME}/xianyu-assistant}"
PORT="${PORT:-12400}"
MONGODB_URI="${MONGODB_URI:-}"
JAVA_OPTS="${JAVA_OPTS:--Xms256m -Xmx512m}"
ENV_FILE="${INSTALL_DIR}/xianyu-assistant.env"

fail() {
  printf '安装失败: %s\n' "$1" >&2
  exit 1
}

random_secret() {
  if command -v openssl >/dev/null 2>&1; then
    openssl rand -base64 48 | tr -d '\n'
    return
  fi
  if command -v python3 >/dev/null 2>&1; then
    python3 -c 'import secrets; print(secrets.token_urlsafe(48))'
    return
  fi
  fail "需要 openssl 或 python3 生成安全密钥"
}

command -v docker >/dev/null 2>&1 || fail "请先安装 Docker 20.10 或更高版本"
docker info >/dev/null 2>&1 || fail "Docker daemon 不可用，或当前用户无访问权限"

if [ -z "${MONGODB_URI}" ]; then
  fail "必须设置 MONGODB_URI，例如 mongodb://host.docker.internal:27017/xianyu_assistant"
fi

mkdir -p "${INSTALL_DIR}/logs"
chmod 700 "${INSTALL_DIR}"

JWT_SECRET="${JWT_SECRET:-$(random_secret)}"
BOOTSTRAP_TOKEN="${BOOTSTRAP_TOKEN:-$(random_secret)}"

cat >"${ENV_FILE}" <<EOF
JAVA_OPTS=${JAVA_OPTS}
SERVER_PORT=12400
SPRING_DATA_MONGODB_URI=${MONGODB_URI}
JWT_SECRET=${JWT_SECRET}
BOOTSTRAP_TOKEN=${BOOTSTRAP_TOKEN}
EOF
chmod 600 "${ENV_FILE}"

printf '正在拉取 %s\n' "${IMAGE}"
docker pull "${IMAGE}"

if docker container inspect "${CONTAINER_NAME}" >/dev/null 2>&1; then
  docker rm -f "${CONTAINER_NAME}" >/dev/null
fi

docker run -d \
  --name "${CONTAINER_NAME}" \
  --restart unless-stopped \
  --add-host host.docker.internal:host-gateway \
  --env-file "${ENV_FILE}" \
  -p "${PORT}:12400" \
  -v "${INSTALL_DIR}/logs:/app/logs" \
  "${IMAGE}" >/dev/null

cat <<EOF
XianYuAssistant 已启动。
访问地址: http://localhost:${PORT}
镜像渠道: ${IMAGE}
环境文件: ${ENV_FILE}（权限 600，请勿提交或分享）
首次注册需要 BOOTSTRAP_TOKEN；可在环境文件中查看。初始化完成后请删除该行并重建容器。
MongoDB 业务数据不在应用容器内，请单独备份 ${MONGODB_URI} 对应的数据库。
查看日志: docker logs -f ${CONTAINER_NAME}
EOF
