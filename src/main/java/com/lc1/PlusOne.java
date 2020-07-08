package com.lc1;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int i =n-1;i>=0;i--){
            int sum = digits[i]+carry;
            if(sum>9){
                digits[i] = 0;
                carry =1;
            }else{
                digits[i] = sum;
                carry=0;
            }
        }
        if(carry==1){
            int[] digits2 = new int[n+1];
            for(int i=1;i<=n;i++){
                digits2[i]= digits[i-1];
            }
            digits2[0]=1;
            digits = digits2;
        }
        return digits;
    }
}
