package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class SortedArraysMerge {

  @EpiTest(testfile = "sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {

      //create a list of iterators of size of sortedArrays
      List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

      //initialize iterators
      for(List<Integer> a : sortedArrays)
          iters.add(a.iterator());

      //create Priority Queue
      PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
          @Override
          public int compare(ArrayEntry arrayEntry1, ArrayEntry arrayEntry2) {
              return Integer.compare(arrayEntry1.value,arrayEntry2.value);
          }
      });

      //add to the PQ
      for(int i=0; i<iters.size(); i++){
          if(iters.get(i).hasNext())
              minHeap.add(new ArrayEntry(iters.get(i).next(),i));
      }

      //create result set
      List<Integer> result = new ArrayList<>();

      //pick minimal element from PQ

      while(!minHeap.isEmpty()){
          ArrayEntry topEntry = minHeap.poll();
          result.add(topEntry.value);

          if(iters.get(topEntry.arrayId).hasNext()){
              minHeap.add(new ArrayEntry(iters.get(topEntry.arrayId).next(),topEntry.arrayId));
          }
      }

      return result;

  }
    public static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
