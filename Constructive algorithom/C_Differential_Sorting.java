import java.util.Scanner;

public class C_Differential_Sorting {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        boolean sorted = true;

        for (int i = 1; i < n; i++) {

            if (a[i] < a[i - 1]) {

                sorted = false;
                break;

            }

        }

        if (sorted) {

            System.out.println(0);
            return;

        }

        if(a[n-1]<0 ){

            for(int i=1;i<n;i++){

                if(a[i-1]<a[i] ){

                    System.out.println(-1);
                    return;

                }

            }

        }

        if (a[n - 1] < a[n - 2]) {

            System.out.println(-1);
            return;

        }

        System.out.println(n - 2);

        for (int i = 0; i < n - 2; i++) {

            System.out.println((i + 1) + " " + (n - 1) + " " + n);

        }

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++)
                a[i] = in.nextLong();

            solve();

        }

    }

}
/* 

3
5
5 -4 2 -1 2
3
4 3 2
3
-3 -2 -1

*/

/* 

1
5
5 -4 2 -1 2


*/