import java.util.Scanner;

public class B_Doremy_s_Perfect_Math_Class {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long gcd = a[0];
		
		for(long i : a) {
			
			gcd = gcd(gcd, i);
			
		}
		
		long operation = a[n - 1] / gcd;
		
		if(a[0] == 0L) ++operation;
		
		System.out.println(operation);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
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