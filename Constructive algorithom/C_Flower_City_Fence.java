import java.util.Scanner;

public class C_Flower_City_Fence {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		long max = a[0];

		for(long i : a) {

			max = Math.max(i, max);

		}

		if(max > n) {

			System.out.println("NO");
			return;
			
		}

		long horizontal[] = new long[n + 1];

		for(int i = 0; i < n; ++i) {

			horizontal[0]++;
			horizontal[(int)a[i]]--;

		}

		for(int i = 1; i <= n; ++i) {

			horizontal[i] += horizontal[i - 1];

		}

		for(int i = 0; i < n; ++i) {

			if(a[i] != horizontal[i]) {

				System.out.println("NO");
				return;

			}

		}

		System.out.println("YES");

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

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

}