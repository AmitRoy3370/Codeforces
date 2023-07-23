import java.util.Scanner;

public class C_Word_on_the_Paper {

     static Scanner in = new Scanner(System.in);
     
     static int testCases, n;
     
     static char a[][];
     
     static void solve() {
     
         StringBuilder sb = new StringBuilder();
         
         for(int i =0; i < 8; ++i) {
            
            for(int j = 0; j < 8; ++j) {
                
                if(a[i][j] != '.') sb.append(a[i][j]);
                
            }
            
         }
         
         System.out.println(sb.toString());
     
     }

     public static void main(String [] amit) {
          
          testCases = in.nextInt();
          
          for(int t = 0; t < testCases; ++t) {
               
               input();
               solve();
               
          }     
     
     }
     
     static void input() {
     
        a = new char[8][8];
        
        for(int i = 0; i < 8; ++i) {
             
             a[i] = in.next().toCharArray();
             
        }
        
     }

} 
