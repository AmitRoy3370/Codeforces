import java.util.Scanner;

public class C_Card_Game {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		long sum = 0L;

		for(long i : a) {

			if(i < 0) {

				continue;

			}

			sum += i;

		}

		if(n == 1) {

			System.out.println(Math.max(0L, sum));

		} else if(a[0] >= 0 || a[1] <= 0) {

			System.out.println(sum);

		} else if(a[0] + a[1] >= 0L) {

			sum += a[0];

			System.out.println(sum);

		} else {

			sum -= a[1];

			System.out.println(sum);

		}

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