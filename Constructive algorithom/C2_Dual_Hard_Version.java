import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C2_Dual_Hard_Version {
	
    static Scanner in = new Scanner();
 
    static PrintWriter out = new PrintWriter(System.out);
 
	static int testCases, n;
	
	static int a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		int solid_positive = 0, solid_negative = 0;
		
		for(int i = 1; i <= n; ++i) {
			
			if(a[i] > 0) {
				
				++solid_positive;
				
			} else if(a[i] < 0){
				
				++solid_negative;
				
			}
			
		}
		
		ArrayList1<String> list = new ArrayList1<>();
		
		if(solid_positive == 0) {
			
			for(int i = a.length - 2; i > 0; --i) {
				
				list.add((i) + " " + (i + 1));
				
			}
			
		} else if(solid_negative == 0) {
			
			for(int i = 2; i < a.length; ++i) {
				
				list.add(i + " " + (i - 1));
				
			}
			
		} else {
			
			int max = 0, min = 0;
			int max_index = -1, min_index = -1;
			
			for(int i = 1; i <= n; ++i) {
				
				if(a[i] > max) {
					
					max = a[i];
					max_index = i;
					
				}
				
				if(a[i] < min) {
					
					min = a[i];
					min_index = i;
					
				}
				
			}
			
			if(min == max) {
				
				ans.append(0).append("\n");
				
				return;
				
			}
			
			int min_copy =  min;
			int max_copy = max;
			
			int s1 = 0, s2 = 0;
			
			while(min + max_copy > 0) {
				
				++s1;
				
				min *= 2;
				
			}
			
			while(max + min_copy < 0) {
				
				++s2;
				
				max *= 2;
				
			}
			
			if(s1 + solid_positive < s2 + solid_negative) {
				
				for(int i = 0; i < s1; ++i) {
					
					list.add(min_index + " " + min_index);
					
				}
				
				for(int i = 0; i < a.length; ++i) {
					
					if(a[i] > 0) {
						
						list.add(i + " " + min_index);
						
					}
					
				}
				
				for(int i = a.length - 2; i > 0; --i) {
					
					list.add(i + " " + (i + 1));
					
				}
				
			} else {
				
				for(int i = 0; i < s2; ++i) {
					
					list.add(max_index + " " + max_index);
					
				}
				
				for(int i = 0; i < a.length; ++i) {
					
					if(a[i] < 0) {
						
						list.add(i + " " + max_index);
						
					}
					
				}
				
				for(int i = 2; i < a.length; ++i) {
					
					list.add(i + " " + (i - 1));
					
				} 
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list.size()).append("\n");
		
		while(!list.isEmpty()) {
			
			String i = list.get(0);
			
			sb.append(i).append("\n");
			
			list.popFront();
			
		}
		
		ans.append(sb.toString());
		
	}
	
	public static void main(String [] priya) throws IOException {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		out.print(ans.toString());
		out.flush();
		
	}
	
	private static void input() throws IOException {
		
		n = in.nextInt();
		
		a = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextInt();
			
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
 
        String nextLine() throws IOException {
 
            return in.readLine();
 
        }
 
        int nextInt() throws IOException {
 
            return Integer.parseInt(next());
 
        }
 
        double nextDouble() throws IOException {
 
            return Double.parseDouble(next());
 
        }
 
        long nextLong() throws IOException {
 
            return Long.parseLong(next());
 
        }
 
        void close() throws IOException {
 
            in.close();
 
        }
 
    }
	
}