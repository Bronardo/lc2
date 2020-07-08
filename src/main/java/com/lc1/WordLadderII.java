package com.lc1;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> a = new LinkedList<>();
        int minStep=Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        List<List<String>> paths =new LinkedList<>();
        paths.add(path);
        wordList.add(endWord);
        int step = 1;
        while(!paths.isEmpty()){
            path = paths.remove(0);
            if(path.size()>step){
                for(String s:visited) wordList.remove(s);
                visited.clear();
                if(path.size()>minStep) break;
                else step=path.size();
            }
            String current = path.get(path.size()-1);
            for(String s:wordList){
                if(is1CharDiff2(current,s)){
                    if(wordList.indexOf(s)!=wordList.size()-1){
                        List<String> newPath = new LinkedList<>(path);
                        newPath.add(s);
                        visited.add(s);
                        if(s==endWord){
                            minStep = step;
                            a.add(newPath);
                        }else{
                            paths.add(newPath);
                        }
                    }
                }
            }
        }

        return a;
    }
    public boolean is1CharDiff(String a, String b){
        for(int i=0;i<a.length();i++){
            String aRegex="^"+a.substring(0,i)+"\\w"+a.substring(i+1)+"$";
            if(b.matches(aRegex)) return true;
        }
        return false;
    }
    public boolean is1CharDiff2(String a, String b){
        int c = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) c++;
            if(c>1) return false;
        }
        return c==1;
    }
}
