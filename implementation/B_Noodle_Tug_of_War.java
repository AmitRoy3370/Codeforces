import java.util.Scanner;

public class B_Noodle_Tug_of_War {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		long prefix[] = new long[n];
		
		prefix[0] = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		long max_score = Long.MIN_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			long left_sum = prefix[i];
			
			long right_sum = (prefix[n - 1] - prefix[i]);
			
			long score = left_sum * right_sum;
			
			max_score = Math.max(max_score, score);
		
		}
		
		System.out.print(max_score);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}