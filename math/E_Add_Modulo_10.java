import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class E_Add_Modulo_10 {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	/*
	**
	*progress of one number
	*----------------------
	*
	*- 2 4 8 16 22 24 28 36 42 44 48 56 62 64 68 76
	*82 84 88 96 102 104 108 116 122 124 128 136 142
	*144 148 156 162 164 168 176 182 184 188 196 202
	*204 208 216 222 224 228 236.....
	*
	*- 3 6 12 14 18 26 32 34 38 46 52 54 58 66 72 74
	*78 86 92 94 98 106 112 114 118 126 132 134 138
	*146 152 154 158 166 172 174 178 186 192 194 198
	*206 212 214 218 226 232 234....
	*
	** no number with out the end digit 5 it is 
	*  impossible to reach at the number that is
	*  divisible by 10.
	*  
	** odd numbers turn to even number by one 
    *  operation	
	*
	*5 10 5 10 5
	*-> 10 10 5  10 5
	*-> 10 10 10 10 5
	*-> 10 10 10 10 10 -> yes
	*
	*1 5
	*-> 2  10
	*-> 4  10
	*-> 8  10
	*-> 16 10 -> no
	*
	*93 96 102
	*-> 96  96  102
	*-> 102 96  102
	*-> 102 102 102 -> yes 
	*
	*50 30
	*-> - - -> no   
	*
	*2 18 22
	*-> 4  18 22
	*-> 8  18 22
	*-> 16 18 22
	*-> 22 18 22
	*-> 22 26 22 -> No
	*
	*1 2 3 4 5
	*-> 2 2 3  4 5
	*-> 4 2 3  4 5
	*-> 4 4 3  4 5
	*-> 4 4 6  4 5
	*-> 4 4 12 4 5
	*-> 4 4 12 4 10 -> no
	*
	*1 2 3 6 7
	*-> 1  2 3  6  7
	*-> 2  2 3  6  7
	*-> 2  2 6  6  7
	*-> 2  2 6  6  14
	*-> 4  2 6  6  14
	*-> 4  4 6  6  14
	*-> 8  4 6  6  14
	*-> 8  8 6  6  14
	*-> 8  8 12 6  14
	*-> 8  8 12 12 14
	*-> 8  8 14 12 14
	*-> 8  8 14 14 14
	*-> 16 8 14 14 14 -> no
	*
	*1  2  2  4  8
	*-> 1	2	2	4	8
	*-> 2	2	2	4	8
	*-> 4	2	2	4	8
	*-> 4	4	2	4	8
	*-> 8	4	2	4	8
	*-> 8	8	2	4	8
	*-> 8	8	2	8	8
	*-> 8	8	4	8	8
	*-> 8	8	8	8	8 -> yes
	*
	*6 11
	*-> 6	11
	*-> 12	11
	*-> 12	12 -> yes
	*
	*5 10 20 5
	*-> 5	10	20	5
	*-> 10	10	20  5
	*-> -	-	-	10
	*-> -	-	-	- -> no
	*
	** first observation : if all the number are 
	*  ..................
	*  divisible by the 10, but all of them are not
	*  equal then ans is no. As no change will be
    *  happen at the case of the number divisible
    *  by 10. 	  
	*
	** second observation : If any number present
	*  ..................
	*  in the list that number ownself is not divisible
	*  by 10 but that number + 5 is divisible by 10
	*  then we can count them as the divisible number
	*
	** third observation : if already all number are
	*  ..................
	*  equal then we already get our wanted sequences
	*
	** fourth observation : the even numbers are
	*  ..................
	*  rotate cyclically, so while the array element
	*  increase by 20 in 4 operation then untill
	*  the module 10 becoms the 2. the element
	*  does not contain the 2 and 12 % 20
	*
	*/
	
	static void solve() {
		
		int divisible = 0, divisible5 = 0;
		
		Set<Long> set = new HashSet<>();
		
		for(long i : a) {
			
			if(i % 10 == 0) {
				
				++divisible;
				
			} else if(i % 5 == 0) {
				
				++divisible5;
				
			}
			
			set.add(i);
			
		}
		
		if(set.size() == 1) {
			
			System.out.println("YES");
			return;
			
		}
		
		if(divisible == n) {
			
			if(set.size() == 1) {
				
				System.out.println("YES");
				
			} else {
				
				System.out.println("NO");
				
			}
			
			//return;
			
		} else {
			
			if(divisible5 > 0) {
				
				long copy[] = new long[n];
				
				for(int i = 0; i < n; ++i) {
					
					copy[i] = a[i];
					
				}
				
				for(int i = 0; i < n; ++i) {
					
					if(copy[i] % 5 == 0) {
						
						copy[i] += 5;
						
					}
					
				}
				
				set = new HashSet<>();
				
				for(long i : copy) {
					
					set.add(i);
					
				}
				
				if(set.size() == 1) {
					
					System.out.println("YES");
					return;
					
				}
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i] % 10 == 0) {
					
					a[i] = a[i];
					
				} else if(a[i] % 10 == 5) {
					
					a[i] += 5;
					
				} else {
					
					while(a[i] % 10 != 2) {
						
						a[i] = (a[i] % 10) + a[i];
						
					}
					
					a[i] %= 20;
					
					if(a[i] == 12) {
						
						a[i] = 3;
						
					} else {
						
						a[i] = 1;
						
					}
					
				}
				
			}
			
			set = new HashSet<>();
			
			for(long i : a) set.add(i);
			
			if(set.size() > 1) {
				
				System.out.println("NO");
				
			} else {
				
				System.out.println("YES");
				
			}
			
		}
		
	}
	
	public static void main(String [] priya) {
		
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
	
}
