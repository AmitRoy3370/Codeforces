import java.util.Scanner;

public class H2_Maximum_Crossings_Hard_Version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(n == 2) {
			
			System.out.println((a[0] == 1 && a[1] == 2 ? 0 : 1));
			return;
			
		}
		
		long ans = sort(a, 0, n - 1, 1);
		
		sort(a, 0, n - 1, 0);
		
		//print(a);
		
		/*long current = 1;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] != a[i - 1]) {
				
				ans += ((current - 1) * current) / 2;
				current = 1;
				
			} else {
				
				++current;
				
			}
			
		}
		
		ans += (current * (current - 1)) / 2;*/
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static long merge(long arr[], int left, int right, int mid) {
		
        long[] temp = new long[right - left + 1];
        long ans = 0;
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k++]  = arr[i++];
            }else {
                ans += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]  = arr[i++];
        }
        while (j <= right){
            ans += (mid - i + 1);
            temp[k++] = arr[j++];
        }
        for(i = left; i <= right; i++)arr[i] = temp[i - left];
        return ans;
		
	}
	
	static long sort(long a[], int left, int right, int option) {
		
		long count = 0;
		
		if(left < right) {
			
		  int mid = (left + right) / 2;
		  
		  if(option == 1) {
		  
		    count = sort(a, left, mid, option);
		    count += sort(a, mid + 1, right, option);
		    count += merge(a, left, right, mid);
		  
		  } else {
			  
			sort(a, left, mid, option);
		    sort(a, mid + 1, right, option);
		    merge(a, left, right, mid);
		    
		  }
		
		}
		
		return count;
	
	}
	
	static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}