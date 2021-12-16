import java.util.Scanner;

public class A_Optimal_Currency_Exchange{
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String [] amit){
		
		int n=in.nextInt();
		
		int d=in.nextInt();
		
		int e=in.nextInt();
		
		int ans = n;
        
		for (int i = 0; i * 5 * e <= n; ++i) {
           ans = Math.min(ans, (n - i * 5 * e) % d);
        }
		
		System.out.println(ans );
		
	}
	
}