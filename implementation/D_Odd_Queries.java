import java.util.Scanner;

public class D_Odd_Queries {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[];
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			a = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			long prefix[] = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				prefix[i] = prefix[i - 1] + a[i];
				
			}
			
			long sum = prefix[n];
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < m; ++i) {
				
				int left = in.nextInt();
				int right = in.nextInt();
				long val = in.nextLong();
				
				long new_val = sum - (prefix[right] - prefix[left - 1]);
				new_val += (right - left + 1) * val;
				
				if(new_val % 2L == 1L) {
					
					sb.append("YES").append("\n");
					
				} else {
					
					sb.append("NO").append("\n");
					
				}
				
			}
			
			System.out.print(sb.toString());
			
		}
		
	}
	
}