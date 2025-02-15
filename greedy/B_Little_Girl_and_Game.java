import java.util.Scanner;

public class B_Little_Girl_and_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static char x[];
	
	static void solve() {
		
		int count[] = new int[26];
		
		for(char i : x) {
			
			count[i - 'a']++;
			
		}
		
		int even = 0, odd = 0;
		
		for(int i : count) {
			
			if(i == 0) {
				
			} else if(i % 2 == 0) {
				
				++even;
				
			} else {
				
				++odd;
				
			}
			
		}
		
		if(odd == 1 || (n == 2 && even == 1)) {
			
			System.out.print("First");
			
		} else {
			
			int player = 1, chars = n;
			
			while(chars != 1) {
				
				if(odd == 1) {
					
					player = (player + 1) % 2;
					
					break;
					
				} else if(odd == 2) {
					
					if(even > 0) {
						
						--even;
						++odd;
						
					} else {
						
						--odd;
						++even;
						
					}
					
				} else {
					
					if(even > 0) {
						
						if(odd % 2 == 1) {
							
							--odd;
							++even;
							
						} else {
							
							++odd;
							--even;
							
						}
						
					} else {
						
						--odd;
						++even;
						
					}
					
				}
				
				player = (player + 1) % 2;
				
				--chars;
				
			}
			
			if(player == 1) {
				
				System.out.print("First");
				
			} else {
				
				System.out.print("Second");
				
			}
			
		}
		
	}
	
	public static void main(String [] Priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		n = x.length;
		
	}
	
}