package com.company;

public class Knapsack {

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

    public static int topDownKnapsack(int[] weights, int[] values, int W, int N, int dp[][]) {
        //if either one is 0 we cannot select any items hence 0
        if (N==0||W==0) return 0;
        //if we have the value of dp[N][W] then return that
        else if (dp[N][W]!=-1) return dp[N][W];
        //if the weight is less than capacity
        else if (weights[N-1]<=W)
            return max(topDownKnapsack(weights,values,W-1,N-1,dp),
                    values[N-1]+topDownKnapsack(weights,values,W-weights[N-1],N-1,dp));
        //if the weight cannot be added
        else return topDownKnapsack(weights,values,W-1,N-1,dp);
    }

    public static int optimizedKnapsack(int[] weights, int[] values, int W, int N, int dp[]) {
        //if either one is 0 we cannot select any items hence 0
        if (N==0||W==0) return 0;
            //if we have the value of dp[N][W] then return that
        else if (dp[W]!=-1) return dp[W];
            //if the weight is less than capacity
        else if (weights[N-1]<=W)
            return max(optimizedKnapsack(weights,values,W-1,N-1,dp),
                    values[N-1]+optimizedKnapsack(weights,values,W-weights[N-1],N-1,dp));
            //if the weight cannot be added
        else return optimizedKnapsack(weights,values,W-1,N-1,dp);
    }

    public static int bottomUpKnapsack(int[] weights, int[] values, int capacity) {

        int dp[][] = new int[weights.length+1][capacity+1];

        for (int i=0; i<=weights.length; i++) {
            for (int w=0; w<=capacity; w++) {
                //first row and column will be 0
                if (i==0||w==0) dp[i][w]=0;
                //can check for addition of current item when its weight is less than weight in consideration
                else if (weights[i-1]<=w) {
                    dp[i][w]=max(dp[i-1][w-1], dp[i-1][w-weights[i-1]]+values[i-1]);
                }
                //ignore item!
                else {
                    dp[i][w]=dp[i-1][w];
                }
            }
        }

        return dp[weights.length][capacity];
    }
}
