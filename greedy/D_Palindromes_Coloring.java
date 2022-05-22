import java.util.Scanner;

public class D_Palindromes_Coloring {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static char a[];
	
	static void solve() {
		
		int alphabet[] = new int[26];
		
		for(char i : a) {
			
			alphabet[i - 'a']++;
			
		}
		
		int even_palindrome = 0, odd_palindrome = 0;
		
		for(int i : alphabet) {
			
			even_palindrome += i / 2;
			odd_palindrome += i % 2;
			
		}
		
		int ans = 2 * (even_palindrome / k);
		
		odd_palindrome += 2 * (even_palindrome % k);
		
		if(odd_palindrome >= k) {
			
			++ans;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			k = in.nextInt();
			
			a = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}