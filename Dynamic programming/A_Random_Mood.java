import java.util.Scanner;

public class A_Random_Mood {
	
	static Scanner in = new Scanner(System.in);
	
	static long n;
	
	static double p;
	
	static void solve() {
		
		double unit[][] = new double[2][2];
		
		for(int i = 0; i < 2; ++i) {
			
			unit[i][i] = 1.0;
			
		}
		
		double mat[][] = new double[2][2];
		
		/*
		
		here we have 4 possible probability
		1. he become happy from happy
		2. he become happy from sad
		3. he become sad from happy
		4. he become sad from sad
		
		here we use 2 * 2 matrix. as it is
		faster. Here 0 index means that he
		is happy and the 1 index mentioned that
		he is sad. 
		
		So, when his mode is not change then the
		the probability is switch or change. And
		when the mode switch then the probability
		will not change. His initial probability
		is P. So, the not change mode will not be
        the reason to change the probability. And
		we use binary exponentiation to solve this
		problem. 
 		
		*/
		
		mat[0][0] = 1.0 - p;
		mat[0][1] = p;
		mat[1][0] = p;
		mat[1][1] = 1.0 - p;
		
		while(n > 0) {
			
			if(n % 2 == 1) {
				
				unit = mul(mat, unit);
				
			}
			
			mat = mul(mat, mat);
			
			n /= 2;
			
		}
		
		System.out.printf("%.9f", unit[0][0]);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextLong();
		p = in.nextDouble();
		
		solve();
		
	}
	
	static double[][] mul(double mat[][], double a[][]) {
		
		int n = mat.length;
		
		double ans[][] = new double[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				//ans[i][j] = 0.0;
				
				for(int k = 0; k < n; ++k) {
					
					ans[i][k] += a[i][j] * mat[j][k];
					
				}
				
			}
			
		}
		
		return ans;
		
	}
	
}