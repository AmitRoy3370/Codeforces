import java.util.Scanner;

public class C_Jellyfish_and_Green_Apple {

	static Scanner in = new Scanner(System.in);

	static int testCases;

	static long X, Y;

	static void solve() {

		long opertions = 0L;

		int step = 0;

		while(X != 0L && step < 101) {

			if(X >= Y) {

				X %= Y;

			} else {

				opertions += X;

				X *= 2L;

			}

			++step;

		}

		if(X != 0L) {

			System.out.println(-1);

		} else {

			System.out.println(opertions);

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

		X = in.nextLong();
		Y = in.nextLong();

	}

}