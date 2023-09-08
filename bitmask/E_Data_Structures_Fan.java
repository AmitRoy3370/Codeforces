import java.util.Scanner;

public class E_Data_Structures_Fan {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, query, m, l, r, x_, type;
	
	static long a[];
	
	static char x[];
	
	static long zero = 0L, one = 0L;
	
	static StringBuilder ans = new StringBuilder();
	
	static long prefix_dp[][], suffix_dp[][];
	
	static void preCalculate() {
		
		one = 0L;
		zero = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			if(x[i] == '1') {
				
				one ^= a[i];
				
			} else {
				
				zero ^= a[i];
				
			}
			
			prefix_dp[i][0] = zero;
			prefix_dp[i][1] = one;
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			//solve();
			
		}
		
		System.out.println(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		prefix_dp = new long[n][2];
		suffix_dp = new long[n][2];
		
		//preCalculate();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		x = in.next().toCharArray();
		
		preCalculate();
		
		m = x.length;
		
		query = in.nextInt();
		
		for(int i = 0; i < query; ++i) {
			
			int type = in.nextInt();
			
			if(type == 1) {
				
				l = in.nextInt();
				
				r = in.nextInt();
				
				--l;
				--r;
				
				long _zero = prefix_dp[r][0];
				
				if(l > 0) {
					
					_zero ^= prefix_dp[l - 1][0];
					
				}
				
				long _one = prefix_dp[r][1];
				
				if(l > 0) {
					
					_one ^= prefix_dp[l - 1][1];
					
				}
				
				one ^= _zero;
				one ^= _one;
				
				zero ^= _zero;
				zero ^= _one;
				
			} else {
				
				x_ = in.nextInt();
				
			    if(x_ == 1) {
					
					ans.append(one).append(" ");
					
			    } else {
					
					ans.append(zero).append(" ");
					
			    }
			
			}
			
		}
		
		ans.append("\n");
		
	}
	
}
