import java.util.Scanner;

public class B_Restricted_RPS {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, a, b, c;
	
	static char bobs_move[];
	
	static void solve() {
		
		int bobs_rock = 0, bobs_paper = 0, bobs_sissor = 0;
		
		int alice_can_bit = 0;
		
		for(char i : bobs_move) {
			
			if(i == 'R') {
				
				bobs_rock++;
				
			} else if(i == 'P') {
				
				bobs_paper++;
				
			} else {
				
				++bobs_sissor;
				
			}
			
		}
		
		alice_can_bit += Math.min(bobs_paper, c) + Math.min(bobs_rock, b) + Math.min(bobs_sissor, a);
		
		//System.out.println(alice_can_bit);
		
		if(2 * alice_can_bit < n) {
			
			System.out.println("NO");
			return;
			
		}
		
		char alice_moves[] = new char[n];
		
		int index = 0;
		
		for(char i : bobs_move) {
			
			if(i == 'R' && b > 0) {
				
				alice_moves[index] = 'P';
					
				--b;
				
			} else if(i == 'P' && c > 0) {
				
				alice_moves[index] = 'S';
					
				--c;
				
			} else if(i == 'S' && a > 0) {
					
					--a;
					
					alice_moves[index] = 'R';
				
			} else {
				
				alice_moves[index] = 'L';
				
			}
			
			++index;
			
		}
		
		System.out.println("YES");
		
		for(int i = 0; i < n; ++i) {
			
			if(alice_moves[i] == 'L') {
				
				if(a > 0) {
					
					alice_moves[i] = 'R';
					--a;
					
				} else if(b > 0) {
					
					alice_moves[i] = 'P';
					--b;
					
				} else if(c > 0) {
					
					alice_moves[i] = 'S';
					--c;
					
				}
				
			}
			
		}
		
		System.out.println(new String(alice_moves) );
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			
			bobs_move = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}