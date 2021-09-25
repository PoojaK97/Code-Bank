package com.company;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class SubsetProblem {

    public static int subsetProblem(int array[], int sum, int n, int dp[][]){
        if (sum==0) return 1;
        else if (n<0 || sum<0) return 0;
        else if (dp[n][sum]!=-1) return dp[n][sum];
        else if (array[n]>sum) dp[n][sum] = 0;
        else if (array[n]==sum) dp[n][sum] = 1;
        else {
            if (subsetProblem(array, sum, n-1,dp) == 1 || subsetProblem(array, sum-array[n], n-1, dp) == 1) {
                dp[n][sum] = 1;
            }
            else dp[n][sum] = 0;
        }
        return dp[n][sum];
    }
}
