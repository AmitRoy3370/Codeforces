import java.util.Scanner;
import java.util.Arrays;

public class A_New_Year_Garland {

    static Scanner in = new Scanner(System.in);

    static int testCases;

    static long red, green, blue;

    static void solve() {

        long color[] = { red, green, blue };

        Arrays.sort(color);

        System.out.println((color[2] <= color[0] + color[1] + 1) ? "YES" : "NO");

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            red = in.nextLong();
            green = in.nextLong();
            blue = in.nextLong();

            solve();

        }

    }

}
