import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class B_Elementary_Particles{
	
	static int testCases,n;
	static long a[];
	
	static Scanner in=new Scanner(System.in);
	
	static void solve(){
		
		int ans=-1;
		
		Map<Long,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++){
			
			if(!map.containsKey(a[i] ) ){
				
				map.put(a[i],i);
				
			}else{
				
				int previous=map.get(a[i]);
				
				int present=n-i-1;
				
				ans=Math.max(ans,present+previous+1 );
				
				map.put(a[i],i);
				
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
		
		//in.close();
		
	}
	
}