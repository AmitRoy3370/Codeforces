import java.util.Scanner;

public class C_Yet_Another_Permutation_Problem {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		a = new long[n];

		boolean dp[] = new boolean[n + 1];

		int index = 0;

		for(int i = 1; i <= n; ++i) {

			if(dp[i]) {

				continue;

			}

			for(int j = i; j <= n; j *= 2) {

				dp[j] = true;

				a[index++] = j;

			}

		}

		StringBuilder sb = new StringBuilder();

		for(long i : a) {

			sb.append(i).append(" ");

		}

		System.out.println(sb.toString().trim());

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

	}

}