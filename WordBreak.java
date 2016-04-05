package marshal.practice.com;

import java.util.*;
import java.util.HashSet;

public class WordBreak {

	static ArrayList<String> result = new ArrayList<String>();
	static HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
	static List<String> strings = new ArrayList<String>();

	public static void wordbreakInit() {

		HashSet<String> dict = new HashSet<String>();

		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		dict.add("cat");
		// dict.add("s");

		String str = "catsanddog";

		System.out.println(wordBreakHelper(str, 0, dict));

		for (String string : strings) {
			System.out.println(string);

		}

	}

	public static boolean wordBreakHelper(String str, int s, Set<String> d) {

		if (s == str.length()) {

			String temp = "";
			for (String string : result) {
				// System.out.println(string);
				temp += string + " ";
			}
			temp.trim();
			strings.add(temp);
			return true;
		}

		boolean out = false;

		if (map.containsKey(s)) {
			return map.get(s);
		}

		for (int i = s; i < str.length(); i++) {

			String temp = str.substring(s, i + 1);

			if (d.contains(temp)) {
				result.add(temp);
				out = wordBreakHelper(str, i + 1, d);
				result.remove(result.size() - 1);

			}

		}

		map.put(s, out);
		return out;
	}

}
