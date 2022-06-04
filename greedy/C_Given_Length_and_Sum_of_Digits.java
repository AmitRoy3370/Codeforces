import java.util.Scanner;

public class C_Given_Length_and_Sum_of_Digits {

  static int testCases, n, s;
  
  static Scanner in = new Scanner(System.in);

  static void solve() {
  
     if((n > 1 && s == 0) || (9 * n < s)) {
     
        System.out.print(-1 + " " + (-1));
        return;
     
     }
  
     String max = "";
     String min = "";
     
     int sum1 = s - 1;
     
     for(int i = 1; i <= n; ++i) {
     
         max += (Math.min(9, s));
         s -= Math.min(9, s);     
     
     }
     
     for(int i = 1; i < n; ++i) {
     
        min = (Math.min(9, sum1)) + min;
        sum1 -= Math.min(9, sum1);
     
     }
     
     min = (sum1 + 1) + min;
     
     System.out.print(min + " " + max);
     
  }

  public static void main(String [] priya) {
  
     n = in.nextInt();
     s = in.nextInt();
     
     solve();
  
  }

}
