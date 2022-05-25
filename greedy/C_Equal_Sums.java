import java.util.Scanner;

public class C_Equal_Sums {
	
	static Scanner in = new Scanner(System.in);
	
	static int k, n;
	
	static long a[];
	
	static void solve(ArrayList<Element> list) {
		
		Element element[] = new Element[list.size()];
		
		int size = list.size();
		
		int index = 0;
		
		while(!list.isEmpty()) {
			
			element[index++] = list.get(0);
			
			list.popFront();
			
		}
		
		sort(element, 0, size - 1);
		
		for(int i = 0; i < size - 1; ++i) {
			
			if(element[i].data_after_remove == element[i + 1].data_after_remove && element[i].i != element[i + 1].i) {
				
				System.out.println("YES");
				
				System.out.println(element[i].toString());
				System.out.println(element[i + 1].toString());
				
				return;
				
			}
			
		}
		
		System.out.println("NO");
		
	}
	
	public static void main(String [] amit) {
		
		k = in.nextInt();
		
		ArrayList<Element> list = new ArrayList<>();
		
		for(int t = 0; t < k; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			long sum = sum(a);
			
			for(int i = 0; i < n; ++i) {
				
				list.add(new Element(sum - a[i], t + 1, i + 1));
				
			}
			
		}
		
		solve(list);
		
	}
	
	static long sum(long a[]) {
		
		long sum = 0;
		
		for(long i : a) {
			
			sum += i;
			
		}
		
		return sum;
		
	}
	
	static class Element {
		
		long data_after_remove;
		int i, j;
		
		public Element(Long data_after_remove, int i, int j) {
			
			this.data_after_remove = data_after_remove;
			this.i = i;
			this.j = j;
			
		}
		
		public String toString() {
			
			return this.i + " " + this.j;
			
		}
		
	}
	
	static int comparator(Element a, Element b) {
		
		return Long.compare(a.data_after_remove, b.data_after_remove);
		
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
    
    static void merge(Element a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        Element L[] = new Element[n1];

        Element R[] = new Element[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (comparator(L[i], R[j]) == -1 || comparator(L[i], R[j]) == -1/*L[i] <= R[j]*/) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(Element a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

}