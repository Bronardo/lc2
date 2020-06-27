package com.lc1;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp= new int[n+1];
        dp[0] = 0;
        int min = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                min = Math.min(min,dp[i-j*j]+1);
            }
            dp[i]=min;
            min=Integer.MAX_VALUE;
        }
        return dp[n];
    }
}
