import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C_Cut_em_al {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, cut = 0;
	
	static List<Integer> list[];
	
	static int dfs(int src, int parent) {
		
		int partialDepth = 0;
		
		for(int i : list[src]) {
			
			if(i != parent) {
				
				partialDepth += dfs(i, src);
				
			}
			
		}
		
		cut +=  partialDepth % 2;
		
		return partialDepth + 1;
		
	}
	
	static void solve() {
		
		if(n % 2 == 1) {
			
			System.out.println("-1");
			return;
			
		}
		
		dfs(1, 0);
		
		System.out.println(--cut);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		list = new ArrayList[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			list[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < n - 1; ++i) {
			
			int u = in.nextInt();
			int v = in.nextInt();
			
			list[u].add(v);
			list[v].add(u);
			
		}
		
	}
	
}