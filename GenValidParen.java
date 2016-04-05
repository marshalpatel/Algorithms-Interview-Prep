package marshal.practice.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GenValidParen {
	
	
	static HashSet<String> result = new HashSet<String>();
	public static void genValidParen(){
		
		String str = "";
		String input="()()()";
		
		genValidParenHelper(str,input);
		
		for(String s : result){
			System.out.println(s);
		}
		
	}
	
public static String genValidParenHelper(String str, String input){
		
	
	if(input==""){
		return str;
	}
	
	String tempInput = input.length()>1?input.substring(1):"";
	
	String s1 = genValidParenHelper(str+input.charAt(0),tempInput);
	String s2 = genValidParenHelper(str,tempInput);
	
	if((isValid(s1) && isValid(s2)) || (isValid(s1) && !isValid(s2))){
		result.add(s1);
		return s1;
	}
	
	else if(!isValid(s1) && !isValid(s2)){
		//result.add("");
		return "";
	}
	
	else{
		result.add(s2);
		return s2;
	}
		
	}

private static boolean isValid(String s){
	
	Stack<Character> stack = new Stack<Character>();
	int count = 0;
	for(int i = 0;i<s.length();i++){
		
		if(s.charAt(i) == '('){
			stack.push(s.charAt(i));
		}
		else{
			count++;
			
			if(!stack.isEmpty()){
				stack.pop();
				count--;
			}
			
		}
	}
	
	if(stack.isEmpty() && count==0)
		return true;
	else
		return false;
}

}
