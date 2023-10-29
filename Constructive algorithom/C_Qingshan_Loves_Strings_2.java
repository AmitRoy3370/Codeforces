import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C_Qingshan_Loves_Strings_2 {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		if(n % 2 == 1) {
			
			System.out.println(-1);
			return;
			
		}
		
		int left_end = 0, right_end = n - 1;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(new String(x));
		
		int operations = 0;
		
		List<Integer> list = new ArrayList<>();
		
		while(operations < 300 && left_end < right_end) {
			
			if(x[left_end] == x[right_end]) {
				
				if(x[left_end] == '0') {
					
					sb.insert(right_end + 1, "01");
					x = sb.toString().trim().toCharArray();
					list.add(right_end + 1);
					right_end += 2;
					++operations;
					
				} else {
					
					sb.insert(left_end, "01");
					list.add(left_end);
					x = sb.toString().trim().toCharArray();
					right_end += 2;
					++operations;
					
				}
				
			}
			
			++left_end;
			--right_end;
			
		}
		
		if(left_end < right_end) {
			
			System.out.println(-1);
			
		}  else {
			
			StringBuilder ans = new StringBuilder();
			
			ans.append(list.size()).append("\n");
			
			for(int i : list) {
				
				ans.append(i).append(" ");
				
			}
			
			System.out.println(ans.toString());
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
}