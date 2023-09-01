import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class B_Two_Binary_Strings {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char x[], y[];

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		boolean find = false;

		for(int i = 0; i < n - 1; ++i) {

			if(x[i] == y[i] && y[i + 1] == x[i + 1]) {

				if(x[i] == '0' && x[i + 1] == '1') {

					find = true;
					break;

				}

			}

		}

		if(find) {

			ans.append("YES").append("\n");

		} else {

			ans.append("NO").append("\n");

		}

	}

	public static void main(String[] args) throws IOException, FileNotFoundException, NullPointerException {

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
		writeFile();

	}

	private static void input() {

		x = in.next().toCharArray();

		y = in.next().toCharArray();

		n = x.length;

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("B_Two_Binary_Strings.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int j = 0, t = 0;

		while((line = br.readLine()) != null ) {

			if(j == 0) {

				testCases = Integer.parseInt(line.trim());

			} else if(j == 1) {

				x = line.trim().toCharArray();

			} else if(j == 2) {

				y = line.trim().toCharArray();

				n = x.length;

				solve();

				j = 0;

			}

			++j;

		}

	}

	private static void writeFile() throws FileNotFoundException, IOException, NullPointerException {

		FileWriter fw = new FileWriter(new File("B_Two_Binary_Strings.out"));

		fw.write(ans.toString());

		fw.close();

	}
	
}