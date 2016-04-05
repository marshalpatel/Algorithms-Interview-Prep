package marshal.practice.com;

public class Elements implements Comparable<Elements> {

	public int val;
	public int count;

	public Elements(int v, int c) {
		val = v;
		count = c;
	}

	@Override
	public int compareTo(Elements e) {
		// TODO Auto-generated method stub
		if (this.count > e.count)
			return -1;
		else if (this.count < e.count)
			return 1;
		else
			return 0;
	}

}