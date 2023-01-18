import java.util.Scanner;

public class D_Valiant_s_New_Map {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[][];
	
	/*
	
	1. what we have?
	
	we have a matrix of n raw and m coloumns.
	
	2. what have we do?
	
	we have to determin a (l * l) cell so that
	all value in that cell's will be at least
	l. but here the value of the l will be maxium.
	
	3. solve example:
	
	eg1:
	
		 1	2	3	4	5	6
	  -|------------------------
	  1| 1	9	4	6	5	8
	   | 		-	-	-
	  2| 10	9	5	8	11	6
	   | 		-	-	-
      3| 24	42	32	8	11	1
	   | 		-	-	-
      4| 23	1	9	69	13	3
	   |
      5| 13	22	60	12	14	17  
	
	if we take (3 * 3) cell from the table.
	from the col 3 to 5 and the raw 1 to
	3 then then this is the maximum area
	of that selected cell.
	
	eg2:
	
	2	2
	
		1	2
	 -|---|----|-
	 1|	2 |	3  |
	  | - | -  |
	 2| 4 | 5  |
        -	-
		
		here we can take a 2 * 2 cell as the 
		cell under this area is atleast 2 or
		the range of the value is the greater
		than or equal to 2.
	
    eg3:
	
	2	3
	
		1	2	3
	---|--|---|---|-
	  1|4 | 4 | 3 |
	   |  |   |   |
	  2|2 | 1 | 4 |
	   |  | - |   |
	   
	   here we can build only 1 * 1 cell. that
	   is in the (2,1) cell.
	   
	4. observations:
	
	- here the maximum value of the l will
	  be the min of the (n, m). As the created
	  cell will be a square.
	
	- So, here we can use binary search to fix
	  the specific length of the l. that take's
      log(min(n, m)) complexity. So, overall 
      complexity is log(min(n, m)) * n * m.	  
	
	- as all the value will be under the range
	  of the m. So, we will ignore those value
      in every step's value m we will calculate.	  
	
	- as we have to count the length of the created
	  square, so we create another matrix that mark
      the specific element's as 1 or 0. that meantion
      that this cell will be under count or not.
      as example for the eg1  	  
	
		 1	2	3	4	5	6
	  -|------------------------
	  1| 0	1	1	1	1	1
	   | 		-	-	-
	  2| 1	1	1	1	1	1
	   | 		-	-	-
      3| 1	1	1	1	1	0
	   | 		-	-	-
      4| 1	0	1	1	1	1
	   |
      5| 1	1	1	1	1	1  
	
	- now we can count the number of cell that
	  contains one in some particular square. As
	  we can see that the presented cell that is
	  valid, we can see them in clear. Have to count
	  them or build some mathematical equation.
	
	- we can build a dp table to count the number
	  of 1 in the table. this must be in the fix
	  square can create from the table. as eg1
	  we can see this table,
	  we mark it as matrix b.
	
		 0	1	2	3	4	5	6
	  -|---------------------------
	  0| 0	0	0	0	0	0	0
	   | 				
	  1| 0	0	1	2	3	4	5
	   | 				
      2| 0	1	3	5	7	9	11
	   | 				
      3| 0	2	5	8	11	14	16
	   |
      4| 0	3	6	10	14	18	21 
	   |
	  5| 0	4	8	13	18	23	27
	
	this normal equation can be,
	
	dp(i + 1, j + 1) = dp(i, j + 1) + dp(i + 1, j) - dp(i, j) + b(i, j)
	
	here mainly dp(i + 1, j + 1) mention the 4'th
	co - ordinate of the created matrix. And every time
    time we will count the created fourth angle.	
	at every point mention the number of 1 or the
	valid cell with previous three point to create
	a fouth angle.
	
	in thia step we mainly count the prefix valid
	cell from the left sight and count the valid
	prefix cell from the right - up sight. And 
	deduct the outer of the both side. Which mention
	the left outer point of the corner left
	point. As from the prefix count we get the count
	from the point (i, j) to (i - m, j - m) point.
	
	- to count the fouth angle valid point's we
	  can generate this formulla,
	  valid cell = dp(i, j) - dp(i - len, j) - dp(i, j - len) + dp(i - len, j - len)
	  
	  if this can full fill the len * len matrix
	  then it counted as a valid square.
	  
	*/
	
	static boolean solve(int len) {
		
		long b[][] = new long[n][m];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < m; ++j) {
				
				b[i][j] = a[i][j];
				
			}
			
		}
		
		long dp[][] = new long[n + 1][m + 1];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < m; ++j) {
				
				if(b[i][j] >= len) {
					
					b[i][j] = 1L;
					
				} else {
					
					b[i][j] = 0L;
					
				}
				
				dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + b[i][j];
				
			}
			
		}
		
		for(int i = len; i <= n; ++i) {
			
			for(int j = len; j <= m; ++j) {
				
				long valid_cell = dp[i][j] - dp[i - len][j] - dp[i][j - len] + dp[i - len][j - len];
				
				if(valid_cell == (long)(len * len) ) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	static void solve() {
		
		int left = 0, right = Math.min(m, n);
		
		int ans = 0;
		
		while(right >= left) {
			
			int mid = (left + right) / 2;
			
			if(solve(mid)) {
				
				ans = mid;
				left = mid + 1;
				
			} else {
				
				right = mid - 1;
				
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			a = new long[n][m];
			
			for(int i = 0; i < n; ++i) {
				
				for(int j = 0; j < m; ++j) {
				
				   a[i][j] = in.nextLong();
				
				}
				
			}
			
			solve();
			
		}
		
	}
	
}