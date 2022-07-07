import java.util.TreeSet;
import java.util.Scanner;

public class B_T_shirt_buying {

    static Scanner in = new Scanner(System.in);

    static int n, m;
	
	static StringBuilder ans = new StringBuilder();

    static long price[], front[], back[], choice[];

    static void solve() {

        color[] c = new color[n];

        for (int i = 0; i < n; i++) {

            c[i] = new color(front[i], back[i], price[i]);

        }
		
		TreeSet<Long> color1 = new TreeSet<>();
		TreeSet<Long> color2 = new TreeSet<>();
		TreeSet<Long> color3 = new TreeSet<>();

		for(color i : c) {
			
			if(i.front_color == 1) {
				
				color1.add(i.price);
				
			} else if(i.front_color == 2) {
				
				color2.add(i.price);
				
			} else if(i.front_color == 3) {
				
				color3.add(i.price);
				
			}
			
			if(i.back_color == 1) {
				
				color1.add(i.price);
			
			} else if(i.back_color == 2) {
				
				color2.add(i.price);
				
			} else if(i.back_color == 3) {
				
				color3.add(i.price);
				
			}
			
		}
		
		StringBuilder testCasesAns = new StringBuilder();
		
		long k = 0;
		
		for(long i : choice) {
			
			if(i == 1) {
				
				if(color1.isEmpty()) {
					
					testCasesAns.append(-1).append(" ");
					
				} else {
					
					testCasesAns.append(color1.first()).append(" ");
					k = color1.first();
					
				}
				
			} else if(i == 2) {
				
				if(color2.isEmpty()) {
					
					testCasesAns.append(-1).append(" ");
					
				} else {
					
					testCasesAns.append(color2.first()).append(" ");
					k = color2.first();
					
				}
				
			} else if(i == 3) {
				
				if(color3.isEmpty()) {
					
					testCasesAns.append(-1).append(" ");
					
				} else {
					
					testCasesAns.append(color3.first()).append(" ");
					k = color3.first();
					
				}
				
			}
			
			color1.remove(k);
			color2.remove(k);
			color3.remove(k);
			
		}
		
		ans.append(testCasesAns.toString().trim());
		
    }

    public static void main(String[] amit) {

        n = in.nextInt();

        price = new long[n];

        front = new long[n];

        back = new long[n];

        for (int i = 0; i < n; i++) {
            price[i] = in.nextLong();
        }

        for (int i = 0; i < n; i++) {
            front[i] = in.nextLong();
        }

        for (int i = 0; i < n; i++) {
            back[i] = in.nextLong();
        }

        m = in.nextInt();

        choice = new long[m];

        for (int i = 0; i < m; i++) {
            choice[i] = in.nextInt();
        }

        solve();
		
		System.out.print(ans.toString());

    }

    static class color implements Comparable<color> {

        long front_color, back_color, price;

        boolean used = false;

        public color(long front_color, long back_color, long price) {
            this.front_color = front_color;
            this.back_color = back_color;
            this.price = price;
        }

        @Override
        public int compareTo(B_T_shirt_buying.color o) {
            // TODO Auto-generated method stub
            return Long.compare(this.price, o.price);
        }

    }

}
/*
 * 
 * 5
 * 300 200 400 500 911
 * 1 2 1 2 3
 * 2 1 3 2 1
 * 6
 * 2 3 1 2 1 1
 * 
 */
