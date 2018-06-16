package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class TreePreorder {
  @EpiTest(testfile = "tree_preorder.tsv")

  public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
  
	Deque<BinaryTreeNode<Integer>> s = new ArrayDeque();
	List<Integer> result = new ArrayList<>();
	
	if(tree != null)
		s.addFirst(tree);

	while(!s.isEmpty()){
		BinaryTreeNode<Integer> curr = s.removeFirst();
		result.add(curr.data);

		//right first to the bottom of the stack
		if(curr.right != null){
			s.addFirst(curr.right);
		}
		if(curr.left != null){
			s.addFirst(curr.left);
		}

	}
	return result;

  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
