import java.util.Scanner;

public class C_Holidays{
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String [] amit){
		
		int n=in.nextInt();
		
		int m=in.nextInt();
		
		int a[]=new int[n+1];
		
		for(int t=0;t<m;t++){
			
			int left=in.nextInt();
			
			int right=in.nextInt();
			
		    for(int i=left;i<=right;i++){
				
				a[i]++;
				
			}
			
		}
		
		int max=Integer.MIN_VALUE,index=-1,index1=-1;
		
		int min=Integer.MAX_VALUE;
		
		int zero=0;
		
		for(int i=1;i<=n;i++){
			
			if(a[i]==0 || a[i]>1 ){
				
				int tempMin=min;
				
				min=Math.min(min,i);
				
				if(min!=tempMin)index=a[min];
				
			}
			
		}
		
		if(index==-1){
		
		System.out.print("OK");
		
		return;
		
	}
	
	System.out.print(min+" "+index);
		
	}

}