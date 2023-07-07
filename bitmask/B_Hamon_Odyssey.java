import java.util.Scanner;

public class B_Hamon_Odyssey {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long and = pow(2, 30) - 1L;
		
		if(AND(a, and) != 0) {
			
			System.out.println(1);
			return;
			
		}
		
		long present = and;
		
		int team = 0;
		
		for(long i : a) {
			
			present &= i;
			
			if(present == 0L) {
				
				++team;
				
				present = and;
				
			}
			
		}
		
		System.out.println(team);
		
	}
	
	public static void main(String [] amit) {
		
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
	
    static long pow(long value, long power) {

        long pow_value = 1L;

        while (power > 0L) {

            if (power % 2L == 1L) {

                pow_value *= value;

            }

            value *= value;

            power /= 2L;

        }

        return pow_value;

    }
	
	private static long AND(long a[], long and) {
		
		for(long i : a) {
			
			and &= i;
			
		}
		
		return and;
		
	}

}