import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class B_Coach {

	static Scanner in = new Scanner(System.in);

	static int n, m;

	static int a[], b[];

	static StringBuilder ans = new StringBuilder();

	static List<Integer> list[];

	static List<Integer> dfs(int source, boolean visited[], List<Integer> list_) {

		visited[source] = true;

		list_.add(source);

		for(int i : list[source]) {

			if(visited[i]) {

				continue;

			}

			return dfs(i, visited, list_);

		}

		return list_;

	}

	static int dfs(int source, boolean visited[], int connected_component) {

		visited[source] = true;

		//ans.append(source).append(" ");

		++connected_component;

		for(int i : list[source]) {

			if(visited[i]) {

				continue;

			}

			return dfs(i, visited, connected_component);

		}

		return connected_component;

	}

	static void solve() {

		// have to count the connected component in the graph

		list = new ArrayList[n + 1];

		boolean missing[] = new boolean[n + 1];

		for(int i = 0; i < m; ++i) {

			missing[a[i]] = true;
			missing[b[i]] = true;

		}

		List<Integer> miss_collections = new ArrayList<>();

		int miss = 0;

		for(int i = 1; i <= n; ++i) {

			if(!missing[i]) {

				miss++;
				miss_collections.add(i);

			}

		}

		if(miss == n) {

			for(int i = 1; i <= n; i += 3) {

				ans.append(i).append(" ").append((i + 1)).append(" ").append(i + 2).append("\n");

			}

			return;

		}

		for(int i = 0; i <= n; ++i) {

			list[i] = new ArrayList<>();

		}

		for(int i = 0; i < m; ++i) {

			list[a[i]].add(b[i]);
			list[b[i]].add(a[i]);

		}

		boolean visited[] = new boolean[n + 1];

		int indexing = 0;

		//ans.append("total missing ").append(miss).append("\n");

		//ans.append("component length").append("\n");

		for(int i = 1; i <= n; ++i) {

			if(visited[i]) {

				continue;

			}

			if(!missing[i]) {

				continue;

			}

			int connected_component = dfs(i, visited, 0);

			//ans.append("\n");

			if(connected_component > 3) {

				ans.append("-1");
				return;

			}

			//ans.append(connected_component).append("\n");

			if(connected_component != 3) {

				if(miss >= Math.abs(connected_component - 3)) {

					//ans.append("enter here first ").append(miss).append("\n");

					for(int j = 0; j < Math.abs(connected_component - 3); ++j) {

						if(indexing >= miss_collections.size()) {

							//ans.append("here").append("\n");

							ans.append("-1");
							return;

						}

						if(list[i].size() + 1 > 3) {

							break;

						}

						//ans.append("come at here ").append(i).append("\n");

						int new_node = miss_collections.get(indexing++);

						int another_node = list[i].get(list[i].size() - 1);

						//ans.append(new_node).append(" added").append("\n");

						visited[new_node] = true;
						missing[new_node] = true;

						list[i].add(new_node);
						list[new_node].add(i);

						list[another_node].add(new_node);
						list[new_node].add(another_node);

					}

					miss -= Math.abs(connected_component - 3);
					continue;

				}

				//ans.append("here").append("\n");

				//ans.append("-1");
				//return;

			}

		}

		if(miss % 3 != 0) {

			ans.append(-1);

			return;

		}

		for(int i = indexing; i < miss_collections.size(); i += 3) {

			try {

			  list[miss_collections.get(i)].add(miss_collections.get(i + 1));
			  list[miss_collections.get(i + 1)].add(miss_collections.get(i));

			  list[miss_collections.get(i + 2)].add(miss_collections.get(i + 1));
			  list[miss_collections.get(i + 1)].add(miss_collections.get(i + 2));

		    } catch(Exception e) {

			   break;

		    }
		
		}

		//ans.append(miss).append("\n");

		/*for(int i : list[1]) {

			ans.append(i).append(" ");

		} */

		//ans.append("\n");

		visited = new boolean[n + 1];

		for(int i = 1; i <= n; ++i) {

			if(visited[i]) {

				continue;

			}

			int connected_component = dfs(i, visited, 0);

			//ans.append("\n");

			//ans.append(connected_component).append("\n");

			if(connected_component != 3) {

				ans.append("-1");
				return;

			}

		}

		List<List<Integer>> ans_ = new ArrayList<>();

		visited = new boolean[n + 1];

		for(int i = 1; i <= n; ++i) {

			if(visited[i]) {

				continue;

			}

			List<Integer> list_ = new ArrayList<>();

			list_ = dfs(i, visited, list_);

			ans_.add(list_);

		}

		for(List<Integer> i : ans_) {

			for(int j : i) {

				ans.append(j).append(" ");

			}

			ans.append("\n");

		}

	}

	public static void main(String[] amit) throws IOException {

		submit();
		//practice();
		
	}

	private static void submit() {

		input();
		solve();

		System.out.print(ans.toString());

	}

	private static void input() {

		n = in.nextInt();
		m = in.nextInt();

		a = new int[m];
		b = new int[m];

		for(int i = 0; i < m; ++i) {

			a[i] = in.nextInt();
			b[i] = in.nextInt();

		}

	}

	private static void practice() throws IOException {

		fileInput();
		writeFile();

	}

	private static void fileInput() throws IOException {

		FileReader fr = new FileReader(new File("B_Coach.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int line_ = 1;

		while((line = br.readLine()) != null) {

			if(line_ == 1) {

				String s[] = line.trim().split(" ");

				n = Integer.parseInt(s[0]);
				m = Integer.parseInt(s[1]);

				a = new int[m];
				b = new int[m];

			} else {

				for(int i = 0; i < m; ++i) {

					String s[] = line.trim().split(" ");

					a[i] = Integer.parseInt(s[0]);
					b[i] = Integer.parseInt(s[1]);

					line = br.readLine();

				}

				solve();

			}

			++line_;

		}

	}

	private static void writeFile() throws IOException {

		FileWriter fw = new FileWriter(new File("B_Coach.out"));

		fw.write(ans.toString());
		fw.close();

	}

}