package marshal.practice.com;

public class SubsetSum {
	
	
	public static void isSubSetSumHelper(){
		
		int[] set = {3,5,4,6,2,1};
		
		System.out.println(isSubsetSum(set,0,0));
		
	}

	public static boolean isSubsetSum(int[] set, int s, int sum){
		
		if(sum==0)
			return true;
		
		if(s>=set.length-1)
			return false;
		
		boolean iss = false;
		
		for(int i = s;i < set.length;i++){
			
			//if(sum>=set[i]){
				
				iss = isSubsetSum(set, i+1, sum-set[i]) || iss;
			//}
			
			//if(iss)
			//	return true;
		}
		
		return iss;
		
	}

}
