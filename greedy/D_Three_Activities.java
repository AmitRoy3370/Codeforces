import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class D_Three_Activities {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[], c[];
	
	static void solve() {
		
		List<Element> A = new ArrayList<>();
		
		List<Element> B = new ArrayList<>();
		
		List<Element> C = new ArrayList<>();
		
		int visit[] = new int[3];
		
		for(int i = 0; i != n; ++i) {
			
			A.add(new Element(a[i], i));
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			B.add(new Element(b[i], i));
		
		}
		
		for(int i = 0; i != n; ++i) {
			
			C.add(new Element(c[i], i));
		
		}
		
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B, Collections.reverseOrder());
		Collections.sort(C, Collections.reverseOrder());
		
		if(A.get(0).index != B.get(0).index && A.get(0).index != C.get(0).index && B.get(0).index != C.get(0).index) {
			
			long max_score = A.get(0).element + B.get(0).element + C.get(0).element;
			
			System.out.println(max_score);
			
			return;
			
		}
		
		long score = 0L;
		
		Element a[] = new Element[]{A.get(0), A.get(1), A.get(2)};
		
		Element b[] = new Element[]{B.get(0), B.get(1), B.get(2)};
		
		Element c[] = new Element[]{C.get(0), C.get(1), C.get(2)};
		
		for(int i = 0; i != 3; ++i) {
			
			for(int j = 0; j != 3; ++j) {
				
				for(int k = 0; k != 3; ++k) {
					
					if(a[i].index != b[j].index && a[i].index != c[k].index && b[j].index != c[k].index) {
						
						score = Math.max(a[i].element + b[j].element + c[k].element, score);
						
					}
					
				}
				
			}
			
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
		c = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			c[i] = in.nextLong();
			
		}
		
	}
	
	private static class Element implements Comparable<Element> {
		
		long element;
		int index;
		
		public Element(long element, int index) {
			
			this.element = element;
			this.index = index;
			
		}
		
		public int compareTo(Element e) {
			
			if(this.element > e.element) {
				
				return 1;
				
			} else if(e.element > this.element) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}