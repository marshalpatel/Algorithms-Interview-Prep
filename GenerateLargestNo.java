package marshal.practice.com;

import java.util.*;

public class GenerateLargestNo{

	public static void getLargestNo(int[] arr) {

		String []strarr = new String[arr.length];
		
		for(int i=0;i<arr.length;i++){
			strarr[i] = Integer.toString(arr[i]);
		}
		
		Arrays.sort(strarr);
		String temp = strarr[strarr.length-1];
		
		for(int i =strarr.length-2;i>=0;i--){
			
			if((temp+strarr[i]).compareTo(strarr[i]+temp)>0){
				temp = temp+strarr[i];
			}
			else{
				temp = strarr[i]+temp;
			}
				
			
			//System.out.print(strarr[i]);
		}
		
		/*Arrays.sort(arr);
		long temp = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {

			if (Long.valueOf(Long.toString(temp) + Long.toString(arr[i])) > Long
					.valueOf(Long.toString(arr[i]) + Long.toString(temp)))
				temp = Long
						.valueOf(Long.toString(temp) + Long.toString(arr[i]));
			else
				temp = Long
						.valueOf(Long.toString(arr[i]) + Long.toString(temp));
		}

		return temp;*/
		System.out.println(temp);
	}

	

}
