
import java.util.Scanner;

public class E_MEX_Count {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static int a[];

    static void solve() {

        int count[] = new int[n + 1];
        
        for(int i : a) {
            
            count[i]++;
            
        }
        
        long prefix[] = new long[n + 2];
        
        for(int i = 0; i <= n; ++i) {
            
            prefix[count[i]]++;
            prefix[n - i + 1]--;
            
            if(count[i] == 0) {
                
                break;
                
            }
            
        }
        
        for(int i = 1; i <= n; ++i) {
            
            prefix[i] += prefix[i - 1];
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= n; ++i) {
            
            sb.append(prefix[i]).append(" ");
            
        }
        
        System.out.println(sb.toString().trim());
        
    }

    public static void main(String[] args) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            input();
            solve();

        }

    }

    private static void input() {

        n = in.nextInt();

        a = new int[n];

        for (int i = 0; i < n; ++i) {

            a[i] = in.nextInt();

        }

    }

}
