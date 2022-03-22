import java.util.Scanner;

public class C_Bracket_Sequence_Deletion {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, len;
	
	static char a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		Stack<Character> stack = new Stack<>();
		
		stack.push(a[0]);
		
		int count = 0, j = 0;
		
		for(int i = 1; i < n; ++i) {
			
			if(!stack.isEmpty()) {
				
				if(stack.top() == '(' && a[i] == ')') {
					
					stack.pop();
					
				} else {
					
					stack.push(a[i]);
					
				}
				
				if(stack.isEmpty()) {
					
					++count;
					
					j = i + 1;
					
				}
				
			} else {
				
				stack.push(a[i]);
				
			}
			
			if(j < n && a[i] == a[j] && i > j) {
				
				j = i + 1;
				
				while(!stack.isEmpty()) {
					
					stack.pop();
					
				}
				
				++count;
				
			}
			
		}
		
        if(!stack.isEmpty()) {
			
			ans.append(count).append(" ").append(n - j).append("\n");
			
		} else {
			
			ans.append(count).append(" ").append(0).append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.next().toCharArray();
			
            len = a.length;			
			
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
    static class Node1<T> {

        T data;

        Node1 next;

        public Node1(T data) {
            this.data = data;

            this.next = null;

        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node1 getNext() {
            return next;
        }

        public void setNext(Node1 next) {
            this.next = next;
        }

    }

    static class Stack<T> {

        int len;

        Node1<T> node;

        public Stack() {

            len = 0;

            node = null;

        }

        boolean isEmpty() {

            return len == 0;

        }

        int size() {

            return len;

        }

        void push(T data) {

            Node1<T> temp = new Node1<>(data);

            temp.setNext(this.node);

            node = temp;

            len++;

        }

        T top() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            return this.node.getData();

        }

        T pop() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            T data = this.node.getData();

            this.node = this.node.getNext();

            len--;

            return data;

        }

    }

}