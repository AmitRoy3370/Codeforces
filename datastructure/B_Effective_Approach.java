import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Effective_Approach {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static long a[], b[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(int i = 1; i <= n; ++i) {
			
			map.put(a[i], i);
			
		}
		
		long fronted_count = 0L, backend_count = 0L;
		
		for(int i = 1; i <= m; ++i) {
			
			if(!map.containsKey(b[i])) {
				
				fronted_count += n;
				backend_count += n;
				continue;
				
			}
			
			int position = map.get(b[i]);
			
			fronted_count += position;
			backend_count += (n - position + 1);
			
		}
		
		System.out.print(fronted_count + " " + backend_count);
		
	}
	
	public static void main(String []amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		m = in.nextInt();
		
		b = new long[m + 1];
		
		for(int i = 1; i <= m; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}