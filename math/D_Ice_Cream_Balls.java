import java.util.Scanner;

public class D_Ice_Cream_Balls {

	static Scanner in = new Scanner(System.in);

	static long N;

	static int testCases;

	static void solve() {

		long k = (long)Math.sqrt(2L * N) - 3L;

		while((k * (k + 1L)) / 2L <= N ) {

			++k;

		}

		long changer = (k * (3L - k)) / 2L;

		long value = N + changer;

		System.out.println(value);

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

	}

}