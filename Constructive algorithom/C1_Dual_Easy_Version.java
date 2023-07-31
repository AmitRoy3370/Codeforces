import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class C1_Dual_Easy_Version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve1() {
		
		long max = a[0], min = a[0];
		
		int max_index = -1, min_index = -1;
		
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
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
		
		if(max == min) {
			
			
		} else {
			
			if(Math.abs(max) > Math.abs(min)) {
				
				for(int i = 2; i <= n; ++i) {
					
					while(a[i - 1] > a[i]) {
						
						list.add((i) + " " + (max_index));
						
						a[i] += max;
						
						if(a[i] > max) {
							
							max = a[i];
							max_index = i;
							
						}
						
					}
					
				} 
				
			} else {
				
				for(int i = n - 1; i >= 1; --i) {
					
					if(a[i] > a[i + 1]) {
						
						while(a[i] > a[i + 1]) {
							
							a[i] += min;
							
							list.add((i) + " " + (min_index));
							
							if(a[i] < min) {
								
								min = a[i];
								min_index = i;
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		sb.append(list.size()).append("\n");
		
		for(String i : list) {
			
			sb.append(i).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
		int solid_positive = 0, solid_negative = 0;
		
		for(int i = 1; i <= n;++i) {
			
			if(a[i] > 0L) {
				
				++solid_positive;
				
			} else if(a[i] < 0L) {
				
				++solid_negative;
				
			}
			
		}
		
		//System.out.println(solid_negative + " " + solid_positive);
		
		if(solid_negative == 0) {
			
			all_positive(list);
			
		} else if(solid_positive == 0) {
			
			all_negative(list);
			
		} else {
			
			long max = 0L, min = 0L;
			
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
			
			if(max == min) {
				
				System.out.println(0);
				return;
				
			}
			
			long max_copy = max;
			long min_copy = min;
			
			// make max to min.
			
			int step_to_make_min_to_max = 0;
			
			int step_to_make_max_to_min = 0;
			
			while(max_copy + min > 0L) {
				
				step_to_make_max_to_min++;
				
				min *= 2L;
				
			}
			
			// make min to max
			
			while(max + min_copy < 0L) {
				
				++step_to_make_min_to_max;
				
				max *= 2L;
				
			}
			
			//System.out.println(step_to_make_max_to_min + " " + step_to_make_min_to_max);
			
			//System.out.println(max + " " + min);
			
			//System.out.println((solid_positive + step_to_make_max_to_min) + " " + (solid_negative + step_to_make_min_to_max));
			
			if(solid_positive + step_to_make_max_to_min < solid_negative + step_to_make_min_to_max) {
				
				for(int i = 0; i < step_to_make_max_to_min; ++i) {
					
					list.add(min_index + " " + min_index);
					
					//a[min_index] += a[min_index];
					
				}
				
				for(int i = 1; i <= n; ++i) {
					
					if(a[i] > 0L) {
						
						list.add((i) + " " + min_index);
						
						//a[i] += a[min_index];
						
					}
					
				}
				
				all_negative(list);
				
				//print(a);
				
			} else {
				
				//System.out.println("here");
				
				for(int i = 0; i < step_to_make_min_to_max; ++i) {
					
					list.add(max_index + " " + max_index);
					
				}
				
				for(int i = 1; i <= n; ++i) {
					
					if(a[i] < 0L) {
						
						list.add((i) + " " + max_index);
						
					}
					
				}
				
				all_positive(list);
				
			}
			
		}
		
		sb.append(list.size()).append("\n");
		
		for(String i : list) {
			
			sb.append(i).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static void all_positive(List<String> list) {
		
		for(int i = 2; i <= n; ++i) {
			
			list.add((i) + " " + (i - 1) );
			
		}
		
	}
	
	static void all_negative(List<String> list) {
		
		for(int i = n - 1; i >= 1; --i) {
			
			list.add(i + " " + (i + 1));
			
			//a[i] += a[i + 1];
			
		}	
		
	}
	
	static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	static void swap(long a[], int i, int j) {
		
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
}