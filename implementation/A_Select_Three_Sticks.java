import java.util.Scanner;
import java.util.Arrays;

public class A_Select_Three_Sticks {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		Arrays.sort(a);

		long min_step = Integer.MAX_VALUE;

		for(int i = 2; i < n; ++i) {

			min_step = Math.min(min_step, a[i] - a[i - 2]);

		}

		System.out.println(min_step);

	}

	public static void main(String[] amit) {

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

}