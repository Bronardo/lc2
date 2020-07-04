package com.lc1;

import java.util.*;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        List<String> words2 = new LinkedList<>(Arrays.asList(words));
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(words2.size()>0){
                    for(int k=0;k<words2.size();k++){
                        System.out.println("i:"+i+",j:"+j+"k:"+k+"\t"+words2.get(k));
//                        if(findNext(board,i,j,words2.get(k),0,new boolean[board.length][board[0].length])){
                            if(findNext2(board,i,j,words2.get(k),0)){
                            ans.add(words2.get(k));
                            words2.remove(k);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public boolean findNext(char[][] board, int i, int j, String word, int pointer, boolean[][] used){
//        if(word.compareTo("aabbbbabbaababaaaabababbaaba")==0 && pointer>22){
//            System.out.println("aabbbbabbaababaaaabababbaaba with:"+pointer+" and length:"+word.length());
//        }
        if(i==0 || j== 0||i ==board.length-1||j==board[0].length-1){
            System.out.println(i+","+j+"\t"+pointer);
        }
        if(used[i][j]) return false;
        if(pointer==word.length()-1) {
            if(word.charAt(pointer)==board[i][j]) return true;
        }
        if(word.charAt(pointer)==board[i][j]){
            used[i][j]=true;
            //up
            if(i>0){
                if(findNext(board,i-1,j,word,pointer+1,used)) return true;
            }
            //down
            if(i<board.length-1){
                if(findNext(board,i+1,j,word,pointer+1,used)) return true;
            }
            //left
            if(j>0){
                if(findNext(board,i,j-1,word,pointer+1,used)) return true;
            }
            //right
            if(j<board[0].length-1){
                if(findNext(board,i,j+1,word,pointer+1,used)) return true;
            }
        }
        return false;
    }
    public boolean findNext2(char[][] board, int i, int j, String word, int pointer){
//        if(word.compareTo("aabbbbabbaababaaaabababbaaba")==0 ){
//            System.out.println("aabbbbabbaababaaaabababbaaba with:"+pointer+" and length:"+word.length());
//        }
        if(i==0 || j== 0||i ==board.length-1||j==board[0].length-1){
            System.out.println(i+","+j+"\t"+pointer);
        }
        if(pointer==word.length()-1) {
            if(word.charAt(pointer)==board[i][j]) return true;
        }
        if(word.charAt(pointer)==board[i][j]){
            char c = board[i][j];
            board[i][j] ='#';
            //up
            if(i>0){
                if(findNext2(board,i-1,j,word,pointer+1)){
                    board[i][j]=c;
                    return true;
                }
            }
            //down
            if(i<board.length-1){
                if(findNext2(board,i+1,j,word,pointer+1)) {
                    board[i][j]=c;
                    return true;
                }
            }
            //left
            if(j>0){
                if(findNext2(board,i,j-1,word,pointer+1)) {
                    board[i][j]=c;
                    return true;
                }
            }
            //right
            if(j<board[0].length-1){
                if(findNext2(board,i,j+1,word,pointer+1)) {
                    board[i][j]=c;
                    return true;
                }
            }
            board[i][j]=c;
        }
        return false;
    }

    //["aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"]

    //fast solution
    public List<String> findWords3(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    //another solution
    public List<String> findWords4(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        for(String word : words)
            if(exist(board,word))
                res.add(word);
        return res;
    }

    public boolean exist(char[][] board, String word) {

        for(int i =0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && existWord(board,word,i,j,1))
                    return true;
            }
        return false;
    }

    private boolean existWord(char[][] board, String word, int row, int col, int index){
        if(word.compareTo("aabbbbabbaababaaaabababbaaba")==0 && index>27){
            System.out.println("aabbbbabbaababaaaabababbaaba with:"+index+" and length:"+word.length());
        }
        if(index == word.length())
            return true;
        board[row][col] = '.';
        if(row > 0 && board[row-1][col] == word.charAt(index) && existWord(board,word,row-1,col,index+1)){
            board[row][col] = word.charAt(index-1);
            return true;
        }
        if(row<board.length-1 && board[row+1][col] == word.charAt(index) && existWord(board,word,row+1,col,index+1)){
            board[row][col] = word.charAt(index-1);
            return true;
        }
        if(col>0 && board[row][col-1] == word.charAt(index) && existWord(board,word,row,col-1,index+1)){
            board[row][col] = word.charAt(index-1);
            return true;
        }
        if(col<board[0].length-1 && board[row][col+1] == word.charAt(index) && existWord(board,word,row,col+1,index+1)){
            board[row][col] = word.charAt(index-1);
            return true;
        }
        board[row][col] = word.charAt(index-1);
        return false;
    }
}
