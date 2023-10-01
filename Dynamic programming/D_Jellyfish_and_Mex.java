import java.util.Scanner;

public class D_Jellyfish_and_Mex {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		long b[] = new long[n + 1];

		for(long i : a) {

			if(i < n) {

				b[(int)i]++;

			}

		}

		int mex = 0;

		while(b[mex] > 0) {

			++mex;

		}

		long dp[] = new long[n + 1];

		for(int i = 0; i <= n; ++i) {

			dp[i] = Integer.MAX_VALUE;

		}

		dp[mex] = 0;

		for(int i = mex; i >= 1; --i) {

			for(int j = 0; j < i; ++j) {

				dp[j] = Math.min(dp[j], dp[i] + i * b[j]);

			}

		}

		long operations = dp[0] - mex;

		System.out.println(operations);

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