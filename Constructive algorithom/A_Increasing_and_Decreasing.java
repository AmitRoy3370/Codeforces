import java.util.Scanner;

public class A_Increasing_and_Decreasing {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static long first, last;

	static void solve() {

		StringBuilder sb = new StringBuilder();

		long difference = 1L;

		a[n - 1] = last;

		for(int i = n - 2; i >= 0; --i) {

			a[i] = a[i + 1] - difference;

			++difference;

		}

		if(a[0] < first) {

			System.out.println(-1);
			return;

		}

		a[0] = first;

		for(long i : a) {

			sb.append(i).append(" ");

		}

		System.out.println(sb.toString().trim());

	}

	public static void main(String [] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		first = in.nextLong();

		last = in.nextLong();

		n = in.nextInt();

		a = new long[n];
		
	}

}