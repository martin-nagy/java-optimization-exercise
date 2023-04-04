package com.github.martinnagy.javaoptimizationexercise;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

public class MinMaxExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Integer> numbers = IntStream.range(0, 100_000_000)
                .mapToObj(i -> random.nextInt())
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(numbers);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Integer> numbers) {
        System.out.println("Min: " + numbers.stream().mapToInt(Integer::intValue).min().orElseThrow());
        System.out.println("Max: " + numbers.stream().mapToInt(Integer::intValue).max().orElseThrow());
    }

}
