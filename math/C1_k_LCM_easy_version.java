import java.util.Scanner;

public class C1_k_LCM_easy_version {
	
	static int testCases, k;
	static long n;
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		if(n == 3) {
			
			System.out.println("1 1 1");
			return;
			
		} else if(n == 4) {
			
			System.out.println("2 1 1");
			return;
			
		} else if(n == 6) {
			
			System.out.println("2 2 2");
			return;
			
		}
		
		if(n % 2 == 1) {
			
			long first = n / 2;
			long second = n / 2;
			
			System.out.println("1 " + first + " " + second);
			
		} else {
			
			if(n % 2 == 0 && n % 4 == 0) {
				
				System.out.println((n / 2) + " " + (n / 4) + " " + (n / 4));
				
			} else if(n % 2 == 0) {
				
				System.out.println("2 " + (n / 2 - 1) + " " + (n / 2 - 1));
				
			}
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		k = in.nextInt();
		
	}
	
}