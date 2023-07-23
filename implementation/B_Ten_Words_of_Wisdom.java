import java.util.Scanner;

public class B_Ten_Words_of_Wisdom {

   static Scanner in = new Scanner(System.in);
   
   static int testCases, n;
   
   static int a[], b[];
   
   static void solve() {
   
       
       int winner = -1, win_score = -1;
       
       for(int i = 0; i < n; ++i) {
       
          if(a[i] <= 10 && b[i] >= win_score) {
              
              winner = i + 1;
              win_score = b[i];
              
          }
       
       }
       
       System.out.println(winner);
       
   }

   public static void main(String [] amit) {
   
        testCases = in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
        
            input();
            solve();
        
        }
   
   
   }
   
   static void input() {
   
      n = in.nextInt();
      
      a = new int[n];
      
      b = new int[n];
      
      for(int i = 0; i < n; ++i) {
      
         a[i] = in.nextInt();
         b[i] = in.nextInt();
      
      }
   
   }


}
