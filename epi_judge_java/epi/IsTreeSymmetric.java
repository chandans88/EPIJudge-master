package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsTreeSymmetric {
  @EpiTest(testfile = "is_tree_symmetric.tsv")

  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    return checkSymmetric(tree.left,tree.right);
  }

  public static boolean checkSymmetric(BinaryTreeNode<Integer> tree1, BinaryTreeNode<Integer> tree2){

    if(tree1 == null && tree2 == null)
      return true;
    else if(tree1 !=null && tree2 != null){
      return (tree1.data == tree2.data) &&
              checkSymmetric(tree1.left,tree2.right) &&
                checkSymmetric(tree1.right,tree2.left);
    }
    return false;
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
