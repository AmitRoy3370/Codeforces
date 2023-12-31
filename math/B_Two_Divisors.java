import java.util.Scanner;

public class B_Two_Divisors {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long a, b;
	
	static void solve() {
		
		long lcm = lcm(a, b);
		
		if(lcm == a || lcm == b) {
			
			lcm *= (b / a);
			
		}
		
		System.out.println(lcm);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextLong();
		b = in.nextLong();
		
	}
	
	static long gcd(long a, long b) {
 
        if (b == 0L) {
 
            return a;
 
        }
 
        return gcd(b, a % b);
 
    }
 
    static long lcm(long a, long b) {
 
        long gcd = gcd(a, b);
 
        long lcm = (a * b) / gcd;
 
        return lcm;
 
    }
    
}