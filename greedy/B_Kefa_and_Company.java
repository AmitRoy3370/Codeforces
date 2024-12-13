import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Kefa_and_Company {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long m[], f[], d;
	
	static void solve() {
		
		List<Person> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			list.add(new Person(m[i], f[i]));
			
		}
		
		Collections.sort(list);
		
		long a[] = new long[n];
		
		a[0] = list.get(0).friendShipFactor;
		
		for(int i = 1; i < n; ++i) {
			
			a[i] = a[i - 1] + list.get(i).friendShipFactor;
			
		}
		
		long maximumfriendShipFactor = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			int j = upperBounds(list.get(i).maxRange, list);
			
			//System.out.println(list.get(i).maxRange + " :- " + j);
			
			if(j <= -1) {
				
				maximumfriendShipFactor = Math.max(maximumfriendShipFactor,
				                 list.get(i).friendShipFactor);
				
				continue;
				
			}
			
			maximumfriendShipFactor = Math.max(maximumfriendShipFactor,
			              a[j - 1] - (i - 1 >= 0 ? a[i - 1] : 0) );
			
			//i = j - 1;
			
		}
		
		System.out.println(maximumfriendShipFactor);
		
	}
	
	private static int upperBounds(long money, List<Person> list) {
		
		int left = 0, right = list.size() - 1, index = n;
		
		while(right >= left) {
			
			int mid = left + (right - left) / 2;
			
			//System.out.println(left + " " + right);
			
			if(list.get(mid).money >= money) {
				
				right = mid - 1;
				index = mid;
				
			} else {
				
				left = mid + 1;
				
			}
			
		}
		
		return index;
		
	}
	
	public static void main(String [] amit) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		d = in.nextLong();
		
		f = new long[n];
		m = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			m[i] = in.nextLong();
			f[i] = in.nextLong();
			
		}
		
	}
	
	static class Person implements Comparable<Person> {
		
		long money, friendShipFactor, maxRange;
		
		public Person(long money, long friendShipFactor) {
			
			this.money = money;
			this.maxRange = this.money + d;
			this.friendShipFactor = friendShipFactor;
			
		}
		
		public int compareTo(Person person) {
			
			if(this.money > person.money) {
				
				return 1;
				
			} else if(this.money < person.money) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
		public String toString() {
			
			return this.money + " " + this.friendShipFactor;
			
		}
		
	}
	
}