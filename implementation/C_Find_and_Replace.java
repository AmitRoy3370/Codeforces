import java.util.Scanner;

public class C_Find_and_Replace {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		int one_way[] = new int[n];
		int another_way[] = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			if(i % 2 == 0) {
				
				one_way[i] = 2;
				another_way[i] = 1;
				
			} else {
				
				one_way[i] = 1;
				another_way[i] = 2;
				
			}
			
		}
		
		//print(one_way);
		//print(another_way);
		
		int chars[] = new int[26];
		
		boolean ok_one = true, ok_another = true;
		
		for(int i = 0; i < n; ++i) {
			
			if(chars[(a[i] - 'a')] == 0) {
				
				chars[(a[i] - 'a')] = one_way[i];
				
			} else {
				
				if(one_way[i] != chars[(a[i] - 'a')]) {
					
					ok_one = false;
					break;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < 26; ++i) {
			
			chars[i] = 0;
			
		}
 		
		for(int i = 0; i < n; ++i) {
			
			if(chars[(a[i] - 'a')] == 0) {
				
				chars[(a[i] - 'a')] = another_way[i];
				
			} else {
				
				if(chars[(a[i] - 'a')] != another_way[i]) {
					
					ok_another = false;
					break;
					
				}
				
			}
			
		}
		
		//System.out.println(ok_one + " " + ok_another);
		
		if(ok_one || ok_another) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
	static void print(int a[]) {
		
		for(int i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}