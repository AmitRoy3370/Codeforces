import java.util.Scanner;

public class C_String_Equality {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k, testCases;
	
	static char a[], b[];
	
	static void solve() {
		
		int alphabet_have[] = new int[26];
		int alphabet_need[] = new int[26];
		
		for(char i : a) {
			
			alphabet_have[i - 'a']++;
			
		}
		
		for(char i : b) {
			
			alphabet_need[i - 'a']++;
			
		}
		
		for(int i = 25; i >= 0; --i) {
			
			if(i + 1 < 26) {
				
				alphabet_have[i] += alphabet_have[i + 1];
				alphabet_need[i] += alphabet_need[i + 1];
				
			}
			
			if(alphabet_have[i] > alphabet_need[i] || (alphabet_need[i] - alphabet_have[i]) % k >= 1) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		System.out.println("YES");
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			k = in.nextInt();
			
			a = in.next().toCharArray();
			b = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}