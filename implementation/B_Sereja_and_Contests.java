import java.util.Scanner;

public class B_Sereja_and_Contests{
	
	static Scanner in = new Scanner(System.in);
	
	static int x, k;
	
	static boolean contest[];
	
	static void solve(){
		
		int min_contest = 0, max_contest = 0;
		int organaize_contest = 1;
		
		while(organaize_contest < x ){
			
			if(!contest[organaize_contest] ){
				
				if(organaize_contest + 1 < x && !contest[organaize_contest + 1] ) {
					
					contest[organaize_contest ] = true;
					contest[organaize_contest + 1 ] = true;
					
					max_contest += 2;
					min_contest += 1;
					
					organaize_contest += 2;
					
				} else {
					
					contest[organaize_contest++ ] = true;
					
					max_contest++;
					min_contest++;
										
				}
				
			} else {
				
				++organaize_contest;
				
			}
			
		}
		
		System.out.println(min_contest+" "+max_contest );
		
	}
	
	public static void main(String [] amit){
		
		x = in.nextInt();
		
		k = in.nextInt();
		
		contest = new boolean[x + 1];
		
		for(int i = 0; i < k; ++i){
			
			int type = in.nextInt();
			
			if(type == 1){
				
				contest[in.nextInt() ] = true;
				contest[in.nextInt() ] = true;
				
			}else{
				
				contest[in.nextInt() ] = true;
				
			}
			
		}
		
		solve();
		
	}
	
}