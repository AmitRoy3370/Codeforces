import java.util.Scanner;

public class A_Plus_or_Minus {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long x, y, z;
	
	static void solve() {
		
		if(x + y == z) {
			
			System.out.println("+");
			
		} else {
			
			System.out.println("-");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			x = in.nextLong();
			y = in.nextLong();
			z = in.nextLong();
			
			solve();
			
		}
		
	}
	
}