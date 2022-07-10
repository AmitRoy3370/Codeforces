import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Uniqueness {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		int have_to_delete = 0, first_duplicate = -1;
		
		Map<Long, Integer> newMap = new HashMap<>();
		
		Map<Long, Integer> map = new HashMap<>();
		
		Map<Long, Integer> position = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			position.put(a[i], i);
			
		}
		
		if(position.size() == 1) {
			
			System.out.print(n - 1);
			return;
			
		}
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		int have_to_delete_back = 0;
		
		Map<Long, Integer> back = new HashMap<>();
		
		int first_duplicate1 = -1;
		
		for(int i = n - 1; i >= 0; --i) {
			
			back.put(a[i], back.getOrDefault(a[i], 0) + 1);
			
			if(back.get(a[i]) > 1) {
				
				first_duplicate1 = i;
				break;
				
			}
			
		}
		
		if(first_duplicate1 == -1) {
			
			System.out.print(0);
			return;
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			newMap.put(a[i], newMap.getOrDefault(a[i], 0) + 1);
			
			if(newMap.get(a[i]) > 1 && first_duplicate == -1) {
				
				first_duplicate = i;
				break;
				
			}
			
		}
		
		if(first_duplicate == -1) {
			
			System.out.print(0);
			return;
			
		}
		
		first_duplicate = Math.min(first_duplicate, first_duplicate1);
		
		newMap.put(a[first_duplicate], newMap.get(a[first_duplicate]) -1);
		map.put(a[first_duplicate], map.get(a[first_duplicate]) - 1);
		
		have_to_delete = 1;
		
		for(int i = first_duplicate + 1; i < n; ++i) {
			
			newMap.put(a[i], newMap.getOrDefault(a[i], 0) + 1);
			
			if(newMap.get(a[i]) > 1 || (map.get(a[i]) > 1 && position.get(a[i]) > i)) {
				
				newMap.put(a[i], newMap.get(a[i]) - 1);
				map.put(a[i], map.get(a[i]) - 1);
				
				have_to_delete = Math.max(i - first_duplicate + 1, have_to_delete);
				
				//++i;
				
			}
			
		}
		
		have_to_delete_back = 1;
		
		back.put(a[first_duplicate1], back.get(a[first_duplicate1]) - 1);
		
		for(int i = first_duplicate1 - 1; i >= 0; --i) {
			
			back.put(a[i], back.getOrDefault(a[i], 0) + 1);
			
			if(back.get(a[i]) > 1) {
				
				back.put(a[i], back.get(a[i]) - 1);
				have_to_delete_back = first_duplicate - i + 1;
				
			}
			
		}
		
		System.out.print(Math.min(have_to_delete, have_to_delete_back));
		
	}
	
	static void solve(int t) {
		
		Map<Long, Integer> map = new HashMap<>();
		
		int ans = n;
		
		for(int i = 0; i < n; ++i) {
			
			boolean valid = true;
			
			for(int j = 0; j < i; ++j) {
				
				if(map.containsKey(a[j])) {
					
					valid = false;
					break;
					
				}
				
				map.put(a[j], j);
				
			}
			
			int end = n;
			
			for(int j = n - 1; j >= i; --j) {
				
				if(map.containsKey(a[j])) {
					
					break;
					
				} else {
					
					end = j;
					
				}
				
				map.put(a[j], j);
				
			}
			
			if(valid) {
				
				ans = Math.min(ans, end - i);
				
			}
			
			map = new HashMap<>();
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve(1);
		
	}
	
}