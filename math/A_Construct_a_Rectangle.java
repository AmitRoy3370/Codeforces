import java.util.Arrays;
import java.util.Scanner;

public class A_Construct_a_Rectangle {

    static Scanner in=new Scanner(System.in);
    
    static int testCases;
    
    static long l1,l2,l3;
    
    static void solve(){
      
       long arr[]={l1,l2,l3}; 
        
       Arrays.sort(arr);
       
       if(arr[0]+arr[1]==arr[2] ){
           
           System.out.println("YES");
           
       }else if(arr[0]==arr[1]){
           
           if(arr[2]%2==0 ){
               
               System.out.println("YES");
               
           }else{
               
               System.out.println("NO");
               
           }
           
       }else if(arr[1]==arr[2]){
           
           if(arr[0]%2==0 ){
               
               System.out.println("YES");
               
           }else{
               
               System.out.println("NO");
               
           }
           
       }else{
           
           System.out.println("NO");
           
       } 
       
    }
    
    public static void main(String[] args) {
        
        testCases=in.nextInt();
        
        for(int t=0;t<testCases;t++){
            
            l1=in.nextLong();
            
            l2=in.nextLong();
            
            l3=in.nextLong();
            
            solve();
            
        }
        
    }
    
}
