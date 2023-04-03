package com.github.martinnagy.javaoptimizationexercise;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

public class JoinExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Employee> employees = IntStream.range(0, 10_000_000)
                .mapToObj(i -> new Employee(i, random.nextInt(1_000)))
                .toList();
        List<Department> departments = IntStream.range(0, 1_000)
                .mapToObj(i -> new Department(i, "name" + i))
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(employees, departments);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Employee> employees, List<Department> departments) {
        for (Employee employee : employees) {
            for (Department department : departments) {
                if (employee.departmentId() == department.departmentId()) {
                    System.out.println(employee + "\t" + department);
                }
            }
        }
    }

    private record Employee(int employeeId, int departmentId) {
    }

    private record Department(int departmentId, String name) {
    }

}
