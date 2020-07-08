package com.lc1;

import java.util.*;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        nums=reduce(nums);
        int n = nums.length;
        if(n<3) return ans;
        Arrays.sort(nums);
        Set<String> checker = new HashSet<>();
        for(int i =0;i<n-2;i++){
            if(nums[i]>0) break;
            for(int j=i+1;j<n-1;j++){
                if(nums[i]+nums[j]>0) break;
                int k = Arrays.binarySearch(nums,j+1,n,0-nums[i]-nums[j]);
                if(k>0){
                    if(checker.contains(nums[i]+","+nums[j]+","+nums[k])) continue;
                    List<Integer> list= new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    checker.add(nums[i]+","+nums[j]+","+nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public int[] reduce(int[] a){
        HashMap<Integer,Integer> s = new HashMap<>();
        int c = 0;
        for(int i:a){
            if(s.containsKey(i)){
                if(s.get(i)<2){
                    s.replace(i,2);
                    c++;
                }else if(i==0 && s.get(i)<3){
                    s.replace(i,3);
                    c++;
                }
            }else{
                s.put(i,1);
                c++;
            }
        }
        a = new int[c];
        c=0;
        for(int i :s.keySet()){
            for(int j=0;j<s.get(i);j++){
                a[c++] = i;
            }
        }
        return a;
    }
    //a fast soulution
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) minValue = v;
            if (v > maxValue) maxValue = v;
            if (v > 0) posSize++;
            else if (v < 0) negSize++;
            else zeroSize++;
        }
        if (zeroSize >= 3) res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0) return res;
        if (minValue * 2 + maxValue > 0) maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0) minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) /2;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }
}

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new LinkedList<>();
//        nums=reduce(nums);
//        int n = nums.length;
//        if(n<3) return ans;
//        Arrays.sort(nums);
//        for(int i =1;i<n-1;i++){
//            for(int j=0;j<i;j++){
//                for(int k=i+1;k<n;k++){
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> l= new LinkedList<>();
//                        l.add(nums[j]);
//                        l.add(nums[i]);
//                        l.add(nums[k]);
//                        if(ans.contains(l)) continue;
//                        ans.add(l);
//                    }
//                }
//            }
//        }
//        return ans;
//    }

//
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new LinkedList<>();
//        nums=reduce(nums);
//        int n = nums.length;
//        if(n<3) return ans;
//        Arrays.sort(nums);
//        Set<String> checker = new HashSet<>();
//        for(int i =0;i<n-2;i++){
//            if(nums[i]>0) break;
//            for(int j=i+1;j<n-1;j++){
//                if(nums[i]+nums[j]>0) break;
//                for(int k=j+1;k<n;k++){
//                    if(nums[i]+nums[j]+nums[k]>0) break;
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> l= new LinkedList<>();
//                        l.add(nums[i]);
//                        l.add(nums[j]);
//                        l.add(nums[k]);
//                        if(checker.contains(nums[i]+","+nums[j]+","+nums[k])) continue;
//                        checker.add(nums[i]+","+nums[j]+","+nums[k]);
//                        ans.add(l);
//                    }
//                }
//            }
//        }
//        return ans;
//    }