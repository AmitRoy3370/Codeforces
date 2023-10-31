import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class B_Deja_Vu {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[], b[];
	
	static void solve() {
		
		List<Long> B = new ArrayList<>();
		
		for(int i = 0; i < m; ++i) {
			
			if(B.isEmpty() || B.get(B.size() - 1) > b[i]) {
				
				B.add(b[i]);
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			for(long j : B) {
				
				if(a[i] % pow(2L, j, 1L) == 0L) {
					
					a[i] += pow(2L, j - 1, 1L);
					
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : a) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		m = in.nextInt();
		
		a = new long[n];
		
		b = new long[m];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
	private static long pow(long base, long power, long result) {
		
		if(power == 0L) {
			
			return 1L;
			
		}
		
		result = pow(base, power / 2L, result);
		
		if(power % 2L == 1L) {
			
			return result * result * base;
			
		} else {
			
			return result * result;
			
		}
		
	}
	
}