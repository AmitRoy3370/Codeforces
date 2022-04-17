import java.util.Scanner;

public class E_Special_Elements {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, n;
	
	private static int a[];
	
	private static void solve() {
		
		int prefix[] = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] += prefix[i - 1] + a[i - 1];
			
		}
		
		boolean isPresent[] = new boolean[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = i + 1; j <= n && prefix[j] - prefix[i - 1] <= n; ++j) {
				
				isPresent[prefix[j] - prefix[i - 1]] = true;
				
			}
			
		}
		
		int ans = 0;
		
		for(int i = 1; i <= n; ++i) {
			
			ans += (isPresent[a[i - 1]] ? 1 : 0); 
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		} 
		
	}
	
}