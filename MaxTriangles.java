package marshal.practice.com;
import java.util.*;

public class MaxTriangles {
	
	public static int getMaxTriangles(int []arr){
		
		int count = 0;
		int k = 0;
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				
				
				while(k<arr.length && arr[i] + arr[j] > arr[k]){
					
					System.out.println(arr[i] +","+ arr[j] + "," + arr[k]);
					k++;
					count++;
				}
				//j=k;
			}
		}
		
		return count;
	}

}
