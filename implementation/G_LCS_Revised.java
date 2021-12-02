import java.util.Scanner;

public class G_LCS_Revised {

    static Scanner in=new Scanner(System.in);
    
    public static void main(String[] amit) {
        
        char a[]=in.next().toCharArray();
        
        int count[]=new int[2];
        
       int n=a.length;
        
       for(char i: a){
           
           count[i-'0' ]++;
           
       }
       
        System.out.println(Math.min(count[0],count[1] ) );
       
    }
    
}
