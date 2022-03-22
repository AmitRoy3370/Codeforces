import java.util.Scanner;

public class A_Integer_Moves {
	
	static Scanner in = new Scanner(System.in);
	
	static int x, y, testCases;
	
	static StringBuilder ans = new StringBuilder();
	
	static double distance() {
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		
	}
	
	static void solve() {
		
		double d = distance();
		
		int e = (int)distance();
		
		if(x == 0 && y == 0 ) {
			
			//System.out.println(0);
			
			ans.append(0).append("\n");
			
		} else if(d == (double)e ) {
			
			//System.out.println(1);
			
			ans.append(1).append("\n");
			
		} else {
			
			//System.out.println(2);
			
			ans.append(2).append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			x = in.nextInt();
			
			y = in.nextInt();
			
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}