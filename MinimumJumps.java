package marshal.practice.com;

public class MinimumJumps {
	
	public static void getMinJumps()
	{
		//int[] arr = {5,9,3,2,1,0,2,3,2,4,0,0};
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(getMinJumps(arr));
	}
	
	public static int getMinJumps(int[] arr)
	{
		int start = 0;
        int count = 0;
        int i = 1;
        
        while(i<arr.length)
        {
            while(i<arr.length && arr[start]>=i-start)
            {
                i++;
            }
            
            if(i==arr.length)
            return count+1;
            
            
            start = trackMax(arr, start+1, i);
            
            count++;
        }
        
        
        return count;
    
	}
	
	public static int trackMax(int[] arr, int s, int e)
    {
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for(int i = s; i<e && i<arr.length; i++)
        {
            if(arr[i]>=arr.length-i)
            return i;
            
            if(arr[i]+i>=max)
            {
                index = i;
                max = arr[i]+i;
            }
        }
        
        return index;
    }

}
