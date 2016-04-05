package marshal.practice.com;

public class LCS {

public static void getLCS(String x, String y){
		
		int[][] LCS = new int[x.length()+1][y.length()+1];
		int max_length = Integer.MIN_VALUE;
		
		for(int i = x.length()-1; i>=0;i--){
			
			for(int j = y.length()-1; j>=0;j--){
				
				
			 if(x.charAt(i) == y.charAt(j)){
					LCS[i][j] = 1 + LCS[i+1][j+1];
					max_length = LCS[i][j]>max_length?LCS[i][j]:max_length;
				}
				
				else{
					
					LCS[i][j] = LCS[i+1][j]>LCS[i][j+1]?LCS[i+1][j]:LCS[i][j+1];
					max_length = LCS[i][j]>max_length?LCS[i][j]:max_length;
				}
				
			}
		}
		
		int i = 0;
		int j = 0;
		//String lcs = "";
		
		while(i<x.length() && j<y.length()){
			
			if(x.charAt(i)==y.charAt(j)){
				System.out.print(x.charAt(i));
				i++;
				j++;
			}
			
			else if(LCS[i+1][j]>=LCS[i][j+1]){
				i++;
			}
			
			else
				j++;
			
		}
		
		//return max_length;
		System.out.println();
		System.out.println(max_length);
		//System.out.println(lcs);
	}

	public static void longestCommonSubString(String x, String y){
		
		int[][] LCS = new int[x.length()+1][y.length()+1];
		int count = Integer.MIN_VALUE;
		
		for(int i = x.length()-1;i>=0;i--){
			
			int tempcount = 0;
			for(int j = y.length()-1;j>=0;j--){
				
				if(x.charAt(i)==y.charAt(j)){
					
					LCS[i][j] = LCS[i+1][j+1]+1;
					//i--;
					j++;
					tempcount++;
				}
				
				else{
					
					LCS[i][j] = LCS[i+1][j]>LCS[i][j+1]?LCS[i+1][j]:LCS[i][j+1];
				}
				
				
			}
			if(tempcount > count)
				count = tempcount;
			
		}
		
		System.out.println(count);
		
	}
}
