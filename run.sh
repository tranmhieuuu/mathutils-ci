#!/usr/bin/env bash
set -euo pipefail

# Ho tro Git Bash Windows va Linux. Khong can Maven khi da co cac JAR trong lib/.
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT_DIR"

if ! ls lib/*.jar >/dev/null 2>&1; then
    echo "ERROR: Thieu cac thu vien .jar trong lib/."
    echo "Hay chay Maven goal dependency:copy-dependencies truoc khi nop."
    exit 1
fi

mkdir -p build
javac --release 11 -encoding UTF-8 -cp "lib/*" -d build \
    src/main/java/com/practice/math/*.java

if [[ "${OSTYPE:-}" == msys* || "${OSTYPE:-}" == cygwin* ]]; then
    CP="build;lib/*;src/main/resources"
else
    CP="build:lib/*:src/main/resources"
fi

java -Dfile.encoding=UTF-8 -cp "$CP" com.practice.math.Main
