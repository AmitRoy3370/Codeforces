import java.util.Scanner;

public class B_Color_the_Fence {
    
    static Scanner in=new Scanner(System.in);
    
    public static void main(String amit[]) {
      
      int total=in.nextInt();
      
      int n=9;
      
      int values[]=new int[n+1];
      
      int weight[]=new int[n+1];
      
	  int noAns=0;
	  
      for(int i=1;i<=9;i++){
          
          weight[i]=in.nextInt();
          
          values[i]=i;
          
		  if(weight[i]>total ){
			  
			  noAns++;
			  
		  }
		  
      }
      
	  if(noAns==n ){
		  
		  System.out.println(-1);
		  
		  return;
		  
	  }
	  
      long size_dp[]=new long[total+1];
	  
	  char dp[]=new char[total+1];
	  
	  for(int value=1;value<=total;value++){
		  
		  for(int i=1;i<=n;i++){
			  
			  if(value-weight[i]>=0 ){
				  
				  if(size_dp[value-weight[i]]+1>size_dp[value] ){
					  
					  size_dp[value]=size_dp[value-weight[i] ]+1;
					  
					  dp[value]=(char)(i+'0');
					  
				  }else if(size_dp[value-weight[i] ]+1==size_dp[value] ){
					  
					  dp[value]=(char)(i+'0');
					  
				  }
				  
			  }
			  
		  }
		  
	  }
	  
	  int j=total;
	  
	  StringBuilder ans=new StringBuilder();
	  
	  if(dp[total]==' ' ){
		  
		  System.out.println(-1);
		  
		  return;
		  
	  }
	  
	  while(j>0){
		  
		  if(dp[j]=='�' ){
			  
			  break;
			  
		  }
		  
		  ans.append(dp[j]);
		  
		  try{
		  
		   j-=weight[Math.abs(dp[j]-'0')];
		  
		  }catch(ArrayIndexOutOfBoundsException e){
			  
			  break;
			  
		  }
		  
	  }
	  
	  if(ans.toString().isEmpty() ){
		  
		  System.out.println(-1);
		  
		  return;
		  
	  }
	  
	  System.out.println(ans.toString().trim() );
	  
    }
}