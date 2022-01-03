import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class A_Indian_Summer{
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String [] amit){
		
		int n=in.nextInt();
		
		Set<Map<String,String>> set=new HashSet<>();
		
		for(int i=0;i<n;i++){
			
			Map<String,String> map=new HashMap<>();
			
			String first=in.next();
			String second=in.next();
			
			map.put(first,second);
			
			set.add(map);
			
		}
		
		System.out.print(set.size() );
		
	}
	
}