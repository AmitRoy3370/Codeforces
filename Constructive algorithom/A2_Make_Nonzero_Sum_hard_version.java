import java.util.Scanner;

public class A2_Make_Nonzero_Sum_hard_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	// allison, fred, pedro, casimero, radrigej
	
	static int a[];
	
	/*
	
	6
	-1 1 1 1 1 1
	
		 i  ii iii iv	v	vi
	0	-1	0	1	2	3	4 = prefix sum
	
	* if the length of the range is even 
	  and the frequency of the +1
	  is equal then the summation of the 
	  segment is 0.
	
	*/
	
	static void solve() {
		
		if(n == 1 && a[0] == 1) {
			
			System.out.println(-1);
			return;
			
		}
		
		int sum = 0;
		
		for(int i : a) {
			
			sum += Math.abs(i);
			
		}
		
		if(sum % 2 == 1) {
			
			System.out.println(-1);
			return;
			
		}
		
		ArrayList1<String> list = new ArrayList1<>();
		
		for(int i = 0; i < n; ) {
			
			if(a[i] == 0) {
				
				list.add((i + 1) + " " + (i + 1));
				
				++i;
				
				continue;
				
			}
			
			int j = i + 1;
			
			for(; j < n && a[j] == 0; ++j) {
				
			}
			
			if(j >= n || i >= n) {
				
				break;
				
			}
			
			int diff = a[i] - a[j];
			int addition = a[i] + a[j];
			
			if((diff == 0 && (j - i) % 2 == 1) || (addition == 0 && (j - i) % 2 == 0)) {
				
				list.add((i + 1) + " " + (j + 1));
				
			} else {
				
				list.add((i + 1) + " " + (i + 1));
				list.add((i + 2) + " " + (j + 1));
				
			}
			
			i = j + 1;
			
			if(i >= n) {
				
				break;
				
			}
			
		}
		
		System.out.println(list.size());
		
		while(!list.isEmpty()) {
			
			System.out.println(list.get(0));
			
			list.popFront();
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
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