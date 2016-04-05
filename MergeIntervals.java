package marshal.practice.com;

import java.util.*;

public class MergeIntervals {

	public static List<Interval> merge(Interval[] intArr) {

		List<Interval> result = new ArrayList<Interval>();
		Interval temp = new Interval(intArr[0].start, intArr[0].end);

		for (int i = 1; i < intArr.length; i++) {

			if (intArr[i].start <= temp.end || intArr[i].start<=temp.start) {
				if(intArr[i].start <= temp.end)
				temp.end = intArr[i].end;
				
				if(intArr[i].start<=temp.start)
					temp.start = intArr[i].start;

			}

			else {
				result.add(temp);
				temp = new Interval(intArr[i].start, intArr[i].end);
			}

		}

		result.add(temp);

		return result;

	}

}
