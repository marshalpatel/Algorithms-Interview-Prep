package marshal.practice.com;

public class BestTimeToBuyStock {
	
	
	public static void getMaxProfit(){
		
		
		int arr[] = {80, 2, 6, 3, 100};
		
		int leader = -1;
		int max_profit = -1;
		int buy = arr[0];
		int sell = arr[0];
		
		
		for(int i = arr.length-1;i>=0;i--){
			
			if(arr[i]>leader){
				leader = arr[i];
			}
			else{
				if(max_profit<leader-arr[i]){
					max_profit = leader - arr[i];
					buy = arr[i];
					sell = leader;
					
				}
			}
			
		}
		
		System.out.println(buy + ", "+ sell);
		
	}

}
