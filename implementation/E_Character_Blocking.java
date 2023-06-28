import java.util.Scanner;

public class E_Character_Blocking {
	
	static int testCases, n, time, query;
	
	static char x[], y[];
	
	static Scanner in = new Scanner(System.in);
	
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		int dismatched = 0;
		
		char [][]a = new char[2][n];
		
		a[0] = x;
		a[1] = y;
		
		int timer = 0;
		
		int time_count[] = new int[query + time + 100];
		
		for(int i = 0; i < n; ++i) {
			
			dismatched += not_equal(a, i);
			
		}
		
		for(int i = 0; i < query; ++i) {
			
			int operation = in.nextInt();
			
			if(operation == 1) {
				
				int blocked_index = in.nextInt() - 1;
				
				dismatched -= not_equal(a, blocked_index);
				
				time_count[timer + time] += not_equal(a, blocked_index);
				
			} else if(operation == 2) {
				
				int number_of_string = in.nextInt();
				
				int swap1 = in.nextInt() - 1;
				
				int number_of_second_string = in.nextInt();
				
				int swap2 = in.nextInt() - 1;
				
				int previous_dismatched = not_equal(a, swap1) + not_equal(a, swap2);
				
				swap(a[number_of_string - 1], a[number_of_second_string - 1], swap1, swap2);
				
				int present_dismatched = not_equal(a, swap1) + not_equal(a, swap2);
				
				dismatched -= (previous_dismatched - present_dismatched);
				
			} else {
				
				if(dismatched <= 0) {
					
					sb.append("YES").append("\n");
					
				} else {
					
					sb.append("NO").append("\n");
					
				}
				
			}
			
			++timer;
			
			dismatched += time_count[timer];
			
		}
		
		//print(time_count);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		y = in.next().toCharArray();
		
		n = x.length;
		
		time = in.nextInt();
		
		query = in.nextInt();
		
	}
	
	static void print(int time_count[]) {
		
		for(int i = 1; i <= 10; ++i) {
			
			System.out.print(time_count[i] + " ");
			
		}
		
		System.out.println();
		
	}
	
	static int not_equal(char a[][], int i) {
		
		return a[0][i] != a[1][i] ? 1 : 0;
		
	}
	
	static void swap(char []a, char b[], int i, int j) {
		
		char temp = a[i];
		a[i] = b[j];
		b[j] = temp;
		
	}
	
}