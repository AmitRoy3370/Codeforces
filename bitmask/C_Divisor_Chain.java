import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C_Divisor_Chain {

	static Scanner in = new Scanner(System.in);

	static int testCases;

	static long N;

	static void solve() {

		StringBuilder sb = new StringBuilder();

		List<Long> list = new ArrayList<>();

		list.add(N);

		if(N % 2L == 1L) {

			N--;
			list.add(N);

		}

		while(N != 2L) {

			long reduce = 1L;

			while((N % (2L * reduce)) == 0L) {

				reduce *= 2L;

			}

			if(reduce == N) {

				reduce /= 2L;

			}

			//System.out.println(reduce + " " + N);

			N -= reduce;

			list.add(N);

		}

		list.add(1L);

		sb.append(list.size()).append("\n");

		for(long i : list) {

			sb.append(i).append(" ");

		}

		System.out.println(sb.toString().trim());

	}

	public static void main(String[] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		N = in.nextLong();
		
	}
	
}