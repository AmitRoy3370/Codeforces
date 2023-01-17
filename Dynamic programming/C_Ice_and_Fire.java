
import java.util.Scanner;

public class C_Ice_and_Fire {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char a[];

    /*
    
    what we have?
    
    we have total n number of player's. the temperature defines the index of the player. and we have a
    string define the type's of the environment. 
    
    what does the value means?
    
    the ith character of the s string is contains only 0 or 1. the char 0 means the lower is win
    char 1 means that the higher is win.
    
    solve example:
    
    eg1:
    
    4
    001
    
    x = 2   3   4
    
    n = 4 means the player (1   2   3   4)
    
	x = 2
	
	(1	2) => 1(winner) 
	
	x = 3
	
	(1	2	3) => (1	2) => (1	3) = 1 win
			   => (2	3) => (2	1) = 1 win
	
    x = 4
    
    (1	2	3	4) => (1	2) => (1	3) => (1	4) = 4
	
	(2	3) => (2	4) => (2	1) = 2(winner)
	
	(3	4) => (1	2) => (3	1) => 1(winner)
	
	so here it has three possibiliies to choose
	as winner.
	
     */
    static void solve() {

        int bin[] = new int[2];
		
		StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; ++i) {

            bin[a[i - 1] - '0'] = i;

            if (a[i - 1] - '0' == 0) {

                sb.append((bin[1] + 1)).append(" ");

            } else {

                sb.append((bin[0] + 1)).append(" ");

            }

        }

        System.out.println(sb.toString());

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = in.next().toCharArray();

            solve();

        }

    }

}
