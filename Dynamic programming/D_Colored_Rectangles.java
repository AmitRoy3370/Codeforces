import java.util.Scanner;

public class D_Colored_Rectangles {
	
	static Scanner in = new Scanner(System.in);
	
	static int R, G, B;
	
	static long r[], g[], b[];
	
	static void solve() {
		
		sort(r, 0, R);
		sort(g, 0, G);
		sort(b, 0, B);
		
		long dp[][][] = new long[R + 2][G + 2][B + 2];
		
		long ans = Long.MIN_VALUE;
		
		for(int red = R; red >= 0; --red) {
			
			for(int green = G; green >= 0; --green) {
				
				for(int blue = B; blue >= 0; --blue) {
					
					if(red == R && green == G && blue == B) {
						
						continue;
						
					}
					
					dp[red][green][blue] = Math.max(Math.max(dp[red + 1][green + 1][blue] + r[red + 1] * g[green + 1], dp[red + 1][green][blue + 1] + r[red + 1] * b[blue + 1]), dp[red][green + 1][blue + 1] + b[blue + 1] * g[green + 1] );
					
					ans = Math.max(ans, dp[red][green][blue]);
					
				}
				
			}
			
		}
		
		System.out.print(ans);
		
		//printDp(dp);
		
	}
	
	public static void main(String [] priya) {
		
		R = in.nextInt();
		G = in.nextInt();
		B = in.nextInt();
		
		r = new long[R + 2];
		g = new long[G + 2];
		b = new long[B + 2];
		
		for(int i = 1; i <= R; ++i) {
			
			r[i] = in.nextLong();
			
		}
		
		for(int i = 1; i <= G; ++i) {
			
			g[i] = in.nextLong();
			
		}
		
		for(int i = 1; i <= B; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	static void printDp(long dp[][][]) {
		
		System.out.println();
		
		for(long i[][] : dp) {
			
			for(long j[] : i) {
				
				for(long k : j) {
					
					System.out.print(k + " ");
					
				}
				
				System.out.print("   ");
				
			}
			
			System.out.println();
			
		}
		
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
	
}