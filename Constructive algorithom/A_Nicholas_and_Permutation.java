import java.util.Scanner;

public class A_Nicholas_and_Permutation {

    static Scanner in = new Scanner(System.in);

    static int n;

    static int a[];

    static void solve() {

        int indexOne = -1, indexN = -1;

        for (int i = 1; i <= n; i++) {

            if (a[i] == 1)
                indexOne = i;
            else if (a[i] == n)
                indexN = i;

        }

        // System.out.println("indexOne: "+indexOne+" indexN: "+indexN);

        if (indexOne == 1 || indexOne == n || indexN == 1 || indexN == n)// if one of them situated in the first or last
                                                                         // index then we easily make the distance
                                                                         // between them is n
            System.out.println(n-1);
        else if ((indexOne == 1 && indexN == n) || (indexN == 1 && indexOne == n))
            System.out.println(n - 1);// this is for the if the one and n situted in the fast and last index
        else {

            /*
             * 
             * may be we can remove the n to the first or last index ans
             * also we can remove the 1 to the last or first index to get the maximum
             * satified answer
             * if we take the n to the nth index then our distance will be n-indexOne-1
             * if we take the 1 to the first index then the distance will be the indexOne-1
             * if we take the n to the nth index then the distance will be the indexOne-1
             * 
             */

            int ans = Math.max(Math.max(n - indexOne , indexN-1 ), Math.max(n - indexN , indexOne-1));

            System.out.println(ans);

        }

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        a = new int[n + 1];

        for (int i = 1; i <= n; i++)
            a[i] = in.nextInt();

        solve();

    }

}
/*

8
4 5 3 8 6 7 1 2

*/

/* 

13
8 4 3 7 5 11 9 1 10 2 13 12 6

*/