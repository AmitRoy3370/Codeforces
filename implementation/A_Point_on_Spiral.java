
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Point_on_Spiral {

    static Scanner in=new Scanner(System.in);
    
    static int x,y;
    
    static Map<Integer,Integer> map=new HashMap<>();
    
    public static void main(String[] amit) {
        
        x=in.nextInt();
        y=in.nextInt();
        
        if(x==0 && y==0){
            
            System.out.println(0);
            
        }else if(-x+1<y && x>=y ){
            
            System.out.println((1 + (x - 1) * 4) );
            
        }else if(-y <= x && x < y){
            
            System.out.println((2 + (y - 1) * 4));
            
        }else if(x <= y && y < -x){
            
            System.out.println((3 + (-x - 1) * 4) );
            
        }else{
            
            System.out.println((4 + (-y - 1) * 4));
            
        }
        
    }
    
}
