import java.util.Scanner;

import javafx.print.PrintColor;

public class A_ABC {

    static int n, testCases;

    static char a[];

    static Scanner in = new Scanner(System.in);

    static void solve() {

        //first try to find the best cases

        if (n == 1) {

            System.out.println("YES");

            return;

        }else if(n==2){

            if((a[0]=='0' && a[1]=='1') || (a[0]=='1' && a[1]=='0') ){

                System.out.println("YES");

                return;

            }else{

                System.out.println("NO");
                return;

            }

        }

        /*

            our main task is find the length of the substring which is palindrome and have length greater than 1
            so if we can count that we have more than one '1' or '0' then it has possibility to contain palindrom length greater than 1
            so our answer is yes only the string contain "10" or "01" or "0" and "1"
            so we will count the number of 1 and 0 in the string if one of them contain more than one then our answer is NO

        */

        int count[] = new int[2];

        for (char i : a)
            count[i - '0']++;

        if (count[0] >1 || count[1]>1) {

            System.out.println("NO");

        } else
            System.out.println("YES");

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = in.next().toCharArray();

            solve();

        }

    }

}
/* 

4
1
1
2
10
2
01
4
1010

*/