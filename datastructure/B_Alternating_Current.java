
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_Alternating_Current {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static char sequence[];

    static int n;

    public static void main(String[] amit) throws IOException {

        sequence = in.next().toCharArray();

        n = sequence.length;

        if(n==1){

            out.println("NO");
            out.flush();
            return;

        }
            
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            try {

                if (stack.top() == sequence[i]) {

                    stack.pop();

                } else {

                    stack.push(sequence[i]);

                }

            } catch (ArrayIndexOutOfBoundsException e) {

                stack.push(sequence[i]);

            }

        }

        if (stack.size() > 0) {

            out.println("NO");
            out.flush();

        } else {

            out.println("YES");
            out.flush();

        }

    }

    static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data) {

            this.data = data;
            this.next = null;

        }

    }

    static class Stack<T> {

        Node<T> node;

        int len;

        public Stack() {

            this.node = null;
            this.len = 0;

        }

        void push(T data) {

            Node<T> next = new Node<>(data);

            next.next = node;

            node = next;

            ++len;

        }

        int size() {

            return len;

        }

        boolean isEmpty() {

            return this.size() == 0;

        }

        T top() throws ArrayIndexOutOfBoundsException {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            return this.node.data;

        }

        T pop() throws ArrayIndexOutOfBoundsException {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            T top = node.data;

            this.node = node.next;

            --len;

            return top;

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
