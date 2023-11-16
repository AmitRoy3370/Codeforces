import java.util.Scanner;
import java.util.TreeSet;

public class A_Glass_Carving {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long w, h;
	
	static Cut cut[];
	
	static void solve() {
		
		StringBuilder ans = new StringBuilder();
		
		Cutter x = new Cutter((int)w);
		Cutter y = new Cutter((int)h);
		
		for(int i = 0; i != n; ++i) {
			
			if(cut[i].axis == 'V') {
				
				x.cut(cut[i].size);
				
			} else {
				
				y.cut(cut[i].size);
				
			}
			
			ans.append((x.max() * y.max())).append("\n");
			
		}
		
		System.out.println(ans.toString());
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		w = in.nextLong();
		h = in.nextLong();
		
		n = in.nextInt();
		
		cut = new Cut[n];
		
		for(int i = 0; i != n; ++i) {
			
			char axis = in.next().charAt(0);
			long size = in.nextLong();
			
			cut[i] = new Cut(axis, size);
			
		}
		
	}
	
	static class Cut {
		
		char axis;
		long size;
		
		public Cut(char axis, long size) {
			
			this.axis = axis;
			this.size = size;
			
		}
		
	}
	
	static class Cutter {
		
		TreeSet<Long> set;
		
		long per_square[];
		
		int length;
		
		long max;
		
		public Cutter(int length) {
			
			this.length = length;
			
			this.max = this.length;
			
			set = new TreeSet<>();
			
			set.add(0L);
			
			per_square = new long[length + 1];
			
			per_square[length] = 1L;
			
		}
		
		private void cut(long x) {
			
			long p = set.floor(x);
			long n = set.ceiling(x + 1) == null ? length : set.ceiling(x + 1);
			
			set.add(x);
			
			per_square[(int)(n - p)]--;
			per_square[(int)(x - p)]++;
			per_square[(int)(n - x)]++;
			
		}
		
		private long max() {
			
			while(per_square[(int)max] == 0L) {
				
				--max;
				
			}
			
			return max;
			
		}
		
	}
	
}