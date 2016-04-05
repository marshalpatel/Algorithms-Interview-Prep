package marshal.practice.com;

import java.util.Arrays;
import java.util.Comparator;

public class SortVersionNums {
	
	
	public static void sortStrings(){
		
		String[] strarr = {"100.00","1.0.9","20.0", "12"};
		
		Arrays.sort(strarr,new VersionComparator());
		//Arrays.sort(strarr);
		for(String s : strarr){
			System.out.println(s);
		}
		
	}

}


class VersionComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		int result = 0;
		int strlen = s1.length()<s2.length()?s1.length():s2.length();
		
		String[] str1 = s1.split("\\.");
		String[] str2 = s2.split("\\.");
		
		int[] sArray1 = new int[str1.length];
		int[] sArray2 = new int[str2.length];
		
		for(int i = 0;i<str1.length;i++){
			sArray1[i]=Integer.parseInt(str1[i]);
		}
		
		for(int i = 0;i<str2.length;i++){
			sArray2[i]=Integer.parseInt(str2[i]);
		}
		
		result = compare(sArray1, sArray2);
		
//		for(int i = 0;i<strlen;i++){
//		
//			result = compare(s1.charAt(i),s2.charAt(i));
//			
//			if(result!=0)
//				return result;
//	}
//	
//	if(result==0){
//		if(s1.length() > s2.length())
//		return 1;
//	
//	if(s1.length() < s2.length())
//		return -1;
//	}
//	
	return result;
	}
	
	public int compare(int[] s1, int[] s2) {
		int result = 0;
		int strlen = s1.length<s2.length?s1.length:s2.length;
		for(int i = 0;i<strlen;i++){
		
			result = compare(s1[i],s2[i]);
			
			if(result!=0)
				return result;
	}
	
	if(result==0){
		if(s1.length > s2.length)
		return 1;
	
	if(s1.length < s2.length)
		return -1;
	}
	
	return result;
	}

	
	private int compare(int c1, int c2){
		
		if(c1>c2)
			return 1;
		else if(c1<c2)
			return -1;
		else
			return 0;
	}

	
	private int compare(char c1, char c2){
		
		if(c1>c2)
			return 1;
		else if(c1<c2)
			return -1;
		else
			return 0;
	}
	
}
