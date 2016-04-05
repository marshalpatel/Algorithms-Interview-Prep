package marshal.practice.com;

public class InPlaceDuplicateRemoval {

	public static void removeDuplicates() {

		// blooooommmbbeergg
		int[] arr = {1,2,2,4,4,5,6,7,7,7};
		//removeDuplicateHelper("bbaaddxyz");
		removeDuplicateHelper(arr);
		//removeDuplicateHelper("ggggghhhhhnnabc");
	}
	
	
	private static void removeDuplicateHelper(int[] arr){
		
		int i = 0;
		int j = 1;
		int pos = -1;

		while(j<arr.length){
			
			if(arr[i]==arr[j]){
				
				//shift
				pos = i+1;
				while(j<arr.length && arr[i]==arr[j]){
					
					j++;
				}
				
				if(j<arr.length){
				arr[pos]=arr[j];
				i=pos;
				
				}
			}
			
			else{
				
				i++;
				j++;
			}
			
			
		}
		
		System.out.println(i);
		
		for(int num : arr){
			System.out.println(num);
		}
		
	}

	private static void removeDuplicateHelper(String str) {

		char[] charArray = new char[str.length()];

		for (int k = 0; k < str.length(); k++) {
			charArray[k] = str.charAt(k);
		}

		//charArray[str.length()] = '\0';

		// char[] charArray = str.toCharArray();

		int i = 0;
		int j = 1;
		int v = 1;

		while (j < charArray.length) {

			if (charArray[i] == charArray[j]) {

				v=j;
				//j++;
				while (j < charArray.length && charArray[i] == charArray[j]) {
					charArray[j]='\0';
					j++;
				}
				
				i = j;
				j++;
			}
			
			
			else{
				i++;j++;
			}
		}
		
		//charArray[charArray.length-1]='\0';
		System.out.println(new String(charArray));
		
		 i = 0;
		 j = 0;
		
		while(i<charArray.length && j <charArray.length){
			
			if(charArray[i]!='\0'){
				i++;
				j++;
			}
			
			else{
				while(j<charArray.length && charArray[j]=='\0'){
					j++;
				}
				if(j<charArray.length){
				charArray[i]=charArray[j];
				charArray[j]='\0';
				i++;j++;
				}
			}
		}
		
		System.out.println(new String(charArray));
		
		//String s = "abc">"aax"?"abc":"xyz";
		System.out.println();

	}

}
