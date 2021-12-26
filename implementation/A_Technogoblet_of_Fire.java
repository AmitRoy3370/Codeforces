import java.util.Scanner;

public class A_Technogoblet_of_Fire{
	
	static Scanner in=new Scanner(System.in);
	
	static int n,m,k;
	
	static int power[],school[],selected[];
	
	static int need;
	
	static boolean solve(){
		
		int satisfied=power[need];
		int fixed=school[need];
		
		for(int i=0;i<n;i++){
			
			if(i==need ){
				
				continue;
				
			}
			
			if(school[i]==fixed && power[i]>satisfied ){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		m=in.nextInt();
		
		k=in.nextInt();
		
		power=new int[n];
		school=new int[n];
		selected=new int[k];
		
		for(int i=0;i<n;i++){
			
			power[i]=in.nextInt();
			
		}
		
		for(int i=0;i<n;i++){
			
			school[i]=in.nextInt();
			
		}
		
		int count=0;
		
		for(int i=0;i<k;i++){
			
			selected[i]=in.nextInt();
			
			need=selected[i]-1;
			
			count=solve()?count+1:count;
			
		}
		
		System.out.print(count);
		
		//solve();
		
	}
	
}