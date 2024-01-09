import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C_Where_is_the_Pizza {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[], b[], c[];
	
	static void solve() {
		
		List<Integer> list[] = new ArrayList[n + 1];
		
		for(int i = 0; i != n + 1; ++i) {
			
			list[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			list[a[i]].add(b[i]);
			list[b[i]].add(a[i]);
			
		}
		
		boolean visited[] = new boolean[n + 1];
		
		for(int i = 0; i < n; ++i) {
			
			if(visited[c[i]] || c[i] == 0) {
				
				continue;
				
			}
			
			int root = c[i];
			
			dfs(visited, list, root);
			
		}
		
		long way = 0L;
		
		long mod = (long)(1e9 + 7);
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == b[i] || visited[b[i]]) {
				
				continue;
				
			}
			
			dfs(visited, list, b[i]);
			
			++way;
			
		}
		
		way = power(2L, way, mod);
		
		System.out.println(way);
		
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
		
		a = new int[n];
		b = new int[n];
		c = new int[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = in.nextInt();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			c[i] = in.nextInt();
			
		}
		
	}
	
	private static void dfs(boolean visited[], List<Integer> list[], int root) {
		
		visited[root] = true;
		
		for(int i : list[root]) {
			
			if(!visited[i]) {
				
				dfs(visited, list, i);
				
			}
			
		}
		
	}
	
	static long power(long x, long y, long p) 
   { 
    
    long res = 1; 
 
    x = x % p; 
  
    if (x == 0L) return 0L; 
 
    while (y > 0L) 
    { 
      
        if ((y & 1L) > 0L) 
            res = (res*x) % p; 
        y = y>>1;
        x = (x*x) % p; 
    } 
    
    return res; 
   
   } 

}