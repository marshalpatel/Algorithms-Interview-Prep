package marshal.practice.com;

public class KnapSack {

	
	public static void knapSack(){
		
		int[] arr = {2,8,10};
		
		int k = 17;
		
		System.out.println(knapSackDP(arr,k));
	}
	
	
private static int knapSackDP(int[] arr, int k){
        
        int[][] DP = new int[k+1][arr.length+1];
        
        for(int col = 1;col<DP[0].length;col++){
            for(int row = 1;row<DP.length;row++){
              
              if(row>=arr[col-1]){
            	  
            	  int val = DP[row-arr[col-1]][col-1]+arr[col-1];
                  //DP[row][col] = max(DP[row][col-1], DP[row-arr[col-1]][col]+arr[col-1]);
                 // System.out.println(DP[row][col]);
            	  while(val+arr[col-1]<=row){
            		  val+=arr[col-1];
            	  }
            	  DP[row][col] = max(DP[row][col-1], val);
              }
              
              else{
            	  DP[row][col] = DP[row][col-1];
              }
              //DP[i][j]=(DP[i-1][j] >= DP[i-1][j-arr[i-1]]+arr[i-1])?DP[i-1][j]: DP[i-1][j-arr[i-1]]+arr[i-1]; 
                
                
            }
            
        }
        
        return DP[k][arr.length];
    }
    
    private static int max(int a, int b){
        
        return a>b?a:b;
    }
	
}
