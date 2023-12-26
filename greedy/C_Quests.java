import java.util.Scanner;

public class C_Quests {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[], b[];
	
	static void solve() {
		
		long experience = 0L;
		
		long sum = 0L, max = b[0];
		
		for(int i = 0; i != Math.min(n, k); ++i) {
			
			sum += a[i];
			
			max = Math.max(max, b[i]);
			
			experience = Math.max(experience, sum + max * (k - i - 1));
			
		}
		
		System.out.println(experience);
		
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
		k = in.nextInt();
		
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
		
		long element;
		
		public Element(long element) {
			
			this.element = element;
			
		}
		
		public int compareTo(Element e) {
			
			if(this.element > e.element) {
				
				return -1;
				
			} else if(this.element < e.element) {
				
				return 1;
				
			}
			
			return 0;
			
		}
		
	}
	
}