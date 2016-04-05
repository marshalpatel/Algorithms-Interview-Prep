package marshal.practice.com;

import java.util.Arrays;

public class ContainsDuplicate {

	public static void containsDuplicate() {

		boolean containDuplicate = false;

		//int[] a = { 0, 10, 22, 15, 0, 5, 22, 12, 1, 5 };// 0,0,1,5,5,10,12,15,22,22
		//int[] a = {3,6,0,4};
		int[] a = {1,2};
		int t = 1;
		int k = 0;

		Numbers[] numArr = new Numbers[a.length];

		for (int i = 0; i < a.length; i++) {

			numArr[i] = new Numbers(i, a[i]);

		}
		
		
		Arrays.sort(numArr);
		
		for (int i = 0; i < a.length; i++) {

			System.out.println(numArr[i].val + "---" + numArr[i].position);

		}


		
		int i=0;
		
		while(i<(numArr.length-1)){
			
			int j = i+1;
			while((j<numArr.length) && (numArr[j].val - numArr[i].val) <= t){
				
				//if((numArr[j].val - numArr[i].val) <= t){
					
					if(Math.abs(numArr[j].position - numArr[i].position) <= k){
						containDuplicate = true;
						break;
					}
					//else
						j++;
				//}
				
				//else{
				
					//break;
				//}
					
				
				//j++;
			}
			
			if(containDuplicate)
				break;
			else
				i++;
			
		}
/*
		for (int i = 1; i < numArr.length; i++) {

			System.out.println(numArr[i].val + "---" + numArr[i].position);

			if ((Math.abs(numArr[i].val - numArr[i - 1].val) <= t)
					&& (Math.abs((numArr[i].position - numArr[i - 1].position)) <= k)){
					//&& ((numArr[i].val - numArr[i - 1].val) >= 0)){
					//&& ((numArr[i].position - numArr[i - 1].position) > 0)) {

				containDuplicate = true;
				System.out.println(i);
				break;
			}

		}*/

		System.out.println(containDuplicate);

	}
}

class Numbers implements Comparable<Numbers> {

	int position;
	int val;

	public Numbers(int position, int val) {

		this.position = position;
		this.val = val;

	}

	@Override
	public int compareTo(Numbers num) {
		// TODO Auto-generated method stub

		if (this.val > num.val)
			return 1;
		else if (this.val < num.val)
			return -1;
		else
			return 0;

	}

}