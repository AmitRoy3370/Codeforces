import java.util.Scanner;

public class E_Restore {

    static Scanner in=new Scanner(System.in);
    
    public static void main(String[] amit) {
        
        int n=in.nextInt();
        
        long mat[][]=new long[n][n];
        
        long sum=0;
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                
                mat[i][j]=in.nextLong();
                
                sum+=mat[i][j];
                
            }
            
        }
        
        sum/=(n-1);
        
        long rawSome[]=new long[n];
        
        long colSum[]=new long[n];
           
        for(int i=0;i<n;i++){
            
            int midIndex=-1,occur=0;
            
            for(int j=0;j<n;j++){
                
                rawSome[i]+=mat[i][j];
            
                if(mat[i][j]==0){
                    
                    midIndex=j;
                    
                    occur++;
                    
                }
                
            }
          
            if(occur>1 ){
           
            for(int j=0;j<n;j++){
                
                colSum[i]+=mat[j][i];
                
            }
                 
                mat[i][i]=(sum-colSum[i] );
                
            }else if(rawSome[i]!=sum ){
                
                mat[i][midIndex]=(-rawSome[i]+sum);
                
            }
            
        }
        
        for(long i[]: mat){
            
            for(long j: i){
                
                System.out.print(j+" ");
                
            }
            
            System.out.println();
            
        }
        
    }
    
}
/*

3
0 9 4
7 0 3
6 1 0


*/