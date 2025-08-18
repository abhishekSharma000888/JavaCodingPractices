package practice02;

import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;

public class SortingTwoArrays {

    public static void main(String[] args) {

        int[] arr1 = {7, -5, 3, 8, -4, 11, -19, 21};
        int[] arr2 = {6, 13, -7, 0, -4, 3, -5};

        List<Integer> l1 = Stream.concat(Arrays.stream(arr1).boxed(),
                        Arrays.stream(arr2).boxed())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("The elements are removing the duplicates are: ");

        System.out.println(l1);

        int smallest = l1.getLast();
        int largest = l1.size()>0 ? l1.get(0) : l1.getLast();
        int secondLargest = l1.size()>1 ? l1.get(1) : l1.getLast();

        System.out.println("Smallest is: "+ smallest);
        System.out.println("Largest is: "+ largest);
        System.out.println("Second largest is: "+ secondLargest);

    }
}
