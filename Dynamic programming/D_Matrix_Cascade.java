import java.util.Scanner;

public class D_Matrix_Cascade {

	static Scanner in = new Scanner(System.in);

	static int n, testCases;

	static char mat[][];

	private static void solve() {

		long operations = 0l;

		int arr[][] = new int[n + 1][n + 1];

		int start[][] = new int[n + 1][n + 1];

		int end[][] = new int[n + 1][n + 1];

		for(int i = 0; i < n; ++i) {

			for(int j = 0; j < n; ++j) {

				if(start[i][j] != 0) {

					arr[i][j] += start[i][j];

					int st = Math.max(j - 1, 0);

					start[i + 1][st] += start[i][j];

				}

				if(end[i][j] != 0) {

					arr[i][j] -= end[i][j];

					int en = Math.min(j + 1, n);

					end[i + 1][en] += end[i][j];

				}

			} 

			for(int j = 1; j < n; ++j) {

				arr[i][j] += arr[i][j - 1];

			}

			for(int j = 0; j < n; ++j) {

				if(arr[i][j] % 2 == 1) {

					if(mat[i][j] == '0') {

						mat[i][j] = '1';

					} else {

						mat[i][j] = '0';

					}

				}

			}

			for(int j = 0; j < n; ++j) {

				if(mat[i][j] == '1') {

					++operations;

					int st = Math.max(j - 1, 0);
					int en = Math.min(j + 2, n);

					start[i + 1][st]++;
					end[i + 1][en]++;

				}

			}

		}

		System.out.println(operations);

	}

	public static void main(String[] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();

		mat = new char[n][n];

		for(int i = 0; i < n; ++i) {

			mat[i] = in.next().toCharArray();

		}

	}
	

	private static void print(int arr[][]) {

		for(int i[] : arr) {

			for(int j : i) {

				System.out.print(j + " ");

			}

			System.out.println();

		}
		
	}
}