import java.util.Scanner;
import java.util.Arrays;

public class J_Lazy_Abdo {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k;

	static long a[];

	static void solve() {

		Arrays.sort(a);

		long sum = 0L;

		for(int i = n - k; i < n; ++i) {

			sum += a[i];

		}

		System.out.println(sum);

	}

	public static void main(String [] priya) {

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

}