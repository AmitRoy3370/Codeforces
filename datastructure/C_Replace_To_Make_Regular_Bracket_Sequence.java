import java.util.Scanner;
import java.util.Stack;

public class C_Replace_To_Make_Regular_Bracket_Sequence {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		Stack<Character> stack = new Stack<>(); 
		
		int replace = 0;
		
		for(char i : a) {
			
			if(i == '(') {
				
				stack.push(i);
				
			} else if(i == '{') {
				
				stack.push(i);
				
			} else if(i == '(') {
				
				stack.push(i);
				
			} else if(i == '<') {
				
				stack.push(i);
				
			} else if(i == '[') {
				
				stack.push(i);
				
			} else if(!stack.isEmpty() && i == ')' && stack.peek() == '(') {
				
				stack.pop();
				
			} else if(!stack.isEmpty() && i == '}' && stack.peek() == '{') {
				
				stack.pop();
				
			} else if(!stack.isEmpty() && i == ']' && stack.peek() == '[') {
				
				stack.pop();
				
			} else if(!stack.isEmpty() && i == '>' && stack.peek() == '<') {
				
				stack.pop();
				
			} else if(stack.isEmpty()) {
				
				System.out.println("Impossible");
				
				return;
				
			} else {
				
				++replace;
				stack.pop();
				
			}
			
		}
		
		if(!stack.isEmpty()) {
			
			System.out.println("Impossible");
			return;
			
		}
		
		System.out.println(replace);
		
	}
	
	public static void main(String [] priya) {
		
		a = in.next().toCharArray();
		
		n = a.length;
		
		solve();
		
	}
	
}