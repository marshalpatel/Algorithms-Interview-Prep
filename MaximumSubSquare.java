public class MaximumSubSquare
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1,0,1,1},
						  {0,1,1,1},
						  {1,1,1,1},
						  {1,1,1,1}
						 };

		System.out.println(getMaxSubSquare(matrix));
		System.out.println(getMaxSubRectangle(matrix));
		System.out.println(getMaxSubSquareDP(matrix));
	}


	private static int getMin(int a, int b)
	{
		return a > b ? b : a;
	}


	public static int getMaxSubSquareDP(int[][] matrix)
	{
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;

		//initialize matrix
		for(int i = 0; i<matrix.length; i++)
		{
			dp[i][0] = matrix[i][0];
		}

		for(int i = 0; i<matrix[0].length; i++)
		{
			dp[0][i] = matrix[0][i];
		}


		for(int i = 1; i < matrix.length; i++)
		{
			for(int j = 1; j<matrix[0].length; j++)
			{
				if(matrix[i][j]==1)
				{
					dp[i][j] = getMin(dp[i][j-1],getMin(dp[i-1][j-1], dp[i-1][j])) + 1;
				}
			}
		}

		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j<matrix[0].length; j++)
			{
				if(dp[i][j]>max)
				{
					max=dp[i][j];
				}
			}
		}

		return max;


	}

	public static int getMaxSubRectangle(int[][] matrix)
	{
		int max = 0;
		int area = 0;



		for(int i = 1; i<=matrix.length; i++)
		{
			for(int j = 1; j<=matrix[0].length; j++)
			{
				if(isSubRectange(matrix, i , j))
				{
					//max++;
					if(i*j > max)
					{
						max = i * j;
						//break;
					}
					//break;
				}
			}
		}

		return max;
	}


	public static boolean isSubRectange(int[][] matrix, int h, int w )
	{
		boolean flag = true;

		int count_h = matrix.length-h+1;
		int count_w = matrix[0].length-w+1;

		for(int start_row=0;start_row<count_h;start_row++)
		{
			for(int start_col=0;start_col<count_w;start_col++)
			{
				flag = true;
				for(int i = start_row; i<start_row+h;i++)
				{
					for(int j = start_col; j<start_col+w;j++)
					{
						if(matrix[i][j]==0)
						{
							flag = false;
							break;
						}
					}

					if(!flag)
					break;
				}
				if(flag)
			return true;
				
			}
			
		}

		return false;
	}

	public static int getMaxSubSquare(int[][] matrix)
	{
		//1. check for each subsquare of size 1 to n

		int max  = 0;

		for(int i = 1; i<=matrix.length; i++)
		{
			if(isSubSquare(matrix, i))
				max++;
		}

		return max;

	}

	public static boolean isSubSquare(int[][] matrix, int length)
	{
		int count = matrix.length-length+1;
		boolean flag = true;

		for(int start_row = 0;start_row<count; start_row++)
		{
			for(int start_col = 0; start_col<count;start_col++)
			{
				flag = true;
				for(int i = start_row; i < start_row+length; i++)
				{
					for(int j = start_col; j<start_col+length;j++)
					{
						if(matrix[i][j]==0)
						{
							flag = false;
							break;
						}
					}

					if(!flag)
						break;
				}

				if(flag)
					return true;
				
			}
		}

		return false;

	}
}