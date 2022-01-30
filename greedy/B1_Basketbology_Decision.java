import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class B1_Basketbology_Decision {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long x[], c[];

    private static void solve() {

        Arrays.sort(x);
        Arrays.sort(c);

        int i=0,j=0;

        while(i<n && j<n ){

            if(x[i]<=c[j] ){

                ++i;
                ++j;

            }else ++j;

        }

        if(i==n && j==n) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void main(String[] amit) {

        testCases = 1;

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            x = new long[n];
            c = new long[n];

            for (int i = 0; i < n; i++)
                x[i] = in.nextLong();

            for (int i = 0; i < n; i++)
                c[i] = in.nextLong();

            solve();

        }

    }

}
