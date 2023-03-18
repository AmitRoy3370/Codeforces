import java.util.Scanner;

public class C_Scoring_Subsequences {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			int left = 1, right = i + 1;
			
			while(right >= left) {
				
				int mid = (left + right) / 2;
				
				if(a[i - mid + 1] >= mid) {
					
					left = mid + 1;
					
				} else {
					
					right = mid - 1;
					
				}
				
			}
			
			sb.append(right).append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}