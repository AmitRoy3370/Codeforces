import java.util.Scanner;

public class B_Distinct_Elements {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long b[] = new long[n];
		
		long element = n;
		
		b[0] = element--;
		
		for(int i = 1; i < n; ++i) {
			
			int index = i + 1 + (int)(a[i - 1] - a[i]);
			
			if(index < 1) {
				
				b[i] = element--;
				
			} else {
				
				b[i] = b[index - 1];
				
			}
			
		}

		StringBuilder sb = new StringBuilder();
		
		for(long i : b) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}