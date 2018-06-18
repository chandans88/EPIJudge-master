package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class TreeWithParentInorder {
  @EpiTest(testfile = "tree_with_parent_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
  
	List<Integer> res = new ArrayList<>();
	BinaryTree<Integer> curr = tree;
	BinaryTree<Integer> prev = null;

	while(curr != null){
		if(curr.left == null){
			res.add(curr.data);
			curr = curr.right;
		}
		else{
			prev = curr.left;
			while(prev.right != null){
				prev = prev.right;
			}
			BinaryTree<Integer> temp = curr;
			prev.right = curr;
			curr = curr.left;
			temp.left = null;
		}
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
