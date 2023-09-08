import java.util.Scanner;

public class D_Plus_Minus_Permutation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long N, X, Y;
	
	static void solve() {
		
		long _x = N / X;
		long _y = N / Y;
		
		long common_mutiple = N / lcm(X, Y);
		
		_x -= common_mutiple;
		_y -= common_mutiple;
		
		long sum = N * (N + 1);
		
		sum /= 2L;
		
		long left_part = sum - ((N - _x) * (N - _x + 1)) / 2L;
		
		long right_part = _y * (_y + 1);
		
		right_part /= 2L;
		
		long max_permutation_score = left_part - right_part;
		
		System.out.println(max_permutation_score);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		N = in.nextLong();
		
		X = in.nextLong();
		
		Y = in.nextLong();
		
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