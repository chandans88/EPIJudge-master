package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {
  @EpiTest(testfile = "tree_level_order.tsv")

  public static List<List<Integer>>
  binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {

    List<List<Integer>> res = new ArrayList<>();
    if(tree == null)
      return res;

    Queue<BinaryTreeNode<Integer>> currDepthNodes = new ArrayDeque<>();
    currDepthNodes.add(tree);

    while(!currDepthNodes.isEmpty()){
      List<Integer> thisLevel = new ArrayList<>();
      Queue<BinaryTreeNode<Integer>> nextDepthNodes = new ArrayDeque<>();

      while(!currDepthNodes.isEmpty()) {
        BinaryTreeNode<Integer> node = currDepthNodes.poll();
        thisLevel.add(node.data);
        if (node.left != null)
          nextDepthNodes.offer(node.left);
        if (node.right != null)
          nextDepthNodes.offer(node.right);

      }
        res.add(thisLevel);
        currDepthNodes = nextDepthNodes;
    }

    return res;
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
