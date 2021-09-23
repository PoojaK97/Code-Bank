package com.company;

import java.util.Scanner;

public class Main {

    public static void printArray(String arrayName, int array[]) {
        System.out.println("\n"+arrayName+"\n");
        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]+" ");
        }
        System.out.println("\n");
    }

    public static int[] inputArray(Scanner sc) {
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        int[] array = new int[tokens.length];
        for (int i=0; i< array.length; i++)
            array[i]=Integer.parseInt(tokens[i]);
        return array;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Knapsack 0/1
        //Read input
        int[] weight_elements = inputArray(sc);
        int[] weight_values = inputArray(sc);
        int capacity = sc.nextInt();
        //Verify input is taken correctly
        printArray("Weight Elements",weight_elements);
        printArray("Weight Values",weight_values);
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
                        obj.initializeDP(weight_elements.length, capacity, -1)
                )
        );
        //Print the value of Knapsack Bottom Up Approach with Optimized space complexity
        System.out.println( '\n'+
                obj.optimizedKnapsack(
                        weight_elements,
                        weight_values,
                        capacity,
                        weight_elements.length,
                        obj.initializeSingleDP(capacity, -1)
                )
        );
    }
}
