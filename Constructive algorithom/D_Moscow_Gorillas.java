import java.util.Scanner;

public class D_Moscow_Gorillas {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int p[], q[];
	
	static void solve() {
		
		int positionsP[] = new int[n + 1];
		int positionsQ[] = new int[n + 1];
		
		int index = 1;
		
		for(int i : p) {
			
			positionsP[i] = index++;
			
		}
		
		index = 1;
		
		for(int i : q) {
			
			positionsQ[i] = index++;
			
		}
		
		long suitablePair = 1L;
		
		long min = Math.min(positionsP[1], positionsQ[1]);
		long max = Math.max(positionsP[1], positionsQ[1]);
		
		suitablePair += ((min) * (min - 1)) / 2;
		suitablePair += ((max - min) * (max - min - 1)) / 2;
		suitablePair += ((n - max) * (n - max + 1)) / 2;
		
		for(int permutation = 2; permutation != n + 1; ++permutation) {
			
			int localMin = Math.min(positionsP[permutation], positionsQ[permutation]);
			int localMax = Math.max(positionsP[permutation], positionsQ[permutation]);
			
			if(min > localMax) {
				
				suitablePair += (n + 1 - max) * (min - localMax);
				
			} else if(localMin > max) {
				
				suitablePair += (min) * (localMin - max);
				
			} else if(min > localMin && localMax > max) {
				
				suitablePair += (min - localMin) * (localMax - max);
				
			}
			
			max = Math.max(max, localMax);
			min = Math.min(min, localMin);
			
		}
		
		System.out.print(suitablePair);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		p = new int[n];
		q = new int[n];
		
		for(int i = 0; i != n; ++i) {
			
			p[i] = in.nextInt();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			q[i] = in.nextInt();
			
		}
		
	}
	
}