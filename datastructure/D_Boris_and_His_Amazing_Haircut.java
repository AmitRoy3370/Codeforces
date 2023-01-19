import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class D_Boris_and_His_Amazing_Haircut {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[], b[], x[];
	
	/*
	
	eg1:
	
	6
	3 4 4 6 3 4 -> a
	-           
	3 1 2 3 2 3 -> b
	3
	3 2 3 -> x
	
	wanted count:
	
	1 := 1 (missing rajor)
	2 := 2 (ok)
	3 := 2 (ok)
	
	rajors count:
	
	3 := 6
	2 : 4
	
	so the ans is no.
	
	*/
	
	static void solve() {
		
		Map<Long, Long> rajor = new HashMap<>();
		
		Map<Long, Long> wanted = new HashMap<>();
		
		for(int i = 0; i < m; ++i) {
			
			if(rajor.containsKey(x[i])) {
				
				rajor.put(x[i], rajor.get(x[i]) + 1L);
				
			} else {
				
				rajor.put(x[i], 1L);
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == b[i]) {
				
				continue;
				
			}
			
			if(a[i] < b[i]) {
				
				System.out.println("NO");
				return;
				
			}
			
			if(wanted.containsKey(b[i])) {
				
				wanted.put(b[i], wanted.get(b[i]) + 1L);
				
			} else {
				
				wanted.put(b[i], 1L);
				
			}
			
		}
		
		/* //Map<Long, Integer> consiqutive = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			int count = 1, j = i;
			
			while(i < n && b[j] >= b[i]) {
				
				++count;
				
				++i;
				
			}
			
			if(count > 1 && wanted.containsKey(b[j])) {
				
				wanted.put(b[j], wanted.get(b[j]) - count + 1);
				
			}
			
		}
		
		//printMap(wanted);
		//printMap(rajor);
		
		for(long i : wanted.keySet()) {
			
			if(!rajor.containsKey(i)) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		for(long i : wanted.keySet()) {
			
			if(rajor.get(i) >= wanted.get(i)) {
				
				rajor.put(i, rajor.get(i) - wanted.get(i));
				
			} else {
				
				System.out.println("NO");
				return;
				
			}
			
		} */
		
		ArrayList1<Long> list = new ArrayList1<>();
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] < b[i]) {
				
				System.out.println("NO");
				return;
				
			}
			
			while(!list.isEmpty() && list.get(0) < b[i]) {
				
				list.popFront();
				
			}
			
			if((list.isEmpty() || ((!list.isEmpty() && list.get(0) != b[i]))) && (a[i] > b[i])) {
				
				list.inserFirst(b[i]);
				
				if(!rajor.containsKey(b[i])) {
					
					//System.out.println("here");
					
					if(a[i] == b[i]) {
						
						continue;
						
					}
					
					System.out.println("NO");
					return;
					
				}
				
				if(rajor.get(b[i]) <= 0L) {
					
					System.out.println("NO");
					return;
					
				}
				
				rajor.put(b[i], rajor.get(b[i]) - 1L);
				
			}
			
		}
		
		System.out.println("YES");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			b = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				b[i] = in.nextLong();
				
			}
			
			m = in.nextInt();
			
			x = new long[m];
			
			for(int i = 0; i < m; ++i) {
				
				x[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static void printMap(Map<Long, Long> map) {
		
		for(long i : map.keySet()) {
			
			System.out.println(i + " : " + map.get(i));
			
		}
		
		System.out.println();
		
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

            return len == 0 || head == null || tail == null;

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