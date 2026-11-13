package com.practice.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/** Chuong trinh demo cho bai CI/CD. */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private Main() {
    }

    public static void main(String[] args) {
        MDC.put("module", "MathUtils");
        try {
            LOGGER.info("event=app_start");
            int sum = MathUtils.add(10, 5);
            int difference = MathUtils.subtract(10, 5);
            int quotient = MathUtils.divide(10, 2);
            LOGGER.info("event=calculation_summary sum={} difference={} quotient={}",
                    sum, difference, quotient);
            LOGGER.info("event=app_finish status=success");
        } finally {
            MDC.clear();
        }
    }
}
