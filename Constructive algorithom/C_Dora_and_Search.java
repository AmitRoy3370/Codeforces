import java.util.Scanner;

public class C_Dora_and_Search {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long min = 1L, max = n; 
		
		int left = 0, right = n - 1;
		
		while(left < n && right >= 0) {
			
			if(a[left] == min) {
				
				++min;
				++left;
				
			} else if(a[left] == max) {
				
				++left;
				--max;
				
			} else if(a[right] == min) {
				
				--right;
				++min;
				
			} else if(a[right] == max) {
				
				--max;
				--right;
				
			} else {
				
				break;
				
			}
			
		}
		
		++right;
		++left;
		
		if(right >= left) {
			
			System.out.println(left + " " + right);
			
		} else {
			
			System.out.println(-1);
			
		}
		
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