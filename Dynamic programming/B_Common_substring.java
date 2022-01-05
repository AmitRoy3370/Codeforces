import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Common_substring{
	
	static Scanner in=new Scanner(System.in);
	
	static int testCases,n;
	
	static char a[];
	
	static void solve(){
		
		int ans=0,max=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		map.put(0,-1);
		
		for(int i=0;i<n;i++){
			
			max+=(a[i]-'0')==1?1:-1;
			
			if(map.get(max)==null ){
				
				map.put(max,i);
				
			}else{
				
				ans=Math.max(ans,i-map.get(max));
				
			}
			
		}
		
		System.out.println(ans);
		
		/*int index0[]=new int[n];
		
		int index1[]=new int[n];
		
		int zero[]=new int[n];
		
		int one[]=new int[n];
		
		one[0]=((a[0]-'0')==1?1:0);
		zero[0]=((a[0]-'0')==0?1:0);
		
		for(int i=1;i<n;i++){
			
			if((a[i]-'0')==0 ){
				
				index0[i]=i;
				zero[i]=zero[i-1]+1;
				
			}else{
				
				index0[i]=index0[i-1];
				zero[i]=zero[i-1];
				
			}
			
			if((a[i]-'0')==1 ){
				
				index1[i]=i;
				one[i]=one[i-1]+1;
				
			}else{
				
				index1[i]=index1[i-1];
				one[i]=one[i-1];
				
			}
			
		}*/
		
		/*System.out.print("one: ");
		
		for(int i: one){
			
			System.out.print(i+" ");
			
		}
		
		System.out.println();
		
		System.out.print("zero: ");
		
		for(int i: zero){
			
			System.out.print(i+" ");
			
		}
		
		System.out.println();
		
		System.out.print("index0: ");
		
		for(int i: index0){
			
			System.out.print(i+" ");
			
		}
		
		System.out.println();
		
		System.out.print("index1: ");
		
		for(int i: index1){
			
			System.out.print(i+" ");
			
		}
		
		System.out.println();*/
		
		/*for(int i=0;i<n;i++){
			
			if(one[i]!=0 && zero[i]!=0 ){
				
				if( one[i]==zero[i] || Math.min(one[i],zero[i] )*2<=Math.max(one[i],zero[i] ) ){
					
					ans=Math.max(Math.min(one[i],zero[i] )*2,ans);
				//	System.out.println("ans: "+ans);
					
				}
				
			}
			
		}
		
		System.out.println(ans);*/
		
		/*int ans=0;
		
		for(int i=0;i<n;i++){
			
			int one=0,zero=0,tempAns=0;
			
			for(int j=i;j<n;j++){
				
				if(a[j]=='1') one++;
				
				else if(a[j]=='0') zero++;
				
				if(one!=0 && zero!=0 && one==zero ){
					
					tempAns=Math.max(tempAns,j-i+1);
					
				}
				
			}
			
			ans=Math.max(ans,tempAns);
			
		}
		
		System.out.println(ans);*/
		
	}
	
	public static void main(String [] amit){
		
		testCases=1;
		
		for(int t=0;t<testCases;t++){
			
			n=in.nextInt();
			
			a=in.next().toCharArray();
			
			//n=a.length;
			
			solve();
			
		}
		
	}
	
}
/*

11
00001000100

*/