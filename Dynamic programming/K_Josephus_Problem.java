import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class K_Josephus_Problem {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static int a[];

	static int storage;

	static long N, P;

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		long last_child_standing = 0L;

		for(long i = 1L; i <= N; ++i) {

			last_child_standing = (last_child_standing + P) % i;

		}

		++last_child_standing;

		ans.append(last_child_standing);

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {

		/*input();
		solve();

		System.out.println(ans.toString());*/

		solver();
		
	}

	private static void solver() throws IOException, FileNotFoundException, NullPointerException {

		fileIO();
		fileWrite();

	}

	private static void input() {

		N = in.nextLong();

		P = in.nextLong();

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("joseph.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		while((line = br.readLine()) != null) {

			String t[] = line.trim().split(" ");

			N = Long.parseLong(t[0]);

			P = Long.parseLong(t[1]);

			solve();

			break;

		}

	}

	private static void fileWrite() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("joseph.out"));

		fw.write(ans.toString());

		fw.close();

	}

}