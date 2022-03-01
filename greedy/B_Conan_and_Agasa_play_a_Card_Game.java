import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Conan_and_Agasa_play_a_Card_Game{
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve(){
		
		Map<Long,Integer> map = new HashMap<>();
		
		for(long i: a ){
			
			map.put(i, map.getOrDefault(i, 0) + 1 );
			
		}
		
		for(long i: a ){
			
			if(map.get(i) % 2 == 1 ){
				
				System.out.println("Conan");
				return;
				
			}
			
		}
		
		System.out.println("Agasa");
		
	}
	
	public static void main(String [] amit){
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i){
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
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