public class BigProduct
{
	public static void main(String[] args)
	{
		//System.out.println(getBigSum("", ""));

		System.out.println(getBigProduct("1231009875" ,"1423345566"));
	}

	public static String getBigProduct(String s1, String s2)
	{
		boolean isS1Small = s1.length() <= s2.length() ? true : false;
		String small = "";
		String big = "";
		int index = 0;

		String[] result;
		if(isS1Small)
		{
			result = new String[s1.length()];
			small = s1;
			big = s2;
		}
		else
		{
			result = new String[s2.length()];
			small = s2;
			big = s1;
		}

		for(int i = small.length()-1; i>=0; i--,index++)
		{
			result[index] = "";
			for(int z = 0; z<index ; z++)
			{
				result[index] = "0" + result[index];
			}

			int temp = Integer.parseInt(small.charAt(i)+"");
			int carry = 0;
			for(int j = big.length()-1; j>=0; j--)
			{
				int p = temp * Integer.parseInt(big.charAt(j)+"") + carry;
				carry = p/10;
				int rem = p%10;
				result[index] = rem + result[index];
			}

			if(carry > 0)
			{
				result[index] = carry + result[index];
			}

			
		}

		String sum = "";
		for(int i = 0; i<result.length; i++)
		{
			
			sum = getBigSum(sum, result[i]);
		}

		return sum;

	}

	public static String getBigSum(String s1, String s2)
	{
		String small = "";
		String big = "";

		small = s1.length()<=s2.length()?s1:s2;
		big = s1.length()>s2.length()?s1:s2;

		int s = small.length()-1;
		int b = big.length()-1;
		int carry = 0;
		String result = "";
		//int sum = 0;

		while(s>=0 && b>=0)
		{
			int sum = Integer.parseInt(small.charAt(s)+"") + Integer.parseInt(big.charAt(b)+"") + carry;
			carry = sum/10;
			int rem = sum%10;
			result = rem + result;
			s--;
			b--;
		}


		while(b>=0)
		{
			
			int sum = Integer.parseInt(big.charAt(b)+"") + carry;
			carry = sum/10;
			int rem = sum%10;
			result = rem+result;
			b--;
		}

		if(carry>0)
		{
			result = carry+result;
		}



		return result;

	}
}