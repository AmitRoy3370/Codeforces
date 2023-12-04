import java.util.Scanner;

public class E_Collapsing_Strings {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static String s[];
	
	static void solve() {
		
		long all_possible_way = 0L;
		
		Trie trie = new Trie();
		
		for(String i : s) {
			
			all_possible_way += i.length() * 2L * n;
			
			trie.add(i);
			
		}
		
		long deduction = 0L;
		
		for(String i : s) {
			
			char x[] = i.toCharArray();
			
			reverse(x);
			
			deduction += trie.query(x) * 2L;
			
		}
		
		long final_score = all_possible_way - deduction;
		
		System.out.print(final_score);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		s = new String[n];
		
		for(int i = 0; i != n; ++i) {
			
			s[i] = in.next();
			
		}
		
	}
	
	private static void reverse(char x[]) {
		
		int n = x.length;
		
		for(int i = 0; i < n / 2; ++i) {
			
			swap(x, i, n - i - 1);
			
		}
		
	}
	
	private static void swap(char x[], int i, int j) {
		
		char temp =  x[i];
		x[i] = x[j];
		x[j] = temp;
		
	}
	
	static class Trie {
		
		int N;
		int char_map[][];
		int char_space[];
		int count = 1;
		
		public Trie() {
			
			this.N = (int)(1e6 + 5);
			this.char_map = new int[26][N];
			this.char_space = new int[N];
			
		}
		
		private void add(String s) {
			
			int index = 0;
			
			for(int i = 0; i != s.length(); ++i) {
				
				if(char_map[s.charAt(i) - 'a'][index] == 0) {
					
					char_map[s.charAt(i) - 'a'][index] = count;
					index = count++;
					
				} else {
					
					index = char_map[s.charAt(i) - 'a'][index];
					
				}
				
				char_space[index]++;
				
			}
			
		}
		
		public long query(char x[]) {
			
			long sum = 0L;
			
			int index = 0;
			
			for(int i = 0; i != x.length; ++i) {
				
				if(char_map[x[i] - 'a'][index] == 0) {
					
					break;
					
				} else {
					
					index = char_map[x[i] - 'a'][index];
					
				}
				
				sum += char_space[index];
				
			}
			
			return sum;
			
		}
		
	}
	
}