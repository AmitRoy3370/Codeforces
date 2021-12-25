import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_Prison_Transfer {

    static Scanner in=new Scanner(System.in);
    
    public static void main(String[] amit) {
        
        int n=in.nextInt();
        
        long t=in.nextLong();
        
        int c=in.nextInt();
        
        long a[]=new long[n];
        
        List<Long> list=new ArrayList<>();
        
        list.add((long)-1);
        
        for(int i=0;i<n;i++){
            
            a[i]=in.nextLong();
            
            if(a[i]>t){
                
                list.add((long)i);
                
            }
            
        }
        
        list.add((long)n);
        
        n=list.size();
        
        long ans=0;
        
        for(int i=1;i<n;i++){
            
            long diff = list.get(i) - list.get(i-1)-1;
            
            ans+=Math.max((diff-c+1),0 );
            
        }
        
        System.out.println(ans);
        
    }
    
}
