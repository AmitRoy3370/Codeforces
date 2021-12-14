import java.util.Scanner;

public class B_Array_Eversion{
	
	static Scanner in=new Scanner(System.in);
	
	static int n,testCases;
	
	static long a[];
	
	static void solve(){
		
		long max=a[0];
		
		int max_index=0;
		
		for(int i=0;i<n;i++){
			
			if(a[i]>=max ){
				
				max=a[i];
				max_index=i;
				
			}
			
		}
		
		if(max_index==n-1 ){
			
			System.out.println(0);
			
			return;
			
		}
		
		int ans=0;
		
		long previous=Long.MIN_VALUE;
		
		for(int i=n-1;i>=0;i--){
			
			if(a[i]==max ){
				
				break;
				
			}
			
			if(a[i]>previous ){
				
				previous=a[i];
				
				ans++;
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=0;t<testCases;t++){
			
			n=in.nextInt();
			
			a=new long[n];
			
			for(int i=0;i<n;i++){
				
				a[i]=in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}