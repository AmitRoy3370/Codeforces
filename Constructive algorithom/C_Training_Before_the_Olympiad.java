import java.util.Scanner;

public class C_Training_Before_the_Olympiad {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		long values[] = new long[n];
		
		int even = 0, odd = 0;
		
		long sum = 0L, reduce = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			if(a[i] % 2L == 0L) {
				
				++even;
				
			} else {
				
				++odd;
				
			}
			
			sum += a[i];
			
			reduce = odd / 3;
			
			if(even == 0 && odd == 1) {
				
				reduce = 0L;
				
			} else if(odd % 3 == 1) {
				
				reduce = (odd + 2) / 3;
				
			}
			
			values[i] = sum - reduce;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : values) {
			
			sb.append(i).append(" ");
			
		}
		
		ans.append(sb.toString().trim()).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}