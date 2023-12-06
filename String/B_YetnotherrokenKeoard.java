import java.util.Scanner;

public class B_YetnotherrokenKeoard {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int upper_case[] = new int[n];
		int lower_case[] = new int[n];
		
		char ch[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		boolean visited[] = new boolean[n];
		
		for(int i = 0; i != n; ++i) {
			
			visited[i]  = true;
			
		}
		
		int index_upper = -1;
		int index_lower = -1;
		
		for(int i = 0; i < n; ++i) {
			
			if(x[i] == 'b') {
				
				visited[i] = false;
				
				if(index_lower == -1) {
					
					continue;
					
				}
				
				visited[lower_case[index_lower] ] = false;
				
				--index_lower;
				
			} else if(x[i] == 'B') {
				
				visited[i] = false;
				
				if(index_upper == -1) {
					
					continue;
					
				}
				
				visited[upper_case[index_upper]] = false;
				--index_upper;
				
			} else {
				
				if( x[i] - 'a' >= 0 && ch[(x[i] - 'a')] == (x[i]) ) {
					
					lower_case[++index_lower] = i;
					
				} else {
					
					upper_case[++index_upper] = i;
					
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			if(!visited[i]) {
				
				continue;
				
			}
			
			sb.append(x[i]);
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		n = x.length;
		
	}
	
}