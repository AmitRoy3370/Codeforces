import java.util.Scanner;

public class A_Color_the_Picture {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, k;
	
	static long n, m;
	
	static long a[];
	
	static void solve() {
		
		long raws = 0L, coloumns = 0L;
		
		long maximum_covered_raws = Long.MIN_VALUE;
		
		long maximum_covered_coloumns = Long.MIN_VALUE;
		
		for(int i = 0; i < k; ++i) {
			
			long raws_coverage = a[i] / m;
			long coloumns_coverage = a[i] / n;
			
			if(raws_coverage >= 2L) {
				
				raws += raws_coverage;
				
				maximum_covered_raws = Math.max(maximum_covered_raws, raws_coverage);
				
			}
			
			if(coloumns_coverage >= 2L) {
				
				coloumns += coloumns_coverage;
				
				maximum_covered_coloumns = Math.max(maximum_covered_coloumns, coloumns_coverage);
				
			}
			
		}
		
		boolean raw_ok = raws >= n && (n % 2L == 0L || maximum_covered_raws >= 3L);
		boolean coloumn_ok = coloumns >= m && (m % 2L == 0L || maximum_covered_coloumns >= 3L);
		
		if(raw_ok || coloumn_ok) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		m = in.nextLong();
		k = in.nextInt();
		
		a = new long[k];
		
		for(int i = 0; i < k; ++i) {
			
			a[i] = in.nextLong();
			
		} 
		
	}
	
}
