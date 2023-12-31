import java.util.Scanner;

public class D_Mathematical_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		switch(n) {
			
			case 1:
			
			   sb.append("1").append("\n");
			
			break;
			
			case 3:
			
			   sb.append("169").append("\n");
			   sb.append("196").append("\n");
			   sb.append("961").append("\n");
			
			break;
			
			default:
			  
			  int zeros = 0, remaining_zeros = n - 3;
			  
			  sb.append("196").append("0".repeat(remaining_zeros)).append("\n");
			  
			  while(remaining_zeros >= 0) {
			  	
			  	sb.append("1").append("0".repeat(zeros));
			  	sb.append("6").append("0".repeat(zeros));
			  	sb.append("9").append("0".repeat(remaining_zeros));
			  	
			  	sb.append("\n");
			  	
			  	sb.append("9").append("0".repeat(zeros));
			  	sb.append("6").append("0".repeat(zeros));
			  	sb.append("1").append("0".repeat(remaining_zeros));
			  	
			  	sb.append("\n");
			  	
			  	remaining_zeros -= 2;
			  	++zeros;
			  	
			  }
			
		}
		
		ans.append(sb.toString());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.println(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
	}
	
}