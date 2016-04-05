public class LongestPalindromicSubstring
{
	public static void main(String[] args)
	{
		System.out.println(getLCS("abxcxdfssef"));
	}


	public static int getLCS(String s)
	{
		char[] arr = s.toCharArray();

		char[] rev = new char[arr.length];

		int row = -1;
		int col = -1;

		int max = 0;

		for(int i = 0; i<arr.length;i++)
		{
			rev[i] = arr[arr.length-1-i];
		}

		int[][] dp = new int[arr.length+1][arr.length+1];

		//initialize table

		for(int i = 0; i <dp.length; i++)
		{
			dp[0][i] = 0;
		}

		for(int i = 0; i <dp.length; i++)
		{
			dp[i][0] = 0;
		}

		for(int i = 1; i<dp.length; i++)
		{
			for(int j = 1; j<dp.length; j++)
			{
				if(arr[i-1] == rev[j-1])
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else
				{
					dp[i][j] = 0;
				}
			}
		}


		for(int i = 0; i<dp.length; i++)
		{
			for(int j = 0; j<dp.length; j++)
			{
				if(dp[i][j] > max)
				{
					max = dp[i][j];
					row = i;
					col = j;
				}
					
			}
		}


		while(row>0 && col>0)
		{
			System.out.print(arr[row-1]);
			row--;
			col--;
		}

		return max;

	}
}