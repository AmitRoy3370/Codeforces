import java.util.Scanner;

public class D_Strong_Vertices {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		long c[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			c[i] = a[i] - b[i];
			
		}
		
		long max = c[0];
		
		for(long i : c) {
			
			max = Math.max(i, max);
			
		}
		
		int count = 0;
		
		for(long i : c) {
			
			if(i == max) {
				
				++count;
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(count).append("\n");
		
		int index = 1;
		
		for(long i : c) {
			
			if(i == max) {
				
				sb.append(index).append(" ");
				
			}
			
			++index;
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		b = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}