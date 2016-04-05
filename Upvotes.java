package marshal.practice.com;

public class Upvotes {
	
	
	public static void getUpvotes(){
		
		//int nonIncCount = 0;
		int nonDecCount = 0;
		int[] arr = {1,2,3,1,1};
		int k = 3;
		
		for(int i = 0;i<(arr.length-k+1);i++){
			
			for(int j = i,m=j+1;m<=(i+k-1) && m<arr.length;j++,m++){
				
				if(arr[j]<=arr[m]){
					nonDecCount += m-j;
				}
				
			}
			
			if(nonDecCount==(k-1)){
				nonDecCount = ((k-1)*k)/2;
				System.out.println(nonDecCount);
			}
			else{
				System.out.println(nonDecCount);
			}
			
			nonDecCount=0;
		}
		
	}
	
	public int getNonDecreasingCount(int[] arr, int start, int end){
		
		int count = 0;
		
		return 0;
	}

}
