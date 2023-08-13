import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class A_United_We_Stand {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		boolean all_equal = true;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] == a[i - 1]) {
				
				continue;
				
			}
			
			all_equal = false;
			break;
			
		}
		
		if(all_equal) {
			
			System.out.println(-1);
			
		} else {
			
			StringBuilder sb = new StringBuilder();
			
			long min = a[0];
			
			int index = 0;
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i] < min) {
					
					min = a[i];
					index = i;
					
				}
				
			} 
			
			int val1 = 0;
			
			int i = 0;
			
			List<Long> b = new ArrayList<>();
			
			List<Long> c = new ArrayList<>();
			
			while(i < n) {
				
				if(a[i] != min) {
					
					++i;
					
					continue;
					
				}
				
				b.add(a[i]);
				
				++i;
				
			}
			
			i = 0;
			
			while(i < n) {
				
				if(a[i] == min) {
					
					++i;
					
					continue;
					
				}
				
				c.add(a[i]);
				
				++i;
				
			}
			
			sb.append(b.size()).append(" ").append(c.size()).append("\n");
			
			for(long element : b) {
				
				sb.append(element).append(" ");
				
			}
			
			sb.append("\n");
			
			for(long element : c) {
				
				sb.append(element).append(" ");
				
			}
			
			System.out.println(sb.toString());
			
		}
		
	}
	
	public static void main(String [] amit) {
		
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