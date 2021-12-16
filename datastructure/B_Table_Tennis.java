import java.util.Scanner;

public class B_Table_Tennis{
	
	static Scanner in=new Scanner(System.in);
	
	static int n;
	
	static long k;
	
	static int a[];
	
	static void solve(){
		
		int basic_comparator=a[0];
		
		int win=0;
		
		for(int i=1;i<n;i++){
			
			if(basic_comparator<a[i] ){
				
				basic_comparator=a[i];
				
				win=1;
				
			}else{
				
				++win;
				
				if( win>=k ){
					
					System.out.print(basic_comparator);
					
					return;
					
				}
				
			}
			
		}
		
		basic_comparator=a[0];
		
		for(int i: a){
			
			basic_comparator=Math.max(i,basic_comparator);
			
		}
		
		System.out.print(basic_comparator);
		
	}
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		k=in.nextLong();
		
		a=new int[n];
		
	    for(int i=0;i<n;i++){
			
			a[i]=in.nextInt();
			
		}
		
		solve();
		
	}
	
}
/*

100 50
2 4 82 12 47 63 52 91 87 45 53 1 17 25 64 50 9 13 22 54 21 30 43 24 38 33 68 11 41 78 99 23 28 18 58 67 79 10 71 56 49 61 26 29 59 20 90 74 5 75 89 8 39 95 72 42 66 98 44 32 88 35 92 3 97 55 65 51 77 27 81 76 84 69 73 85 19 46 62 100 60 37 7 36 57 6 14 83 40 48 16 70 96 15 31 93 80 86 94 34

*/

/*

5 2
1 4 3 5 2

*/