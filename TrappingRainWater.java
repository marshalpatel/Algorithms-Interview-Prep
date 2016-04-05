package marshal.practice.com;

public class TrappingRainWater {
	
	public static void trappingRainWater()
	{
		int[] arr = {2,1,0,3,3,0,1};
		System.out.println("water: " + getWaterAmt(arr));
	}
	
	public static int getWaterAmt(int[] arr)
	{
		//Brute force: for each histogram, calculate the amount of water can be stored starting that histogram.

		int water = 0;
		int index = -1;
		for(int i = 0; i<arr.length;)
		{
			int temp = 0;
			index = -1;
			for(int j = i+1; j<arr.length; j++)
			{
				if(isValid(i,j,arr) && arr[i]>0)
				{
					temp = getWaterAmt(min(i,j,arr),arr, i, j);
					index = j;
					
				}	
			}

			if(index==-1)
				i++;
			else
				i=index;

			System.out.println(temp);
			water += temp;
		}

		return water;


	}


	public static int max(int i, int j, int[] arr)
	{
		return arr[i]>arr[j]?arr[i]:arr[j];
	}


	public static int min(int i, int j, int[] arr)
	{
		return arr[i]<=arr[j]?arr[i]:arr[j];
	}


	public static boolean isValid(int s, int e, int[] arr)
	{
		//int high = arr[s]>arr[e]?arr[s]:arr[e];

		if(s+1==e)
			return false;

		int low = arr[s]<=arr[e]?arr[s]:arr[e];

		for(int i=s+1;i<e;i++)
		{
			if(arr[i] > low)
				return false;
		}

		return true;
	}

	public static int getWaterAmt(int low, int[] arr, int s, int e)
	{
		int i = s+1;
		int water = 0;

		while(i < e)
		{
			int level =  low - arr[i] >= 0?low - arr[i]:0;
			water = water + level;
			i++;
		}

		return water;
	}

}
