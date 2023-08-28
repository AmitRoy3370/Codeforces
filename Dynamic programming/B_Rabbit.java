import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class B_Rabbit {

	static int n;

	static char a[];

	static void solve() throws IOException {

		long ans = 0L;

		long dp[] = new long[n + 1];

		for(int i = 1; i <= n; ++i) {

			dp[i] = Integer.MIN_VALUE;

		}

		dp[0] = 0L;

		for(int i = 1; i < n; ++i) {

			if(a[i] == 'w') {

				dp[i] = Integer.MIN_VALUE;
				continue;

			}

			long score = ((a[i] == '"') ? 1L : 0L);

			long value = (dp[i - 1] + score);

			dp[i] = Math.max(dp[i], 
			((dp[i - 1] != Integer.MIN_VALUE) ? value : dp[i]));
			
			if(i - 3 >= 0) {

				value = (dp[i - 3] + score);

				dp[i] = Math.max(dp[i], 
				((dp[i - 3] != Integer.MIN_VALUE) ? value : dp[i]));

			}

			if(i - 5 >= 0) {

				value = (dp[i - 5] + score);

				dp[i] = Math.max(dp[i],
				(dp[i - 5] != Integer.MIN_VALUE ? value : dp[i]));

			}

		}

		//print(dp);

		ans = dp[n - 1];

		if(ans == Integer.MIN_VALUE) {

			ans = -1L;

		}

		FileWriter fw = new FileWriter(new File("lepus.out"));

		fw.write(ans + "");

		fw.close();

	}

	public static void main(String[] priya) throws Exception {
		
		input();
		solve();

	}

	private static void input() throws Exception {

		String file_name = "lepus.in", line;

		int i = 1;

		FileReader reader = new FileReader(new File(file_name));

		BufferedReader bufferedReader = new BufferedReader(reader);

		while((line = bufferedReader.readLine()) != null) {

			if(i == 1) {

				n = Integer.parseInt(line.trim());

				a = new char[n];

			} else {

				a = line.trim().toCharArray();
				break;

			}

			++i;

		}

	}

	private static void print(long dp[]) {

		for(long i : dp) {

			System.out.print(i + " ");

		}

		System.out.println();
		
	}
	
}