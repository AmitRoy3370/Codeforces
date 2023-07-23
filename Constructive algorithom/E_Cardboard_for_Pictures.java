import java.util.Scanner;

public class E_Cardboard_for_Pictures {
    
    static Scanner in = new Scanner(System.in);
    
    static int testCases, n;
    
    static long c;
    
    static long a[];
    
    static void solve() {
    
       long used_square = 0L;
       
       long w = 0L, width = 0L;
       
       long L = 1L, R = (long)(1e9);
       
       while(R >= L) {
          
          long mid = (R + L) / 2L;
          
          w = 0L;
          
          for(long i : a) {
             
             w += (i + 2L * mid) * (i + 2L * mid);
             
             if(w > c) break;
             
          }
          
          if(w == c) {
             
             width = mid;
             break;
             
          } else if(w > c) R = mid - 1L;
            else L = mid + 1L;
       
       }
       
       System.out.println(width);
    
    }
    
    public static void main(String [] Amit) {
    
        testCases = in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
            
            input();
            solve();
            
        }
    
    }
    
    static void input() {
       
       n = in.nextInt();
       c = in.nextLong();
       
       a = new long[n];
       
       for(int i = 0; i < n; ++i) {
          
          a[i] = in.nextLong();
          
       }
       
    }
    
}
