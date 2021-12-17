import java.util.Scanner;

public class B_Balanced_Tunnel{
	
	static Scanner in=new Scanner(System.in);
	
	static int n;
	
	static int enter[],exit[];
	
	static void solve(){
		
		int indexOut[]=new int[n+1];
		
		for(int i=0;i<n;i++){
			
			indexOut[exit[i]]=i;
			
		}
		
		int max=indexOut[0];
		
		int ans=0;
		
		for(int i=0;i<n;i++){
			
			if(max>indexOut[enter[i]] ){
				
				ans++;
				
			}else{
				
				max=indexOut[enter[i]];
				
			}
			
		}
		
		System.out.print(ans);
		
		/*Stack<Integer> entry=new Stack<>();
		
		Stack<Integer> outry=new Stack<>();
		
		int max=enter[0];
		
		for(int i=n-1;i>=0;i--){
			
			entry.push(enter[i] );
			
			outry.push(exit[i] );
			
			max=Math.max(max,enter[i] );
			
		}
		
		//entry.print();
		//outry.print();
		
		boolean visited[]=new boolean[max+1];
		
		int ans=0;
		
		while(!entry.isEmpty() && !outry.isEmpty() ){
			
			try{
			
			 if( !entry.isEmpty() && visited[entry.top() ]  ){
				
				entry.pop();
				
				continue;
				
			 }
			 
			 if( !outry.isEmpty() && visited[outry.top()] ){
				 
				 outry.pop();
				 
				 continue;
				 
			 }
			
			}catch(ArrayIndexOutOfBoundsException w){
				
				break;
				
			}
			
			try{
			
			 if( !visited[entry.top()] && !visited[outry.top()] && entry.top()!=outry.top() ){
				
				ans++;
				
				visited[outry.top()]=true;
				outry.pop();
				//visited[entry.pop()]=true;
				
			 }
			
			}catch(ArrayIndexOutOfBoundsException w){
				
				break;
				
			}
			
			try{
			
			 if(entry.top()==outry.top() && !visited[entry.top()] && !visited[outry.top()] ){
				
				visited[entry.pop()]=true;
				visited[outry.pop()]=true;
				
			 }
			
			}catch(ArrayIndexOutOfBoundsException w){
				
				break;
				
			}
			
		}
		
		System.out.println(ans);*/
		
	}
	
	public static void main(String [] amit){
		
		n=in.nextInt();
		
		enter=new int[n];
		
		exit=new int[n];
		
		for(int i=0;i<n;i++){
			
			enter[i]=in.nextInt();
			
		}
		
		for(int i=0;i<n;i++){
			
			exit[i]=in.nextInt();
			
		}
		
		solve();
		
	}
	
	static class Node<T>{
		
		T data;
		
		Node<T> next;
		
		public Node(T data){
			
			this.data=data;
			this.next=null;
			
		}
		
	}
	
	static class Stack<T>{
		
		Node<T> node;
		
		int len;
		
		public Stack(){
			
			this.node=null;
			this.len=0;
			
		}
		
		void push(T data){
			
			Node<T> temp=new Node<>(data);
			
			temp.next=node;
			
			node=temp;
			
			len++;
			
		}
		
		int size(){
			
			return len;
			
		}
		
		boolean isEmpty(){
			
			return this.size()==0;
			
		}
		
	    T pop() throws ArrayIndexOutOfBoundsException {
			
			if(isEmpty() ){
				
				throw new ArrayIndexOutOfBoundsException();
				
			}
			
			T data=node.data;
			
			node=node.next;
			
			--len;
			
			return data;
			
		}
		
		T top(){
			
			if(isEmpty() ){
				
				throw new ArrayIndexOutOfBoundsException();
				
			}
			
			return node.data;
			
		}
		
		void print(){
			
			Node<T> temp=node;
			
			while(temp!=null ){
				
				System.out.print(temp.data+" " );
				
				temp=temp.next;
				
			}
			
			System.out.println();
			
		}
		
	}
	
}