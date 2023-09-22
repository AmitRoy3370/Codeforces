import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class F_Money_Trees {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long X;

	static long a[], b[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		boolean ok_height[] = new boolean[n + 1];

		for(int i = 1; i <= n - 1; ++i) {

			if(b[i] % b[i + 1] == 0L) {

				ok_height[i] = true;

			} 

		}

		boolean flag = false;

		for(int i = 1; i <= n; ++i) {

			flag |= (a[i] <= X);

		}

		int answer = (flag ? 1 : 0);

		int start = 0;

		long collect_fruits = 0L;

		for(int i = 1; i <= n; ++i) {

			if(ok_height[i] && !ok_height[i - 1]) {

				start = i - 1;
				collect_fruits = a[i];

			} else {

				collect_fruits += a[i];

			}

			while(start < n && X < collect_fruits) {

				collect_fruits -= a[++start];

			}

			if(ok_height[i] || ok_height[i - 1]) {

				answer = Math.max(answer, i - start);

			}

		}

		ans.append(answer);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] priya) throws IOException {

		//submit();
		practice();
		
	}

	private static void submit() throws IOException {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve(t + 1);

		}

		System.out.print(ans.toString());

	}

	private static void practice() throws IOException {

		fileIO();
		writeFile();

	}

	private static void input() {

		n = in.nextInt();

		X = in.nextLong();

		a = new long[n + 1];
		b = new long[n + 1];

		for(int i = 1; i <= n; ++i) {

			a[i] = in.nextLong();

		}

		for(int i = 1; i <= n; ++i) {

			b[i] = in.nextLong();

		}

	}

	private static void fileIO() throws IOException {

		FileReader fr = new FileReader(new File("F_Money_Trees.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(t = 1; t <= testCases; ++t) {

					String s[] = line.trim().split(" ");

					n = Integer.parseInt(s[0]);
					X = Long.parseLong(s[1]);

					a = new long[n + 1];
					b = new long[n + 1];

					line = br.readLine();

					s = line.trim().split(" ");

					for(int i = 1; i <= n; ++i) {

						a[i] = Long.parseLong(s[i - 1]);

					}

					line = br.readLine();

					s = line.trim().split(" ");

					for(int i = 1; i <= n; ++i) {

						b[i] = Long.parseLong(s[i - 1]);

					}

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

		FileWriter fw = new FileWriter(new File("F_Money_Trees.out"));

		fw.write(ans.toString());

		fw.close();

	}

}