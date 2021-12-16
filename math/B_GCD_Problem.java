import java.util.Scanner;

public class B_GCD_Problem {

    static Scanner in=new Scanner(System.in);
    
    static int testCases;
    
    static long n;
    
    static void solve(){
        
        if(n%2==0){
            
            long mid=n/2;
            
            System.out.println( (mid-1)+" "+mid+" "+1);
            
        }else{
            
            long value=(n-1)/2;
            
            if(value%2==1 ){
                
                long mid=n/2;
                
                System.out.println((mid+2) +" "+(mid-2)+" " +1);
                
            }else{
                
                long mid=n/2;
                
                System.out.println((mid+1)+" "+(mid-1)+" "+1 );
                
            }
            
        }
        
       /* --n;
          
        for(long i=n/2;i>=1;--i){
            
            if(gcd(i,n-i)==1 ){
                
                System.out.print(i+" "+(n-i)+" " );
                
                break;
                
            }
            
        }
        
        System.out.println(1);*/
        
    }
    
    public static void main(String[] args) {
        
        testCases=in.nextInt();
        
        for(int t=0;t<testCases;t++){
            
            n=in.nextLong();
            
            solve();
            
        }
        
    }
 
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    
}
/*

6
18
63
73
91
438
122690412


*/

/*

1
18

*/

/*

1
63

*/

/*

16
122690412
122690421
122690214
123456789
122690412
122690421
122690214
123456789
122690412
122690421
122690214
123456789
122690412
122690421
122690214
123456789


*/