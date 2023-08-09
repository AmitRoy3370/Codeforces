import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class E_Eszett {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static char a[];
	
	static void solve() {
		
		int have = 0;
		
		Set<String> set = new HashSet<>();
		
		set.add(new String(a));
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(a[i] == a[i + 1] && a[i] == 's') {
				
				StringBuilder sb = new StringBuilder();
				
				for(int j = 0; j < n; ++j) {
					
					if(j == i + 1) {
						
						continue;
						
					} else if(j == i) {
						
						sb.append('B');
						
					} else {
						
						sb.append(a[j]);
						
					}
					
				}
				
				set.add(sb.toString());
				
			} 
			
		}
		
		for(String i : set) {
			
			System.out.println(i);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		a = in.next().toLowerCase().toCharArray();
		
		n = a.length;
		
	}
	
}