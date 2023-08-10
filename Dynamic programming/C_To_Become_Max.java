import java.util.Scanner;

public class C_To_Become_Max {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long k;
	
	static long a[];
	
	static boolean ok(long mid) {
		
		long getting_max = 0L;
		
		for(int i = 1; i <= n; ++i) {
			
			getting_max = 0L;
			
			for(int j = i; j <= n; ++j) {
				
				if(a[j] < mid - j + i) {
					
					getting_max += mid - j + i - a[j];
					
				} else if(getting_max <= k) {
					
					return true;
						
				}
				
			}
			
		}
		
		return false;
		
	}
	
	static void solve() {
		
		long left = 1, right = (long)(2e8);
		
		while(right > left) {
			
			long mid = (left + right + 1) / 2L;
			
			//System.out.println(left + " " + right + " " + mid);
			
			if(ok(mid)) {
				
				left = mid;
				
			} else {
				
				right = mid - 1;
				
			}
			
		}
		
		System.out.println(left);
		
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
		
		k = in.nextLong();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}