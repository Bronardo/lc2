package com.lc1;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid==null) return 0;
        int m = grid.length;
        if(m==0) return 0;
        int start=0;
        while(onesNParts(grid[start])[0]==0){
            start++;
        }
        int[] a;
        a = onesNParts(grid[start]);
        int c= 2*a[0]+2*a[1];
        for(int i=start+1;i<m;i++){
            a = onesNParts(grid[i]);
            if(a[0]==0) break;
            c=c+2*a[0]+2*a[1] - 2*overlaps(grid[i],grid[i-1]);
        }

        return c;
    }
    //ones & parts
    public int[] onesNParts(int[] line){
        int[] c = {0,0};
        boolean inOnes = false;
        for(int i: line){
            if(i==1){
                c[0]++;
                if(!inOnes){
                    inOnes = true;
                    c[1]++;
                }
            }else if(inOnes){
                inOnes = false;
            }

        }
        return c;
    }
    public int overlaps(int[] a, int[] b){
        int c=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==1 && b[i]==1) c++;
        }
        return c;
    }

    public int islandPerimeter2(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    c+=4;
                    if(i<grid.length-1&& grid[i+1][j]==1) c-=2;
                    if(j<grid[0].length-1&& grid[i][j+1]==1) c-=2;
                }
            }
        }
        return c;
    }
}
