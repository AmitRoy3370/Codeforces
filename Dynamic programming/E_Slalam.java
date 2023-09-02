import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class E_Slalam {

	static Scanner in = new Scanner(System.in);

	static int n;

	static long hill[][];

	static StringBuilder ans = new StringBuilder();

	static long solve(int i, int j, long dp[][]) {

		if(i < 0 || j < 0 || i >= n || j >= n) {

			return 0L;

		}

		if(dp[i][j] != Integer.MIN_VALUE) {

			return dp[i][j];

		}

		dp[i][j] = Math.max(dp[i][j], 
			hill[i][j] + Math.max(
				solve(i + 1, j + 1, dp), 
				solve(i + 1, j, dp)));

		return dp[i][j];

	}

	static void solve() {

		long dp[][] = new long[n][n];

		for(int i1 = 0; i1 < n; ++i1) {

			for(int j1 = 0; j1 < n; ++j1) {

				dp[i1][j1] = Integer.MIN_VALUE;

			}

		}

		int i = 0, j = 0;

		//dp[i][j] = 0L;

		solve(i, j, dp);

		for(i = 0; i < n; ++i) {

			dp[0][0] = Math.max(dp[0][0], dp[0][i]);

		}

		ans.append(dp[0][0]);

		//print(dp);

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {

		/*input();
		solve();

		System.out.print(ans.toString());*/

		solver();
		
	}

	private static void input() {

		n = in.nextInt();

		hill = new long[n][n];

		for(int i = 1; i <= n; ++i) {

			for(int j = 0; j < i; ++j) {

				hill[i - 1][j] = in.nextLong();

			}

		}

	}

	private static void solver() throws FileNotFoundException, IOException, NullPointerException {

		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("E_Slalam.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int j = 0, i = 1;

		while((line = br.readLine()) != null) {

			if(j == 0) {

				n = Integer.parseInt(line.trim());

				hill = new long[n][n];

			} else {

				String s[] = line.trim().split(" ");

				int index = 0;

				for(int k = 0; k < i; ++k) {

					hill[i - 1][k] = Long.parseLong(s[index++]);

				}

				++i;

				if(i > n) {

					solve();
					return;

				}

			}

			++j;

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("E_Slalam.out"));

		fw.write(ans.toString());

		fw.close();

	}

	private static void print(long dp[][]) {

		for(long i[]: dp) {

			for(long j : i) {

				System.out.print(j + " ");

			}

			System.out.println();

		}

	}
	
}
