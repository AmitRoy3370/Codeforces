import java.util.Scanner;

public class B_Verse_For_Santa {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long sum;

    static long a[];

    static void solve() {

        int min_index = 0;

        for (int i = 0; i < n; i++) {

            if (a[i] > a[min_index]) {

                min_index = i;

            }

            sum -= a[i];

            if (sum < 0) {

                break;

            }

        }

        if (sum >= 0) {

            System.out.println(0);

        } else {

            System.out.println((min_index + 1));

        }

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();
            sum = in.nextLong();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve();

        }

    }

}
/*

1
7 11
2 9 1 3 18 1 4

*/
