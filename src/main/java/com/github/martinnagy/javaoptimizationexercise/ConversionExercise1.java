package com.github.martinnagy.javaoptimizationexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

public class ConversionExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Dto> dtos = IntStream.range(0, 100_000)
                .mapToObj(i -> new Dto(randomLongString(random), randomLongString(random)))
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < 10_000; i++) {
            optimizeMe(dtos);
        }
        System.out.println(stopWatch);
    }

    private static List<Entity> optimizeMe(List<Dto> dtos) {
        List<Entity> entities = new ArrayList<>();
        for (Dto dto : dtos) {
            entities.add(new Entity(dto.firstName(), dto.lastName()));
        }
        return entities;
    }

    private static String randomLongString(Random random) {
        return StringUtils.repeat(random.nextInt(10) + "", 10);
    }

    private record Dto(String firstName, String lastName) {
    }

    private record Entity(String firstName, String lastName) {
    }

}
