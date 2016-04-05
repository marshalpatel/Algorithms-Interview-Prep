public class Google1
{
	public static void main(String[] args)
	{
		getLargestNo(1001);
	}


	private static void getLargestNo(int x)
	{
		String str = String.valueOf(x);

		int max = Integer.MIN_VALUE;
		char[] arr = str.toCharArray();

		for(int i = 1; i<arr.length;i++)
		{
			if(arr[i-1] == arr[i])
			{
				String s = i+1<arr.length?str.substring(i+1).toString():"";
				String temp = str.substring(0,i).toString() + s;

				if(Integer.parseInt(temp) > max)
				{
					max = Integer.parseInt(temp);
				}

			}
		}

		System.out.println(max);


	}
}