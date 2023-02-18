import java.util.Scanner;

public class C_Tea_Tasting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		long prefix[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] = prefix[i - 1] + b[i];
			
		}
		
		long times[] = new long[n + 5];
		
		long add[] = new long[n + 5];
		
		for(int i = 1; i <= n; ++i) {
			
			long tea = a[i];
			
			long right_sum = prefix[n] - prefix[i - 1];
			
			if(tea >= right_sum) {
				
				times[i]++;
				times[n + 1]--;
				
				continue;
				
			}
			
			int left = i, right = n, end_at = -1;
			
			while(right >= left) {
				
				int mid = (right + left) / 2;
				
				right_sum = prefix[mid] - prefix[i - 1];
				
				if(tea >= right_sum) {
					
					end_at = mid;
					left = mid + 1;
					
				} else {
					
					right = mid - 1;
					
				}
				
			}
			
			if(end_at == -1) {
				
				add[i] += tea;
				
			} else {
				
				times[i]++;
				times[end_at + 1]--;
				
				long left_sum = tea - (prefix[end_at] - prefix[i - 1]);
				
				if(end_at + 1 <= n) {
					
					add[end_at + 1] += left_sum;
					
				}
				
			}
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			times[i] = times[i - 1] + times[i];
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			long val = times[i] * b[i] + add[i];
			
			sb.append(val).append(" ");
			
		}
		
		sb.append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n + 1];
			
			b = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			for(int i = 1; i <= n; ++i) {
				
				b[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
		System.out.print(sb.toString());
		
	}
	
}