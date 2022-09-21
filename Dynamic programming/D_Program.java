
import java.util.Scanner;

public class D_Program {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, m, left_index, right_index;

    static char a[];

    static ArrayList1<Long> forward_left = new ArrayList1<>();
    static ArrayList1<Long> forward_right = new ArrayList1<>();
    static ArrayList1<Long> backward_left = new ArrayList1<>();
    static ArrayList1<Long> backward_right = new ArrayList1<>();

    static long positive_forward[], positive_backward[];
    static long negative_forward[], negative_backward[];
    static long left_max[];
    static long left_min[];

    static long right_max[];
    static long right_min[], sum[];

    static void solve() {

        left_max = new long[n + 1];
        left_min = new long[n + 1];

        right_max = new long[n + 2];
        right_min = new long[n + 2];

        sum = new long[n + 1];

        for (int i = 1; i <= n; ++i) {

            sum[i] = sum[i - 1] + (a[i - 1] == '+' ? 1L : -1L);

            left_min[i] = Math.min(left_min[i - 1], sum[i]);
            left_max[i] = Math.max(left_max[i - 1], sum[i]);

        }

        for (int i = n; i >= 1; --i) {

            if (a[i - 1] == '+') {

                right_max[i] = Math.max(0L, right_max[i + 1] + 1L);
                right_min[i] = Math.min(0L, right_min[i + 1] + 1L);

            } else {

                right_max[i] = Math.max(0L, right_max[i + 1] - 1L);
                right_min[i] = Math.min(0L, right_min[i + 1] - 1L);

            }

        }

    }

    static void solve(int t) {

        if (left_index == 1 && right_index == n) {

            System.out.println(1);
            return;

        }

        long max = Math.max(left_max[left_index - 1], sum[left_index - 1] + right_max[right_index + 1]);
        long min = Math.min(left_min[left_index - 1], sum[left_index - 1] + right_min[right_index + 1]);

        long ans = max - min + 1L;

        System.out.println(ans);

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            m = in.nextInt();

            a = in.next().toCharArray();

            solve();

            for (int i = 0; i < m; ++i) {

                left_index = in.nextInt();
                right_index = in.nextInt();

                solve(i + 1);

            }

        }

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

    static class ArrayList1<T> {

        Node<T> head, tail;

        int len;

        public ArrayList1() {

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

                System.out.print(temp.getData().toString() + " ");
                //out.flush();

                temp = temp.getNext();

            }

            System.out.println();
            //out.flush();

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

            if (index == 0) {

                return head.getData();

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

                //return;
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

/*

    1
    8 4
    -+--+--+
    1 8
    2 8
    2 5
    1 1

 */

 /*
    1
    4 10
    +-++
    1 1
    1 2
    2 2
    1 3
    2 3
    3 3
    1 4
    2 4
    3 4
    4 4

 */

 /*

    1
    4 1
    +-++
    2 3
    
 */
