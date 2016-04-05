package marshal.practice.com;

import java.util.*;

public class PracticeMain {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		/*
		 * For arrays: 1. Check for overflow 2. If alternating, check for
		 * indices 3. Scan from backward and see. 4. Use a stack/queue if order
		 * matters (previous/next). 5. Sort and modify. 6. Brute force -> nested
		 * loops/Recursion. Check for overlapping subproblems -> DP. 7. If
		 * sorted -> Binary Search/Merge sort 8. K smallest/largest -> Use a
		 * heap. 9. Use hash-map/hash-set 10. If range from 1-n, use indices.
		 */
		// int[] arr = { 1, 34, 3, 98, 9, 76, 45, 4 };
		// 998764543431

		// 4,5,7,8
		// System.out.println(PeakElement.getPeakElement(arr,0,arr.length-1));

		// System.out.println(MaxTriangles.getMaxTriangles(arr));

		/*
		 * RearrangePosNeg.rearrange(arr);
		 * 
		 * Interval[] intArr = new Interval[4];
		 * 
		 * intArr[0] = new Interval(1,3); intArr[1] = new Interval(4,6);
		 * intArr[2] = new Interval(10,13); intArr[3] = new Interval(15,17);
		 * 
		 * // System.out.println(intArr[0].compareTo(intArr[1]));
		 * 
		 * Arrays.sort(intArr);
		 * 
		 * List<Interval> result = MergeIntervals.merge(intArr);
		 * 
		 * for (int i = 0; i < intArr.length; i++) {
		 * 
		 * System.out.println("{" + intArr[i].start + "," + intArr[i].end +
		 * "}"); }
		 * 
		 * System.out.println("=====================");
		 * 
		 * for (int i = 0; i < result.size(); i++) {
		 * 
		 * System.out.println("{" + result.get(i).start + "," +
		 * result.get(i).end + "}"); }
		 */

		// Generate Largest No.
		// GenerateLargestNo.getLargestNo(arr);

		/*
		 * int A[] = {2,7,10,-1,-1,-1,-1}; int B[] = {5,8,12,14};
		 * 
		 * MergeTwoArrays.mergeArrays(A, B);
		 */

		// MaximumLengthBitonicSubArray
		// int[] A = {2,-3,5,7,-10,100};
		// MaximumLengthBitonicSubArray.getMaxLengthBitonicSubArray(A);

		// MaximumSumSubArray.getMaxSum();

		// MaximumSumNonContiguous.getMaxNonContiguousSum();

		// generate balanced parenthesis
		// GenerateParenthesis.getParenthCombos(4);

		// int[] arr = { 3, 5, 2, 1, 4 };
		// PancakeSorting.pancakeSorting(arr);

		// ValidPaths.getPathCount();

		// Islands.getIslandCount();

		// IncreasingSubSeqMaxProd.getMaxProdSize3();

		// to be done
		// LIS.getLIS();

		// PrintCombination.PrintCombo();

		// MergeKSortedArrays.mergeKSortedArrays();

		// LargestContiguousSubArray.getLargestContiguousSubArray();

		// SearchInAlmostSortedArray.search();

		// FindKClosestElements.getKClosestElements();

		// ClosestPairSumInSortedArray.getClosestPairSum();

		// PrintMatrixDiagonally.printMatrixDiagonally();

		// SortArrayByFrequency.sortByFrequency();

		// MaximumSumPathArray.getMaximumPathSum();

		// FirstNonRepeatingNo.LinkedListTest();

		// CircularTour.getStartingPoint();

		// StockSpanProblem.getStockSpan();

		// LargestAreaRectHist.getLargestRectInHist();

		// PrintMatrixSpirally.spiralOrderHelper();

		// RotateMatrix.rotateMat();

		// BestTimeToBuyStock.getMaxProfit();

		// PoisonousPlants.getDays();

		// SubsetSum.isSubSetSumHelper();

		// LCS.getLCS("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA",
		// "GTCGTTCGGAATGCCGTTGCTCTGTAAA");
		// LCS.longestCommonSubString("abxyz", "xyzab");

		// Upvotes.getUpvotes();
		// ContainsDuplicate.containsDuplicate();

		// GenValidParen.genValidParen();
		// SortVersionNums.sortStrings();

		/*
		 * LRUCache lru = new LRUCache(2);
		 * 
		 * lru.set(2, 1); //lru.set(1, 2); //System.out.println(lru.get(2));
		 * lru.set(1, 1); System.out.println(lru.get(2)); lru.set(4, 1);
		 * System.out.println(lru.get(1)); System.out.println(lru.get(2));
		 */

		// KnapSack.knapSack();

		// CoinChange.coinChange();

		// InPlaceDuplicateRemoval.removeDuplicates();

		// RotateArray.rotate();

		// System.out.println(AdditiveNumbers.isAdditiveNumber());

		// KthElementInSortedArray.findKthElement();

		// Target.getScore();

		// WiggleSort.wiggleSort();
		// ZigZagConversion.zzConversion();

		// WordBreak.wordbreakInit();

		/*
		 * Trie trieObj = new Trie();
		 * 
		 * trieObj.insert("abc"); System.out.println(trieObj.search("abc"));
		 * System.out.println(trieObj.search("ab")); trieObj.insert("ab");
		 * System.out.println(trieObj.search("ab")); trieObj.insert("ab");
		 * System.out.println(trieObj.search("ab"));
		 * //System.out.println(trieObj.search("the"));
		 */

		/*
		 * Spaceship[] arr = new Spaceship[5];
		 * 
		 * arr[0] = new Spaceship(2, 100, 200); arr[1] = new Spaceship(3, 110,
		 * 190); arr[2] = new Spaceship(4, 105, 145); arr[3] = new Spaceship(1,
		 * 90, 150); arr[4] = new Spaceship(5, 102, 198);
		 * 
		 * Arrays.sort(arr,new SpaceshipStartTimeComparator());
		 * 
		 * AVLTree avlObj = new AVLTree();
		 * 
		 * avlObj.getScore(arr); Arrays.sort(arr,new
		 * SpaceshipScoreIdComparator());
		 * 
		 * for(int i = 0;i<arr.length;i++){ System.out.println(arr[i].id +" " +
		 * arr[i].score); }
		 */

		// MinSwap.minimumSwapsRequired();
		// WordSearch.wordSearch();

		// StringCompression.compressString("");

		// System.out.println(SearchInRotatedArray.search());

		// System.out.println(MinWindowSubStr.minWindow("ADOBECODEBANC",
		// "ABC"));
		// ThreeSum.threeSum();

		// A a = null;
		// System.out.println(a.demoMethod());

		// LIPathMatrix.longestIncreasingPath();

		// LuckyNo.printLuckyDivisors(9);

		// TrappingRainWater.trappingRainWater();

		// SelfCrossing.isSelfCrossing();

		// MinimumJumps.getMinJumps();

		int[] nums = { 1,2,3,4,5,6,7 };
		BIT bit = new BIT(nums);
		System.out.println(bit.sumRange(0));
	}
}

class A {

	// public A(){
	// A a = new A();
	// System.out.println("Constructor");
	// }

	public int demoMethod() {

		// System.out.println("Static");

		return (true ? null : new Integer(0));
	}

}

class B extends A {

	@Override
	public int demoMethod() {

		return 0;
	}
}
