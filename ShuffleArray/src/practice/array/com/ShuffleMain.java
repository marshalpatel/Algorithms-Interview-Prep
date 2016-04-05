package practice.array.com;

public class ShuffleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3,2,4,1,8,0};
		
		shuffle(arr);
		
		//System.out.println(arr.toString());

	}
	
	public static void shuffle(int a[]){
		
		int rand = 0;
		for(int i = a.length-1;i>=0;i--){
			
			rand = (int)(Math.random() * (i + 1)) ;
			//System.out.println("rand:"+rand);
		//System.out.println((int)(Math.random() * (10-5 + 1) + 5));
			swap(a,rand,i);
			System.out.println(a[i]);
		}
		
	}
	
	public static void swap(int a[],int r, int index){
		
		int temp=0;
		
		temp = a[r];
		a[r] = a[index];
		a[index]=temp;
	}

}
