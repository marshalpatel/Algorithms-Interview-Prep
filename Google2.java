class Node
{
	String val;
	Node next;
	Node child;

	public Node(String v)
	{
		this.val = v;
	}
}

public class Google2
{
	

	public static void main(String[] args)
	{
		String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
		//String s = "dir1\ndir2";
		String[] sarr = s.split("\\n");
		Node root;

		for(String str:sarr)
		{
			System.out.println(str);
		}

		root = new Node(sarr[0]);
		createStructure(root,sarr,0,1);

		traverseStructure(root);

	}


	private static void traverseStructure(Node root)
	{
		if(root == null)
			return;

		System.out.println(root.val);

		traverseStructure(root.child);
		traverseStructure(root.next);
	}

	private static void createStructure(Node root, String[] arr, int level, int index)
	{
		if(level >= arr.length)
			return;

		for(int i = index; i < arr.length;)
		{
			int count = countSpace(arr[i]);

			if(count == level)
			{
				root.next = new Node(arr[i].trim());
				//root = root.next;
				createStructure(root.next, arr, level, ++i);
			}
			else if(count < level)
			{
				return;
			}
			else
			{
				root.child = new Node(arr[i].trim());
				//root = root.next;
				createStructure(root.child, arr, level+1, ++i);
			}

			i++;
		}
	}

private static int countSpace(String s)
{
	int count=0;

	while(s.charAt(count) == ' ')
		count++;

	return count;
}


	
}