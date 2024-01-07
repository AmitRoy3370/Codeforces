import java.util.Scanner;

public class B_Plus_Minus_Split {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int plus = 0;
		int minus = 0;
		
		for(char i : x) {
			
			if(i == '+') {
				
				++plus;
				
			} else {
				
				++minus;
				
			}
			
		}
		
		System.out.println(Math.abs(plus - minus));
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
}