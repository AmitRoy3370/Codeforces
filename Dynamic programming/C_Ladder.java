
import java.util.Scanner;

public class C_Ladder {

    static Scanner in=new Scanner(System.in);
    
    static int n,m;
    
    static long a[];
    
    public static void main(String[] amit) {
        
        n=in.nextInt();
        m=in.nextInt();
        
        a=new long[n];
        
        for(int i=0;i<n;i++){
            
            a[i]=in.nextLong();
            
        }
     
        long increasing_dp[]=new long[n+1];
        
        long decreasing_dp[]=new long[n+1];
        
        decreasing_dp[0]=increasing_dp[n-1]=1;
        
        for(int i=1;i<n;i++){
             
            decreasing_dp[i]+= ((a[i] <= a[i - 1] ? decreasing_dp[i - 1] : 0) + 1);
                
        }
        
        for(int i=n-2;i>=0;i--){
           
            increasing_dp[i]+=(a[i] <= a[i + 1] ? increasing_dp[i + 1] : 0) + 1;
                 
        }
        
        /*for(long i:increasing_dp ){
            
            System.out.print(i+" ");
            
        }
        
        System.out.println();
        
        for(long i:decreasing_dp ){
            
            System.out.print(i+" ");
            
        }
        
        System.out.println();*/
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<m;i++){
            
            int l=in.nextInt()-1;
            int r=in.nextInt()-1;
            
            ans.append((increasing_dp[l]+decreasing_dp[r]>=(r-l+1)?"Yes":"No"));
            ans.append("\n");
            
        }
        
        System.out.println(ans);
        
    }
    
}
/*

8 6
1 2 1 3 3 5 2 1
1 3
2 3
2 4
8 8
1 4
5 8


*/

/*

8 1
1 2 1 3 3 5 2 1
5 8

*/

/*

8 1
1 2 1 3 3 5 2 1
1 3


*/