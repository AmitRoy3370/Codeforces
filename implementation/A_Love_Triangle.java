import java.util.Scanner;
import java.util.ArrayList;

public class A_Love_Triangle{
	
	static int n;
	
	static int a[];
	
	static ArrayList<Integer> list[];
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		list=new ArrayList[n+1];
		
		for(int i=0;i<=n;i++){
			
			list[i]=new ArrayList<>();
			
		}
		
		boolean visited[]=new boolean[n+1];
		
		for(int i=1;i<=n;i++){
			
			list[i].add(in.nextInt() );
			
		}
		
		for(int i=1;i<=n;i++){
			
			if(!visited[i] ){
				
				visited[i]=true;
				
				int b=list[i].get(0);
				
				visited[b]=true;
				
				int c=list[b].get(0);
				
				visited[c]=true;
				
				if(list[c].get(0)==i ){
					
					System.out.println("YES");
					
					return;
					
				}
				
			}
			
		}
		
		System.out.println("NO");
		
	}
	
}