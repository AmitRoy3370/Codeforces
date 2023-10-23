import java.util.Scanner;
import java.util.TreeMap;

public class D_In_Love {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static TreeMap<Long, Integer> min = new TreeMap<>();
	
	static TreeMap<Long, Integer> max = new TreeMap<>();
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		StringBuilder ans = new StringBuilder();
		
		for(int t = 0; t < testCases; ++t) {
			
			char ch = in.next().charAt(0);
			
			long L = in.nextLong();
			
			long R = in.nextLong();
			
			if(ch == '+') {
				
				min.put(L, min.getOrDefault(L, 0) + 1);
				max.put(R, max.getOrDefault(R, 0) + 1);
				
			} else {
				
				min.put(L, min.getOrDefault(L, 0) - 1);
				max.put(R, max.getOrDefault(R, 0) - 1);
				
				if(min.get(L) == 0) {
					
					min.remove(L);
					
				}
				
				if(max.get(R) == 0) {
					
					max.remove(R);
					
				}
				
			}
			
			if(!min.isEmpty() && !max.isEmpty()) {
				
				if(min.lastKey() > max.firstKey()) {
					
					ans.append("YES").append("\n");
					
				} else {
					
					ans.append("NO").append("\n");
					
				}
				
			} else {
				
				ans.append("NO").append("\n");
				
			}
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}