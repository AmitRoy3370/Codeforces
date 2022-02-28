import java.util.Scanner;

public class A_Vanya_and_Cards{
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static int a[];
	
	static void solve(){
		
		int sum = 0;
		
		for(int i: a){
			
			sum += i; 
			
		}
		
		int ans = 0;
		
		if(sum < 0){
			
			while(sum < 0 ){
				
				sum += k;
				
				++ans;
				
			}
			
			System.out.println(ans);
			return;
			
		}
		
		while(sum > 0 ){
			
			sum -= k;
			
			++ans;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit){
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i){
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}
	
	