# Huong dan chung minh GitHub Actions CI (DIEN MINH CHUNG THUC TE)

## A. Kich hoat workflow thanh cong
1. Tao repository GitHub (vi du `mathutils-ci`).
2. Push NOI DUNG cua `Bai03` len repo root, bao gom `.github/workflows/ci.yml`.
3. Vao tab **Actions** -> chon run gan nhat.
4. Kiem tra cac step `Test with Maven`, `Package JAR with Maven`,
   `Verify JAR exists...` va `Upload JAR artifact` mau xanh.
5. O cuoi trang run, tai artifact `mathutils-ci-jar`. Xem trong ZIP co
   `mathutils-ci-1.0-SNAPSHOT.jar`.
6. Luu anh chup trang run thanh cong va artifact.

## B. Co tinh tao loi TEST de kiem tra CI (lam tren branch rieng)
1. Tao branch rieng: `git switch -c ci-fail-demo`.
2. Mo `src/test/java/com/practice/math/MathUtilsTest.java`.
3. Trong `testAdd()`, doi:

       assertEquals(15, MathUtils.add(10, 5));

   thanh:

       assertEquals(999, MathUtils.add(10, 5));

4. `git add . && git commit -m "test: demonstrate CI test failure" && git push -u origin ci-fail-demo`
5. Vao GitHub -> tab Actions -> run do, mo job `build` -> step `Test with Maven`.
   Du kien: assertion failure (expected 999, actual 15), job that bai.
6. Chup anh run do va doan log `Failures: 1` / `BUILD FAILURE`.

**Luu y:** Day la KET QUA DU KIEN, khong phai log da chay that.

## C. Sua loi va chung minh CI phuc hoi
1. Doi `assertEquals(999, ...)` ve `assertEquals(15, ...)`.
2. `git add . && git commit -m "fix: restore expected test result" && git push`
3. Vao tab Actions, kiem tra run moi thanh cong.
4. Chup anh run xanh, xem artifact trong phan Artifacts.

## D. Bao cao ngan (dien sau khi co run thuc)
- Link repository GitHub: [dien tai day]
- Link CI run thanh cong: [dien tai day]
- Link CI run that bai: [dien tai day]
- Nguyen nhan: Gia tri mong doi sai (999 thay vi 15) trong testAdd.
- Cach debug: Mo Actions -> job build -> step Test with Maven, doc log
  assertEquals expected/actual va vi tri MathUtilsTest.java.
- Cach sua: Tra lai gia tri mong doi = 15 va push lai.
- Link CI run thanh cong sau khi sua: [dien tai day]
- Anh minh chung: [chen anh that tu tai khoan GitHub cua ban]

Khong nen co tinh lam sai branch main. Dung branch `ci-fail-demo` va dong bo
cac thay doi sau khi da thu xong.
