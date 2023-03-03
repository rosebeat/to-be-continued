package com.example.util;

import lombok.Data;

/**
 * @author kai·yang
 * @Date 2023/2/1 17:12
 */
@Data
public class TreeNode {

    int val;

    TreeNode parent;

    TreeNode left;

    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }


    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }


}
