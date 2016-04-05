import java.util.*;

public class Graph
{
	public static void main(String[] args)
	{
		int[][] courses = {{1,0},{2,1}, {3,1}, {0,3}};
		int num = 4;

		List<Integer>[] g = new List[num];

		for (int i = 0; i < num; i++) 
		{
     		 g[i] = new ArrayList<>();
    	}

    	for(int i = 0; i<courses.length; i++)
		{
			g[courses[i][1]].add(courses[i][0]);
		}

		boolean[] visited = new boolean[num];
		boolean[] processed = new boolean[num];

		System.out.println(hasCycle(g, visited, processed));

	}

	/*public static ArrayList<Integer>[] createGraph(int num, int[][] courses)
	{
		ArrayList<Integer>[] graph =  (ArrayList<Integer>[]) new  Object[num];

		for(int i = 0 ;i<num; i++)
		{
			graph[i] = new ArrayList<Integer>();
		}

		

		return graph;
	}*/

	public static boolean hasCycle(List<Integer>[] g, boolean[] visited, boolean[] processed)
	{
		boolean cycle = false;
		for(int i = 0; i<g.length; i++)
		{
			if(!processed[i] && !cycle)
			{
				cycle = dfs(g, i, visited, processed);
			}
			
		}

		if(cycle)
			return true;
		else
			return false;
	}

	public static boolean dfs(List<Integer>[] g, int node, boolean[] visited, boolean[] processed)
	{
		visited[node] = true;
		boolean flag = false;

		for(int i = 0; i<g[node].size() && !flag; i++)
		{
			if(!visited[g[node].get(i)] && !processed[g[node].get(i)])
				flag =  dfs(g,g[node].get(i),visited,processed);
			else if(visited[g[node].get(i)] && !processed[g[node].get(i)])
				flag = true;
		}

		processed[node] = true;
		visited[node] = false;
		
		if(flag)
			return true;
		
		else
		return false;

	}
}