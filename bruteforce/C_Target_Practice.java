import java.util.Scanner;

public class C_Target_Practice {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char mat[][];

	static void solve() {

		long total_cost = 0L;

		for(int i = 0; i < n; ++i) {

			int cross_count = 0;

			// first raw

			for(int j = i; j < n - i; ++j) {

				if(mat[i][j] == 'X') {

					++cross_count;

				}

			}

			// first coloumn

			for(int j = i + 1; j < n - i; ++j) {

				if(mat[j][n - i - 1] == 'X') {

					++cross_count;

				}

			}

			// second raw

			for(int j = i; j < n - i - 1; ++j) {

				if(mat[n - i - 1][j] == 'X') {

					++cross_count;

				}

			}

			// second coloumn

			for(int j = i + 1; j < n - i - 1; ++j) {

				if(mat[j][i] == 'X') {

					++cross_count;

				}

			}

			total_cost += (cross_count * (i + 1));

		}

		System.out.println(total_cost);

	}

	public static void main(String[] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = 10;

		mat = new char[n][n];

		for(int i = 0; i < n;  ++i) {

			mat[i] = in.next().toCharArray();

		}

	}

}