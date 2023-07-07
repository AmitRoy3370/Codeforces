import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A_The_Man_who_became_a_God {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		List<Long> list = new ArrayList<>();
		
		for(int i = 1; i < n; ++i) {
			
			list.add(Math.abs(a[i] - a[i - 1]));
			
		}
		
		Collections.sort(list);
		
		long sum = 0L;
		
		for(int i = 0; i < n - k; ++i) {
			
			sum += list.get(i);
			
		}
		
		System.out.println(sum);
		
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
		
		k = in.nextInt();
		
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