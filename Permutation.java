
import java.util.*;

public class Permutation
{
	static List<String> result = new ArrayList<String>();

	public static void main(String[] args)
	{
		//System.out.println(perms("           Hello world  marshal   patel           "));
		perms("abcd");

	}

	public static void perms(String str)
	{
		Set<Integer> index = new HashSet<Integer>();
		char[] arr = str.toCharArray();

		permsHelper(arr, index,"");

		for(String s : result)
		{
			System.out.println(s);
		}
	}

	public static void permsHelper(char[] arr, Set<Integer> index, String s)
	{
		if(s.length() == arr.length)
		{
			result.add(s);
			return;
		}

		//String temp = "";
		for(int i = 0; i<arr.length; i++)
		{
			
			if(!index.contains(i))
			{
				s +=arr[i];
				index.add(i);
				permsHelper(arr, index,s);

				if(s.length()==1)
				{
				s="";
				}
				else
				{
				s = s.substring(0,s.length()-1);
				}
				index.remove(i);
			}
	
		}
	}
}