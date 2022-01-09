import java.util.Scanner;

public class A_Ice_Skating{
	
	static Scanner in=new Scanner(System.in);
	
	static int edges;
	
	static boolean visited[];
	
	static int x[],y[];
	
	public static void main(String [] amit){
		
		edges=in.nextInt();
		
		x=new int[edges+1];
		y=new int[edges+1];
		
		visited=new boolean[edges+1];
		
		for(int i=0;i<edges;i++){
			
			x[i]=in.nextInt();
			y[i]=in.nextInt();
			
		}
		
		int ans=0;
		
		for(int i=0;i<edges;i++){
			
			if(!visited[i] ){
				
				dfs(i);
				
				ans++;
				
			}
			
		}
		
		System.out.print(ans-1);
		
	}
	
	static void dfs(int source){
		
		visited[source]=true;
		
		for(int i=0;i<edges;i++){
			
			if(!visited[i] ){
				
				if(x[source]==x[i] || y[source]==y[i] )
				dfs(i);
				
			}
			
		}
		
	}
	
}