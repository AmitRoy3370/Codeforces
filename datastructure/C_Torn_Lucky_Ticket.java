import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Torn_Lucky_Ticket {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static String s[];
	
	static void solve() {
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			int len = s[i].length();
			
			long sum = sum(s[i], 0L);
			
			long removed_sum = 0L;
			
			for(int j = 0; j < len; ++j) {
				
				removed_sum += (s[i].charAt(j) - '0');
				
				long need = 2L * removed_sum - sum;
				int length_need = 2 * (j + 1) - len;
				
				map.put(need + "_" + length_need, map.getOrDefault(need + "_" + length_need, 0) + 1);
				
			}
			
		}
		
		long pair = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			long sum = sum(s[i], 0L);
			int need_length = s[i].length();
			
			pair += map.getOrDefault(sum + "_" + need_length, 0);
			
			sum *= -1;
			need_length *= -1;
			
			pair += map.getOrDefault(sum + "_" + need_length, 0);
			
		}
		
		System.out.println(pair);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		s = new String[n];
		
		for(int i = 0; i < n; ++i) {
			
			s[i] = in.next();
			
		}
		
	}
	
	private static long sum(String s, long sum) {
		
		for(int i = 0; i < s.length(); ++i) {
			
			sum += (s.charAt(i) - '0');
			
		}
		
		return sum;
		
	}
	
}
