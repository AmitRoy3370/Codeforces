import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class E_Building_an_Aquarium {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long X;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static boolean need_water(long height) {

		long sum = 0L;

		for(long i : a) {

			if(i >= height) {

				continue;

			}

			sum += height - i;

			if(sum > X) {

				return false;

			}

		}

		return sum <= X;

	}

	static void solve(int t) {

		long L = 0L, R = (long)(1e18), answer = 0L;

		while(R > L + 1L) {

			long mid = (L + R) / 2L;

			if(need_water(mid)) {

				L = mid + 1;

				answer = mid;

			} else {

				R = mid - 1;

			}

		}

		if(need_water(R)) {

			answer = R;;

		} else if(need_water(L)){

			answer = L;

		}

		ans.append(answer);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] amit) throws IOException {

		//submit();
		practice();
		
	}

	private static void submit() {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve(t + 1);

		}

		System.out.print(ans.toString());

	}

	private static void input() {

		n = in.nextInt();

		X = in.nextLong();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

	private static void practice() throws IOException {

		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException {

		FileReader fr = new FileReader(new File("E_Building_an_Aquarium.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t ==  0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(t = 1; t <= testCases; ++t) {

					String s[] = line.trim().split(" ");

					n = Integer.parseInt(s[0]);
					X = Long.parseLong(s[1]);

					a = new long[n];

					line = br.readLine();

					s = line.trim().split(" ");

					for(int i = 0; i < n; ++i) {

						a[i] = Long.parseLong(s[i]);

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

		FileWriter fw = new FileWriter(new File("E_Building_an_Aquarium.out"));

		fw.write(ans.toString());

		fw.close();

	}

}