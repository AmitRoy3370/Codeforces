
import java.util.Scanner;

public class A_New_Year_and_Naming {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        int n = in.nextInt();
        int m = in.nextInt();

        String s[] = new String[n];

        String t[] = new String[m];

        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }

        for (int i = 0; i < m; i++) {
            t[i] = in.next();
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {

            int x=in.nextInt()-1;
            
            String ans=s[x%n]+t[x%m];
            
            System.out.println(ans);
            
        }

    }

}
