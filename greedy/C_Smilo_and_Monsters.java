import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Smilo_and_Monsters {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		List<Long> list = new ArrayList<>();
		
		for(long i : a) {
			
			list.add(i);
			
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		long sum = 0L;
		
		for(long i : a) {
			
			sum += i;
			
		}
		
		long min_operations = sum;
		
		long removed_element = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			sum -= list.get(i);
			
			removed_element += list.get(i);
			
			long attached_value = 0L;
			
			if(removed_element > sum) {
				
				attached_value = (removed_element - sum + 1L) / 2L;
				
			}
			
			min_operations = Math.min(min_operations, i + 1 + sum + attached_value);
			
		}
		
		System.out.println(min_operations);
		
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
			
			a[i]  = in.nextLong();
			
		}
		
	}
	
}