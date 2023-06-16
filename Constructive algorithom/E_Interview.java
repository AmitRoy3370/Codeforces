import java.util.Scanner;

public class E_Interview {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		int left = -1, right = n;
		
		long _two = 0L;
		
		long prefix[] = new long[n + 1];
		
		prefix[0] = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(right - left > 1) {
			
			int mid = (left + right) / 2;
			
			sb = new StringBuilder();
			
			sb.append("? ").append(mid + 1).append(" ");
			
			for(int i = 0; i <= mid; ++i) {
				
				sb.append(i + 1).append(" ");
				
			}
			
			sb.append("\n");
			
			System.out.print(sb.toString());
			
			long k = in.nextLong();
			
			if(prefix[mid] < k) {
				
				right = mid;
				
			} else {
				
				left = mid;
				
			}
			
		}
		
		sb = new StringBuilder();
		
		sb.append("! ").append(++right).append("\n");
		
		System.out.print(sb.toString());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			
		int left = -1, right = n;
		
		long _two = 0L;
		
		long prefix[] = new long[n + 1];
		
		prefix[0] = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(right - left > 1) {
			
			int mid = (left + right) / 2;
			
			sb = new StringBuilder();
			
			sb.append("? ").append(mid + 1).append(" ");
			
			for(int i = 0; i <= mid; ++i) {
				
				sb.append(i + 1).append(" ");
				
			}
			
			sb.append("\n");
			
			System.out.print(sb.toString());
			
			long k = in.nextLong();
			
			if(prefix[mid] < k) {
				
				right = mid;
				
			} else {
				
				left = mid;
				
			}
			
		}
		
		sb = new StringBuilder();
		
		sb.append("! ").append(++right).append("\n");
		
		System.out.print(sb.toString());
		
			
		}
		
		//System.out.println(ans.toString().trim());
		
	}
	
}