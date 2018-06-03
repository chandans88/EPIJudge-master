package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsTreeBalanced {

  @EpiTest(testfile = "is_tree_balanced.tsv")

  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {

    if(tree == null)
        return true;
    return isBalanced(tree.left) && isBalanced(tree.right) && Math.abs((depth(tree.left) - depth(tree.right))) <= 1;

  }

  public static int depth ( BinaryTreeNode<Integer> node){
    int lDepth=0,rDepth=0;
    if(node == null)
      return 0;
    if(node.left != null)
      lDepth = depth(node.left);
    if(node.right != null)
      rDepth = depth(node.right);

    return 1 + Math.max(lDepth,rDepth);
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
