import java.util.Arrays;
import java.util.Scanner;

public class D_Triangle_Formation {

    static Scanner in=new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int n=in.nextInt();
        
        long a[]=new long[n];
        
        for(int i=0;i<n;i++){
            
            a[i]=in.nextLong();
            
        }
        
        Arrays.sort(a);
        
        boolean visited[]=new boolean[n];
        
        int ans=0;
        
        for(int i=0;i<n;i++){
        
            for(int j=0;j<n;j++){
                
                for(int k=0;k<n;k++){
                    
                    if(i!=j && j!=k && i!=k && !visited[i] && !visited[j] && !visited[k] ){
                        
                        if(a[i]+a[j]>a[k] && a[k]+a[j]>a[i] && a[i]+a[k]>a[j] ){
                            
                            ans++;
                            
                            visited[i]=true;
                            visited[j]=true;
                            visited[k]=true;
                            
                        }
                        
                    }
                    
                }
                
            }
            
          //  System.out.println(ans);
            
        }
        
        System.out.println(ans);
        
    }
    
}
