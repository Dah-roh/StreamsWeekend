package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //Intermediate Stream Operation(MAP, FILTER, DISTINCT, FLATMAP)
        //Terminal Stream Operations(FOREACH, REDUCE, COLLECT, COUNT, MAX, MIN)

        System.out.println("Distinct Example: "+ Arrays.asList("java", "macbook", "notnull", "comprehension", "java", "macbook")
                .stream().distinct()
                .collect(Collectors.toList()));


        System.out.println("Filter example: "+ Arrays.asList("java", "macbook", "notnull", "comprehension", "java", "macbook")
                .stream().filter(el->el.length()<=4)
                .collect(Collectors.toList()));


        System.out.println("Count example: "+ Arrays.asList("java", "macbook", "notnull", "comprehension", "java", "macbook")
                .stream().distinct()
                .filter(el->el.length()<=4)
                .count());

//TODO: METHOD REFERENCING FOR FLATMAP EXAMPLE
//TODO: LAMBDA AS NAMELESS FUNCTIONS
        System.out.println("FlatMap example: "+ Arrays.asList(Arrays.asList("java", "macbook", "notnull"),
                Arrays.asList("comprehension", "java", "macbook"))
                .stream()
                .flatMap(array -> array.stream())
                        .distinct()
                .collect(Collectors.joining(", ")));


        System.out.println("Reduce example: "+ Arrays.asList(-1, 30, 50, 49, 12, 0)
                .stream()
                        .filter(el->el%2==0)
                .reduce((a, b )-> a+b)
                .get());


        System.out.println("Max example: "+ Arrays.asList(-1, 30, 50, 49, 12, 0)
                .stream()
                .max(Comparator.naturalOrder())
                .get());




        //Function<argument, return-type>
        Function<Integer, Boolean> prediFunction = num -> num>50;
        Predicate<Integer> predicate = num -> (num+50)>100;
        Function<List<String>, String> convertList = list-> {
           return list.stream()
                    .collect(Collectors.joining(", "));
        };
        Consumer<Integer> printValue = num-> System.out.println("This is our consumer value: "+ num);

        System.out.println("Predicate made with functional Interface example: "+prediFunction.apply(49));

        System.out.println("Predicate example: "+predicate.test(49));

        System.out.println("Stream in functional programming example: "+convertList.apply(Arrays.asList("java", "macbook", "notnull")));

        printValue.accept(100);

    }



}