import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CodeTON_Round_3_Div_1_Div_2_Rated_Prizes {
    
    static Scanner in = new Scanner(System.in);
    
    static int testCases, n;
    static int a[];
    static char s[], t[];
    
    static void C_Complementary_XOR(int te) {
        
        // best cases
        
        if(new String(s).equals(new String(t))) {
            
           List<String> list = new ArrayList<>();
        
           int one = 0;
        
           for(int i = 0; i < n; ++i) {
            
              if(s[i] == '1') {
                
                 ++one;
                
                 list.add((i + 1) + " " + (i + 1));
                
              }
            
            }
            
            if(one % 2 == 1) {
        
              list.add(1 + " " + 1);
              list.add(2 + " " + n);
              list.add(1 + " " + n);
        
            }
            
            StringBuilder ans = new StringBuilder();
        
           ans.append("YES\n");
           ans.append((list.size()) + "\n");
        
           for(String i : list) {
            
              ans.append(i).append("\n");
            
           }
           
           System.out.println(ans.toString());
         
           return;
            
        }
        
        // then if any character is equal
        // at the same position
        
        for(int i = 0; i < n; ++i) {
            
            if(s[i] == t[i]) {
                
                System.out.println("NO");
               
                return;
                
            }
            
        }
        
        List<String> list = new ArrayList<>();
        
        int one = 0;
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < n; ++i) {
            
            if(s[i] == '1') {
                
                ++one;
                
                list.add((i + 1) + " " + (i + 1));
                
            }
            
        }
        
        if(one % 2 == 0) {
        
              list.add(1 + " " + 1);
              list.add(2 + " " + n);
              list.add(1 + " " + n);
        
        }
        
        ans.append("YES\n");
        ans.append(list.size() + "\n");
        
        for(String i : list) {
            
            ans.append(i).append("\n");
            
        }
        
        System.out.print(ans.toString());
        
    }
    
    static void B_Maximum_Substring(int t) {
        
        long total_zero = 0, total_one = 0;
        
        long one = 0, zero = 0;
        long substring_one = 0, substring_zero = 0;
        
        for(char i : s) {
            
            if(i == '0') {
                
                ++zero;
                
                ++total_zero;
                
                substring_zero = Math.max(substring_zero, one);
                
                one = 0;
                
            } else {
                
                ++one;
                
                substring_one = Math.max(substring_one, zero);
                
                zero = 0;
                
                ++total_one;
                
            }
            
        }
        
        substring_zero = Math.max(zero, substring_zero);
        substring_one = Math.max(one, substring_one);
        
        long ans = Math.max(total_one * total_zero, Math.max(substring_one * substring_one, substring_zero * substring_zero));
        
        System.out.print(ans);
        
        if(t != testCases) {
            
            System.out.println();
            
        }
        
    }
    
    static void A_Indirect_Sort(int t) {
        
        if(a[0] == 1) {
            
            System.out.print("YES");
            
        } else {
            
            System.out.print("NO");
            
        }
        
        if(t != testCases) {
            
            System.out.println();
            
        }
        
    }
    
    public static void main(String priya[]) {
      
      testCases = in.nextInt();
      
      for(int te = 0; te < testCases; ++te) {
          
          /*n = in.nextInt();
          
          a = new int[n];
          
          for(int i = 0; i < n; ++i) {
              
              a[i] = in.nextInt();
              
          }
          
          A_Indirect_Sort(t + 1);*/
          
          /*n = in.nextInt();
          
          s = in.next().toCharArray();
          
          B_Maximum_Substring(t + 1);*/
          
          n = in.nextInt();
          
          s = in.next().toCharArray();
          t = in.next().toCharArray();
          
          C_Complementary_XOR(te + 1);
          
      }
      
    }

}