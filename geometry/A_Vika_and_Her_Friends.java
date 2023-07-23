import java.util.Scanner;

public class A_Vika_and_Her_Friends {
    
    static Scanner in = new Scanner(System.in);
    
    static int testCases, n, m, k, X, Y;
    
    static int x[], y[];
    
    static void solve() {
        
        boolean can_pick = true;
        
        for(int i = 0; i < k; ++i) {
            
            if((X + Y) % 2 == (x[i] + y[i]) % 2) {
                
                can_pick = false;
                break;
                
            }
            
        }
        
        if(can_pick) {
            
            System.out.println("YES");
            
        } else {
            
            System.out.println("NO");
            
        }
        
    }
    
    public static void main(String []amit) {
        
        testCases = in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
            
            input();
            solve();
            
        }
        
    }
    
    private static void input() {
        
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        
        X = in.nextInt();
        
        Y = in.nextInt();
        
        x = new int[k];
        y = new int[k];
        
        for(int i = 0; i < k; ++i) {
            
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            
        }
        
    }
    
}
