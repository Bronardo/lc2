package com.lc1;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
//        if(m==0||n==0) return 0;
        return (int)(factorial((m-1)+(n-1))/(factorial((m-1)+(n-1)-(n-1))*factorial(n-1)));
    }
    public static long factorial(int n){
        long fac=1;
        for(int i=1;i<=n;i++){
            fac*=i;
        }
        return fac;
    }
    //try recursive
    public int uniquePaths2(int m, int n) {
        if(m==1||n==1) return 1;
        return uniquePaths2(m-1,n)+uniquePaths2(m,n-1);
    }
    //try dp
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) {
                    dp[i][j] =1;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //an upgrade of math method best memory
    int uniquePaths4(int m, int n) {
        int N = m + n - 2;
        int k = n - 1;

        double res = 1;
        for (int i=1; i<=k; i++) {
            res = res * (N-k+i)/i;
        }
        return (int)res;
    }
}
