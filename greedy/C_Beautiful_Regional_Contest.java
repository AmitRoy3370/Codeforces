import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Beautiful_Regional_Contest {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		for(long i : a) {
			
			map.put(i, map.getOrDefault(i, 0) + 1);
			
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		sort(a, 0, n - 1);
		
		for(int i = 0; i < n / 2; ++i) {
		    
		    swap(a, i, n - i - 1);
		    
		}
		
		Map<Long, Boolean> m = new HashMap<>();
		
		for(long i : a) {
			
			if(m.containsKey(i)) {
			    
			    continue;
			    
			}
			
			list.add(map.get(i));
			
			m.put(i, true);
			
			//System.out.print(i + " ");
			
		}
		
		//System.out.println();
		
		int counter[] = new int[list.size() + 1];
		
		int index = 0;
		
		while(!list.isEmpty()) {
			
			counter[index++] = list.get(0);
			
			list.popFront();
			
		}
		
		//printArray(counter);
		
		int gold = counter[0], silver = 0, bronze = 0;
		
		index = 1;
		
		int size = counter.length;
		
		//System.out.println("gold : " + gold);
		
		while(index < size && gold >= silver) {
			
			silver += counter[index];
			
			++index;
			
		}
		
		if(gold < silver) {
		
		  while(index < size && gold >= bronze) {
			
			 bronze += counter[index];
			
			 ++index;
			
		  }
		
		  while(index < size && gold + silver + bronze + counter[index] <= n / 2) {
			
			 bronze += counter[index];
			
			 ++index;
			
		  }
		
		  if(bronze > gold && gold + silver + bronze <= n / 2) {
			
			 System.out.println(gold + " " + silver + " " + bronze);
			 return;
			
		  }
		
		}
		
		System.out.println(0 + " " + 0 + " " + 0);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static void swap(long a[], int i, int j) {
		
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
		
    static void printArray(long a[]) {

        for (long i : a) {

            System.out.print(i + " ");

        }

        System.out.println();

    }
	
    static void printArray(int a[]) {

        for (int i : a) {

            System.out.print(i + " ");

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
    
    static void merge(long a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        long L[] = new long[n1];

        long R[] = new long[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

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

    static void sort(long a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

}