import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class C_Medium_Design {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	static long m;
	
	static long L[], R[];
	
	static long calculate_range(long x, int n) {
		
		long prefix[] = new long[n + 1];
		
		for(int i = 0; i < L.length; ++i) {
			
			if(x >= L[i] && x <= R[i]) {
				
				continue;
				
			}
			
			prefix[(int)L[i]]++;
			prefix[(int)R[i] + 1]--;
			
		}
		
		long max = prefix[0];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] += prefix[i - 1];
			
			max = Math.max(prefix[i], max);
			
		}
		
		return max;
		
	}
	
	static void solve() {
		
		/*
		
		collect the set to store all
		the point in the array.
		
		1 to m is the first pair
		as the length of the array
		is  m.
		
		*/
		
		Set<Long> set = new HashSet<>();
		
		set.add(1L);
		set.add(m);
		
		for(long i : L) {
			
			set.add(i);
			
		}
		
		for(long i : R) {
			
			set.add(i);
			
		}
		
		List<Long> list = new ArrayList<>();
		
		for(long i : set) {
			
			list.add(i);
			
		}
		
		/*
		
		sort all the point as the 
		point's are in asending order
		from left to right.
		
		*/
		
		Collections.sort(list);
		
		Map<Long, Long> map = new HashMap<>();
		
		long x = 0L;
		
		for(long i : list) {
			
			map.put(i, x++);
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			L[i] = map.get(L[i]);
			R[i] = map.get(R[i]);
			
		}
		
		long ans = Math.max(calculate_range(0L, (int)x), calculate_range(x - 1, (int)x));
		
		System.out.println(ans);
		
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
		m = in.nextLong();
		
		L = new long[n];
		R = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			L[i] = in.nextLong();
			R[i] = in.nextLong();
			
		}
		
	}
	
}