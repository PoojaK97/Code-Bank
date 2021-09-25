package com.company;

public class LongestCommonSubsequence {

    public static int lcs(char[] a, int m, char[] b, int n, int dp[][]) {
        if (dp[m][n]!=-1) return dp[m][n];
        else if (m==0||n==0) dp[m][n]=0;
        else if (a[m-1]!=b[n-1]) {
            dp[m][n]=new UtilityFunctions().max(
                    lcs(a, m-1, b, n, dp), lcs(a, m, b, n-1, dp));
        }
        else dp[m][n]=1+lcs(a, m-1, b, n-1, dp);
        return dp[m][n];
    }
}
