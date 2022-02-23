import java.util.Scanner;

public class B_Anti_Fibonacci_Permutation {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static void solve() {

        for (int i = 1; i <= n; i++) {

            System.out.print(i+" ");

            for (int j = n; j > 0; j--) {

                if (i == j) {

                    continue;

                }

                System.out.print(j + " ");

            }

            System.out.println();

        }

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            solve();

        }

    }

}

/*
 * 
 * 2
 * 4
 * 3
 * 
 */