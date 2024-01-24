/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int ans = 0;
  public int pseudoPalindromicPaths (TreeNode root) {
    getPath(root, new int[10]);

    return ans;
  }

  // 모든 노드 탐색하며 값(val)이 나온 횟수 추가
  public void getPath(TreeNode node, int[] cnt) {
    ++cnt[node.val];
    if (node.left == null && node.right == null) {
      if (isPalindromic(cnt)) ++ans;
    }
    if (node.left != null) getPath(node.left, cnt);
    if (node.right != null) getPath(node.right, cnt);
    --cnt[node.val];
  }

  // 대칭을 이루는지?
  public boolean isPalindromic(int[] cnt) {
    int odd = 0;
    for (int i=1;i<=9;i++) {
      if (cnt[i] % 2 == 1) ++odd;
    }

    return odd == 1 || odd == 0;
  }
}