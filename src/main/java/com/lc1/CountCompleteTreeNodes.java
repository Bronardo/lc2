/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lc1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BroNardo
 */

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int height = 0;
        int lastLvLeaves = 0 ;
        TreeNode index =root;
        while(index.left!=null){
            height++;
            index = index.left;
        }
        return 0;
    }
    public int solution2(TreeNode root){
        treeToMap(root,0,0);
        return map.size();
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    public void treeToMap(TreeNode node,int height, int pos){
        map.put((int)Math.pow(2, height)+pos-1, node.val);
        if(node.left!=null) treeToMap(node.left,height+1,pos*2);
        if(node.right!=null) treeToMap(node.right,height+1,pos*2+1);
    }
    
}
