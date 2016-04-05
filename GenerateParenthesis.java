
import java.util.*;

public class GenerateParenthesis
{
	
	public static void main(String[] args)
	{
		genParen(3,3,"");
	}

	public static void genParen(int l, int r, String s)
	{
		if(l==0 && r == 0)
		{
			System.out.println(s);
			return;
		}

		if(l>0)
			genParen(l-1,r,s+"(");

		if(r>l)
		genParen(l,r-1,s+")");
	}
}