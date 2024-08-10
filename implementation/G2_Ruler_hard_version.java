import java.util.Scanner;

public class G2_Ruler_hard_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	static long area;
	
	static void solve() {
		
		long l = 1, r = 1000;
		
		while(r > l) {
			
			long a = (2 * l + r) / 3;
			long b = (2 * r + l) / 3;
			
			System.out.println("? " + a + " " + b);
			
			long area = a * b;
			
			long assumedArea = in.nextLong();
			
			if(area == assumedArea) {
				
				l = b + 1;
				
			} else if(a * (b + 1) == assumedArea) {
				
				l = a + 1;
				r = b;
				
			} else {
				
				r = a;
				
			}
			
		}
		
		System.out.println("! " + l);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			solve();
			
		}
		
	}
	
}