import java.util.Scanner;

public class B_XOR_Palindromes {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char x[];

	static void solve() {

		char y[] = new char[n + 1];

		for(int i = 0; i <= n; ++i) {

			y[i] = '0';

		}

		int starting_mismatch = 0;

		for(int i = 0; i < n / 2; ++i) {

			if(x[i] != x[n - i - 1]) {

				++starting_mismatch;

			}

		}

		y[starting_mismatch] = '1';

		int ok = n - 2 * starting_mismatch;

		int changes = ok / 2;

		if(n % 2 == 0) {

			for(int i = starting_mismatch; i <= n && changes >= 0; i += 2, --changes) {

				y[i] = '1';

			}

		} else {

			for(int i = starting_mismatch; i <= n && changes >= 0; i += 2, --changes) {

				y[i] = '1';

				if(i + 1 <= n) {

					y[i + 1] = '1';

				}

			}

		}

		System.out.println(new String(y));

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

		x = in.next().toCharArray();

	}

}