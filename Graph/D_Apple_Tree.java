import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class D_Apple_Tree {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, q;
	
	static List<Integer> list[];
	
	static int a[], b[], x[], y[];
	static long degree[];
	
	static void dfs(int root, boolean visited[], long degree[]) {
		
		visited[root] = true;
		
		for(int vertices : list[root]) {
			
			if(visited[vertices]) {
				
				continue;
				
			}
			
			dfs(vertices, visited, degree);
			
			degree[root] += degree[vertices];
			
		}
		
		//System.out.println("stuck at here");
		
		if(degree[root] == 0) {
			
			degree[root] = 1;
			
		}
		
	}
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < q; ++i) {
			
			long pair = degree[x[i]] * degree[y[i]];
			
			sb.append((pair)).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
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
		
		a = new int[n];
		b = new int[n];
		
		list = new ArrayList[n + 1];
		
		degree = new long[n + 1];
	
		for(int i = 0; i <= n; ++i) {
			
			list[i] = new ArrayList<>();
			//degree[i] = -1;
			
		}
		
		for(int i = 0; i < n - 1; ++i) {
			
			a[i] = in.nextInt() - 1;
			b[i] = in.nextInt() - 1;
			
			list[a[i]].add(b[i]);
			list[b[i]].add(a[i]);
			
		}
		
		boolean visited[] = new boolean[n + 1];
		
		visited[0] = true;
		
		dfs(0, visited, degree);
		
		//print(degree);
		
		q = in.nextInt();
		
		x = new int[q];
		y = new int[q];
		
		for(int i = 0; i < q; ++i) {
			
			x[i] = in.nextInt() - 1;
			y[i] = in.nextInt() - 1;
			
		}
		
	}
	
	private static void print(long degree[]) {
		
		for(long i : degree) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}