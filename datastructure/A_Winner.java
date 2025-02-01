import java.util.Scanner;
import java.util.TreeMap;

public class A_Winner {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static String name[];
	static long score[];
	
	static void solve() {
		
		TreeMap<String, Long> map = new TreeMap<>();
		
		String winner = "";
		long maximumScore = Long.MIN_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			map.put(name[i], map.getOrDefault(name[i], 0L) + score[i]);
			
		}
		
		TreeMap<String, Boolean> names = new TreeMap<>();
		
		for(String i : map.keySet()) {
			
			if(map.get(i) >= maximumScore) {
				
				maximumScore = map.get(i);
				//names.put(i, true);
				
			}
			
		}
		
		for(String i : map.keySet()) {
			
			if(map.get(i) == maximumScore) {
				
				names.put(i, true);
				
			}
			
		}
		
		//System.out.println("maximum score :- " + maximumScore);
		
		TreeMap<String, Long> newCalculation = new TreeMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			newCalculation.put(name[i], newCalculation.getOrDefault(name[i], 0L) + score[i]);
			
			if(names.containsKey(name[i]) && newCalculation.get(name[i]) >= maximumScore) {
				
				winner = name[i];
				break;
				
			}
			
		}
		
		//System.out.println("andrew :- " + map.get("andrew"));
		
		System.out.print(winner);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		name = new String[n];
		score = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			name[i] = in.next();
			score[i] = in.nextLong();
			
		}
		
	}
	
}