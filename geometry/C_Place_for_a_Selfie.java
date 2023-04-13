import java.util.Scanner;
import java.util.TreeSet;

public class C_Place_for_a_Selfie {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[], b[], c[], k[];
	
	static void solve() {
		
		StringBuilder ans = new StringBuilder();
		
		TreeSet<Long> set = new TreeSet<>();
		
		set.add((long)(1e9));
		set.add(-1 * (long)(1e9));
		
		for(long i : k) {
			
			set.add(i);
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			long floor = (long)set.floor(b[i]);
			long celling = (long)set.ceiling(b[i]);
			
			long B = b[i] - floor;
			long B1 = celling - b[i];
			
			if(B > B1) {
				
				long D = B1 * B1 - 4 * a[i] * c[i];
				
				if(D < 0L) {
					
					ans.append("YES").append("\n");
					
					ans.append(celling).append("\n");
					
				} else {
					
					ans.append("NO").append("\n");
					
				}
				
			} else {
				
				long D = B * B - 4L * a[i] * c[i];
				
				if(D < 0L) {
					
					ans.append("YES").append("\n");
					
					ans.append(floor).append("\n");
					
				} else {
					
					ans.append("NO").append("\n");
					
				}
				
			}
			
		}
		
		System.out.println(ans.toString());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			k = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				k[i] = in.nextLong();
				
			}
			
			a = new long[m];
			b = new long[m];
			c = new long[m];
			
			for(int i = 0; i < m; ++i) {
				
				a[i] = in.nextLong();
				b[i] = in.nextLong();
				c[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}