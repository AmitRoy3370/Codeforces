
import java.util.Scanner;

public class B_Build_a_Contest {

    static int n,m;
    
    static int problems[];
    
    static Scanner in=new Scanner(System.in);
    
    public static void main(String[] amit) {
        
        n=in.nextInt();
        m=in.nextInt();
        
        problems=new int[m];
       
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++){
            
            problems[i]=in.nextInt();
            
            max=Math.max(problems[i],max);
            
        }
        
       int counting[]=new int[max+1];
       int double_counting[]=new int[max+1+m];
        
       int ans[]=new int[m];
       
       int index=0;
       
       for(int i: problems){
           
           counting[i]++;
           double_counting[counting[i] ]++;
           
           if(double_counting[counting[i] ]==n ){
               
               ans[index]=1;
               
           }
                   
           index++;
           
       }
       
       for(int i: ans){
           
           System.out.print(i);
           
       }
       
    }
    
}
/*

3 11
2 3 1 2 2 2 3 2 2 3 1


*/

/*

4 8
4 1 3 3 2 3 3 3


*/

/*

5 20
1 4 4 2 1 1 3 5 4 2 2 4 5 2 3 3 4 5 1 4

*/