import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Uniqueness {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int total_duplicates = 0;
		
	static long a[];
	
	static Map<Long, Integer> count = new HashMap<>();
	
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
		
		have_to_delete = 1;
		
		for(int i = first_duplicate + 1; i < n; ++i) {
			
			newMap.put(a[i], newMap.getOrDefault(a[i], 0) + 1);
			
			if(newMap.get(a[i]) > 1 || (map.get(a[i]) > 1 && position.get(a[i]) > i)) {
				
				newMap.put(a[i], newMap.get(a[i]) - 1);
				map.put(a[i], map.get(a[i]) - 1);
				
				have_to_delete = i - first_duplicate + 1;
				
				//++i;
				
			}
			
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
		
		have_to_delete_back = 1;
		
		back.put(a[first_duplicate1], back.get(a[first_duplicate1]) - 1);
		
		for(int i = first_duplicate1 - 1; i >= 0; --i) {
			
			back.put(a[i], back.getOrDefault(a[i], 0) + 1);
			
			if(back.get(a[i]) > 1) {
				
				back.put(a[i], back.get(a[i]) - 1);
				have_to_delete_back = first_duplicate1 - i + 1;
				
			}
			
		}
		
		map = new HashMap<>();
		
		int min = Math.min(first_duplicate, first_duplicate1);
		
		for(int i = 0; i <= min; ++i) {
			
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			
		}
		
		int have_to_delete_middle = 0;
		
		map.put(a[min], map.get(a[min]) - 1);
		
		have_to_delete_middle = 1;
		
		for(int i = min + 1; i < n; ++i) {
			
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			
			if(map.get(a[i]) > 1) {
				
				map.put(a[i], map.get(a[i]) - 1);
				
				have_to_delete_middle = Math.max(i - min + 1, have_to_delete_middle);
				
			}  
			
			if(position.get(a[i]) > i) {
				
				int pos = position.get(a[i]);
				
				if(pos - min + 1 > have_to_delete_middle) {
					
					have_to_delete_middle = pos - min + 1;
					i = pos;
					
				}
				
			}
			
		}
		
		have_to_delete_back = Math.min(have_to_delete_back, have_to_delete_middle);
		
		System.out.print(Math.min(have_to_delete, have_to_delete_back));
		
	}
	
	static void solve(int t) {
		
		for(long i : a) {
			
			count.put(i, 0);
			
		}
		
		int total_duplicates = 0;
		
		Counter counter = new Counter();
		
		for(long i : a) {
			
			total_duplicates = counter.count(i);
			
		}
		
		if(total_duplicates <= 1) {
			
			System.out.print(total_duplicates);
			return;
			
		}
		
		int L = n, R = n, current_duplicates = total_duplicates;
		
		int ans = n;
		
		for(;;) {
			
			if(current_duplicates > 0) {
				
				if(L == 0) {
					
					break;
					
				}
				
				current_duplicates = counter.uncount(a[--L]);
				continue;
				
			}
			
			if(ans > R - L) {
				
				ans = R - L;
				
				if(ans == total_duplicates) {
					
					break;
					
				}
				
			}
			
			current_duplicates = counter.count(a[--R]);
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve(1);
		
	}
	
	static class Counter {
		
		int count(long value) {
			
			count.put(value, count.getOrDefault(value, 0) + 1);
			
			if(count.get(value) > 1) {
				
				++total_duplicates;
				
			}
			
			return total_duplicates;
			
		}
		
		int uncount(long value) {
			
			if(count.get(value) > 1) {
				
				--total_duplicates;
				
			}
			
			count.put(value, count.getOrDefault(value, 0) - 1);
			
			return total_duplicates;
			
		}
		
	}
	
}
