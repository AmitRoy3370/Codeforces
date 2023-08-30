import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class D_Path_Cost {

	static long mat[][], dp[][];

	static int n, m;

	// bottom up approach

	private static long dp(int raw, int coloumn) {

		if(raw == 0 || coloumn > 8) {

			return 0L;

		}

		for(int j = 1; j <= m; ++j) {

			long up = mat[raw][j] + dp[raw + 1][j];
			long right = mat[raw][j] + dp[raw][j - 1];
			long corner = mat[raw][j] + dp[raw + 1][j -1];

			dp[raw][j] = Math.min(Math.min(up, dp[raw][j]), 
				Math.min(right, corner));

		}

		return dp(raw - 1, coloumn);

	}

	private static void dp() throws IOException {

		for(int i = 0; i <= 9; ++i) {

			for(int j = 0; j <= 9; j++) {

				dp[i][j] = Integer.MAX_VALUE;

			}

		}

		dp[8][1] = 0L;

		//print(dp); 

		long ans = dp(8, 1);

		//print(dp);

		ans = dp[1][8];

		FileWriter fw = new FileWriter(new File("king2.out"));

		fw.write(ans + "");

		fw.close();

	}

	// top down approach

	private static long solve(int raw, int coloumn) {

		if(raw > 8 || coloumn > 9 || raw < 1 || coloumn < 1) {

			//System.out.println("return from first");

			return Long.MAX_VALUE;

		}

		for(int j = m; j >= 1; --j) {

			dp[raw][j] = Math.min(dp[raw][j], 
				Math.min(mat[raw][j] + dp[raw - 1][j], 
			    Math.min(mat[raw][j] + dp[raw - 1][j + 1],
			    mat[raw][j] + dp[raw][j + 1] ) ));

		}

		return solve(raw + 1, coloumn);

	}

	private static void solve() throws IOException {

		long ans = mat[8][1] + mat[1][8];

		for(int i = 2; i <= 8; ++i) {

			for(int j = 0; j <= 9; ++j) {

				dp[i][j] = Integer.MAX_VALUE;

			}

		}

		for(int j = m; j >= 1; --j) {

			dp[1][j] = mat[1][j];

		}

		for(int j = m; j >= 1; --j) {

			dp[1][j] += dp[1][j + 1];

		}

		for(int j = m; j >= 1; --j) {

			dp[8][j] = mat[8][j];

		}

		dp[8][0] = 0L;

		for(int i = 1; i <= m; ++i) {

			dp[8][i] += dp[8][i - 1];

		}

		dp[8][0] = Integer.MAX_VALUE;

		dp[1][9] = Integer.MAX_VALUE;

		int raw = 2, coloumn = 8;

		//print(mat);

		//dp[raw][coloumn] = mat[raw][coloumn];

		ans = solve(raw, coloumn);

		//print(dp);

		//System.out.println("answer flow");

		ans = dp[8][1] + Math.min(dp[7][1], (dp[7][2]));

		for(int j = 2; j <= m; ++j) {

			ans = Math.min(ans, dp[8][j] + Math.min(dp[7][j], 
		          dp[7][j + 1]));

		}

		//print(dp);

		//ans = dp[8][1]; 

		FileWriter fw = new FileWriter(new File("king2.out"));

		fw.write(ans + "");

		fw.close();

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException  {

		input();
		dp();
		
	}
	
	private static void input() throws FileNotFoundException, IOException, NullPointerException  {

		String file_name = "king2.in", line;

		int i = 1;

		FileReader reader = new FileReader(new File(file_name));

		BufferedReader bufferedReader = new BufferedReader(reader);

		n = 8;

		m = 8;

		mat = new long[n + 2][m + 2];

		dp = new long[n + 2][m + 2];

		while((line = bufferedReader.readLine()) != null) {

			String s[] = line.trim().split(" ");

			for(int j = 1; j <= m; ++j) {

				mat[i][j] = Long.parseLong(s[j - 1].trim());

			}

			++i;

			if(i > 8) {

				break;

			}

		}

	}

	private static void print(long dp[][]) {

		for(int i = 0; i <= 9; ++i) {

			for(int j = 0; j <= 9; ++j) {

				if(dp[i][j] == Integer.MAX_VALUE) {

					System.out.print("I ");
					continue;

				}

				System.out.print(dp[i][j] + " ");

			}

			System.out.println();

		}
	}

}