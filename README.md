# Bai 3 - CI/CD Automation (MathUtils)

## 1. Y tuong
Tai su dung cac ham `add`, `subtract`, `divide` tu Bai 1 de tao project Maven.
Su dung SLF4J 2.0.9 + Logback 1.4.11 de ghi log va JUnit Jupiter 5.9.2
voi 5 test. Workflow GitHub Actions tu dong kiem tra test, package va upload JAR.

## 2. Cau truc
- `pom.xml`: dependency, plugin compile/test/package.
- `src/main/java/com/practice/math/`: Java source.
- `src/main/resources/logback.xml`: cau hinh logging.
- `src/test/java/com/practice/math/`: JUnit tests.
- `.github/workflows/ci.yml`: CI workflow.
- `run.sh`: chay tren Linux hoac Git Bash (can JAR trong `lib`).
- `docs/CI_EVIDENCE.md`: huong dan tao chung cu build that bai / sua loi.

## 3. Build local tren IntelliJ
Mo thu muc Bai03 duoi dang Maven project. Dung `Execute Maven Goal` lan luot:

    clean test
    package
    dependency:copy-dependencies

Ket qua mong doi: `Tests run: 5, Failures: 0, Errors: 0, Skipped: 0`, `BUILD SUCCESS`.
File dau ra: `target/mathutils-ci-1.0-SNAPSHOT.jar`.

Chay file `run.sh` sau khi da co lib/*.jar:

    bash run.sh

Tren Linux, neu can:

    chmod +x run.sh
    ./run.sh

## 4. GitHub Actions
**Rat quan trong:** de workflow hoat dong, thu muc `.github` phai nam ngay
thu muc GOC repository GitHub. Cach de nhat: day NOI DUNG Bai03 len repo moi
(chu khong day thu muc cha Week9). Khi do:

    repo-root/
      .github/workflows/ci.yml
      pom.xml
      src/
      run.sh

Workflow duoc kich hoat tren `push` va `pull_request`.
Tren may GitHub (Ubuntu + Temurin JDK 25):
1. `mvn clean test`
2. `mvn package`
3. Xac nhan JAR ton tai va co 2 file class.
4. `upload-artifact` luu JAR thanh artifact `mathutils-ci-jar`.

GitHub Maven khong can file lib/ do Maven tu tai dependency.

## 5. Logging
- INFO: phep tinh thanh cong; bat dau/ket thuc chuong trinh.
- WARN: dau vao sai (chia cho 0).
- Du lieu log: thao tac, dau vao, ket qua, status/reason (khong co du lieu nhay cam).

## 6. Chung minh CI phat hien loi
Doc `docs/CI_EVIDENCE.md` de tao commit co test sai tren BRANCH RIENG,
cap nhat GitHub, chup execution logs that bai va sua de build xanh lai.

## 7. Nop bai
Voi JDK 25 va quy dinh giao vien chi chay `./run.sh`, can:
- Copy cac JAR runtime vao `lib/` truoc khi zip.
- Giu `pom.xml`, `src/`, `run.sh`, `lib/`, `.github/`, `docs/`, `README.md`.
- Trinh bay minh chung CI tren GitHub (link run + anh log thuc te).
- `chmod +x run.sh` / `git update-index --chmod=+x run.sh` neu can.
- Khong dua `.idea`, `target`, `build` vao ZIP.

**Luu y:** File jar `target/mathutils-ci-1.0-SNAPSHOT.jar` la JAR thong thuong,
khong bao gom Logback; vi vay chay `java -jar ...` mot minh khong du.
Dung `run.sh` voi `lib/` nhu tren.
