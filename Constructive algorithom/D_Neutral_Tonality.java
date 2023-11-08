import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class D_Neutral_Tonality {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[], b[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		List<Long> A = new ArrayList<>();
		
		List<Long> B = new ArrayList<>();
		
		for(long i : a) {
			
			A.add(i);
			
		}
		
		for(long i : b) {
			
			B.add(i);
			
		}
		
		Collections.sort(B, Collections.reverseOrder());
		
		int i = 0, j = 0;
		
		while(i < n && j < m) {
			
			if(A.get(i) >= B.get(j)) {
				
				sb.append(A.get(i++)).append(" ");
				
			} else {
				
				sb.append(B.get(j++)).append(" ");
				
			}
			
		}
		
		while(i < n) {
			
			sb.append(A.get(i++) ).append(" ");
			
		}
		
		while(j < m) {
			
			sb.append(B.get(j++)).append(" ");
		
		}
		
		ans.append(sb.toString().trim()).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new long[n];
		b = new long[m];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < m; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}