import java.util.Scanner;

public class C_Number_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n;
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println("FastestFinger");
			
			return;
			
		} else if(n == 2) {
			
			System.out.println("Ashishgup");
			
			return;
			
		} else if(n % 2 == 1) {
			
			System.out.println("Ashishgup");
			
		} else {
			
			int count = 0;
			
			for(long divisor = 2L; divisor * divisor <= n; ++divisor) {
				
				if(n % divisor == 0) {
					
					long first = divisor;
					long second = n / divisor;
					
					if(first % 2 == 1) {
						
						++count;
						
					}
					
					if(second % 2 == 1) {
						
						++count;
						
					}
					
				}
				
			}
			
			if(count > 0) {
				
				long half = n / 2;
				
				boolean yes = true;
				
				for(long i = 3; i * i <= n; ++i) {
					
					if(n % i == 0) {
						
						yes = false;
						break;
						
					}
					
				}
				
				if(yes) {
					
					System.out.println("FastestFinger");
					
				} else {
					
					System.out.println("Ashishgup");
					
				}
				
			} else if(count == 0) {
				
				System.out.println("FastestFinger");
				
			}
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		
	}
	
}