package ru.kostyanetskiy.practice.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringPractice {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task3_1();
    }

    /**
     * Подсчет повторяющихся символов. Написать программу, которая
     * подсчитывает повторяющиеся символы в заданной строке.
     */
    public static void task1() {
        String testString = "gfjskkeh352s353gfg5es";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : testString.toCharArray()) {
            Integer integer = map.get(c);
            if (integer == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++integer);
            }
        }
        System.out.println(map);
    }

    /**
     * Отыскание первого неповторяющегося символа. Написать программу,
     * которая возвращает первый неповторяющийся (некратный) символ в заданной строке.
     */
    public static void task2() {
        String testString = "gfjskkeh352s353gfg5es";
        Character first;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : testString.toCharArray()) {
            Integer integer = map.get(c);
            if (integer == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++integer);
            }
        }
        first = map.entrySet().stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1)
                .findFirst()
                .get().getKey();
        System.out.println(first);
    }

    /**
     * Инвертирование букв и слов. Написать программу, которая инвертирует
     * буквы каждого слова, и программу, которая инвертирует буквы каждого слова и
     * сами слова.
     */
    public static void task3() {
        String testString = "Get arrays";
        String collect = Stream.of(testString.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    /**
     * Инвертирование букв и слов. Написать программу, которая инвертирует
     * буквы каждого слова, и программу, которая инвертирует буквы каждого слова и
     * сами слова.
     */
    public static void task3_1() {
        String testString = "Get arrays";
        String collect = Stream.of(testString.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));

        StringBuilder sb = new StringBuilder();
        String[] strings = collect.split(" ");

        for (int i = strings.length - 1; i > -1; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.deleteCharAt(collect.length());

        System.out.println(sb);
    }
}
