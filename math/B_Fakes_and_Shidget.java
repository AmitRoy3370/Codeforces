import java.util.Scanner;

public class B_Fakes_and_Shidget {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static double a[], b[], c[], d[];

	static void solve() {

		double left = 0.0, right = (1e9);

		double ans = 0.00;

		int time = 0;

		while(true) {

			double mid = (right + left) / 2.00;

			double sum = 0.0;

			//System.out.println("stack for left :- " + left + " right :- " + right);

			for(int i = 0; i < n; ++i) {

				double x = b[i] - mid * a[i];

				double y = d[i] - mid * c[i];

				sum += Math.max(x, y);

			}

			if(sum >= 0.0) {

				ans = mid;
				left = mid;

			} else {

				right = mid;

			}

			++time;

			if(time == 100) {

				break;

			}

		}

		System.out.println(ans);

	}

	public static void main(String [] priya) {

		input();
		solve();

	}

	private static void input() {

		n = in.nextInt();

		a = new double[n];
		b = new double[n];
		c = new double[n];
		d = new double[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextDouble();
			b[i] = in.nextDouble();
			c[i] = in.nextDouble();
			d[i] = in.nextDouble();

		}

	}

}