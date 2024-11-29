import java.util.Scanner;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.TreeMap;

public class E_Eating_Queries {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, q;
	
	static long a[];
	
	static TreeSet<Long> set; 
	
	static void solve() {
		
		Arrays.sort(a);
		
		for(int i = 0; i < n / 2; ++i) {
			
			long temp = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = temp;
			
		}
		
		long prefix[] = new long[n];
		
		prefix[0] = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		TreeMap<Long, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			map.put(prefix[i], i + 1);
			
		}
		
		set = new TreeSet<>();
		
		for(long i : prefix) {
			
			set.add(i);
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < q; ++i) {
			
			long num = in.nextLong();
			
			Long index = set.higher(num - 1);
			
			sb.append(index == null ? -1 : map.get(index)).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
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
		q = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}