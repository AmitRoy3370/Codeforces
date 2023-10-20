import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class I_Parking_Lot {

	static Scanner in = new Scanner(System.in);

	static int n;

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		long way = 9L * n - 3 << (2 * n - 6L);

		ans.append(way);

	} 

	public static void main(String [] priya) throws IOException {

		//submit();
		practice();

	}

	private static long pow(long base, long power, long pow_value) {

		if(power == 0) {

			return 1L;

		}

		pow_value = pow(base, power / 2, pow_value);

		if(power % 2L == 1L) {

			return pow_value * pow_value * base;

		} else {

			return pow_value * pow_value;

		}

	}

	private static void practice() throws IOException {

		fileIO();
		writeFile();

	}

	private static void submit() {

		input();
		solve();

		System.out.print(ans.toString());

	}

	private static void fileIO() throws IOException {

		FileReader fr = new FileReader(new File("I_Parking_Lot.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		while((line = br.readLine()) != null) {

			n = Integer.parseInt(line.trim());

			solve();

		}

	}

	private static void writeFile() throws IOException {

		FileWriter fw = new FileWriter(new File("I_Parking_Lot.out"));

		fw.write(ans.toString());
		fw.close();

	}

	private static void input() {

		n = in.nextInt();

	}

}