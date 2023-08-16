import java.util.Scanner;

public class A_Buttons {

	static int testCases, n;

	static long a, b, c;

	static Scanner in = new Scanner(System.in);

	static void solve() {

		if(a > b) {

			System.out.println("First");

		} else if(b > a) {

			System.out.println("Second");

		} else {

			if(c % 2L == 1L) {

				System.out.println("First");

			} else {

				System.out.println("Second");

			}
			
		}

	}

	public static void main(String [] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		a = in.nextLong();
		b = in.nextLong();
		c = in.nextLong();

	}

}