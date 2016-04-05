public class ShortestPalindrome
{
	public static void main(String[] args)
	{
		//abbaabba
		System.out.println(getShortestPalindrome("aba"));
	}

	public static String getShortestPalindrome(String s)
	{
		if(s==null || s.length()==0)
			return s;

		int max_index = 0;

		for(int i = 1; i<s.length(); i++)
		{
			if(isPalindrome(s,0,i))
			{
				max_index = i;
			}
		}




		return insertChar(s, max_index+1);


	}

	public static String insertChar(String s, int index)
	{
		if(index == s.length()-1)
			return s;


		String substr = s.substring(index);

		

		StringBuilder sb = new StringBuilder(s);
		//StringBuilder result = new StringBuilder(s);




		for(int i = 0; i<substr.length(); i++)
		{
			//String x = substr.charAt(i)+"";
			StringBuilder temp = new StringBuilder(substr.charAt(i)+"");

			//System.out.println(temp);

			sb = temp.append(sb);

		}

		return sb.toString();
	}

	public static boolean isPalindrome(String str, int s, int e)
	{
		while(s<e)
		{
			if(str.charAt(s)!=str.charAt(e))
			{
				return false;
			}

			s++;
			e--;
		}

		return true;
	}

	public static String shortestPalindrome(String s)
	{
		if(s==null || s.length()==0)
			return s;

		int i = 0;
		int j = s.length()-1;

		while(i<j)
		{
			if(s.charAt(i) == s.charAt(j))
			{
				i++;
				j--;
			}
			else
			{
				s = insertChar(s,i, s.charAt(j));
				//System.out.println(s);
				//break;
				j++;
			}
		}

		return s;
	}


	public static String insertChar(String s, int index, char c)
	{
		if(index == 0)
		{
			return c+s;
		}
		else
		{
			String t = s.substring(0,index);
			String p = s.substring(index);

			return t+c+p;
		}
	}
}