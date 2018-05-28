package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class BuyAndSellStock {
  @EpiTest(testfile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {

  	//Check for overflow Int vs Double
	  //IDE open commit test

	Double minPrice = Double.MAX_VALUE;
	Double maxProfit = 0.0;
	for(Double p : prices){
		minPrice = Math.min(p,minPrice);
		maxProfit = Math.max(p-minPrice,maxProfit);
	}
	return maxProfit;

  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
