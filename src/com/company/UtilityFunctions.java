package com.company;

import java.util.Scanner;

public class UtilityFunctions {

    public static int max(int a, int b) {
        return (a>b)?a:b;
    }

    public static int[][] initializeDP(int x, int y, int val) {
        int[][] dp = new int[x+1][y+1];
        for (int i=0; i<=x; i++)
            for (int j=0; j<=y; j++)
                dp[i][j]=val;
        return dp;
    }

    public static int[] initializeSingleDP(int x, int val) {
        int[] dp = new int[x+1];
        for (int i=0; i<=x; i++)
            dp[i]=val;
        return dp;
    }

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

}
