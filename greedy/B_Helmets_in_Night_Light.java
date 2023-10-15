	import java.util.Scanner;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Collections;
	
	public class B_Helmets_in_Night_Light {
		
		static Scanner in = new Scanner(System.in);
		
		static int testCases, n, p;
		
		static long a[], b[];
		
		static void solve() {
			
			Person person[] = new Person[n];
			
			for(int i = 0; i < n; ++i) {
				
				person[i] = new Person(a[i], b[i]);
				
			}
			
			List<Person> list = new ArrayList<>();
			
			for(Person i : person) {
				
				list.add(i);
				
			}
			
			Collections.sort(list);
			
			long left = n - 1; 
			
			int i = 0;
			
			long ans = p;
			
			while(i < n && left > 0) {
				
				if(list.get(i).cost_to_share < p) {
					
					if(list.get(i).can_share <= left) {
						
						ans += list.get(i).can_share * list.get(i).cost_to_share;
						left -= list.get(i).can_share;
						++i;
						
					} else {
						
						ans += (left * list.get(i).cost_to_share);
						list.get(i).can_share -= left;
						left = 0;
						break;
						
					}
					
				} else {
					
					ans += left * p;
					break;
					
				}
				
			}
			
			System.out.println(ans);
			
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
			p = in.nextInt();
			
			a = new long[n];
			b = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				b[i] = in.nextLong();
				
			}
			
		}
		
		static class Person implements Comparable<Person> {
			
			long can_share, cost_to_share;
			
			public Person(long can_share, long cost_to_share) {
				
				this.can_share = can_share;
				this.cost_to_share = cost_to_share;
				
			}
			
			public int compareTo(Person p) {
				
				if(this.cost_to_share > p.cost_to_share) {
					
					return 1;
					
				} else if(this.cost_to_share < p.cost_to_share) {
					
					return -1;
					
				} else {
					
					if(this.can_share > p.can_share) {
						
						return 1;
						
					} else if(this.can_share < p.can_share) {
						
						return -1;
						
					} else {
						
						return 0;
						
					}
					
				}
				
			}
			
		}
		
	}