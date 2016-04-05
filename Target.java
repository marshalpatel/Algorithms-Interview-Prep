package marshal.practice.com;

import java.util.Arrays;

public class Target {
	
	
	public static void getScore(){
		
		int[][] x = {{0,0},
					 {1,1},
					 {2,2},
					 {3,3},
					 {4,4},
					 {5,5}};
		
		int[] r = {2,4,6,8,10};
		
		System.out.println(getScore(x, r));
	}
	
public static int getScore(int[][] coods, int[] r){
        
        //double[] radii = new double[r.length];
        
        int score = 0;
        
        //for(int i = 0;i < r.length; i++){
            
          //  radii[i] = (double)r[i-1];
        //}
        
        double[] distance = new double[coods.length];
        
        for(int i = 0;i<coods.length;i++){
            
            distance[i] = getDistance(coods[i][0],coods[i][1]);
        }
        
        Arrays.sort(distance);
        
        int a = 0;
        int b = 0;
        
        while(b<distance.length && a<r.length){
            
            if(distance[b] <= r[a]){
                
                score += r.length-a;
                b++;
            }
            
            else{
            while(b < distance.length && a<r.length && (double)r[a]<distance[b]){
                a++;
            }
            }
            
        }
        
        return score;
        
    }
    
    private static double getDistance(int x, int y){
        
        //return Math.sqrt((x*x) + (y*y));
    	
    	return x>y?x:y;
    }


}
