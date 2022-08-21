
import java.util.Scanner;

public class C_Fighting_Tournament {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, query, max_index = -1;

    static long a[], winners[], winners_end[];

    static long k;

    static ArrayList1<Long> list;

    static void solve(int ith_participant, long round) {

        if (ith_participant > max_index || round < winners[ith_participant] || round < ith_participant - 1) {

            System.out.println(0);
            return;

        }

        long strength = a[ith_participant - 1];

        //round = Math.min(round, n);
        if (ith_participant == max_index) {

            System.out.println(Math.max(0, round - winners[ith_participant] + 1));

        } else {

            System.out.println(Math.min(round - winners[ith_participant] + 1, winners_end[ith_participant] - winners[ith_participant]));

        }

        //int size = (int)round, count = 0;
        /*for(int i = 1; i <= size; ++i) {
			
			long first = list.get(0);
			long second = list.get(1);
			
			if(first > second) {
				
				if(first == strength) {
					
					++count;
					
				}
				
				list.removeAt(1);
				
				//list.see();
				
				list.add(second);
				
				//list.see();
				
			} else {
				
				if(second == strength) {
					
					++count;
					
				}
				
				list.removeAt(0);
				
				//list.see();
				
				list.add(first);
				
				//list.see();
				
			}
			
		}
		
		System.out.println(count);*/
        //list.see();
    }

    static void solve() {

        long max = a[0];

        /*int index = 0, j = 0;
		
		max_index = 0;
		
		for(long i : a) {
			
			list.add(i);
			
			if(i > max) {
				
				max = i;
				max_index = j;
				
			}
			
			++j;
			
		}*/
        //list.see();
        max = -1;

        max_index = 0;

        //winners[0] = max;
        //winners[1] = max;
        //winners_end[0] = winners[0];
        //winners_end[1] = winners_end[1];
        for (int i = 0; i < n; ++i) {

            if (a[i] > max) {

                max = a[i];

                winners_end[max_index] = i;

                max_index = i + 1;

                winners[max_index] = i;
                //winners_end[i] = i;

            }

        }

        winners_end[max_index] = n - 1;

        if (winners_end[1] >= 1) {

            winners[1] = 1;

        }

        //winners[n - 1] = winners[n - 2];
    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new long[n];

            list = new ArrayList1<>();

            winners = new long[n + 1];
            winners_end = new long[n + 1];

            query = in.nextInt();

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextLong();

            }

            solve();

            for (int i = 0; i < query; ++i) {

                int ith_participant = in.nextInt();

                long round = in.nextLong();

                /*list = new ArrayList1<>();
				
				for(long i1 : a) {
					
					list.add(i1);
					
				}*/
                solve(ith_participant, round);

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
3 1
3 1 2
1 2

 */

 /*

1
4 2
1 3 4 2
4 5
3 2

 */
