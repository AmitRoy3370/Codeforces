import java.util.Scanner;
import java.util.TreeSet;

public class C_Product_of_Three_Numbers {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	static long n;
	
	static void solve() {
		
		TreeSet<Long> divisors = new TreeSet<>();
		
		for(long i = 2; i * i <= n; ++i) {
			
			if(n % i == 0) {
				
				divisors.add(i);
				
				if(n / i != i) {
					
					divisors.add(n / i);
					
				}
				
			}
			
		}
		
		if(divisors.size() < 3) {
			
			System.out.println("NO");
			
		} else {
			
			boolean yes = false;
			
			long ab = 0, c = 0;
			
			for(long divisor : divisors) {
				
				long another = n / divisor;
				
				if(another != 1 && divisors.contains(another)) {
					
					yes = true;
					c = divisor;
					ab = another;
					break;
					
				}
				
			}
			
			if(yes) {
				
				for(long divisor : divisors) {
					
					if(ab % divisor == 0) {
						
						long b = ab / divisor;
						
						if(b == 1) {
							
							continue;
							
						}
						
						long a = divisor;
						
						if(a == b || b == c || a == c) {
							
							continue;
							
						}
						
						System.out.println("YES");
						System.out.println(a + " " + b + " " + c);
						return;
						
					}
					
				}
				
				System.out.println("NO");
				
			} else {
				
				System.out.println("NO");
				
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