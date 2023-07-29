import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Great_Sequence {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static long x;
	
	static long a[];
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		//print(a);
		
		int number_add = 0;
		
		Map<Long, ArrayList1<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			if(!map.containsKey(a[i])) {
				
				ArrayList1<Integer> list = new ArrayList1<>();
				
				list.add(i);
				
				map.put(a[i], list);
				
			} else {
				
				map.get(a[i]).add(i);
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			if(map.get(a[i]).size() == 0) {
				
				continue;
				
			}
			
			long need = a[i] * x;
			
			map.get(a[i]).popFront();
			
			if(map.containsKey(need) && map.get(need).size() != 0) {
				
				map.get(need).popFront();
				
			} else {
				
				++number_add;
				
			}
			
		}
		
		System.out.println(number_add);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static boolean present(long a[], int l, int r, long need, boolean visited[]) {
		
		while(r >= l) {
			
			int mid = (l + r) / 2;
			
			if(a[mid] == need && !visited[mid]) {
				
				visited[mid] = true;
				
				return true;
				
			} else if(a[mid] >= need) {
				
				r = mid - 1;
				
			} else {
				
				l = mid + 1;
				
			}
			
		}
		
		return false;
		
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
	
	static void print(long a[]) {
		
		for(long i : a) {
			
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