#!/usr/bin/env bash
set -euo pipefail

expected_version="${1:-2.0.3}"

pom_version="$(sed -n '/<artifactId>XianYuAssistant<\/artifactId>/{n;s/.*<version>\([^<]*\)<\/version>.*/\1/p;q;}' pom.xml)"
frontend_version="$(node -p "require('./vue-code/package.json').version")"
lock_version="$(node -p "require('./vue-code/package-lock.json').version")"
app_version="$(sed -n 's/^  version: *//p' src/main/resources/application.yaml | head -n 1)"

for entry in \
  "pom.xml:${pom_version}" \
  "vue-code/package.json:${frontend_version}" \
  "vue-code/package-lock.json:${lock_version}" \
  "application.yaml:${app_version}"; do
  file="${entry%%:*}"
  value="${entry#*:}"
  if [[ "${value}" != "${expected_version}" ]]; then
    echo "${file} version is '${value}', expected '${expected_version}'" >&2
    exit 1
  fi
done

grep -q "ARG APP_VERSION=${expected_version}" Dockerfile
grep -q 'FROM eclipse-temurin:21-jre-jammy AS java-runtime' Dockerfile
grep -q 'COPY --from=java-runtime /opt/java/openjdk /opt/java/openjdk' Dockerfile
grep -q 'ENV JAVA_HOME=/opt/java/openjdk' Dockerfile
grep -q 'ghcr.io/chloemlla/xianyuassistant' README.md install.sh

if grep -Eqi 'iamlzy/xianyuassistant|docker\.io/.+xianyuassistant|jdbc:sqlite|mybatis-plus|/app/dbdata' \
  README.md install.sh docs/technical-reference/0[1-5]-*.md; then
  echo "Legacy release channel or storage documentation remains" >&2
  exit 1
fi

echo "Release contract verified: GHCR, MongoDB, version ${expected_version}."
