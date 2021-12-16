import java.util.Scanner;

public class B_Badges{
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String [] amit){
		
		int b=in.nextInt();
		
		int g=in.nextInt();
		
		int n=in.nextInt();
		
		System.out.print((Math.min(g,n)-(n-Math.min(b,n))+1) );
		
	}
	
}