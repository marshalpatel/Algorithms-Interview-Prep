public class ReverseString
{
	public static void main(String[] args)
	{
		System.out.println(reverse("           Hello world  marshal   patel           "));
	}

	public static String reverse(String str)
	{
		char[] arr = str.toCharArray();

		int wordStart = -1;
		int wordEnd = -1;

		for(int i = 0;i<arr.length;i++)
		{
			if(arr[i]!=' ')
			{
				if(wordStart==-1)
				wordStart = i;

				wordEnd = i;
			}
			else
			{
				revese(arr,wordStart,wordEnd);
				wordStart = -1;
				wordEnd = -1;
			}
		}


		if(wordStart<wordEnd && wordStart!=-1 && wordEnd!=-1)
			revese(arr,wordStart,wordEnd);

		revese(arr, 0, arr.length-1);
		return new String(arr);
	}





	public static void revese(char[] arr, int s, int e)
	{
		while(s<e)
		{
			char c = arr[s];
			arr[s] = arr[e];
			arr[e] = c;
			s++;
			e--;
		}
	}
}