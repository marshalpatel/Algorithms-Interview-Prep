package marshal.practice.com;

public class MaximumSumSubArray {

	public static void getMaxSum() {

		int[] arr = {2,-3,5,7,-10,100};
		int tempSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			
			tempSum +=arr[i];
			
			if(tempSum < 0)
				tempSum= 0;
			
			if(tempSum > maxSum){
				maxSum = tempSum;
			}
		}
		
		System.out.println(maxSum);
	}

}
