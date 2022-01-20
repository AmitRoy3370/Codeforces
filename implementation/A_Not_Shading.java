import java.util.Scanner;

public class A_Not_Shading{
	
	static Scanner in=new Scanner(System.in);
	
	static int n,m,r,c,testCases;
	
	static char a[][];
	
	static void solve(){
		
		int white=0,black=0;
		
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
				
				if(a[i][c-1]=='B' || a[r-1][j]=='B' ){
					
					black++;
					
				}
				if(a[i][j]=='W'){
					
					++white;
					
				}
				
			}
			
		}
		
		if(a[r-1][c-1]=='B'){
		
		   System.out.println(0);
		
		}else if(white==n*m){
			
			System.out.println(-1);
			
		}else if(a[r-1][c-1]=='W' && black>0 ){
			
			System.out.println(1);
			
		}else{
			
			System.out.println(2);
			
		}
		
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=0;t<testCases;t++){
			
			n=in.nextInt();
			m=in.nextInt();
			r=in.nextInt();
			c=in.nextInt();
			
			a=new char[n][m];
			
			for(int i=0;i<n;i++){
				
				a[i]=in.next().trim().toCharArray();
				
			}
			
			solve();
			
		}
		
	}
	
}

/*

1
3 5 1 4
WBWWW
BBBWB
WWBBB

*/