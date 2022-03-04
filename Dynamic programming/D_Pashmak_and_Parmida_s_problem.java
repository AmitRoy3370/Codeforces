import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class D_Pashmak_and_Parmida_s_problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[], frequency[], fragment_tree[];
	
	static Map<Long, Integer> map = new HashMap<>();
	
	private static void solve() {
		
		frequency = new long[n];
		
		calculate_frequency(frequency);
		
		map = new HashMap<>();
		
		long ans = 0;
		
		for(int i = n - 1; i >= 0; --i) {
			
			ans += counting_element( (int)(frequency[i] - 1), 0 );
			map.put(a[i], map.getOrDefault(a[i], 0) + 1 );
			
			update(map.get(a[i]));
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new long[n];
		
		fragment_tree = new long[1000001];
		
		for(int i = 0; i < n ; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	private static void update(int index) {
		
		if(index > n ) {
			
			return;
			
		}
		
		++fragment_tree[index];
		
		update(index + (index & -index) );
		
	}
	
	private static long counting_element(int last_element_index, long ans) {
		
		if(last_element_index <= 0) {
			
			return ans;
			
		}
		
		ans += fragment_tree[last_element_index];
		
		return counting_element(last_element_index - (last_element_index & -last_element_index), ans );
		
	}
	
	private static void calculate_frequency(long frequency[]) {
		
		for(int i = 0; i < n; ++i) {
			
			map.put(a[i], map.getOrDefault(a[i], 0) + 1 );
			
			frequency[i] = map.get(a[i]);
			
		}
					
	}
	
}