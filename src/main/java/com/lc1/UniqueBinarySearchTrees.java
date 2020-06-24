package com.lc1;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n==0||n==1) return 1;
        int c=0;
        for(int i=1;i<=n;i++){
            c+=numTrees(i-1)*numTrees(n-i);
        }
        return c;
    }
    //fastest
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
