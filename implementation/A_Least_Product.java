import java.util.Scanner;

public class A_Least_Product {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		for(long i : a) {
			
			if(i == 0) {
				
				ans.append(0);
				
				if(t != testCases) {
					
					ans.append("\n");
					
				}
				
				return;
				
			}
			
		}
		
		long val = 1L;
		
		for(long i : a) {
			
			if(i > 0L) {
				
				val *= 1L;
				
			} else {
				
				val *= -1L;
				
			}
			
		}
		
		if(val >= 0) {
			
			ans.append(1).append("\n");
			
			ans.append(1).append(" ").append(0);
			
		} else {
			
			ans.append(0);
			
		}
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			 
		}
		
	}
	
}