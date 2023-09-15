import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class D_Cyclic_Operations {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		if(k == 1) {

			for(int i = 1; i <= n; ++i) {

				if(a[i] != i) {

					ans.append("NO").append("\n");
					return;

				}

			}

			ans.append("YES").append("\n");
			return;

		}

		int visit[] = new int[n + 1];

		int times[] = new int[n + 1];

		int floor = 1;

		for(int i = 1; i <= n; ++i) {

			if(visit[i] == 0) {

				int start = i;

				int component_number = 0;

				while(visit[start] == 0) {

					visit[start] = floor;

					times[start] = component_number++;

					start = (int)a[start];

				}

				if(visit[start] != floor) {

					++floor;
					continue;

				}

				if(component_number - times[start] != k) {

					ans.append("NO").append("\n");
					return;

				}

			}

			++floor;

		}

		ans.append("YES").append("\n");

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {

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

		n = in.nextInt();

		k = in.nextInt();

		a = new long[n + 1];

		for(int i = 1; i <= n; ++i) {

			a[i] = in.nextLong();

		}

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("D_Cyclic_Operations.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0, reach = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				if(t % 2 == 1) {

				  String s[] = line.trim().split(" ");

				  n = Integer.parseInt(s[0]);
				  k = Integer.parseInt(s[1]);

				  a = new long[n + 1];

				  ++reach;

			    } else {

				  String s[] = line.trim().split(" ");

				  for(int i = 1; i <= n; ++i) {

					a[i] = Long.parseLong(s[i - 1].trim());

				  }

				  solve();

			    }

			}

			++t;

			if(reach > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("D_Cyclic_Operations.out"));

		fw.write(ans.toString());

		fw.close();

	}

	private static void print(int a[]) {

		for(int i : a) {

			System.out.print(i + " ");

		}

		System.out.println();

	}

}