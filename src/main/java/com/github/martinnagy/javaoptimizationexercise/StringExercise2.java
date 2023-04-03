package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.time.StopWatch;

public class StringExercise2 {
    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe();
        System.out.println(stopWatch);
    }

    private static void optimizeMe() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 50_000_000; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i);
        }
        System.out.println(sb);
    }
}
