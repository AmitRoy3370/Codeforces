import java.util.Scanner;

public class C_Complex_Market_Analysis {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, e;
	
	static long a[];
	
	static boolean prime[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		long pair = 0L;
		
		if(e >= 0) {
			
			long dp[] = new long[n + 1];
			long suffix_dp[] = new long[n + 1];
			
			int k = e;
			
			for(int i = n; i >= 1; --i) {
				
				if(a[i] != 1L) {
					
					continue;
					
				}
				
				if(i + k <= n) {
					
					suffix_dp[i] = suffix_dp[i + k] + 1;
					
				} else {
					
					suffix_dp[i]++;
					
				}
				
			}
			
			for(int i = 1; i <= n; ++i) {
				
				if(a[i] != 1L) {
					
					continue;
					
				}
				
				//System.out.println("comes with " + a[i]);
				
				if(i - k >= 0) {
					
					dp[i] = dp[i - k] + 1L;
					
				} else {
					
					dp[i]++;
					
				}
				
			}
			
			//print(a);
			//print(dp);
			//print(suffix_dp);
			
			for(int i = 1; i <= n; ++i) {
				
				if(prime[(int)a[i]] || a[i] == 1L) {
					
					continue;
					
				}
				
				//System.out.println("insert for the " + a[i]);
				
				long value = (i - e >= 1) ? dp[i - e] : 0L;
				
				if(i - e >= 0) {
					
					pair += (dp[i - e]);
					
				}
				
				int j = i + k;
				
				if(j > n) {
					
					continue;
					
				}
				
				pair += (suffix_dp[j]);
				
				pair += (suffix_dp[j] * value);
				
				//System.out.println(dp[i] + " " + value);
				
			}
			
			ans.append(pair).append("\n");
			return;
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			if(prime(a[i])) {
				
				++pair;
				
			}
			
		}
		
		ans.append(pair).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		prime();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		e = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static boolean prime(long x) {
		
		if(x == 1) {
			
			return false;
			
		}
		
		for(long i = 2L; i * i <= x; ++i) {
			
			if(x % i == 0L) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	private static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	private static void prime() {
		
		prime = new boolean[(int)(1e6 + 1)];
			
	    for(int i = 2; i < prime.length; ++i) {
			
			if(prime[i]) {
				
				continue;
				
			}
			
			int j = i + i;
			
			for(; j < prime.length; j += i) {
					
				prime[j] = true;
				
			}
				
		}
		
	}
	
}

/*

input

6
7 3
10 2 1 3 1 19 3
3 2
1 13 1
9 3
2 4 2 1 1 1 1 4 2
3 1
1 1 1
4 1
1 2 1 1
2 2
1 2

output

2
0
4
0
5
0

*/