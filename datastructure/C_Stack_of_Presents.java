
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C_Stack_of_Presents {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n, m;

    static int a[], b[], inB[];

    static StringBuilder Ans = new StringBuilder();

    static void solve() {

        ArrayList<Integer> list = new ArrayList<>();

        long ans = 0;

        for (int i = 0; i <= n - 1; i++) {
            list.add(a[i]);
        }

        for (int i = 0; i < m; i++) {

            int search = b[i];

            int its_index = list.indexOf(search);

            if (its_index == 0) {

                ++ans;

                try {

                    list.popFront();

                } catch (Exception e) {

                }

                //System.out.println("at the " + i + "th state: ");
                //list.see();
            } else {

                int have = (its_index);

                ans += (2 * have) + 1;

                int index = its_index;

                //list.removeAt(list.indexOf(search));
                for (int j = index; j >= 0; j--) {

                    if (inB[list.get(j)] != 1) {

                        list.removeAt(j);

                    }

                }

                list.removeAt(list.indexOf(search));

                //System.out.println("at the " + i + "th state: ");
                //list.see();
            }

        }

        Ans.append(ans).append("\n");

    }

    static void solve(int testCases) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.put(a[i], i);

        }

        long ans = m;

        int lastIndex = -1;

        for (int i = 0; i < m; i++) {

            if (map.get(b[i]) != null && map.get(b[i]) > lastIndex) {

                ans += 2 * (map.get(b[i]) - i);

                lastIndex = map.get(b[i]);

            }

        }

        Ans.append(ans).append("\n");

    }

    public static void main(String[] amit) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();
            m = in.nextInt();

            a = new int[n];
            b = new int[m];
            inB = new int[((int) 1e5) + 1];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextInt();

            }

            for (int i = 0; i < m; i++) {

                b[i] = in.nextInt();
                inB[b[i]] = 1;

            }

            solve(t);

        }

        out.println(Ans.toString());
        out.flush();

        in.close();

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

    static class citation implements Comparable<citation> {

        long element;

        public citation(long element) {
            this.element = element;
        }

        @Override
        public int compareTo(citation t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            return Long.compare(this.element, t.element);

        }

    }

}
/*

2
3 3
3 1 2
3 2 1
7 2
2 1 7 3 4 5 6
3 1


 */

 /*

1
7 2
2 1 7 3 4 5 6
3 1

 */

 /*

1
3 3
3 1 2
3 2 1

 */

 /*

1
18 12
11 17 4 7 12 10 1 6 14 16 3 15 9 5 13 8 18 2
18 15 9 4 7 1 14 13 11 12 8 2

 */
