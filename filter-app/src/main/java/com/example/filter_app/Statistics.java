package com.example.filter_app;

import java.util.List; 

public class Statistics {
    public void displayStatistics(List<Integer> integers, List<Float> floats, List<String> strings, boolean shortStats, boolean fullStats) {
        if (shortStats || fullStats) {
            System.out.println("Short Statistics:"); 
            System.out.println("Integers: " + integers.size()); 
            System.out.println("Floats: " + floats.size()); 
            System.out.println("Strings: " + strings.size()); 
        }

        if (fullStats) {
            displayFullStatistics(integers, floats, strings); 
        }
    }

    private void displayFullStatistics(List<Integer> integers, List<Float> floats, List<String> strings) {
        if (!integers.isEmpty()) {
            int max = integers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE); 
            int min = integers.stream().min(Integer::compare).orElse(Integer.MAX_VALUE); 
            double average = integers.stream().mapToInt(Integer::intValue).average().orElse(0); 
            int sum = integers.stream().mapToInt(Integer::intValue).sum(); 

            System.out.println("Full Statistics for Integers:");
            System.out.println("Count: " + integers.size());
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        }

        if (!floats.isEmpty()) {
            float max = floats.stream().max(Float::compare).orElse(Float.NEGATIVE_INFINITY);
            float min = floats.stream().min(Float::compare).orElse(Float.POSITIVE_INFINITY);
            double average = floats.stream().mapToDouble(Float::floatValue).average().orElse(0);
            float sum = (float) floats.stream().mapToDouble(Float::floatValue).sum();

            System.out.println("Full Statistics for Floats:");
            System.out.println("Count: " + floats.size());
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        }

        if (!strings.isEmpty()) {
            int minLength = strings.stream().mapToInt(String::length).min().orElse(0); 
            int maxLength = strings.stream().mapToInt(String::length).max().orElse(0); 

            System.out.println("Full Statistics for Strings:");
            System.out.println("Count: " + strings.size());
            System.out.println("Min Length: " + minLength);
            System.out.println("Max Length: " + maxLength);
        }
    }
}