import java.util.Scanner;

public class E_Look_Back {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long per_step = 0L;
		
		long ans = 0L;
		
		for(int i = 1; i < n; ++i) {
			
			long this_step = (long)Math.ceil(Math.log((double)a[i - 1] / (double)a[i]) / Math.log(2));
			
			per_step += this_step;
			
			if(per_step < 0L) {
				
				per_step = 0;
				
			}
			
			ans += per_step;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static long pow(long base, long power, long pow_value) {
		
		if(power == 0) {
			
			return 1;
			
		}
		
		pow_value = pow(base, power / 2, pow_value);
		
		if(power % 2 == 1) {
			
			return pow_value * pow_value * base;
		
		} else {
			
			return pow_value * pow_value;
			
		}
		
	}
	
}