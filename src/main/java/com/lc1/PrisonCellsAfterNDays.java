package com.lc1;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14 == 0 ? 14 : N % 14;
        byte b = 0b1111111;
        int n= cells.length;
        int[] cells2 = new int[n];
        boolean odd = true;
        for(int i=0;i<N;i++){
            for(int j=1;j<n-1;j++){
                if(odd){
                    if(cells[j-1]==cells[j+1]){
                        cells2[j]=1;
                    }else{
                        cells2[j]=0;
                    }
                }else{
                    if(cells2[j-1]==cells2[j+1]){
                        cells[j]=1;
                    }else{
                        cells[j]=0;
                    }
                }
            }
            if(i==1){
                cells[0]=0;
                cells[n-1]=0;
            }
            odd=!odd;
        }

        return odd? cells:cells2;
    }
}
