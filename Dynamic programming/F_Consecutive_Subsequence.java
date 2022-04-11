import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class F_Consecutive_Subsequence {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int n;
	
	private static long a[];
	
	private static Map<Long, Integer> dp;
	
	private static void solve() {
		
		for(long i : a) {
			
			dp.put(i , dp.getOrDefault(i - 1, 0) + 1 );
			
		}
		
		long last = -1, max = Long.MIN_VALUE;
		
		for(long i : dp.keySet() ) {
			
			if(max < dp.get(i)) {
				
				max = dp.get(i);
				last = i;
				
			}
			
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n; i >= 1; --i) {
			
			if(a[i] == last) {
				
				stack.push(i);
				
				--last;
				
			}
			
		}
		
		System.out.println((stack.size() == 0 ? 1 : stack.size()) );
		
		try {
		
		  stack.print();
		
		} catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.print(1);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		dp = new HashMap<>();
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	private static class Node<T> {
		
		T data;
		Node<T> next;
		
		public Node(T data) {
			
			this.data = data;
			this.next = null;
			
		}
		
	}
	
	private static class Stack<T> {
		
		Node<T> node;
		
		int len;
		
		public Stack() {
			
			node = null;
			len = 0;
			
		}
		
		int size() {
			
			return len;
			
		}
		
		boolean isEmpty() {
			
			return size() == 0;
			
		}
		
		void push(T data) {
			
			Node<T> newNode = new Node<>(data);
			
			newNode.next = node;
			
			node = newNode;
			
			++len;
			
		}
		
		void print() {
			
			if(isEmpty()) {
				
				throw new ArrayIndexOutOfBoundsException();
				
			}
			
			Node<T> temp = node;
			
			while(temp != null) {
				
				System.out.print(temp.data + " ");
				
				temp = temp.next;
				
			}
			
			System.out.println();
			
		}
		
	}
	
}