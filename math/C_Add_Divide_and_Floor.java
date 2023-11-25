import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C_Add_Divide_and_Floor {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long x = a[0];
		
		for(long i : a) {
			
			x = Math.min(i, x);
			
		}
		
		List<Long> list = new ArrayList<>();
		
		while(true) {
			
			if(all_equal(a)) {
				
				break;
				
			}
			
			list.add(x);
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = (a[i] + x) / 2L;
				
			}
			
			if(all_equal(a)) {
				
				break;
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list.size()).append("\n");
		
		if(list.size() <= n) {
			
			for(long i : list) {
				
				sb.append(i).append(" ");
			
			}
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	static boolean all_equal(long a[]) {
		
		int n = a.length;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] != a[i - 1]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
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