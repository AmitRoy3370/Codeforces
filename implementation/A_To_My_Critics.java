import java.util.Scanner;

public class A_To_My_Critics {

    static Scanner in = new Scanner(System.in);
    
    static int testCases, a, b, c;
    
    static void solve() {
    
         if(a + b >= 10) System.out.println("YES");
         else if(b + c >= 10) System.out.println("YES");
         else if(a + c >= 10) System.out.println("YES");
         else System.out.println("NO");
    
    }

    public static void main(String [] amit) {
    
        testCases =  in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
        
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            
            solve();
        
        }
    
    
    }


}
