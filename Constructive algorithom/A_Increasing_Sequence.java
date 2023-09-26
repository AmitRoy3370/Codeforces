import java.util.Scanner;

public class A_Increasing_Sequence {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		long element = (a[0] == 1L) ? 2L : 1l;

		for(int i = 1; i < n; ++i) {

			++element;

			if(element == a[i]) {

				++element;

			}

		}

		System.out.println(element);

	}

	public static void main(String[] priya) {
		
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