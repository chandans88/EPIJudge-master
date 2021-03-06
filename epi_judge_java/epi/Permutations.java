package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.LexicographicalListComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class Permutations {
  @EpiTest(testfile = "permutations.tsv")

  public static List<List<Integer>> permutations(List<Integer> A) {
    // Implement this placeholder.
    List<List<Integer>> results = new ArrayList<>();
    recursivePerm(0,A, results);
    return results;
  }



  public static List<List<Integer>> recursivePerm(int i,List<Integer> A,List<List<Integer>> results) {

      //if index has reached end of the array, return result set.
      if(i == A.size() - 1) {
          results.add(A);
          System.out.println(A);
          return results;
      }

        //keep integer in 0-th index fixed, permute remaining string
      for(int j = i; j<A.size(); ++j) {
          Collections.swap(A, i, j);
          recursivePerm(i + 1, A, results);
          Collections.swap(A,i,j);
      }
      return results;
  }

  @EpiTestComparator
      public static BiPredicate < List<List<Integer>>,
      List < List<Integer>>> comp = (expected, result) -> {
    if (result == null) {
      return false;
    }
    for (List<Integer> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<Integer> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
