import java.util.Scanner;

public class D_Color_with_Occurrences {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static String a[];
	
	static char s[];
	
	static long dp[];
	
	static long solve(int index) {
		
		if(index == n) {
			
			return 0L;
			
		}
		
		if(dp[index] != -1) {
			
			return dp[index];
			
		}
		
		long ans = 1000000000L;
		
		boolean here = false;
		
		for(int i = 0; i < m; ++i) {
			
			if(index + a[i].length() <= n) {
				
				if(a[i].equals(new String(s).substring(index, index + a[i].length()))) {
					
					for (int j = index + 1; j <= index + a[i].length(); j++) {
						
						ans = Math.min(ans, 1L + solve(j));
						
					}
					
				}
				
			}
			
		}
		
		return dp[index] = ans;
		
	}
	
	static void print(int index) {
		
		if(index >= n) {
			
			return;
			
		}
		
		long option = dp[index];/*= solve(index);*/
		
		boolean here = false;
		
		for(int i = 0; i < m; ++i) {
			
			if(index + a[i].length() <= n) {
				
				if(a[i].equals(new String(s).substring(index, index + a[i].length()))) {
					
					for (int j = index + 1; j <= index + a[i].length(); j++) {
						
						if(option == 1 + solve(j)) {
							
							System.out.println((i + 1) + " " + (index + 1) );
							print(j);
							here = true;
							break;
						
						}
						
						if(here) {
							
							break;
							
						}
						
					}
					
				}
				
			}
			
			if(here) {
				
				break;
				
			}
			
		}
		
	}
	
	static void solve() {
		
		dp = new long[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			dp[i] = -1L;
			
		}
		
		long ans = solve(0);
		
		if(ans == 1000000000L) {
			
			System.out.println(-1);
			
		} else {
			
			System.out.println(ans);
			print(0);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			s = in.next().toCharArray();
			
			n = s.length;
			
			m = in.nextInt();
			
			a = new String[m];
			
			for(int i = 0; i < m; ++i) {
				
				a[i] = in.next();
				
			}
			
			solve();
			
		}
		
	}
	
}