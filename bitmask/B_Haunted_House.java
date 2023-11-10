import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class B_Haunted_House {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		List<Integer> zeros = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			if(x[i] == '0') {
				
				zeros.add(i);
				
			}
			
		}
		
		int m = zeros.size();
		
		StringBuilder sb = new StringBuilder();
		
		long added = 0;
		
		for(int i = n - 1, j = m - 1; i >= 0; --i, --j) {
			
			if(j < 0) {
				
				sb.append(-1).append(" ");
				
			} else {
				
				added += Math.abs(i - zeros.get(j));
				
				sb.append(added ).append(" ");
				
			} 
			
		}
		
		System.out.println(sb.toString().trim());
		
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
		
		x = in.next().toCharArray();
		
	}
	
}