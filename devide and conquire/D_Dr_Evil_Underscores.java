
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Dr_Evil_Underscores extends Thread {
		
    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	static int n;
	
	static int a[];
	
	static long solve(ArrayList<Integer> list, int bit) {
		
		if(bit < 0) {
			
			return 0;
			
		}
		
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		
		while(!list.isEmpty()) {
			
			int number = list.get(0);
			
			list.popFront();
			
			if(((number >> bit ) & 1) == 0 ) {
				
				left.add(number);
				
			} else {
				
				right.add(number);
				
			}
			
		}
		
		if(left.isEmpty() && !right.isEmpty()) {
			
			return solve(right, bit - 1);
			
		}
		
		if(right.isEmpty() && !left.isEmpty()) {
			
			return solve(left, bit - 1);
			
		}
		
		return Math.min(solve(left, bit - 1), solve(right, bit - 1) ) + (1 << bit);
		
	}
	
	static void solve() {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i : a) {
			
			list.add(i);
			
		}
		
		long ans = solve(list, 30);
		
		out.println(ans);
		out.flush();
		
	}
	
	public static void main(String [] priya) throws IOException {
		
		new Thread(null, new D_Dr_Evil_Underscores(), "MAIN", 2 << 28).start();
		
	} 
	
	public void run() {
		
		try {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		} catch(IOException e) {
			
			
		}
		
	}
	
    static int multiply(int x, int res[], int res_size) {

        int carry = 0;

        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;

            res[i] = prod % 10;

            carry = prod / 10;
        }

        while (carry > 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    static long power(int x, int n) {

        int MAX = 100000;

        if (n == 0) {

            return 1;
        }
        int res[] = new int[MAX];
        int res_size = 0;
        int temp = x;

        while (temp != 0) {
            res[res_size++] = temp % 10;
            temp = temp / 10;
        }

        for (int i = 2; i <= n; i++) {
            res_size = multiply(x, res, res_size);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = res_size - 1; i >= 0; i--) {
            sb.append(res[i]);
        }

        return Long.parseLong(sb.toString());

    }
	
    static class Node<T> {

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

    static class ArrayList<T> {

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

            int index = 0, i = 0;

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

            Node<T> temp = head;

            if (index == 0) {

                return temp.getData();

            }

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

        T popFront() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            T data = head.getData();

            if (head == tail) {

                head = null;
                tail = null;

            } else {

                head = head.getNext();

            }

            len--;

            return data;

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

    static class Scanner {

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

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        String nextLine() throws IOException {

            return in.readLine();

        }

        char nextChar() throws IOException {

            return next().charAt(0);

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        float nextFloat() throws IOException {

            return Float.parseFloat(next());

        }

        boolean nextBoolean() throws IOException {

            return Boolean.parseBoolean(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

}