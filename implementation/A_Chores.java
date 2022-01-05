import java.util.Scanner;

public class A_Chores{
	
	static Scanner in=new Scanner(System.in);
	
	static int n,k,x;
	
	static int a[];
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		k=in.nextInt();
		
		x=in.nextInt();
		
		a=new int[n];
		
		for(int i=0;i<n;i++){
			
			a[i]=in.nextInt();
			
		}
		
		for(int i=n-1;i>=n-k;i--){
			
			a[i]=x;
			
		}
		
		int sum=0;
		
		for(int i:a){
			
			sum+=i;
			
		}
		
		System.out.println(sum);
		
	}
	
}