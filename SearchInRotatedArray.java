package marshal.practice.com;

public class SearchInRotatedArray {
	
	
	public static int search(){
		
		int pivot_index = -1;
		int target = 3;
		
		int[] nums = {3,3,1,1};
        
        pivot_index = getPivotIndexDup(nums, 0, nums.length-1);
        
        System.out.println(pivot_index);
        
        if(nums[pivot_index] == target)
            return pivot_index;
            
            if(pivot_index == nums.length-1){
                //simple binary search;
                return binarySearch(nums, 0, nums.length-1, target);
            }
            
            if(target>=nums[0] && target<=nums[pivot_index-1]){
                //search 0 to pivot_index-1;
                return binarySearch(nums, 0, pivot_index-1, target);
            }
            
            else{
                //search pivot_index+1 to end
                return binarySearch(nums, pivot_index+1, nums.length-1, target);
            }
            
            
            
        
	}
	
	 public static int binarySearch(int[] nums, int s, int e, int target){
	        
	        if(s>=e){
	            if(nums[s]==target)
	            return s;
	            
	            else
	            return -1;
	        }
	        
	        int mid = (s+e)/2;
	        
	        if(nums[mid] == target)
	        return mid;
	        
	        if(nums[mid] > target)
	        return binarySearch(nums, s, mid-1, target);
	        
	        else
	        return binarySearch(nums, mid+1, e,target);
	        
	    }
	

public static int getPivotIndexDup(int[] nums, int s, int e){
        
        if(s==e){
            return s;
        }
        
        
        int mid = (s+e)/2;
        
        if(mid==s){
            if(nums[s]>nums[e]){
                return s;
            }
            else{
                return e;
            }
        }
        
        if(mid - 1 >=s && nums[mid-1] <= nums[mid] && mid+1<=e && nums[mid+1]<nums[mid]){
            
            return mid;
            
        }
        
        if(nums[mid] < nums[s]){
            return getPivotIndex(nums, s, mid-1);
        }
        else{
            return getPivotIndex(nums, mid+1, e);
        }
        
    }
	
public static int getPivotIndex(int[] nums, int s, int e){
        
        if(s==e){
            return s;
        }
        
        
        int mid = (s+e)/2;
        
        if(mid==s){
            if(nums[s]>nums[e]){
                return s;
            }
            else{
                return e;
            }
        }
        
        if(mid - 1 >=s && nums[mid-1] <= nums[mid] && mid+1<=e && nums[mid+1]<nums[mid]){
            
            return mid;
            
        }
        
        if(nums[mid] < nums[s]){
            return getPivotIndex(nums, s, mid-1);
        }
        else{
            return getPivotIndex(nums, mid+1, e);
        }
        
    }

}
