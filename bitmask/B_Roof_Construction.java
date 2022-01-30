import java.util.Scanner;

public class B_Roof_Construction {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static void solve() {

        /*

             our sequence is : x1,x2,x3......2^log2(n-1).......n-1  

        */

        int digit = (int) (Math.log(n-1) / Math.log(2));
        int max = (int) Math.pow(2, digit);

        for (int i = max - 1; i >= 0; i--)
            System.out.print(i + " ");
        for (int i = max; i < n; i++)
            System.out.print(i + " ");

        System.out.println();

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            solve();

        }

    }

}
