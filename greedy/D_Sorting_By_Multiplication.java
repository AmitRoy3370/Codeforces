import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class D_Sorting_By_Multiplication {

	static int testCases, n;

	static Scanner in = new Scanner(System.in);

	static long a[];

	static StringBuilder ans = new StringBuilder();

	private static void solve() {

		long prefix[] = new long[n];

		long suffix[] = new long[n];

		prefix[0]++;

		for(int i = 1; i < n; ++i) {

			if(a[i] >= a[i - 1]) {

				prefix[i]++;

			}

			prefix[i] += prefix[i - 1];

		}

		for(int i = n - 2; i >= 0; --i) {

			if(a[i] >= a[i + 1]) {

				++suffix[i];

			}

			suffix[i] += suffix[i + 1];

		}

		long ans_ = Math.min(prefix[n - 1], suffix[0]);

		for(int i = 1; i < n; ++i) {

			ans_ = Math.min(ans_, prefix[i - 1] + suffix[i]);

		}

		ans.append(ans_).append("\n");

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

	private static void input() {

		n = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

	private static void solver() throws IOException, FileNotFoundException, NullPointerException {

		fileio();

		writeFile();

	}

	private static void fileio() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("D_Sorting_By_Multiplication.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int i = 0;

		while((line = br.readLine()) != null ) {

			if(i == 0) {

				try {

				   testCases = Integer.parseInt(line.trim());

			    } catch(Exception e) {

			    	break;

			    }

			} else if(i == 1) {

				try {

				   n = Integer.parseInt(line.trim());

				   a = new long[n];

			    } catch(Exception e) {

			    	break;

			    }

			} else {

				try {

				  String s[] = line.trim().split(" ");

				  for(int j = 0; j < n; ++j) {

					 a[j] = Long.parseLong(s[j].trim());

				  }

				  solve();

			    } catch(Exception e) {

			    	break;

			    }

				/*for(int j = 0; j < n; ++j) {

					System.out.print(a[j] + " ");

				}

				System.out.println();*/

				//solve();

				i = 0;

			}

			++i;

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("D_Sorting_By_Multiplication.out"));

		fw.write(ans.toString());

		fw.close();

	}

	private static void print(long a[]) {

		for(long i : a) {

			System.out.print(i + " ");

		}

		System.out.println();

	}
	
}