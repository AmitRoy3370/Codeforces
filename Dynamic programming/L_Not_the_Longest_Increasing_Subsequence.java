import java.util.Scanner;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class L_Not_the_Longest_Increasing_Subsequence {

	static Scanner in = new Scanner(System.in);

	static int n, k;

	static int a[];

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		int frequency[] = new int[n + 1];

		int previous_frequency[] = new int[n + 1];

		for(int i = 0; i < n; ++i) {

			previous_frequency[i + 1] = frequency[a[i]];

			if(a[i] == 1) {

				frequency[a[i]]++;

			} else {

				frequency[a[i]] = Math.min(frequency[a[i] - 1], frequency[a[i]] + 1);

			}

		}

		ans.append(frequency[k]).append("\n");

		for(int i = n; i >= 1; --i) {

			if(a[i - 1] == k) {

				if(previous_frequency[i] + 1 == frequency[a[i - 1]]) {

					ans.append(i).append(" ");

					//System.out.println("here");

				} else {

					--k;

				}

			}

			frequency[a[i - 1]] = previous_frequency[i];

		}

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {
		
		/*input();
		solve();

		System.out.print(ans.toString());*/

		solver();

	}

	private static void solver() throws IOException, FileNotFoundException, NullPointerException {

		fileIO();
		writeFile();

	}

	private static void input() {

		n = in.nextInt();

		k = in.nextInt();

		a = new int[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextInt();

		}

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("L_Not_the_Longest_Increasing_Subsequence.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int j = 0;

		while((line = br.readLine()) != null) {

			if(j == 0) {

				String s[] = line.trim().split(" ");

				n = Integer.parseInt(s[0]);

				k = Integer.parseInt(s[1]);

				a = new int[n];

			} else {

				String s[] = line.trim().split(" ");

				for(int i = 0; i < n; ++i) {

					a[i] = Integer.parseInt(s[i]);

				}

				solve();

				return;

			}

			++j;

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("L_Not_the_Longest_Increasing_Subsequence.out"));

		fw.write(ans.toString());

		fw.close();

	}
	
}