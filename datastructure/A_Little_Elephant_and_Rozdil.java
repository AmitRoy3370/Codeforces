import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Little_Elephant_and_Rozdil {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		}
		
		long min = a[0], min_count = 0;
		
		for(long i : a) {
			
			min = Math.min(i, min);
			
		}
		
		min_count = map.get(min);
		
		//System.out.println(min + " " + min_count);
		
		if(min_count > 1) {
			
			System.out.print("Still Rozdil");
			
		} else {
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i] == min) {
					
					min = i + 1;
					break;
					
				}
				
			}
			
			System.out.print(min);
			
		}
		
	}
	
	public static void main(String []amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}