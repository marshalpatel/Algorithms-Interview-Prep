public class LuckyNo
{
	static boolean almostLucky = false;
	static boolean lucky = false;

	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10};

		for(int i = 0; i<arr.length; i++)
		printLuckyDivisors(arr[i]);
	}

	private static void printLuckyDivisors(int n)
	{
		int lucky_count = 0;
		int almostLucky_count = 0;
		for(int i = 3; i<=n; i++)
		{
			lucky = false;
			almostLucky = false;
			if(n%i==0)
			{
				isLucky(i);
				if(lucky)
				{
					lucky_count++;
				}

				else if(almostLucky)
				{
					almostLucky_count++;
				}
			}
		}


		System.out.println (lucky_count + almostLucky_count);
	}

	private static void isLucky(int div)
	{
		int length = 0;
		//int threes = 0;
		//int fives = 0;
		int count = 0;

		while(div>0)
		{
			length++;
			int rem = div%10;
			if(rem == 3 || rem==5)
			{
				almostLucky = true;
				
				count++;
			}

			div = div/10;
		}

		if(length == count)
		{
			lucky = true;
			almostLucky = false;
		}
			
	}
}