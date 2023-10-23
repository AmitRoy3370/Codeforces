import java.util.Scanner;

public class A_Morning {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int digit[] = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			if(x[i] == '0') {
				
				digit[i] = 10;
				
			} else {
				
				digit[i] = (x[i] - '0');
				
			}
			
		}
		
		int sum = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(i == 0) {
				
				sum = digit[i];
				
			} else {
				
				sum += Math.abs(digit[i] - digit[i - 1]) + 1;
			
			}
		
		} 
		
		System.out.println(sum);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		
		n = x.length;
		
	}
	
}
