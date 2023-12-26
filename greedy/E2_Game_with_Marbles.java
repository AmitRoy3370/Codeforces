import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class E2_Game_with_Marbles {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		List<Element> list = new ArrayList<>();
		
		for(int i = 0; i != n; ++i) {
			
			list.add(new Element(a[i] + b[i], i));
			
		}
		
		Collections.sort(list);
		
		int player = 0;
		
		for(int i = 0; i != n; ++i) {
			
			int index = list.get(i).index;
			
			if(player == 0) {
				
				a[index]--;
				b[index] = 0L;
				
			} else {
				
				a[index] = 0L;
				b[index]--;
				
			}
			
			player = 1 - player;
			
		}
		
		long score = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			score += a[i] - b[i];
			
		}
		
		System.out.println(score);
		
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
		b = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
	private static class Element implements Comparable<Element> {
		
		long summation;
		int index;
		
		public Element(long summation, int index) {
			
			this.summation = summation;
			this.index = index;
			
		}
		
		public int compareTo(Element e) {
			
			if(this.summation > e.summation) {
				
				return -1;
				
			} else if(e.summation > this.summation) {
				
				return 1;
				
			}
			
			return 0;
			
		}
	}
	
}