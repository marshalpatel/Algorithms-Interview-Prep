import java.util.*;


class Points
{
	int x;
	int y;

	public Points(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
}


public class NQueen
{

	static ArrayList<ArrayList<Points>> result = new ArrayList<ArrayList<Points>>();
	
	public static void main(String[] args)
	{
		nQueen(9);
	}

	/*
N-Queen Problem
*/


private static void nQueen(int n)
{
	char[][] board = new char[n][n];
	ArrayList<Points> points = new ArrayList<Points>();

	String x = "1,2,#,#,#,";

	String[] arr = x.split(",");

	for(int i = 0; i<arr.length;i++)
	{
		if(arr[i].equals("#"))
		System.out.println(arr[i]);
	}


	for(int i = 0;i<n;i++)
	{
		for(int j = 0; j<n; j++)
		{
			board[i][j] = '.';
		}
	}

	nQueenHelper(n,0,n,board,points);

	System.out.println(result.size());
}

private static void nQueenHelper(int n, int row,int col, char[][] board, ArrayList<Points> points)
{
	if(n==0)
	{
		result.add(points);
		return;
	}

	if(row < col)
	{
		for(int c = 0; c<col;c++)
		{
			//ArrayList<Points> temp = new ArrayList<Points>();
			if(isSafe(row,c,col,board))
			{
				//System.out.println("row: "+ row + ", col: " + c);
				points.add(new Points(row,c));
				board[row][c] = 'Q';
				nQueenHelper(n-1,row+1,col,board,points);
				board[row][c] = '.';
				points.remove(points.size()-1);
			}
		}
	}
}


private static boolean isSafe(int row, int col, int n, char[][] board)
{
	//check columns
	for(int i = 0; i < n; i++)
	{
		if(board[row][i]=='Q')
			return false;
	}

	//check cells above

	for(int i = row-1; i>=0 ;i--)
	{
		if(board[i][col]=='Q')
			return false;
	}

	//check diagonals

	//check top-left

	int t = row-1;
	int l = col-1;
	int r = 0;
	int b = 0;

	while(t>=0 && l>=0)
	{
		if(board[t][l]=='Q')
			return false;
		t--;
		l--;
	}

	//check top right
	t = row-1;
	r = col+1;

	while(t>=0 && r<n)
	{
		if(board[t][r]=='Q')
			return false;
		t--;
		r++;
	}

	//check bottom left
	b = row+1;
	l = col-1;

	while(b<board.length && l>=0)
	{
		if(board[b][l]=='Q')
			return false;
		b++;
		l--;
	}

	//check bottom right
	b = row+1;
	r = col+1;

	while(b<board.length && r<n)
	{
		if(board[b][r]=='Q')
			return false;
		b++;
		r++;
	}

	return true;

}

/*nQueen Ends */


}

