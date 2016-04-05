package marshal.practice.com;

public class AdditiveNumbers {

	static boolean  isAdditive;

	public static boolean isAdditiveNumber() {

		String str = "12012122436";
		
		//String str = "101";
		
		if (str.length() < 3)
			return false;
	//	int index_1 = 0;
		int index_2 = 1;

		String f = str.substring(0, index_2);
		String s = str.substring(index_2, index_2 + 1);

		isAdditiveHelper(f, s, str.substring(index_2 + 1));

		return (isAdditive);

	}

	public static void isAdditiveHelper(String first, String second, String str) {

		if (second.charAt(0) == '0' && second.length() > 1) {
			isAdditiveHelper(first + "0", second.substring(1), str.substring(1));
			return;
		}

		else if (first.charAt(0) == '0' && str.length() > 2 && first.length()>1) {
			isAdditiveHelper(second, String.valueOf(str.charAt(1)),
					str.substring(2));
			return;
		}

		long f = Long.parseLong(first);
		long s = Long.parseLong(second);

		String sum = String.valueOf(f + s);

		if (sum.length() <= str.length()
				&& sum.equals(str.substring(0, sum.length()))) {

			if (str.length() == sum.length()) {
				isAdditive = true;
				return;
			}

			String newString = str.substring(sum.length());

			isAdditiveHelper(second, sum, newString);

		}

		if (str.length() > 1 && !isAdditive) {
			isAdditiveHelper(first + second, String.valueOf(str.charAt(0)),
					str.substring(1));
			isAdditiveHelper(first, second + String.valueOf(str.charAt(0)),
					str.substring(1));
			
			
			
		}

	}
}
