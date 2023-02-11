import java.util.Scanner;

public class B_Sum_of_Two_Numbers {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n;
	
	static long solve(long n, long addition) {
		
		if(n % 10L == 9L) {
			
			return solve(n / 10L, addition ^ 1) * 10L + 4 + addition;
			
		}
		
		return n / 2L;
		
	}
	
	static void solve() {
		
		if(n % 2L == 0L) {
			
			System.out.println(n / 2L + " " + n / 2L);
			
		} else {
			
			if(n % 10L == 9L) {
				
				long solve = solve(n, 1L);
				
				System.out.println(solve + " " + (n - solve));
				
				return;
				
			}
			
			long first = (n + 1L) / 2L;
			
			long second = (n - 1L) / 2L;
			
			System.out.println(first + " " + second);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextLong();
			
			solve();
			
		}
		
	}
	
	static int digit_sum(long n) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(n);
		
		char a[] = sb.toString().toCharArray();
		
		int sum = 0;
		
		for(char i : a) {
			
			sum += (i - '0');
			
		}
		
		return sum;
		
	}
	
}