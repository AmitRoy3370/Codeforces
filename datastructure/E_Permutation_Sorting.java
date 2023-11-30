import java.util.Scanner;

public class E_Permutation_Sorting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		Element element = new Element(n);
		
		for(int i = 1; i <= n; ++i) {
			
			if(a[i] >= i) {
				
				element.add(a[i] + n);
				
			}
			
		}
		
		long ans[] = new long[n + 1];
		
		for(int i = n; i >= 1; --i) {
			
			int value = a[i] < i ? a[i] + n : a[i];
			
			ans[a[i]] = (a[i] - i + n) % n - element.query(value);
			
			element.add(value);
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		
		for(long i : ans) {
			
			if(index == 0) {
				
				++index;
				continue;
				
			}
			
			sb.append(i).append(" ");
			
			++index;
			
		}
		
		System.out.println(sb.toString().trim());
		
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
		
		a = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
	static class Element {
		
		long a[];
		
		int length;
		
		public Element(int n) {
			
			a = new long[2 * n + 1];
			
			length = 2 * n;
			
		}
		
		private void add(int x) {
			
			for(; x <= length; x += x & -x) {
				
				a[x]++;
				
			}
			
		}
		
		private long query(int x) {
			
			long sum = 0L;
			
			for(; x > 0; x -= x & -x) {
				
				sum += a[x];
				
			}
			
			return sum;
			
		}
		
	}
	
}