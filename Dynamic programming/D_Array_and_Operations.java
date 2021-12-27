import java.util.Scanner;

public class D_Array_and_Operations{
	
	static Scanner in=new Scanner(System.in);
	
	static int n,k,testCases;
	
	static long a[];
	
	static void solve(){
		
	   sort(a,0,n-1);	
	   
	   long sum=0;
	   
	   for(int i=0;i<n-2*k;i++){
		   
		   sum+=a[i];
		   
	   }
	   
	   for(int i=0;i<n;i++){
		   
		   try{
		   
		    sum+=a[n-2*k+i]/a[n-k+i];
		   
		   }catch(Exception e){
			   
			   break;
			   
		   }
		   
	   }
			
		System.out.println(sum);	
			
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=0;t<testCases;t++){
		
		 n=in.nextInt();
		
		 k=in.nextInt();
		
		 a=new long[n];
		
		 for(int i=0;i<n;i++){
			
			a[i]=in.nextLong();
			
		 }
		
		 solve();
		
		}
		
	}
	
   static void merge(long a[],int left,int right,int mid){
	
	int n1=mid-left+1,n2=right-mid;
	
	long L[]=new long[n1];
	
	long R[]=new long[n2];
	
	for(int i=0;i<n1;i++){
		
		L[i]=a[left+i];
		
	}
	
	for(int i=0;i<n2;i++){
		
		R[i]=a[mid+1+i];
		
	}
	
	int i=0,j=0,k=left;
	
	while(i<n1 && j<n2){
		
		if(L[i]<=R[j]){
			
			a[k]=L[i];
			
			i++;
			
		}else{
			
			a[k]=R[j];
			
			j++;
			
		}
		
		k++;
		
	}
	
	while(i<n1){
		
		a[k]=L[i];
		
		i++;
		k++;
		
	}
	
	while(j<n2){
		
		a[k]=R[j];
		
		j++;
		k++;
		
	}
	
  }

  static void sort(long a[],int left,int right){
	
	if(left>=right){
		
		return;
		
   }
	
	int mid=(left+right)/2;
	
	sort(a,left,mid);
	
	sort(a,mid+1,right);
	
	merge(a,left,right,mid);
	
  }
	
}