import java.util.Scanner;

public class B_Lunatic_Never_Content {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		long x = 0L;
		
		for(int i = 0; i <= n / 2; ++i) {
			
			x = gcd(x, Math.abs(a[i] - a[n - i - 1]));
			
		}
		
		System.out.println(x);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
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