import java.util.Scanner;

public class B_Dreamoon_and_WiFi {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static char s1[], s2[];
	
	static void solve() {
		
		double target = 0.0; 
		
		for(char i : s1) {
			
			if(i == '+') {
				
				target += 1.0;
				
			} else {
				
				target -= 1.0;
				
			}
			
		}
		
		double can_change = 0.0, point_gain = 0.0;
		
		for(char i : s2) {
			
			if(i == '?') {
				
				++can_change;
				
			} else {
				
				if(i == '+') {
					
					point_gain += 1.0;
					
				} else {
					
					point_gain -= 1.0;
					
				}
				
			}
			
		}
		
		if(can_change == 0.0 && point_gain == target) {
			
			System.out.println("1.000000000000");
			
			return;
			
		}
		
		double distance = Math.abs(target - point_gain);
		
		if(can_change < distance || (distance + can_change) % 2 == 1 ) {
			
			System.out.println("0.000000000000");
			
			return;
			
		}
		
		double need = (distance + can_change) / 2.0;
		
		double ans = 1.0;
		
		for(int i = 0; i < need; ++i) {
			
			ans *= (can_change - i);
			
		}
		
		for(int i = 2; i <= need; ++i) {
			
			ans /= i;
			
		}
		
		ans = ans / Math.pow(2, (int)can_change);
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		s1 = in.next().toCharArray();
		
		s2 = in.next().toCharArray();
		
		n = s1.length;
		m = s2.length;
		
		solve();
		
	}
	
}