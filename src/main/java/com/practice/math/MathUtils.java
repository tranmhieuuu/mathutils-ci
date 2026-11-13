package com.practice.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Cac phep toan co ban, tai su dung tu Bai 1. */
public final class MathUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathUtils.class);

    private MathUtils() {
        // Lop tien ich khong can tao doi tuong.
    }

    /** Cong hai so nguyen. */
    public static int add(int a, int b) {
        int result = a + b;
        LOGGER.info("operation=add a={} b={} result={}", a, b, result);
        return result;
    }

    /** Tru hai so nguyen. */
    public static int subtract(int a, int b) {
        int result = a - b;
        LOGGER.info("operation=subtract a={} b={} result={}", a, b, result);
        return result;
    }

    /** Chia nguyen, nem ngoai le neu mau so bang 0. */
    public static int divide(int a, int b) {
        if (b == 0) {
            LOGGER.warn("operation=divide status=rejected reason=division_by_zero a={}", a);
            throw new IllegalArgumentException("Khong the chia cho 0");
        }
        int result = a / b;
        LOGGER.info("operation=divide a={} b={} result={}", a, b, result);
        return result;
    }
}
