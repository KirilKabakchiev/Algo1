package linears.queue;

import linears.dynarray.DynArray;


public class MyQueue<T> {

	private DynArray<T> arr;
	
	public MyQueue(){
		arr = new DynArray<T>();
	}
	
	public MyQueue(T[] data){
		
	}
	
	public DynArray<T> getArr() {
		return arr;
	}

	
	public int size() {
		return arr.size();
	}

	public boolean isEmpty() {
		return arr.size() == 0;
	}

	public boolean push(T e) {
		return arr.add(e);
	}

	
	public T peek() throws IndexOutOfBoundsException {
		return arr.get(1);
	}

	public T pop() throws IndexOutOfBoundsException {
		return arr.remove(1);
	}
	
	public void print(){
		arr.print();
	}
	
	public void clear(){
		while(!arr.isEmpty()){
			arr.pop();
		}
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		
		for (int i = 0; i < 5; i++) {
			q.push(i);
			q.print();
		}
		
		for (int i = 0; i < 3; i++) {
			q.pop();
			q.print();
		}
		
		System.out.println("Peek --> " + q.peek());
		System.out.println("==================");
		q.clear();
		q.print();
		System.out.println("=====================");
		q.push(1);
		q.print();
		System.out.println(q.isEmpty());
		q.pop();
		q.print();
		System.out.println(q.isEmpty());
		q.push(5);
		q.print();
		q.pop();
		q.print();
		//q.pop();
		q.print();


	}

}
