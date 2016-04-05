package marshal.practice.com;

public class BIT {

	int[] bit;

    public BIT(int[] nums) {
        
        bit = new int[nums.length+1];
        createBIT(nums);
    }

    void update(int i, int val) 
    {
        int next = i+1;
        //int diff = val - bit[next];
        
        while(next<bit.length)
        {
            bit[next] = bit[next] + val;
            
            next = next + (next & -next);
        } 
        
    }
 
    public int sumRange(int j) 
    {
        
        int sum_j = 0;
        
        sum_j = getSum(j);
        
        return sum_j;
    }
    
    private int getSum(int i)
    {
        int current = i+1;
        
        int sum = 0;
        
        while(current>0)
        {
            sum += bit[current];
            
            current = current - (current & -current);
        }
        
        return sum;
    }
    
    private void createBIT(int[] nums)
    {
        for(int i = 0; i<nums.length; i++)
        {
            update(i, nums[i]);
        }
    }
    
}
