public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		int[] arr = {1,1,2,3,3,3,4,5,5,5,5,5,5,5,6};
		removeDuplicates(arr);

	}




/*
method to remove duplicate from sorted array
*/
	private static void removeDuplicates(int[] arr)
	{
		int i = 0;
		int j = 0;

		while(j<arr.length)
		{
			if(j-1>=0 && arr[j]==arr[j-1])
			{
				while(j<arr.length && arr[j]==arr[j-1])
				{
					j++;
				}

				arr[i]=arr[j];
				i++;
				j++;
			}
			else
			{
				arr[i]=arr[j];
				i++;
				j++;
			}
		}

		for(int k = 0; k<i;k++)
		{
			System.out.println(arr[k]);
		}
	}
}