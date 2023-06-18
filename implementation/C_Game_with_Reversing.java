
import java.util.Scanner;

public class C_Game_with_Reversing {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char x[], y[];

    /*
    
    y o y o y o
    o y o y o y
    ------------
    1 1 1 1 1  1  -> 6
    
    y o y o y o   
    y y o y o y
    
    o  y  o  y  o  y
    y  y  o  y  o  y
    
    o  y   o   y  o   y
    y  o   o   y  o   y
    
    y  o  y  o   y   o
    y  o  o  y   o   y
          -
    
    y   o   y  o   y  o
    y   o   y  y   o  y
    
    o   y   o  y   o   y
    y   o   y  y   o   y
               -
    
    o   y   o   y   o   y
    y   o   y   o   o   y
    
    y   o   y   o   y   o
    y   o   y   o   o   y
    
    y   o   y   o   y   o
    y   o   y   o   y   y
                        -
    
    0   y   o   y   o   y
    y   o   y   o   y   0
    
    y   o   y   o   y   o
    y   o   y   o   y   o
    
    total 12 operation need.
    
    1
    
    3
    
    y   o   y
    
    o   y   o
    ----------
    1   1   1   = 3
    
    y   o   y
    
    y   y   o  i, ii
    -
    
    y   o   y  iii, iv
    
    y   o   o
        -
    
    y   o   y
    y   o   y   v
    
     */
    private static void reverse(char x[]) {

        int n = x.length;

        for (int i = 0; i < n / 2; ++i) {

            char temp = x[i];
            x[i] = x[n - i - 1];
            x[n - i - 1] = temp;

        }

    }

    static void solve() {

        int tempA = 0, tempB = 0;

        for (int i = 0; i < n; ++i) {

            if (x[i] != y[i]) {

                ++tempA;

            }

        }

        reverse(y);

        for (int i = 0; i < n; ++i) {

            if (x[i] != y[i]) {

                ++tempB;

            }

        }

        if (tempA == 0) {

            System.out.println(0);

        } else if (tempB == 0) {

            System.out.println(2);

        } else {

            long final_ans = 2 * tempA + tempA % 2;

            final_ans = Math.min(final_ans, 2 * tempB + (tempB % 2 == 0 ? 1 : 0));

            System.out.println(final_ans);

        }

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

        x = in.next().toCharArray();

        y = in.next().toCharArray();

    }

}
