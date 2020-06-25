package com.lc1;

import java.util.HashMap;
import java.util.LinkedList;

public class MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        if(points.length==1) return 1;
        //<key,{number, a,b}>
        HashMap<String,double[]> lines = new HashMap<>();
        double x1,y1,x2,y2,a,b;
        for(int i=0;i<points.length-1;i++){
            x1 = points[i][0];
            y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                x2=points[j][0];
                y2=points[j][1];
                if(x1==x2){
                    String line =""+x1;
                    if(lines.containsKey(line)) lines.get(line)[0]++;
                    else {
                        double[] d = {1,x1,0};
                        lines.put(line,d);
                    }
                }else{
                    a=(y1-y2)/(x1-x2);
                    b=y1 - a*x1;
                    String line = ""+a+","+b;
                    if(lines.containsKey(line)) lines.get(line)[0]++;
                    else {
                        double[] d = {1,a,b};
                        lines.put(line,d);
                    }
                }
            }
        }
        int max = 0;
        for(String line:lines.keySet()){
            int dots = (int)((-1+Math.sqrt(1+4*2*lines.get(line)[0]))/2+1);
            if(dots>max) max = dots;
        }

        return max;
    }
    public  int sol2(int[][] points){
        if(points.length==1) return 1;
        //construct weighted points; <x,y,weight>
//        LinkedList<Integer[]> wp = new LinkedList<>();
        HashMap<String,int[]> map = new HashMap<>();
        for(int[] p : points){
            String s = p[0]+","+p[1];
            if(map.containsKey(s)) map.get(s)[2]++;
            else {
                int[] a = {p[0],p[1],1};
                map.put(s,a);
            }
        }
        int[][] wp = new int[map.size()][];
        int it=0;
        for(int[] a:map.values()){
            wp[it++]=a;
        }
        //<key,{number, a,b}>
        HashMap<String,double[]> lines = new HashMap<>();
        double x1,y1,x2,y2,a,b;
        for(int i=0;i<wp.length-1;i++){
            x1 = wp[i][0];
            y1 = wp[i][1];
            for(int j=i+1;j<wp.length;j++){
                x2=wp[j][0];
                y2=wp[j][1];
                if(x1==x2){
                    String line =""+x1;
                    if(lines.containsKey(line)) lines.get(line)[0]+=wp[i][2]*wp[j][2];
                    else {
                        double[] d = {1,x1,0};
                        lines.put(line,d);
                    }
                }else{
                    a=(y1-y2)/(x1-x2);
                    b=y1 - a*x1;
                    String line = ""+a+","+b;
                    if(lines.containsKey(line)) lines.get(line)[0]+=wp[i][2]*wp[j][2];
                    else {
                        double[] d = {1,a,b};
                        lines.put(line,d);
                    }
                }
            }
        }
        int max = 0;
        for(String line:lines.keySet()){
            int dots = (int)((-1+Math.sqrt(1+4*2*lines.get(line)[0]))/2+1);
            if(dots>max) max = dots;
        }

        return max;
    }
    public  int sol3(int[][] points){
        if(points.length==1) return 1;
        //construct weighted points; <x,y,weight>
//        LinkedList<Integer[]> wp = new LinkedList<>();
        HashMap<String,int[]> map = new HashMap<>();
        for(int[] p : points){
            String s = p[0]+","+p[1];
            if(map.containsKey(s)) map.get(s)[2]++;
            else {
                int[] a = {p[0],p[1],1};
                map.put(s,a);
            }
        }
        int[][] wp = new int[map.size()][];
        int it=0;
        for(int[] a:map.values()){
            wp[it++]=a;
        }
        if(wp.length==1) return wp[0][2];
        //<key,{number, a,b}>
        HashMap<String,double[]> lines = new HashMap<>();
        HashMap<String,double[]> newlines = new HashMap<>();
        double x1,y1,x2,y2,a,b;
        for(int i=0;i<wp.length-1;i++){
            x1 = wp[i][0];
            y1 = wp[i][1];
            for(int j=i+1;j<wp.length;j++){
                x2=wp[j][0];
                y2=wp[j][1];
                if(x1==x2){
                    String line =""+x1;
                    if(!lines.containsKey(line)){
                        if(newlines.containsKey(line)) newlines.get(line)[0]+=wp[j][2];
                        else {
                            double[] d = {wp[i][2]+wp[j][2],x1,0};
                            newlines.put(line,d);
                        }
                    }
                }else{
                    a=(y1-y2)/(x1-x2);
                    if(a==-0) a=0.0;
                    b=y1 - a*x1;
                    String line = ""+a+","+b;
                    if(!lines.containsKey(line)){
                        if(newlines.containsKey(line)) newlines.get(line)[0]+=wp[j][2];
                        else {
                            double[] d = {wp[i][2]+wp[j][2],a,b};
                            newlines.put(line,d);
                        }
                    }
                }
            }
            lines.putAll(newlines);
            newlines.clear();
        }
        int max = 0;
        for(String line:lines.keySet()){
            if(max<lines.get(line)[0]) max= (int)lines.get(line)[0];
        }
        return max;
    }
    public  int sol4(int[][] points){
        if(points.length==1) return 1;
        //construct weighted points; <x,y,weight>
        HashMap<String,int[]> map = new HashMap<>();
        for(int[] p : points){
            String s = p[0]+","+p[1];
            if(map.containsKey(s)) map.get(s)[2]++;
            else {
                int[] a = {p[0],p[1],1};
                map.put(s,a);
            }
        }
        int[][] wp = new int[map.size()][];
        int it=0;
        for(int[] a:map.values()){
            wp[it++]=a;
        }
        if(wp.length==1) return wp[0][2];
        //<key,{number, a,b}>
        HashMap<String,Integer> lines = new HashMap<>();
        int x1,y1,x2,y2,dx,dy,gcd;

        int max = 0;
        for(int i=0;i<wp.length-1;i++){
            lines.clear();
            x1 = wp[i][0];
            y1 = wp[i][1];
            for(int j=i+1;j<wp.length;j++){
                x2=wp[j][0];
                y2=wp[j][1];
                dx=x1-x2;
                dy=y1-y2;
                gcd = gcd(dx,dy);
                dx=dx/gcd;
                dy=dy/gcd;
                String key = dx+","+dy;
                lines.put(key,lines.getOrDefault(key,wp[i][2])+wp[j][2]);
                max = Math.max(max,lines.get(key));
            }
        }
        return max;
    }
    public int gcd(int a, int b)
    {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    //fastest
    public int maxPoints2(int[][] points) {
        int n = points.length;
        if(n<3) return n;
        int max = 2;

        for(int i=1; i<n; i++){
            int count = 0;
            long x1 = points[i-1][0];
            long y1 = points[i-1][1];
            long x2 = points[i][0];
            long y2 = points[i][1];

            // iff (x1 - x2) * y2 - (y1 - y2) * x2 == (x1 - x2) * y3 - (y1 - y2) * x3 the points are collinear
            long dx = (x1 - x2);
            long dy = (y1 - y2);
            long check = dx * y2 - dy * x2; // do this math only once, this is the (x1-x2) * y2 - (y1-y2) * x2 part

            if(x1 == x2 && y1 == y2){
                //if points all identical, nothing to count
                //     // for(int j=0;j<n;j++){
                //     //     if(points[j][0] == x1 && points[j][1] == y1){
                //     //         count++;
                //     //     }
                //     // }
            } else{
                // if (x1 !)
                for(int j=0;j<n;j++){
                    if (j == i-1 | j == i) { // index is the same so we don't need the check
                        count++;
                    } else {
                        long x3 = points[j][0];
                        long y3 = points[j][1];
                        if(check == dx * y3 - dy * x3){ //  (x1-x2) * y3 - (y1-y2) * x3
                            count++;
                        }
                    }
                }
            }
            max = Math.max(max,count);
        }

        // extra loop to check points on the diagonal such as [1,1] [2,2] [5,5] etc.
        int count = 0;
        for(int i=0;i<n;i++){
            long x1 = points[i][0];
            long y1 = points[i][1];
            if(x1 == y1) count++;
        }
        max = Math.max(max,count);
        return max;
    }
}
