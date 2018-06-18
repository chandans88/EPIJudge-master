package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class TwoSum {
  @EpiTest(testfile = "two_sum.tsv")

  public static boolean hasTwoSum(List<Integer> A, int t) {
  
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int a : A){
      map.put(t-a, a);
    }
    for(int a : A){
      if(map.getKey(a)){
        return true;
      }
    }
  
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
