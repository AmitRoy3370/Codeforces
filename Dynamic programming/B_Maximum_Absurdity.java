import java.util.Scanner;

public class B_Maximum_Absurdity
{
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve()
	{
		
		long sum[] = new long[n + 1];
		
		for(int i = n - 1; i >= 0; --i) 
		{
			
			sum[i] = sum[i + 1] + a[i];
			
		}
		
		int x = -1, y = -1, y1 = -1;
		
		long max_dis = 0L, maximum_dis = 0L;
		
		for(int i = n - 2 * k; i >= 0; --i) 
		{
			
			if(sum[i + k] - sum[i + 2 * k] >= max_dis) 
			{
				
				max_dis = sum[i + k] - sum[i + 2 * k];
				y1 = i + k; 
				
			}
			
			if(sum[i] - sum[i + k] + max_dis >= maximum_dis) 
			{
				
				maximum_dis = sum[i] - sum[i + k] + max_dis;
				
				x = i;
				y = y1;
				
			}
			
		} 
		
		System.out.print(++x + " " + ++y);
		
	}
	
	public static void main(String [] priya)
	{
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i)
		{
			
			a[i] = in.nextLong();
			
		}
		
		solve();
					
	}
	
} 