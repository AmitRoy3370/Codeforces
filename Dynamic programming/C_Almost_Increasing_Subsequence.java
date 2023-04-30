import java.util.Scanner;

public class C_Almost_Increasing_Subsequence {
	
	static int testCases, n;
	
	static long a[], dp[], prefix_dp[];
	
	static int L, R;
	
	static Scanner in = new Scanner(System.in);
	
	static StringBuilder sb = new StringBuilder();
	
	static void makeDp() {
		
		dp[1] = 1L;
		
		for(int i = 2, length = 1; i <= n; ++i) {
			
			if(a[i - 1] >= a[i]) {
				
				++length;
				
			} else {
				
				length = 1;
				
			}
			
			dp[i] = length;
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			long adder = (dp[i] > 2L ? 1L : 0L);
			
			prefix_dp[i] = prefix_dp[i - 1] + adder;
			
		}
		
	}
	
	static void solve() {
		
		if(R == L) {
			
			sb.append(1).append("\n");
			return;
			
		}
		
		if(R - L + 1 == 2) {
			
			sb.append(2).append("\n");
			return;
			
		}
		
		long deduct_length = prefix_dp[R] - prefix_dp[L + 1];
		
		long len = R - L + 1;
		
		len -= deduct_length;
		
		sb.append(len).append("\n");
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		testCases = in.nextInt();
		
		a = new long[n + 1];
		
		dp = new long[n + 1];
		prefix_dp = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		makeDp();
		
		for(int t = 0; t < testCases; ++t) {
			
			L = in.nextInt();
			
			R = in.nextInt();
			
			solve();
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}

/*

9 1
1 2 4 3 3 5 6 2 1
2 5

*/