import java.util.Scanner;

public class A_Home_Numbers {

	static Scanner in = new Scanner(System.in);

	static int n, a;

	static void solve() {

		int start = 1;

		int time_taken = 1;

		while(start < a) {

			start += 2;

			++time_taken;

		}

		if(start != a) {

			time_taken = Integer.MAX_VALUE;

		}

		//System.out.println(start);

		int time_taken2 = 1;

		start = n;

		while(start > a) {

			start -= 2;

			++time_taken2;

		}

		//System.out.println(start);

		if(start != a) {

			time_taken2 = Integer.MAX_VALUE;

		}

		System.out.println(Math.min(time_taken2, time_taken));

	}

	public static void main(String[] amit) {

		input();
		solve();
		
	}

	static void input() {
		
		n = in.nextInt();
		a = in.nextInt();

	}

}