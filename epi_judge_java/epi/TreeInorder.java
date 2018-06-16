package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;
public class TreeInorder {
  @EpiTest(testfile = "tree_inorder.tsv")

  public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {

	Deque<BinaryTreeNode<Integer>> s = new ArrayDeque();
	BinaryTreeNode<Integer> curr = tree;
	List<Integer> res = new ArrayList<>();
	
	while(!s.isEmpty() ||  curr != null){
		
		if(curr != null){
			s.addFirst(curr);
			//traverse to left side
			curr = curr.left;
		}
		else{
			curr = s.removeFirst();
			res.add(curr.data);
			curr = curr.right;
		}
	}
	//
    return res;
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
