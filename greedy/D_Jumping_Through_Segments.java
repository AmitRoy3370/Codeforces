import java.util.Scanner;

public class D_Jumping_Through_Segments {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		boolean already_ok = true;
		
		for(int i = 0; i != n; ++i){
			
			if(a[i] != 0 && b[i] != 0) {
				
				already_ok = false;
				break;
				
			}
			
		}
		
		if(already_ok) {
			
			System.out.println(0);
			return;
			
		}
		
		long max_jump = 0L;
		
		long l = 0, r = (long)(1e18);
		
		while(l + 1 < r) {
			
			long mid = (l + r) / 2L;
			
			if(possible(mid)) {
				
				r = mid;
				max_jump = mid;
				
			} else {
				
				l = mid;
				
			}
			
		}
		
		System.out.println(max_jump);
		
	}
	
	private static boolean possible(long x) {
		
		long start = 0L, end = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			start -= x;
			end += x;
			
			start = Math.max(start, a[i]);
			end = Math.min(end, b[i]);
			
			if(start > end) {
				
				return false;
				
			}
			
		}
		
		return true;
		
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
		
		a = new long[n];
		b = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			b[i] = in.nextLong();
			
		}
		
	}
	
}