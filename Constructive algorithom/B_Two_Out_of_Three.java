import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Two_Out_of_Three {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int action[] = new int[]{1, 2, 3};
		
		int m = action.length;
		
		boolean visited[] = new boolean[101];
		
		List<element> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			list.add(new element(a[i], i));
			
		}
		
		Collections.sort(list);
		
		int condition = 0;
		
		long b[] = new long[n];
		
		for(int i = 0, j = 0; i < n - 1; ++i) {
			
			if(condition < 2 && list.get(i).element == list.get(i + 1).element) {
				
				if(visited[(int)list.get(i).element]) {
					
					continue;
					
				}
				
				visited[(int)list.get(i).element] = true;
				
				if(action[j] == 1) {
					
					b[list.get(i).index] = 1L;
					b[list.get(i + 1).index] = 2L;
					
					++condition;
					
				} else if(action[j] == 2) {
					
					b[list.get(i).index] = 1L;
					b[list.get(i + 1).index] = 3L;
					
					++condition;
					
				} else {
					
					b[list.get(i).index] = 2L;
					b[list.get(i + 1).index] =  3L;
					
					++condition;
					
				}
				
				j = (j + 1) % m;
				
				++i;
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			if(b[i] != 0) {
				
				continue;
				
			}
			
			b[i] = 1L;
			
		}
		
		if(condition < 2) {
			
			System.out.println(-1);
			
		} else {
			
			print(b);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static class element implements Comparable<element> {
		
		long element;
		int index;
		
		public element(long element, int index) {
			
			this.element = element;
			this.index = index;
			
		}
		
		public int compareTo(element e) {
			
			if(this.element > e.element) {
				
				return 1;
				
			} else if(this.element == e.element) {
				
				return 0;
				
			}
			
			return -1;
			
		}
		
	}
	
	private static void print(long b[]) {
		
		for(long i : b) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}