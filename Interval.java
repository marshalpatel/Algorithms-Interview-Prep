package marshal.practice.com;

public class Interval implements Comparable<Interval> {

	public int start;
	public int end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	public Interval() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Interval I) {
		// TODO Auto-generated method stub

		if (I.end > this.end)
			return -1;
		else if (I.end < this.end) {
			return 1;
		} else
			return 0;

	}
}
