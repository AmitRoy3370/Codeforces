import java.util.Scanner;

public class B_And_It_s_Non_Zero {

    static Scanner in=new Scanner(System.in);
    
    static int testCases,l,r;
    
    static int dp[][]=new int[200001][20];
    
    static void solve(){
        
        int maxElement=0;
        
        for(int i=0;i<20;i++){
            
            maxElement=Math.max(maxElement,dp[r][i]-dp[l-1][i]);
            
        }
     
        System.out.println((r - l + 1 - maxElement));
        
    }
    
    public static void main(String[] amit) {
        
        testCases=in.nextInt();
        
        for(int i=1;i<200001;i++){
            
            int check=i,index=0;
            
            while(check>0 ){
                
                dp[i][index++]+=check%2;
                
                check/=2;
                
            }
            
            for(int j=0;j<20;j++){
                
                dp[i][j]+=dp[i-1][j];
                
            }
            
        }
        
        for(int t=0;t<testCases;t++){
            
            l=in.nextInt();
            
            r=in.nextInt();
            
            solve();
            
        }
        
    }
    
}
