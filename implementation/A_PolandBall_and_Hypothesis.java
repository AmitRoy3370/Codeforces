import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class A_PolandBall_and_Hypothesis {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        int n = in.nextInt();

        int i = 1;

        while (true) {

            if (!isPrime(n * (i++) + 1)) {

                System.out.println(--i);

                return;

            }

        }

    }

    static boolean isPrime(int n) {

        if (n == 1)
            return false;

        boolean already_prime = true;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                already_prime = false;

                break;

            }

        }

        return already_prime;

    }

}
