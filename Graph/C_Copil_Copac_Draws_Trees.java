import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Copil_Copac_Draws_Trees {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static ArrayList1<Integer> list[];
	
	static Map<String, Integer> edge_position;
	
	static void solve() {
		
		ArrayList1<Integer> drawn_vertices = new ArrayList1<>();
		
		drawn_vertices.add(1);
		
		boolean visited_vertices[] = new boolean[n + 1];
		
		visited_vertices[1] = true;
		
		int vertices_indexes[] = new int[n + 1];
		
		vertices_indexes[1] = 0;
		
		int count[] = new int[n + 1];
		
		count[1] = 1;
		
		int total_iteration = 1;
		
		while(!drawn_vertices.isEmpty()) {
			
			int parent = drawn_vertices.get(0);
			
			while(!list[parent].isEmpty()) {
				
				int vertices = list[parent].get(0);
				
				if(visited_vertices[vertices]) {
					
					list[parent].popFront();
					continue;
					
				}
				
				visited_vertices[vertices] = true;
				
				if(edge_position.get(parent + "_" + vertices) > vertices_indexes[parent]) {
					
					count[vertices] = count[parent];
					
				} else {
					
					count[vertices] = count[parent] + 1;
					
				}
				
				total_iteration = Math.max(total_iteration, count[vertices]);
				
				vertices_indexes[vertices] = edge_position.get(parent + "_" + vertices);
				
				drawn_vertices.add(vertices);
				
				list[parent].popFront();
				
			}
			
			drawn_vertices.popFront();
			
		}
		
		System.out.println(total_iteration);
		
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
		
		list = new ArrayList1[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			list[i] = new ArrayList1<>();
			
		}
		
		edge_position = new HashMap<>();
		
		for(int i = 1; i < n; ++i) {
			
			int u = in.nextInt();
			
			int v = in.nextInt();
			
			list[u].add(v);
			list[v].add(u);
			
			edge_position.put(u + "_" + v, i);
			edge_position.put(v + "_" + u, i);
			
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