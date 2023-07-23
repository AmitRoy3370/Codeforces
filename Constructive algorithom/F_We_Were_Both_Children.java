import java.util.Scanner;

public class F_We_Were_Both_Children {

    static Scanner in = new Scanner(System.in);
    
    static int testCases, n;
    
    static long a[];
    
    static void solve() {
    
        int traps[] = new int[200001];
        
        for(long i : a) {
           
           if(i > n) continue;
           
           traps[(int)i]++;
           
        }
        
        int deaths[] = new int[200001];
        
        for(int i = 1; i <= n; ++i) {
           
           for(int j = i; j <= n; j += i) {
               
               deaths[j] += traps[i];
               
           }
           
        } 
        
        int max_death = deaths[0];
        
        for(int i : deaths) {
           
           max_death = Math.max(i, max_death);
           
        }
        
        System.out.println(max_death);
    
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
      
      a = new long[n];
      
      for(int i = 0; i < n; ++i) {
      
         a[i] = in.nextLong();
         
      }
      
    }

}
