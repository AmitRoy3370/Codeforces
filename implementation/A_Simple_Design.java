import java.util.Scanner;

public class A_Simple_Design {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, k;
	
	static long x;
	
	static void solve() {
		
		long have_sum = sum(x);
		
		long remaining_have = have_sum % k;
		
		if(remaining_have == 0L) {
			
			System.out.println(x);
			return;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(sum(x) % k != 0) {
			
			++x;
			
		}
		
		//sb.reverse();
		
		System.out.println(x);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.nextLong();
		k = in.nextInt();
		
	}
	
	private static long sum(long x) {
		
		long sum = 0L;
		
		while(x > 0L) {
			
			sum += x % 10L;
			
			x /= 10L;
			
		}
		
		return sum;
		
	}
	
}