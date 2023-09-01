import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class A_Prime_Deletion {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char a[];

	static StringBuilder ans = new StringBuilder();

	static boolean isPrime(long n) {

		for(long i = 2L; i * i <= n; ++i) {

			if(n % i == 0L) {

				return false;

			}

		}

		return true;

	}

	static void solve() {

		for(int i = 0; i < n; ++i) {

			for(int j = i + 1; j < n; ++j) {

				long num = Long.parseLong(a[i] + "" + a[j]);

				if(isPrime(num)) {

					ans.append(num).append("\n");
					return;

				}

			}

		}

		ans.append("-1").append("\n");

	}

	public static void main(String[] amit) throws IOException, FileNotFoundException, NullPointerException {
		
		/*testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

		System.out.println(ans.toString());*/

		solver();

	}

	private static void solver() throws IOException, FileNotFoundException, NullPointerException {

		fileIO();
		fileWriter();

	}

	private static void input() {

		a = in.next().toCharArray();

		n = a.length;

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("A_Prime_Deletion.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				a = line.trim().toCharArray();

				n = a.length;

				solve();

			}

			++t;

		}

	}

	private static void fileWriter() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("A_Prime_Deletion.out"));

		fw.write(ans.toString());

		fw.close();

	}

}