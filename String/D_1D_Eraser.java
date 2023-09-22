import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class D_1D_Eraser {

	private static Scanner in = new Scanner(System.in);

	private static int testCases, n, k;

	private static char x[];

	private static StringBuilder ans = new StringBuilder();

	private static void solve(int t) {

		int operations = 0;

		for(int i = 0; i < n; ++i) {

			if(x[i] == 'B') {

				i += k - 1;
				++operations;

			}

		}

		ans.append(operations);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] amit) throws IOException {

		practice();
		//submit();
		
	}

	private static void submit() {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			n = in.nextInt();
			k = in.nextInt();

			x = in.next().toCharArray();

			solve(t + 1);

		}

		System.out.print(ans.toString());

	}

	private static void practice() throws IOException {

		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException {

		FileReader fr = new FileReader(new File("D_1D_Eraser.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(; t <= testCases; ++t) {

					String s[] = line.trim().split(" ");

					n = Integer.parseInt(s[0]);
					k = Integer.parseInt(s[1]);

					line = br.readLine();

					x = line.trim().toCharArray();

					solve(t);

					line = br.readLine();

				} 

			}

			++t;

			if(t > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException {

		FileWriter fw = new FileWriter(new File("D_1D_Eraser.out"));

		fw.write(ans.toString());

		fw.close();

	}

}