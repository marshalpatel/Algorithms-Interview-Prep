package marshal.practice.com;

public class MergeTwoArrays {

	public static void mergeArrays(int[] A, int[] B) {

		// int A[] = {2,3,4,8,-1,-1,-1,-1};
		// int B[] = {1,5,6,7};
		int ae = A.length - 1 - B.length;
		int be = B.length - 1;

		int na = A.length - 1;
		int temp = 0;

		for (int i = 0; i < (B.length + A.length) && be >= 0 && ae >= 0; i++) {

			if (A[ae] > B[be]) {
				temp = A[ae];
				A[ae] = A[na];
				A[na] = temp;
				ae--;
				na--;
			} else {
				A[na] = B[be];
				be--;
				na--;
			}
		}
		
		if(A[0]==-1){
			for(int j=0;j<=be;j++){
				A[j]=B[j];
			}
		}

	}

}
