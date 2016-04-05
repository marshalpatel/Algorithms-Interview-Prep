package marshal.practice.com;

import java.util.*;

public class IncreasingSubSeqMaxProd {

	public static void getMaxProdSize3() {

		//int[] arr = {1,5,6,3,4,5};
		int[] arr = {1,6,2,8,3,7};
		getMaxProdSize3Helper(arr);

	}

	public static void getMaxProdSize3Helper(int[] arr) {

		int second_index = getMaxProdIncPair(arr);
		int max_first = Integer.MIN_VALUE;

		for (int i = 0; i < second_index; i++) {

			if (arr[i] > max_first && arr[i] <= arr[second_index]) {
				max_first = arr[i];
			}
		}

		System.out.println(max_first);

	}

	public static int getMaxProdIncPair(int[] arr) {

		// Queue<Integer> q = new LinkedList<Integer>();
		// 8 ,9 ,10 ,1 ,2 ,3 ,4 ,5
		int index = 0;
		int maxProd = Integer.MIN_VALUE;
		
		int t = arr[arr.length - 1];
		int maxRight = t;
		int s = 1;
		int tempProd = 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			
			if(maxRight >= arr[i]){
				tempProd = arr[i]*maxRight;
				if(tempProd > maxProd){
					maxProd = tempProd;
					s=arr[i];
					t= maxRight;
					index = i;
				}
			}
			
			else{
				
				maxRight = arr[i];
			}
			
		}
		
		System.out.print(t+","+s+",");
		return index;

	}

}
