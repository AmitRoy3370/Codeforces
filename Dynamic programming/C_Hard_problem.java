import java.util.Scanner;

public class C_Hard_problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long cost[];
	
	static String a[];
	
	static void solve() {
		
		String reverse[] = new String[n];
		
		// collect the reverse of the every string
		
		for(int i = 0; i < n; ++i) {
			
			reverse[i] = reverse(a[i]);
			
		}
		
		long dp[][] = new long[n][2];
		
		// here 0 means we use reverse operations
		// at here, 1 means we skip this operations
		// at here.
		
		for(int i = 0; i < n; ++i) {
			
			dp[i][0] = Long.MAX_VALUE;
			dp[i][1] = Long.MAX_VALUE;
			
		}
		
		// set the initial value's
		
		dp[0][0] = cost[0];
		dp[0][1] = 0;
		
		// here we will check all the combination
		
		/*
		     1  2  3
		  -> aa ba ac -> original
		  -> aa ab ca -> reverse data
		  
		  we will compare with 
		    - (reverse, original)
			- (reverse, reverse)
			- (original, reverse)
			- (original, original)
		
		*/
		
		for(int i = 1; i < n; ++i) {
			
			if(dp[i - 1][1] != Long.MAX_VALUE && compare(reverse[i], a[i - 1]) >= 0) {
				
				dp[i][0] = Math.min(dp[i - 1][1] + cost[i], dp[i][0]);
				
			}
			
			if(dp[i - 1][0] != Long.MAX_VALUE && compare(reverse[i], reverse[i - 1]) >= 0) {
				
				dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + cost[i]);
				
			}
			
			if(compare(a[i], reverse[i - 1]) >= 0) {
				
				dp[i][1] = Math.min(dp[i][1], dp[i - 1][0]);
				
			}
			
			if(compare(a[i], a[i - 1]) >= 0) {
				
				dp[i][1] = Math.min(dp[i - 1][1], dp[i][1]);
				
			}
			
		}
		
		System.out.print(((Math.min(dp[n - 1][0], dp[n - 1][1])) >= Long.MAX_VALUE ? -1 : (Math.min(dp[n - 1][0], dp[n - 1][1]))));
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			cost = new long[n];
			
			a = new String[n];
			
			for(int i = 0; i < n; ++i) {
				
				cost[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.next();
				
			} 
			
			solve();
			
		}
		
	}
	
	static void swap(char a[], int i, int j) {
		
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	static String reverse(String s) {
		
		char a[] = s.toCharArray();
		
		int n = a.length;
		
		for(int i = 0; i < n / 2; ++i) {
			
			swap(a, i, n - i - 1);
			
		}
		
		return new String(a);
		
	}
	
	static int compare(String a, String b) {
		
		return a.compareTo(b);
		
	}
	
}