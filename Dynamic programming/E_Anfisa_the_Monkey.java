import java.util.Scanner;

public class E_Anfisa_the_Monkey{
	
	static Scanner in=new Scanner(System.in);
	
	static int a,b,k;
	
	static char text[];
	
	public static void main(String[] amit){
		
		k=in.nextInt();
		a=in.nextInt();
		b=in.nextInt();
		
		text=in.next().toCharArray();
		
		int n=text.length;
		
		if(n<k*a || n>k*b  ){
			
			System.out.println("No solution");
			
			return;
			
		}
		
		int avg=(int)Math.floor((double)(n/k));
		int add=n%k;
		
		int y=0;
		
		for(int i=0;i<n;i++){
			
			System.out.print(text[i]);
			
			++y;
			
			if(y>=avg+((add>0)?1:0) ){
				
				System.out.println();
				
				--add;
				
				y=0;
				
			}
			
		}
		
	}
	
}