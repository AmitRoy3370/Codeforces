import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class C_Dijkstra {
	
	static Scanner in = new Scanner(System.in);
	
	static int nodes, edges;
	
	static List<Nodes> list[];
	
	static void solve() {
		
		//print();
		
		/*for(Nodes n : list[3]) {
			
			System.out.println(n.v + " " + n.w);
			
		}*/
		
		long distance[] = new long[nodes + 1];
		
		for(int i = 0; i <= nodes; ++i) {
			
			distance[i] = Long.MAX_VALUE;
			
		}
		
		distance[1] = 0L;
		
		PriorityQueue<Nodes> pq = new PriorityQueue<>();
		
		pq.add(new Nodes(1, 0));
		
		int node_path[] = new int[nodes + 1];
		
		for(int i = 0; i <= nodes; ++i) {
			
			node_path[i] = -1;
			
		}
		
		while(!pq.isEmpty()) {
			
			int source = pq.poll().v;
			
			/*if(i == 3) {
				
				System.out.print(i + " -> " );
				
			}*/
			
			for(Nodes nodes_ : list[source]) {
				
				//pq.add(nodes_.v);
				
				/*if(i == 3) {
					
					System.out.println(nodes_.v + " " + distance[nodes_.v] + " " + (distance[i] + nodes_.w) );
					 
				}*/
				
				if(distance[nodes_.v] > distance[source] + nodes_.w) {
					
					/*if(i == 3) {
					
					   System.out.print(nodes_.v + " ");
					
					}*/
					
					pq.add(new Nodes(nodes_.v, distance[source] + nodes_.w) );
					
					node_path[nodes_.v] = source;
					distance[nodes_.v] = distance[source] + nodes_.w;
					
					//System.out.println(distance[nodes_.v] + " " + i);
					
				}
				
			}
			
			/*if(i == 3) {
				
				System.out.println();
				
			}*/
			
		}
		
		if(distance[nodes] == Long.MAX_VALUE || node_path[nodes] == -1) {
			
			System.out.println(-1);
			return;
			
		}
		
		//print(distance);
		
		List<Integer> path = new ArrayList<>();
		
		path.add(nodes);
		
		int source = nodes;
		
		while(source != 1) {
			
			source = node_path[source];
			
			if(source == -1) {
				
				break;
				
			}
			
			path.add(source);
			
		}
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = path.size() - 1; i >= 0; --i) {
			
			ans.append(path.get(i)).append(" ");
		
		}
		
		System.out.print(ans.toString());
		
	}
	
	public static void main(String []priya) {
		
		input();
		solve();
		
	} 
	
	private static void input() {
		
		nodes = in.nextInt();
		edges = in.nextInt();
		
		list = new ArrayList[nodes + 1];
		
		for(int i = 0; i <= nodes; ++i) {
			
			list[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < edges; ++i) {
			
			int u = in.nextInt();
			int v = in.nextInt();
			int w = in.nextInt();
			
			list[u].add(new Nodes(v, w));
			list[v].add(new Nodes(u, w));
			
		}
		
	}
	
	static class Nodes implements Comparable<Nodes> {
		
		int v;
		long w;
		
		public Nodes(int v, long w) {
			
			this.v = v;
			this.w = w;
			
		}
		
		public int compareTo(Nodes n) {
			
			if(this.w > n.w) {
				
				return 1;
				
			} else if(this.w < n.w) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
	private static void print(long a[]) {
		
		for(int i = 1; i < a.length; ++i) {
			
			System.out.print(a[i] + " ");
			
		}
		
		System.out.println();
		
	}
	
	private static void print() {
		
		for(int i = 1; i <= nodes; ++i) {
			
			for(Nodes node : list[i]) {
				
				System.out.println(i + " " + node.v + " " + node.w);
				
			}
			
		}
		
	}
	
    static class OutputWriter {
 
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }
 
        public void println(Object... objects) {
            print(objects);
            writer.println();
        }
 
        public void println() {
            writer.println();
        }
 
        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }
 
        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }
 
        public void close() {
            writer.close();
        }
 
        public void flush() {
            writer.flush();
        }
 
    }
 
    static class Scanner {
 
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public Scanner(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
 
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }
 
        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }
 
        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }
 
        public String nextLine() {
            return readLine();
        }
 
        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }
 
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }
 
        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }
 
        public SpaceCharFilter getFilter() {
            return filter;
        }
 
        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }
 
        public interface SpaceCharFilter {
 
            public boolean isSpaceChar(int ch);
        }
 
        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextInt();
            }
            return array;
        }
 
        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + nextInt();
            }
            return array;
        }
 
        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextLong();
            }
            return array;
        }
 
        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + nextInt();
            }
            return array;
        }
 
    }
    
}