import java.util.Scanner;

public class M_Captain_Haddock_And_The_Counting_Problem {

	static int testCases, n;

	static Scanner in = new Scanner(System.in);

	static void solve() {

		System.out.println((n - 2));

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

	}

}