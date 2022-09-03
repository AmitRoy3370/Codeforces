import java.util.Scanner;

public class C_Madoka_and_Formal_Statement {
    
    static int n, testCases;
    
    static long a[], b[];
    
    static Scanner in = new Scanner(System.in);
    
    static void solve() {
        
        boolean ok = true;
        
        for(int i = 0; i < n; ++i) {
            
            if(a[i] > b[i]) {
                
                ok = false;
                break;
                
            }
            
            if(b[i] > a[i]) {
                
                //5 % 5 = 0 4 % 5 = 4
                
                if(b[i] > b[(i + 1) % n] + 1) {
                    
                    ok = false;
                    break;
                    
                }
                
            }
            
        }
        
        if(ok) {
            
            System.out.println("YES");
            
        } else {
            
            System.out.println("NO");
            
        }
        
    }
    
    public static void main(String [] priya) {
        
        testCases = in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
            
            n = in.nextInt();
            
            a = new long[n];
            b = new long[n];
            
            for(int i = 0; i < n; ++i) {
                
                a[i] = in.nextLong();
                
            }
            
            for(int i = 0; i < n; ++i) {
                
                b[i] = in.nextLong();
                
            }
            
            solve();
            
        }
        
    }
    
}