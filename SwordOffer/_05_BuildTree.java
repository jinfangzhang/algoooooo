package SwordOffer;

import DataStruct.TreeNode;

/**
 * _05_BuildTree
 */
public class _05_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length <= 0)
            return null;

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preOrder, int preS, int preE, int[] inOrder, int inS, int inE) {
        if (preE - preS <= 0 && inE - inS <= 0)
            return new TreeNode(preOrder[preS]);

        int rootVal = preOrder[preS];
        TreeNode root = new TreeNode(rootVal);

        int rIndex = -1;
        for (int i = inS; i <= inE; ++i) {
            if (inOrder[i] == rootVal) {
                rIndex = i;
                break;
            }
        }

        int leftLen = rIndex - inS;
        int rightLen = inE - rIndex;

        TreeNode leftNode;
        if (leftLen > 0) {
            leftNode = buildTree(preOrder, preS + 1, preS + leftLen, inOrder, inS, rIndex - 1);
            root.left = leftNode;
        }

        TreeNode rightNode;
        if (rightLen > 0) {
            rightNode = buildTree(preOrder, preS + leftLen + 1, preE, inOrder, rIndex + 1, inE);
            root.right = rightNode;
        }
        return root;
    }
}