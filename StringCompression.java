package marshal.practice.com;

public class StringCompression {

	public static void compressString(String str){
		
		String result = "";
		int count = 1;
		
		for(int i=0,j=1;i<str.length();){
			
			if(j < str.length() && str.charAt(i)==str.charAt(j)){
				while(j<str.length() && str.charAt(i)==str.charAt(j)){
					count++;
					j++;
				}
				
				if(count>1){
					result +=str.charAt(i)+String.valueOf(count);
				}
				else{
					result +=str.charAt(i);
				}
				
				i=j;
				j=i+1;
				count=1;
			}
			else{
				result +=str.charAt(i);
				i++;j++;
				count=1;
			}
			
			
			
		}
		
		System.out.println(result);
		
	}
}
