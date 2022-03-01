import java.util.Scanner;

public class A_Perfect_Squares{
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	public static void main(String [] amit){
		
		n = in.nextInt();
		
		a = new long[n];
		
		long ans = Long.MIN_VALUE;
		
		for(int i = 0; i < n; ++i){
			
			a[i] = in.nextLong();
			
			if(Math.sqrt(a[i]) != (long)Math.sqrt(a[i]) ){
				
				ans = Math.max(a[i], ans );
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
}