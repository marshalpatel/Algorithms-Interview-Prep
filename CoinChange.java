package marshal.practice.com;

public class CoinChange {
	
	static int ways;
	public static void coinChange(){
		
		int[] arr={1,2,3};
		int n = 4;
		
		coinChangeBF(arr, n);
		System.out.println(ways);
	}
	
	private static void coinChangeBF(int[] arr, int n){
		
		if(n==0){
			ways++;
			return;
		}
		
		for(int i=0;i<arr.length;i++){
			
			if(n-arr[i]>=0){
				coinChangeBF(arr, n-arr[i]);
			}
		}
		
	}

}
