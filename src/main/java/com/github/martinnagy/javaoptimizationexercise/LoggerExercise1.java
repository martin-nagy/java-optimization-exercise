package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.simple.SimpleLogger;

public class LoggerExercise1 {
    private static Logger log;

    public static void main(String[] args) {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");
        log = LoggerFactory.getLogger(LoggerExercise1.class);

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(2_000_000);
        System.out.println(stopWatch);
        System.clearProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY);
    }

    private static void optimizeMe(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += i;
            log.debug("added: " + i + ", squared average: " + heavy(i));
        }
        log.info("Sum: " + sum);
    }

    private static String heavy(int i) {
        return StringUtils.repeat(i + " ", 200);
    }

}
