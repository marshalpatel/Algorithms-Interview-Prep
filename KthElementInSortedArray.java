package marshal.practice.com;

public class KthElementInSortedArray {

	public static void findKthElement() {

		/*
		 * int[] nums1 = { 1, 2, 3, 4, 5 }; int[] nums2 = { 6, 7, 8, 9, 10, 11,
		 * 12 };
		 */

		int[] nums1 = { 1,2 };
		int[] nums2 = { 1,2 };

		//System.out.println(findKthElement(nums1, nums2, 0, nums1.length - 1, 0,
			//	nums2.length - 1, 2));
		
		
		int median1 = (nums1.length + nums2.length)/2 + 1;
		int median2 = 0;
		
		double result=0;
		
		if((nums1.length + nums2.length)%2==0){
			
			median2 = median1-1;
		}
		
		median1 = findKthElement(nums1, nums2, 0, nums1.length - 1, 0,
				nums2.length - 1, median1);
			
		if(median2>0)
		median2 = findKthElement(nums1, nums2, 0, nums1.length - 1, 0,
				nums2.length - 1, median2);	
				
		//System.out.println(findKthElement(nums1, nums2, 0, nums1.length - 1, 0,
			//	nums2.length - 1, 5));
			
			if(median2>0)
			result = (double)(median1+median2)/2;
			
			else
			result = median1;
			
			System.out.println(result);
			
			//return result;


	}

	public static int findKthElement(int[] nums1, int[] nums2, int s1, int e1,
			int s2, int e2, int k) {

		/*
		 * If the size of one of the array is 0
		 */

		if (s1 > e1 && s2 <= e2) {

			return nums2[s2 + k - 1];
		}

		if (s2 > e2 && s1 <= e1) {

			return nums1[s1 + k - 1];
		}

		/*
		 * if k = 1: pick the smaller of the first element
		 */

		if (k == 1) {

			// return num1[s1]<nums[s2]?nums[s1]:nums[s2];
			if (s1 <= e1 && s2 <= e2)
				return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];

			else if (s1 > e1 && s2 <= e2) {
				return nums2[s2];
			}

			else if (s1 <= e1 && s2 > e2) {

				return nums1[s1];
			}

		}

		/*
		 * 
		 * If k = 2, pick the second element. constant amount of work
		 */

		if (k == 2) {

			int count = 0;
			int i = s1;
			int j = s2;
			int element = 0;

			while (i <= e1 && j <= e2 && count < 2) {

				if (nums1[i] < nums2[j]) {

					element = nums1[i];
					i++;
					count++;

				}

				else if (nums1[i] > nums2[j]) {
					element = nums2[j];
					j++;
					count++;
				}

				else {
					element = nums1[i];
					i++;
					j++;
					count+=2;
				}

			}

			if (count < 2 && i <= e1 && j > e2) {

				while (count < 2 && i <= e1) {
					element = nums1[i];
					i++;
					count++;
				}
			}

			else if (count < 2 && i > e1 && j <= e2) {

				while (count < 2 && j <= e2) {
					element = nums2[j];
					j++;
					count++;
				}
			}

			return element;

		}

		/* medians of 2 arrays */
		int med1 = (s1 + e1) / 2;
		int med2 = (s2 + e2) / 2;

		/* position of median of the sorted array */
		int med = (e1 - s1 + e2 - s2 + 2) / 2;

		boolean isNum1 = false;

		// int min_rank = 0;
		// int max_rank = 0;

		/*
		 * If the size of arrays is either 1 or 2 - constant work
		 */

		if (med1 == s1 && med2 == s2) {

			int count = 0;
			int i = s1;
			int j = s2;
			int element = nums1[i];

			while (i <= e1 && j <= e2 && count < k) {

				if (nums1[i] < nums2[j]) {

					element = nums1[i];
					i++;
					count++;

				}

				else if (nums1[i] > nums2[j]) {
					element = nums2[j];
					j++;
					count++;
				}

				else {
					element = nums1[i];
					i++;
					j++;
					count+=2;
				}

			}

			if (count < k && i <= e1 && j > e2) {

				while (count < k && i <= e1) {
					element = nums1[i];
					i++;
					count++;
				}
			}

			else if (count < k && i > e1 && j <= e2) {

				while (count < k && j <= e2) {
					element = nums2[j];
					j++;
					count++;
				}
			}

			return element;

		}

		/*
		 * Check which array has smaller median
		 */

		if (nums1[med1] < nums2[med2]) {

			// min_rank = med2 - s2 + 2 + med1 - s1;
			// max_rank = e2 - s2 + med1 - s1 + 2;
			isNum1 = true;
		} else {
			// count = med1 - s1;
			// min_rank = med2 - s2 + 2 + med1 - s1;
			// max_rank = e1 - s1 + med2 - s2 + 2;
			// isNum1= true;
		}

		/*
		 * If k = median of union, then search in the lower half of the array
		 * with higher median and upper half of the array with lower median
		 */

		if (k == med) {

			if (!isNum1) {

				return findKthElement(nums1, nums2, s1, med1, med2, e2, k
						- (med2 - s2));

			} else {

				return findKthElement(nums1, nums2, med1, e1, s2, med2, k
						- (med1 - s1));

			}

		}

		/*
		 * If k > median of union, then discard the lower half of the array with
		 * smaller median
		 */

		else if (k > med) {

			if (isNum1) {

				if (med1 - s1 > 0) {
					return findKthElement(nums1, nums2, med1, e1, s2, e2, k
							- (med1 - s1));
				}

				else {
					return findKthElement(nums1, nums2, med1 + 1, e1, s2, e2,
							k - (1));
				}

			}

			else {

				if (med2 - s2 > 0)
					return findKthElement(nums1, nums2, s1, e1, med2, e2, k
							- (med2 - s2));

				else {
					return findKthElement(nums1, nums2, s1, e1, med2 + 1, e2,
							k - (1));
				}
			}

		}

		/*
		 * If k < median of union, then discard the lower half of the array with
		 * higher median
		 */
		else {

			if (isNum1)
				return findKthElement(nums1, nums2, s1, e1, s2, med2, k);

			else
				return findKthElement(nums1, nums2, s1, med1, s2, e2, k);

		}

	}

}
