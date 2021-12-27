import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Mike_and_Children{
	
	static Scanner in=new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		a=new long[n];
		
		for(int i=0;i<n;i++){
			
			a[i]=in.nextLong();
			
		}
		
		Map<Long,Long> map=new HashMap<>();
		
		for(int i=0;i<n-1;i++){
			
			for(int j=i+1;j<n;j++){
				
				//map.put(a[i]+a[j],map.getOrDefault(a[i]+a[j],0 )+1  );
				
				long sum=a[i]+a[j];
				
				if(map.containsKey(sum) ){
					
					map.put(sum,map.get(sum)+1 );
					
				}else{
					
					map.put(sum,(long)1);
					
				}
				
			}
			
		}
		
		long count=0;
		
		for(long i: map.keySet() ){
			
			count=Math.max(count,map.get(i) );
			
		}
		
		System.out.print(count);
		
	}
	
}