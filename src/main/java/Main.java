package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Chalauri-G on 5/9/2017.
 */
public class Main {
    public static void main(String[] args) {
        collectors();
    }

    private static void printRandomNumbers() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    private static void mapExample() {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 9, 7, 6, 1, 2, 6, 7);
        List<Integer> squaresList = numbers.stream().map(i -> i * i)
                .distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);
    }

    private static void countEmptyStrings() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();
    }


    private static void countEmptyStringsParallel() {
        List<String> strings =
                Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.parallelStream()
                .filter(string -> string.isEmpty()).count();
    }

    private static void collectors() {
        List<String> strings =
                Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

}
