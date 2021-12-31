import java.util.Scanner;

public class C_Letter{
	
	static Scanner in=new Scanner(System.in);
	
	static int n;
	
	static char a[];
	
	static void solve(){
		
		long dp[][]=new long[n+1][2];
		
		//0 index for the upper case and 1 for the lower case
		
		if(Character.isUpperCase(a[0] ) ){
			
			dp[0][0]=1;
			dp[0][1]=0;
			
		}else{
			
			dp[0][1]=1;
			dp[0][0]=0;
			
		}
		
		for(int i=1;i<n;i++){
			
			if(Character.isUpperCase(a[i]) ){
				
				dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1] )+1;
				dp[i][1]=dp[i-1][1];
				
			}else{
				
				dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1] );
				dp[i][1]=dp[i-1][1]+1;
				
			}
			
		}
		
		System.out.println(Math.min(dp[n-1][1],dp[n-1][0]));
		
	}
	
	public static void main(String [] amit){
		
		a=in.next().toCharArray();
		
		n=a.length;
		
		solve();
		
	}
	
}