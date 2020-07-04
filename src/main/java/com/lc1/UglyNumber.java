package com.lc1;

import java.util.LinkedList;
import java.util.List;

public class UglyNumber {
    public int nthUglyNumber(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        int by2,by3,by5;
        by2=by3=by5=0;
        boolean f2,f3,f5;
        for(int i=2;i<=n;i++){
            f2=f3=f5=true;
            for(int a:list){
                int cur = list.get(i-2);
                if(f2 && a*2>cur){
                    by2=a*2;
                    f2=false;
                }
                if(f3 && a*3>cur){
                    by3=a*3;
                    f3=false;
                }
                if(f5 && a*5>cur){
                    by5=a*5;
                    f5=false;
                }
                if(!f2&&!f3&&!f5){
                    list.add(Math.min(by2,Math.min(by3,by5)));
                    break;
                }
            }
        }
        return list.get(n-1);
    }
    //Fastest solution using an Ugly class
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber2(int n) {

        return ugly.nums[n-1];

    }
}

class Ugly {

    int[] nums;

    public Ugly(){
        nums = new int[1690];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for(int i=1;i<1690;i++){

            nums[i] = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);

            if(nums[i]==nums[i2]*2) i2++;
            if(nums[i]==nums[i3]*3) i3++;
            if(nums[i]==nums[i5]*5) i5++;
        }
    }

}