import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class C_Knight_s_move {

	static int n, m;

	static long dp[][];

	static long solve(int n, int m, long count) {

		if(n <= 0L || m <= 0L) {

			return 0L;

		}

		if(dp[n][m] != -1) {

			return dp[n][m];

		}

		if(n == 1 && m == 1) {

			return 1L;

		}

		dp[n][m] = (solve(n - 2, m - 1, ++count) +
	    solve(n - 1, m - 2, ++count));

	    return dp[n][m];

	}

	static void solve() throws Exception {

		long ans = 0L;

		for(int i = 0; i <= n; ++i) {

			for(int j = 0; j <= m; ++j) {

				dp[i][j] = -1L;

			}

		}

		ans = solve(n, m, 0L);

		FileWriter fw = new FileWriter(new File("knight.out"));

		fw.write(ans + "");

		fw.close();

	}

	public static void main(String[] priya) throws Exception {

		input();
		solve();
		
	}
	
	private static void input() throws Exception {

		String file_name = "knight.in", line;

		int i = 1;

		FileReader reader = new FileReader(new File(file_name));

		BufferedReader bufferedReader = new BufferedReader(reader);

		while((line = bufferedReader.readLine()) != null) {

			if(i == 1) {

				String s[] = line.split(" ");

				n = Integer.parseInt(s[0].trim());

				m = Integer.parseInt(s[1].trim());

				dp = new long[n + 1][m + 1];

			} else {

				break;

			}

			++i;

		}

	}

}