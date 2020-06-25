package com.lc1;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int a,b;
        a=nums[0];
        b = nums[nums[0]];
        while(a!=b){
            a= nums[a];
            b= nums[nums[b]];
        }
        b=0;
        while(a!=b){
            a=nums[a];
            b=nums[b];
        }
        return b;
    }
    //best memory
    public int findDuplicate2(int[] nums) {
        int pos = 0;
        while (pos < nums.length) {
            if (pos + 1 == nums[pos]) {
                pos++;
            } else {
                if (pos + 1 > nums[pos] || nums[pos] == nums[nums[pos] - 1]) {
                    break;
                } else {
                    swap(nums, pos, nums[pos] - 1);
                }
            }
        }
        return nums[pos];
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
