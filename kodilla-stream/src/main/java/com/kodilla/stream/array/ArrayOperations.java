package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

     static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        double avgNum = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(0.0);
         return avgNum;
    }
}
