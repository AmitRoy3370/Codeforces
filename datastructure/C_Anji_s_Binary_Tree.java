import java.util.Scanner;

public class C_Anji_s_Binary_Tree {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[], b[];
	
	static char x[];
	
	static long solve(int root, Node node[]) {
		
		if(root == -1) {
			
			return Integer.MAX_VALUE;
			
		}
		
		if(node[root].left == -1 && node[root].right == -1) {
			
			return 0;
			
		}
		
		long L = solve(node[root].left, node);
		long R = solve(node[root].right, node);
		
		if(x[root] == 'L') {
			
			return Math.min(L, R + 1);
			
		} else if(x[root] == 'R') {
			
			return Math.min(L + 1, R);
			
		}
		
		return Math.min(L, R) + 1;
		
	}
	
	static void solve() {
		
		Node node[] = new Node[n];
		
		for(int i = 0; i < n; ++i) {
			
			node[i] = new Node(a[i] - 1, b[i] - 1);
			
		}
		
		long operations = solve(0, node);
		
		System.out.println(operations);
		
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
		
		x = in.next().toCharArray();
		
		a = new int[n];
		b = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			b[i] = in.nextInt();
			
		}
		
	}
	
	static class Node {
		
		int left, right;
		
		public Node(int left, int right) {
			
			this.left = left;
			this.right = right;
			
		}
		
	}
	
}