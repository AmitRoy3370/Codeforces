import java.util.Scanner;

public class A_Color_the_Picture {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, k;
	
	static long n, m;
	
	static long a[];
	
	static void solve() {
		
		long raws = 0L, coloumns = 0L;
		
		long maximum_raw_distributions = Long.MIN_VALUE;
		
		long maximum_coloumn_distributions = Long.MIN_VALUE;
		
		for(int i = 0; i < k; ++i) {
			
			long raw_distributions = a[i] / m;
			
			long coloumn_distributions = a[i] / n;
			
			if(raw_distributions >= 2L) {
				
				raws += raw_distributions;
				
				maximum_raw_distributions = Math.max(maximum_raw_distributions, raw_distributions);
				
			}
			
			if(coloumn_distributions >= 2L) {
				
				coloumns += coloumn_distributions;
				
				maximum_coloumn_distributions = Math.max(maximum_coloumn_distributions, coloumn_distributions);
				
			}
			
		}
		
		boolean raws_ok = raws >= n && (n % 2L == 0L || maximum_raw_distributions >= 3L);
		
		boolean coloumns_ok = coloumns >= m && (m % 2L == 0L || maximum_coloumn_distributions >= 3L);
		
		if(raws_ok || coloumns_ok) {
			
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