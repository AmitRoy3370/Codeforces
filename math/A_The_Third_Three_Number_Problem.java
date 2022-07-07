import java.util.Scanner;

public class A_The_Third_Three_Number_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		if(n % 2 == 1) {
			
			ans.append(-1);
			
		} else {
			
			ans.append(0).append(" ").append(0).append(" ").append(n / 2);
			
		}
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextLong();
			
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}