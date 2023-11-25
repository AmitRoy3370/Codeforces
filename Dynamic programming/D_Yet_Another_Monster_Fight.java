import java.util.Scanner;

public class D_Yet_Another_Monster_Fight {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		long prefix[] = new long[n + 2];
		long suffix[] = new long[n + 2];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] = Math.max(prefix[i - 1], a[i] + n - i);
			
		}
		
		for(int i = n;  i >= 1; --i) {
			
			suffix[i] = Math.max(suffix[i + 1], a[i] + i - 1);
			
		}
		
		long initial_power = Long.MAX_VALUE;
		
		for(int i = 1; i <= n; ++i) {
			
			initial_power =  Math.min(initial_power, Math.max(Math.max(prefix[i - 1], suffix[i + 1]), a[i]));
			
		}
		
		System.out.println(initial_power);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 2];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}