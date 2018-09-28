package com.higgsup.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {

        //filter
        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            myList.add(i);
        }

        Stream<Integer> sequentialStream = myList.stream();

        Stream<Integer> highNums = sequentialStream.filter(n -> n > 90);

        System.out.print("High Nums greater than 90 = ");
        highNums.forEach(n -> System.out.print(n + " "));

        //map
        Stream<String> names = Stream.of("aBc", "d", "ef", "123456");
        System.out.println();
        System.out.println(names.map(String::toUpperCase).collect(Collectors.toList()));

        //reduce

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> intOptional = numbers.reduce((i,j) -> i*j);
        intOptional.ifPresent(integer -> System.out.println("Multiplication = " + integer));

        //match: anyMatch, allMatch, noneMatch

        Stream<Integer> numbers3 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains 4? " + numbers3.anyMatch(i -> i == 4));

        Stream<Integer> numbers4 = Stream.of(1,2,3,4,5);
        System.out.println("Stream contains all elements less than 10? "+ numbers4.allMatch(i -> i > 6));

        Stream<Integer> numbers5 = Stream.of(1,2,3,4,5);
        System.out.println("Stream doesn't contain 10? "+numbers5.noneMatch(i -> i==10));

        //findFirst()
        Stream<String> names4 = Stream.of("Pankaj","Amit","David", "Lisa");
        Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();

        firstNameWithD.ifPresent(String -> System.out.println(firstNameWithD.get()));

        //distinct
        List<Integer> numberList = Arrays.asList(1, 2, 3, 3, 5, 1, 7, 2);
        System.out.println("Before distinct: " + numbers);

        List<Integer> results = numberList.stream().distinct().collect(Collectors.toList());
        System.out.println("Result of distinct: " + results);

        //limit
        List<Integer> numberList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> resultList = numberList1.stream().filter(i -> {
            System.out.println("Filter: " + i);
            return i > 4;
        }).limit(3).collect(Collectors.toList());

        System.out.println("Result of limit: " + resultList);

        //skip

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList1 = numbers1.stream().filter(i -> {
            System.out.println("Filter: " + i);
            return i > 4;
        }).skip(2).collect(Collectors.toList());

        System.out.println("Result of skip: " + resultList1);

    }
}
