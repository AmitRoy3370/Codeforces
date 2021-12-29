import java.util.Scanner;

public class C_Set_or_Decrease{
	
	static Scanner in=new Scanner(System.in);
	
	static int testCases,n;
	
	static long a[];
	
	static long wantedSum;
	
	static void solve(){
		
		if(n==1){
			
			if(a[0]<=wantedSum ){
				
				System.out.println(0);
				
			}else{
				
				System.out.println((-wantedSum+a[0]) );
				
			}
			
			return;
			
		}
		
		long sum=0;
		
		for(long i: a){
			
			sum+=i;
			
		}
		
		if(sum<=wantedSum){
			
			System.out.println(0);
			
			return;
			
		}
		
		sort(a,0,n-1);
		
		long step=Math.max(sum-wantedSum,0);
		
		for(int i=1;i<n;i++){
			
			sum-=a[n-i]-a[0];
			
			long t=sum>wantedSum?(sum-wantedSum+i)/(i+1):0;
			
			step=Math.min(step,t+i);
			
		}
		
		System.out.println(step);
		
		//System.out.println("sum after iterate: "+sum);
		
		//System.out.println("ans: "+ans);
		
	}
	
	public static void main(String [] amit){
		
		testCases=in.nextInt();
		
		for(int t=0;t<testCases;t++){
			
			n=in.nextInt();
			
			wantedSum=in.nextLong();
			
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
