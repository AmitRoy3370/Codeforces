import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Matching_Arrays {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, x;
	
	static long a[], b[];
	
	static void solve() {
		
		List<Element> A = new ArrayList<>();
		List<Long> B = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			A.add(new Element(a[i], i));
			
		}
		
		for(long i : b) {
			
			B.add(i);
			
		}
		
		Collections.sort(A);
		Collections.sort(B);
		
		long ans[] = new long[n];
		
		for(int i = n - x, j = 0; i < n; ++i, ++j) {
			
			ans[A.get(i).index] = B.get(j);
			
		}
		
		for(int i = n - x - 1, j = n - 1; i >= 0; --i, --j) {
			
			ans[A.get(i).index] = B.get(j);
			
		}
		
		int valid = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] > ans[i]) {
				
				++valid;
				
			}
			
		}
		
		if(valid == x) {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("YES").append("\n");
			
			for(long i : ans) {
				
				sb.append(i).append(" ");
				
			}
			
			System.out.println(sb.toString().trim());
			
		} else {
			
			System.out.println("NO");
			
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
		x = in.nextInt();
		
		a = new long[n];
		b = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
	static class Element implements Comparable<Element> {
		
		long value;
		int index;
		
		public Element(long value, int index) {
			
			this.value = value;
			this.index = index;
			
		}
		
		public int compareTo(Element e) {
			
			if(this.value > e.value) {
				
				return 1;
				
			} else if(this.value < e.value) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}