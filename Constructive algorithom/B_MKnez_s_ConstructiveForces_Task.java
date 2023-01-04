import java.util.Scanner;

public class B_MKnez_s_ConstructiveForces_Task {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		if(n == 3) {
			
			sb.append("NO").append("\n");
			
			return;
			
		}
		
		if(n % 2 == 0) {
			
			sb.append("YES").append("\n");
			
			for(int i = 0; i < n / 2; ++i) {
				
				sb.append(1).append(" ").append(-1).append(" ");
				
			}
			
			sb.append("\n");
			
			return;
			
		}
		
		sb.append("YES").append("\n");
		
		for(int i = 0; i < n / 2; ++i) {
			
			sb.append(-1 * (n / 2 - 1)).append(" ").append(n / 2).append(" ");
			
		}
		
		sb.append(-1 * (n / 2 - 1)).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			solve();
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}