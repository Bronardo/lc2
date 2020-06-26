package com.lc1;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {


        return recSum(root,0);
    }
    public int recSum(TreeNode node, int product){
        product = product*10+node.val;
        int left =0;
        int right =0;
        if(node.left!=null) left = recSum(node.left,product);
        if(node.right!=null) right = recSum(node.right,product);
        if(node.left==null && node.right==null) return product;
        return left+right;
    }
    public int recSum2(TreeNode node, int product){
        if(node==null) return 0;
        if(node.left==null && node.right==null) return product*10+node.val;
        return recSum2(node.left,product*10+node.val)+recSum2(node.right,product*10+node.val);
    }
}
