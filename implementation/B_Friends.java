import java.util.Scanner;
import java.util.ArrayList;

public class B_Friends{
	
	static Scanner in=new Scanner(System.in);
	
	static ArrayList<Integer> list[]=new ArrayList[6];
	
	static int m;
	
	public static void main(String [] amit){
		
		m=in.nextInt();
		
		for(int i=0;i<=5;i++){
			
			list[i]=new ArrayList<>();
			
		}
		
		for(int i=0;i<m;i++){
			
			int u=in.nextInt();
			
			int v=in.nextInt();
			
			list[u].add(v);
			
			list[v].add(u);
			
		}
		
		for(int i=1;i<=5;i++){
			
			if(list[i].size()!=2 ){
				
				System.out.print("WIN");
				
				return;
				
			}
			
		}
		
		System.out.print("FAIL");
		
	}
	
}