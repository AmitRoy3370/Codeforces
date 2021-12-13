import java.util.Scanner;

public class A_Life_of_a_Flower{
	
	static Scanner in=new Scanner(System.in);
	
	static int testCases,n;
	
	static int a[];
	
	static void solve(){
		
		int ans=1;
		
		for(int i=0;i<n;i++){
			
			if(i>=1 && a[i]==a[i-1] && a[i]==1 ){
				
				ans+=5;
				
			}else if(a[i]==1 ){
				
				ans++;
				
			}else if(i>=1 && a[i]==a[i-1] && a[i]==0 ){
				
				System.out.println(-1);
				
				return;
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=0;t<testCases;t++){
			
			n=in.nextInt();
			
			a=new int[n];
			
			for(int i=0;i<n;i++){
				
				a[i]=in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}