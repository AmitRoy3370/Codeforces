import java.util.Scanner;

public class G_Lexicographically_Minimal_Subsequence {

	static int testCases, n, k;

	static char a[];

	static Scanner in = new Scanner(System.in);

	static void solve() {

		StringBuilder ans = new StringBuilder();

		char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		ArrayList1<Character> list = new ArrayList1<>();

		for(int i = 0; i < n; ++i) {

			if(list.isEmpty()) {

				list.add(a[i]);

			} else {

				while(!list.isEmpty() && (list.get(0) - 'a') > (a[i] - 'a') && list.size() - 1 + n - i >= k) {

					list.popFront();

				}

				if(list.isEmpty() || list.size() < k) {

					list.inserFirst(a[i]);

				}

			}

		}

		while(!list.isEmpty()) {

			ans.append(list.get(0));

			list.popFront();

		}

		ans.reverse();

		System.out.println(ans.toString());

	}

	public static void main(String [] priya) {

		input();
		solve();

	}

	private static void input() {

		a = in.next().toCharArray();

		n = a.length;

		k = in.nextInt();

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