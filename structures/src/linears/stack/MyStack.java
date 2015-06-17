package linears.stack;

import java.util.Arrays;

import linears.queue.MyQueue;

public class MyStack<T> {

	private MyQueue<T> q1, q2;
	
	public MyStack(){
		q1 = new MyQueue<>(); // push is O(1), new element is always pushed in q1
		q2 = new MyQueue<>(); //to pop : transition all elements except last from q1 to q2
							  //deque last element from q1 = it is the result
							  // swap names of queues
	}
	
	public T push(T elem){
		q1.push(elem);
		return elem;
	}
	
	public T pop(){
		
		T result = null;
		if(q2.isEmpty()){
			while(q1.size() > 1){
				
				T pop = q1.pop();
				System.out.println("waadasdasdasasd");
				q2.print();
				q1.print();
				System.out.println("Asdsadasdadasdas");
				q2.push(pop);
			}
			System.out.println("q1size=" + q1.size());
			System.out.println("q2size=" + q2.size());
			result = q1.pop();
			
			
			MyQueue<T> temp = q1;
			q1 = q2;
			q2 = temp;
			System.out.println(q1.size() + " " + q2.isEmpty());
		}
		else {
			System.out.println("something uncool happened in MyStack.pop()");
		}
		return result;
	}
	
	public T peek(){
		return null;
	}
	
	boolean empty(){
		return q1.isEmpty();
	}
	
	public int size(){
		return q1.size();
	}
	public void print(){
//		T[] tempo = (T[]) new Object[q1.getArr().size()];
//		for(int i = 0; i < q1.getArr().size(); i++){
//			tempo[i] = q1.getArr().getData()[i];
//		}
//		
//		//System.out.println(Arrays.toString(tempo));
//		MyQueue<T> temp = new MyQueue<>();
//		for(int i = 0; i < tempo.length; i ++){
//			temp.push(tempo[i]);
//		}
//		
//		//System.out.println("size " + temp.size());
//		int i =0;;
//		while(!temp.isEmpty()){
//			System.out.println(i++);
//			System.out.print("hey" + temp.pop() + " ");
//			//System.out.println("size " + temp.size());
//		}
//		System.out.println();
		q1.print();

	}
	
	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>();
		for(int i = 1; i < 6; i++){
			s.push(i);
			//s.print();
			//System.out.println("===");
		}
		s.print();
		System.out.println(s.pop());
		//s.print();
		System.out.println(s.pop());
		s.print();
		
	}
}
