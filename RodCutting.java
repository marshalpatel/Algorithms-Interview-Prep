import java.util.*;

class State
{
    int m;
    int n;
    
    public State(int m, int n)
    {
        this.m = m;
        this.n = n;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        State s = (State)obj;
        
        if(s!=null && s instanceof State)
        {
            if(s.m==this.m && s.n==this.n)
            {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7*this.m + 31*this.n;
        
        return hash;
    }
}



public class RodCutting
{
	static int counter = 0;
	static HashMap<State,Integer> map = new HashMap<State,Integer>();

	public static void main(String[] args)
	{
		int[] price = {1,5,8,9,10,17,17,20};

		
		System.out.println(rodCutting(price,0,price.length,1));
		System.out.println(counter);
	}


	private static int max(int a, int b)
	{
		return a>b?a:b;
	}


	public static int rodCutting(int[] price, int start,int n, int length)
	{

		State s = new State(start,length);

		if(map.containsKey(s))
			return map.get(s);
		
		counter++;

		if(length > n || n==0)
			return 0;


		int cost = Integer.MIN_VALUE;

		if(start<price.length)
		{
		cost = max(rodCutting(price,start,n-length,length) + price[start], rodCutting(price, start+1, n, length+1));

		map.put(s,cost);
		}

		return cost;
	}
}