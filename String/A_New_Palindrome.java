import java.util.Scanner;

public class A_New_Palindrome {
	
	static int testCases, n;
	
	static char a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		int count[] = new int[26];
		
		for(char i : a) {
			
			count[i - 'a']++;
			
		}
		
		int uni = 0;
		
		for(int i : count) {
			
			if(i == n) {
				
				System.out.println("NO");
				return;
				
			}
			
			if(i > 0) {
				
				++uni;
				
			}
			
		}
		
		if(n % 2 == 0) {
			
			for(int i = 0; i < 26; ++i) {
				
				if(count[i] == 0) {
					
					continue;
					
				}
				
				if(count[i] % 2 != 0) {
					
					System.out.println("NO");
					return;
					
				}
				
			}
			
			System.out.println("YES");
			
		} else {
			
			int odd = 0, one_count = 0;
			
			for(int i = 0; i < 26; ++i) {
				
				if(count[i] == 0) {
					
					continue;
					
				}
				
				if(count[i] % 2 == 0) {
					
					continue;
					
				}
				
				if(count[i] == 1) {
					
					one_count++;
					
				}
				
				if(count[i] % 2 == 1) {
					
					++odd;
					
					if(odd > 1) {
						
						System.out.println("NO");
						return;
						
					}
					
				}
				
			}
			
			if(uni == 2 && one_count == 1) {
				
				System.out.println("NO");
				return;
				
			}
			
			System.out.println("YES");
			
		}
		
	}
	
	public static void main(String []priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.next().toCharArray();
		
		n = a.length;
		
	}
	
}