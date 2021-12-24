import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class A_Closing_The_Gap {

    static Scanner in=new Scanner(System.in);
    
    static int testCases,n;
    
    static int a[];
    
    static void solve(){
        
        int sum=0;
        
        Set<Integer> set=new HashSet<>();
        
        for(int i: a){
            
            sum+=i;
            
            set.add(i);
            
        }
        
        if(set.size()==1 ){
            
            System.out.println(0);
            
            return;
            
        }
        
        System.out.println((int)Math.abs((sum/n)-(int)Math.ceil((double)sum/(double)n ) ));
        
    }
    
    public static void main(String[] amit) {
        
        testCases=in.nextInt();
        
        for(int t=0;t<testCases;t++){
            
            n=in.nextInt();
            
            a=new int[n];
            
            for(int i=0;i<n;i++){
                
                a[i]=in.nextInt();
                
            }
            
            solve();
            
        }
        
    }
    
}
