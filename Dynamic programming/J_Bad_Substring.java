import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class J_Bad_Substring {

	static Scanner in = new Scanner(System.in);

	static int n;

	static StringBuilder ans = new StringBuilder(); 

	private static void solve() {

		if(n == 0) {

			ans.append(1);
			return;

		}

		long dp[][] = new long[3][1];

		dp[0][0] = 1L;
		dp[1][0] = 1L;
		dp[2][0] = 1L;

		for(int i = 1; i < n; ++i) {

			long previous_a = dp[0][0];
			long previous_b = dp[1][0];
			long previous_c = dp[2][0];

			dp[0][0] = previous_a + previous_b + previous_c;

			dp[1][0] = previous_b + previous_c;

			dp[2][0] = previous_a + previous_b + previous_c;

		}

		long final_ans = dp[0][0] + dp[1][0] + dp[2][0];

		ans.append(final_ans);

	}

	public static void main(String[] priya) throws Exception {
		
		/*input();
		solve();

		System.out.println(ans.toString());*/

		solver();

	}

	private static void solver() throws Exception {

		fileIO();
		writeFile();

	}

	private static void input() {

		n = in.nextInt();

	}

	private static void fileIO() throws Exception {

		FileReader fr = new FileReader(new File("J_Bad_Substring.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		while((line = br.readLine()) != null) {

			n = Integer.parseInt(line.trim());
			solve();
			break;

		}

	}

	private static void writeFile() throws Exception {

		FileWriter fw = new FileWriter(new File("J_Bad_Substring.out"));

		fw.write(ans.toString());
		fw.close();

	}

}