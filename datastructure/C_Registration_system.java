import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class C_Registration_system {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static String s[];
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		Ternery ternery = new Ternery();
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String i : s) {
			
			if(!ternery.search(i)) {
				
				ternery.add(i);
				
				sb.append("OK").append("\n");
				
			} else {
				
				//System.out.println("here");
				
				//ternery.add(i + "" + map.get(i));
				sb.append(i).append(map.get(i)).append("\n");
				
			}
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		System.out.print(sb.toString());
		
		//ternery.print();
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		s = new String[n];
		
		for(int i = 0; i < n; ++i) {
			
			s[i] = in.next();
			
		}
		
	}
	
	private static class Node {
		
		final char data;
		
		Node left, right, middle;
		
		boolean endCharacter = false;
		
		public Node(char data) {
			
			this.data = data;
			
		}
		
	}
	
	private static class Ternery {
		
		Node root;
		
		public void add(String word) {
			
			root = add(root, word.toCharArray(), 0);
			
			//System.out.println( (root == null) ) ;
			
		}
		
		private Node add(Node node, char s[], int index) {
			
			if(node == null) {
				
				node = new Node(s[index]);
				
			}
			
			if(s[index] > node.data) {
				
				node.right = add(node.right, s, index);
				
			} else if(s[index] < node.data) {
				
				node.left = add(node.left, s, index);
				
			} else if(index < s.length - 1) {
				
				node.middle = add(node.middle, s, index + 1);
				
			} else if(index == s.length - 1) {
				
				node.endCharacter = true;
				
			}
			
			return node;
			
		}
		
		public boolean search(String word) {
			
			if(root == null) {
				
				return false;
				
			}
			
			Node node = search(root, word.toCharArray(), 0);
			
			return node != null && node.endCharacter;
			
		}
		
		private Node search(Node node, char s[], int index) {
			
			if(node == null) {
				
				return null;
				
			}
			
			if(s[index] > node.data) {
				
				return search(node.right, s, index);
				
			} else if(s[index] < node.data) {
				
				return search(node.left, s, index);
				
			} else if(index < s.length - 1) {
				
				return search(node.middle, s, index + 1);
				
			} else if(index == s.length - 1) {
				
				return node;
				
			}
			
			return node;
			
		}
		
		private void print() {
			
			if(root == null) {
				
				return;
				
			}
			
			List<String> list = new ArrayList<>();
			
			print(root, "", list);
			
			for(String i : list) {
				
				System.out.print(i + " ");
				
			}
			
			System.out.println();
			
		}
		
		private void print(Node node, String s, List<String> list) {
			
			if(node == null) {
				
				return;
				
			}
			
			print(node.left, s, list);
			
			s += node.data;
			
			if(node.endCharacter) {
				
				list.add(s);
				
			}
			
			print(node.middle, s, list);
			
			s = s.substring(0, s.length() - 1);
			
			print(node.right, s, list);
			
		}
		
	}
	
}