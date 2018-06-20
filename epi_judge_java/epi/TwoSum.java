package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class TwoSum {
  @EpiTest(testfile = "two_sum.tsv")

  public static boolean hasTwoSum(List<Integer> A, int t) {
  
    return false;
  
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
