
import java.util.Scanner;

public class A_Legs {

    static Scanner in = new Scanner(System.in);

    static int n, testCases;

    static void solve() {

        int animal = n / 4;

        n = n % 4;

        animal += n / 2;

        System.out.println(animal);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();

    }

}
