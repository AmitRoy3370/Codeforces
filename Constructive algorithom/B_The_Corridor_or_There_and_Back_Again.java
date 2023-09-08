import java.util.Scanner;

public class B_The_Corridor_or_There_and_Back_Again {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long room[], activated_time[];
	
	static void solve() {
		
		long visted_room = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			if(activated_time[i] % 2 == 0) {
				
				visted_room = Math.min(visted_room, room[i] + (activated_time[i] - 2) / 2);
				
			} else {
				
				visted_room = Math.min(visted_room, room[i] + activated_time[i] / 2);
				
			}
			
		}
		
		System.out.println(visted_room);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		room = new long[n];
		
		activated_time = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			room[i] = in.nextLong();
			
			activated_time[i] = in.nextLong();
			
		}
		
	}
	
}