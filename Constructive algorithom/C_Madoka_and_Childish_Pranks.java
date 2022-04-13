
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_Madoka_and_Childish_Pranks {
	
	private static Scanner in = new Scanner();
		
    private static PrintWriter out = new PrintWriter(System.out);
	
	private static int testCases, n, m;
	
	private static char a[][];
	
	private static StringBuilder ans = new StringBuilder(); 
	
	private static void solve() {
		
		if(a[1][1] - '0' == 1) {
			
			ans.append(-1).append("\n");
			
			return;
			
		}
		
		ArrayList<Position> list = new ArrayList<>();
		
		//ans = new StringBuilder();
		
		for(int j = m; j >= 1; --j) {
			
			for(int i = n; i >= 1; --i) {
				
				if(a[i][j] - '0' == 1) {
					
					if(i != 1) {
						
						list.add(new Position(i - 1, j, i, j ) );
						
					} else {
						
						list.add(new Position(i, j - 1, i, j));
						
					}
					
				}
				
			}
			
		}
		
		ans.append(list.size()).append("\n");
		
		while(!list.isEmpty()) {
			
			ans.append(list.get(0).toString()).append("\n");
			
			list.popFront();
			
		}
		
	}
	
	public static void main(String [] amit) throws IOException {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			a = new char[n + 1][m + 1];
			
			for(int i = 0; i <= n; ++i) {
			
			  for(int j = 0; j <= m; ++j) {
				
				a[i][j] = '0';
				
			  }
			
		    }
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = (" " + in.next()).toCharArray();
				
			}
			
			solve();
			
		}
		
		out.print(ans.toString());
		out.flush();
		
		in.close();
		
	}
	
    private static class Scanner {

        BufferedReader in;
        StringTokenizer st;

        public Scanner() {

            in = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() throws IOException {

            while (st == null || !st.hasMoreElements()) {

                st = new StringTokenizer(in.readLine());

            }

            return st.nextToken();

        }

        String nextLine() throws IOException {

            return in.readLine();

        }

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        void close() throws IOException {

            in.close();

        }

    }
	
	private static class Position {
		
		int x1, y1, x2, y2;
		
		public Position(int x1, int y1, int x2, int y2) {
			
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			
		}
		
		public String toString() {
			
			return this.x1 + " " + this.y1 + " " + this.x2 + " " + this.y2;
			
		}
		
	}
	
    private static class Node<T> {

        T data;

        Node<T> next;

        public Node() {

            this.next = null;

        }

        public Node(T data) {

            this.data = data;

            this.next = null;

        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {

            return this.getData().toString() + "  ";

        }

    }

    private static class ArrayList<T> {

        Node<T> head, tail;

        int len;

        public ArrayList() {

            this.head = null;

            this.tail = null;

            this.len = 0;

        }

        int size() {

            return len;

        }

        boolean isEmpty() {

            return len == 0;

        }

        int indexOf(T data) {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            Node<T> temp = head;

            int index = -1, i = 0;

            while (temp != null) {

                if (temp.getData() == data) {

                    index = i;

                }

                i++;

                temp = temp.getNext();

            }

            return index;

        }

        void add(T data) {

            Node<T> newNode = new Node<>(data);

            if (isEmpty()) {

                head = newNode;

                tail = newNode;

                len++;

            } else {

                tail.setNext(newNode);

                tail = newNode;

                len++;

            }

        }

        void see() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            Node<T> temp = head;

            while (temp != null) {

                out.print(temp.getData().toString() + " ");
                out.flush();

                temp = temp.getNext();

            }

            out.println();
            out.flush();

        }

        void inserFirst(T data) {

            Node<T> newNode = new Node<>(data);

            Node<T> temp = head;

            if (isEmpty()) {

                head = newNode;
                tail = newNode;

                len++;

            } else {

                newNode.setNext(temp);

                head = newNode;

                len++;

            }

        }

        T get(int index) {

            if (isEmpty() || index >= len) {

                throw new ArrayIndexOutOfBoundsException();

            }
			
			if(index == 0) {
				
				return head.data;
				
			}

            Node<T> temp = head;

            int i = 0;

            T data = null;

            while (temp != null) {

                if (i == index) {

                    data = temp.getData();

                }

                i++;

                temp = temp.getNext();

            }

            return data;

        }

        void addAt(T data, int index) {

            if (index >= len) {

                throw new ArrayIndexOutOfBoundsException();

            }

            Node<T> newNode = new Node<>(data);

            int i = 0;

            Node<T> temp = head;

            while (temp.next != null) {

                if (i == index) {

                    newNode.setNext(temp.next);

                    temp.next = newNode;

                }

                i++;

                temp = temp.getNext();

            }

            //    temp.setNext(temp);
            len++;

        }

        void popFront() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            if (head == tail) {

                head = null;
                tail = null;

            } else {

                head = head.getNext();

            }

            len--;

        }

        void removeAt(int index) {

            if (index >= len) {

                throw new ArrayIndexOutOfBoundsException();

            }

            if (index == 0) {

                this.popFront();

                return;

            }

            Node<T> temp = head;

            int i = 0;

            Node<T> n = new Node<>();

            while (temp != null) {

                if (i == index) {

                    n.next = temp.next;

                    temp.next = n;

                    break;

                }

                i++;

                n = temp;

                temp = temp.getNext();

            }

            tail = n;

            --len;

        }

        void clearAll() {

            this.head = null;
            this.tail = null;

        }

    }

}