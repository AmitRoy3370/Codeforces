import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class C_Binary_String {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		List<Integer> list = new ArrayList<>(); 
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == '1') {
				
				list.add(i + 1);
				
			}
			
		}
		
		int one = list.size();
		
		int min = Math.min(one, n - one);
		
		for(int i = 1; i <= one; ++i) {
			
			int left = i, right = one;
			
			while(right >= left) {
				
				int mid = (left + right) / 2;
				
				int x = mid - i + 1;
				
				int y = list.get(mid - 1) - list.get(i - 1) + 1 - x;
				
				x = one - x;
				
				min = Math.min(min, Math.max(x, y));
				
				if(x >= y) {
					
					left = mid + 1;
					
				} else {
					
					right = mid - 1;
					
				}
				
			}
			
		}
		
		System.out.println(min);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.next().toCharArray();
			
			n = a.length;
			
			solve();
			
		}
		
	}
	
}