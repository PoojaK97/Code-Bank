package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UtilityFunctions ul = new UtilityFunctions();

        //Subset Problem

        int[] array = ul.inputArray(sc);
        int sum = sc.nextInt();

        SubsetProblem sP = new SubsetProblem();

        System.out.println(sP.subsetProblem(array, sum, array.length-1, ul.initializeDP(array.length-1, sum, -1)));

        /**
        //Longest Common Subsequence

        String first = sc.next();
        String second = sc.next();
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        System.out.println(lcs.lcs(a, a.length, b, b.length, ul.initializeDP(a.length, b.length, -1)));
        **/

        /**
        //Knapsack 0/1

        int[] weight_elements = ul.inputArray(sc);
        int[] weight_values = ul.inputArray(sc);
        int capacity = sc.nextInt();

        ul.printArray("Weight Elements",weight_elements);
        ul.printArray("Weight Values",weight_values);
        System.out.println(capacity);

        Knapsack obj = new Knapsack();

        //Print the value of Knapsack Bottom-Up Approach
        System.out.println( '\n'+
                obj.bottomUpKnapsack(
                        weight_elements,
                        weight_values,
                        capacity
                )
        );

        //Print the value of Knapsack Top-Down Approach
        System.out.println( '\n'+
                obj.topDownKnapsack(
                        weight_elements,
                        weight_values,
                        capacity,
                        weight_elements.length,
                        ul.initializeDP(weight_elements.length, capacity, -1)
                )
        );

        //Print the value of Knapsack Bottom Up Approach with Optimized space complexity
        System.out.println( '\n'+
                obj.optimizedKnapsack(
                        weight_elements,
                        weight_values,
                        capacity,
                        weight_elements.length,
                        ul.initializeSingleDP(capacity, -1)
                )
        );
         **/
   }
}
