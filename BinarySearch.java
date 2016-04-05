public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] arr = {3,3,4,5,5,5,7,8,8,9};

		//System.out.println(binarySearch(arr,0,arr.length-1,15));
		System.out.println(binarySearchLeft(arr,0,arr.length-1,5));
		System.out.println(binarySearchRight(arr,0,arr.length-1,5));
	}

	public static int binarySearch(int[] arr, int start, int end, int key)
	{

		if(start == end)
		{
			if(arr[start]==key)
				return start;
			else
				return -1;
		}

		int mid = (start + end)/2;

		if(mid==start)
		{
			if(arr[mid] == key)
				return start;
			else if(arr[end] == key)
				return end;
			else
				return -1;
		}

		if(arr[mid] == key)
			return mid;

		if(arr[mid] > key)
		{
			return binarySearch(arr, start, mid-1, key);
		}
		else
		{
			return binarySearch(arr, mid+1, end, key);
		}

	}

	public static int binarySearchLeft(int[] arr, int start, int end,int key)
	{
		if(start == end)
		{
			if(arr[start]==key)
				return start;
			else
				return -1;
		}

		int mid = (start+end)/2;

		if(mid==start)
		{
			if(arr[mid]==key)
			{
				return start;
			}
			else if(arr[end] == key)
				return end;
			else
				return -1;
		}

		if(arr[mid]==key)
		{
			if(mid-1>=start && arr[mid] == arr[mid-1])
			{
				//search left;

				return binarySearchLeft(arr, start, mid-1, key);
			}
			else
				return mid;
		}

		if(arr[mid] > key)
		{
			return binarySearchLeft(arr, start, mid-1, key);
		}
		else
		{
			return binarySearchLeft(arr, mid+1, end, key);
		}


		//return 0;
	}

	public static int binarySearchRight(int[] arr, int start, int end, int key)
	{
		
		if(start == end)
		{
			if(arr[start]==key)
				return start;
			else
				return -1;
		}

		int mid = (start+end)/2;

		if(mid==start)
		{
			if(arr[mid]==key)
			{
				return start;
			}
			else if(arr[end] == key)
				return end;
			else
				return -1;
		}

		if(arr[mid]==key)
		{
			if(mid+1<=end && arr[mid] == arr[mid+1])
			{
				//search right;

				return binarySearchRight(arr, mid+1, end, key);
			}
			else
				return mid;
		}

		if(arr[mid] > key)
		{
			return binarySearchRight(arr, start, mid-1, key);
		}
		else
		{
			return binarySearchRight(arr, mid+1, end, key);
		}



	}


}