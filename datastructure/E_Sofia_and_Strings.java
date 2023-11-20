import java.util.Scanner;
import java.util.TreeSet;

public class E_Sofia_and_Strings {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char s[], t[];
	
	static void solve() {
		
		TreeSet<Integer> indexes[] = new TreeSet[26];
		
		for(int i = 0; i != 26; ++i) {
			
			indexes[i] = new TreeSet<>();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			indexes[(s[i] - 'a')].add(i);
			
		}
		
		for(int i = 0; i != m; ++i) {
			
			char char_need = t[i];
			
			if(!indexes[char_need - 'a'].isEmpty()) {
				
				int position_in_s = indexes[char_need - 'a'].first();
				
				for(int j = 0; j != (char_need - 'a'); ++j) {
					
					while(!indexes[j].isEmpty() && indexes[j].first() < position_in_s) {
						
						indexes[j].pollFirst();
						
					}
					
				}
				
				indexes[char_need - 'a'].pollFirst();
				
			} else {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		System.out.println("YES");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		s = in.next().toCharArray();
		t = in.next().toCharArray();
	
	}
	
}