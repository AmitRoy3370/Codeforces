import java.util.Scanner;
import java.util.PriorityQueue;

public class E_Kolya_and_Movie_Theatre {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, m;

	static long a[];

	static long d;

	private static void solve() {

		long actually_have_entertainment = 0L, achived_maximum_entertainment = 0L, passing_days = 1L;

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(long i : a) {

			if(i > 0L) {

				actually_have_entertainment += i;
				pq.add(i);

			}

			if(pq.size() > m) {

				actually_have_entertainment -= pq.poll();

			}

			long achived_entertainment = actually_have_entertainment - passing_days * d;

			++passing_days;

			achived_maximum_entertainment = Math.max(achived_maximum_entertainment, achived_entertainment);

		}

		System.out.println(achived_maximum_entertainment);

	}

	public static void main(String [] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}
	
	private static void input() {

		n = in.nextInt();

		m = in.nextInt();

		d = in.nextLong();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}
		
	}

}