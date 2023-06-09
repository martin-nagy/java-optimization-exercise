package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.time.StopWatch;

public class StringExercise1 {
    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe();
        System.out.println(stopWatch);
    }

    private static void optimizeMe() {
        String string = "";
        for (int i = 0; i < 100_000; i++) {
            if (i > 0) {
                string += ", ";
            }
            string += i;
        }
        System.out.println(string);
    }
}
