package marshal.practice.com;

public class RotateArray {

	public static void rotate(){
		
		int[] arr = {1,2,3,4,5};
		int k = 8;
		
		rotate(arr,k);
		
		for(int i:arr){
			
			System.out.print(i+" ");
		}
	}
	
public static void rotate(int[] nums, int k) {
        
        
        int count=0;
        int prev = 0;
        int next = k<nums.length?k:k%nums.length;
        int temp = nums[next];
        int start = 0;
        boolean isFirstTime = true;
        while(count<nums.length){
            
            while(start!=next && count<nums.length){
            if(isFirstTime){
                nums[next]=nums[start];
                count++;
                isFirstTime=false;
            }
            else{
                int t = temp;
                temp = nums[next];
                nums[next]=t;
                count++;
            }
            next = next+k<nums.length?next+k:(next+k)%nums.length;
           // count++;
            }
            
            //nums[next]=temp;
            int t = temp;
            temp = nums[next];
            nums[next]=t;
            count++;
            
            start++;
            next = start+k<nums.length?start+k:(start+k)%nums.length;
            isFirstTime=true;
            temp = nums[next];
        }
    }

}
