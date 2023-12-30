import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class C_Heavy_Intervals {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long L[], R[], C[];
	
	static void solve() {
		
		List<Long> c = new ArrayList<>();
		
		List<Long> r = new ArrayList<>();
		
		TreeSet<Long> l = new TreeSet<>();
		
		long initial_weight = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			initial_weight += C[i] * (R[i] - L[i]);
			
		}
		
		for(long i : L) {
			
			l.add((i));
			
		}
		
		for(long i : R) {
			
			r.add(i);
			
		}
		
		for(long i : C) {
			
			c.add(i);
			
		}
		
		Collections.sort(c, Collections.reverseOrder());
		Collections.sort(r);
		
		long weight = 0L;
		
		List<Long> diff = new ArrayList<>();
		
		for(long i : r) {
			
			//System.out.println((r.peek() - l.peek()));
			
			long x = l.floor((i));
			
			//--x;
			
			diff.add((i) - x);
			
			l.remove(x);
			
		}
		
		Collections.sort(diff);
		
		for(int i = 0; i != n; ++i) {
			
			weight += (c.get(i) * diff.get(i));
			
		}
		
		weight = Math.min(weight, initial_weight);
		
		System.out.println(weight);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		R = new long[n];
		L = new long[n];
		C = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			L[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			R[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			C[i] = in.nextLong();
			
		}
		
	}
	
}