import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Notepad {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n - 1; ++i) {
			
			String s = (a[i] + "" + a[i + 1]);
			
			if(map.containsKey(s) && map.get(s) < i - 1) {
				
				System.out.println("YES");
				return;
				
			} else {
				
			    if(map.containsKey(s)) {
					
					continue;
					
			    }
			
			    map.put(s, i);
			
			}
			
		}
		
		System.out.println("No");
		
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
		
		a = in.next().toCharArray();
		
	}
	
}