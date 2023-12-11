import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class B_Collecting_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long ans[] = new long[n];
		
		List<Element> list = new ArrayList<>();
		
		for(int i = 0; i != n; ++i) {
			
			list.add(new Element(a[i], i));
			
		}
		
		Collections.sort(list);
		
		Stack<Integer> index = new Stack<>();
		
		long prefix[] = new long[n];
		
		prefix[0] = list.get(0).value;
		
		for(int i = 1; i != n; ++i) {
			
			prefix[i] = prefix[i - 1] + list.get(i).value;
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			index.push(list.get(i).index);
			
			if(i == n - 1 || prefix[i] < list.get(i + 1).value) {
				
				while(!index.isEmpty()) {
					
					ans[index.pop()] = i;
					
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : ans) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		} 
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static class Element implements Comparable<Element> {
		
		long value;
		int index;
		
		public Element(long value, int index) {
			
			this.value = value;
			this.index = index;
			
		}
		
		public int compareTo(Element e) {
			
			if(this.value > e.value) {
				
				return 1;
				
			} else if(this.value == e.value) {
				
				return 0;
				
			}
			
			return -1;
			
		}
		
	}
	
}