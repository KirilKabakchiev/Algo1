package linears.dynarray;

import java.util.Arrays;

public class DynArray<T> {

	private T[] data;
	private int size;
	private int capacity;
	private final static int DEFAULT_CAPACITY = 15;

	@SuppressWarnings( "unchecked" )  
	public DynArray(int capacity) {
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public DynArray() {
		this(DEFAULT_CAPACITY);
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 2);
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
			capacity = newCapacity;
		}
	}
	
	public void downSizeCapacity(){
		if(size*2 < capacity && size >=1){
			System.out.println(size + " " + capacity);
			 @SuppressWarnings("unchecked")
		        final T[] temp = (T[]) new Object[size];
		        System.arraycopy(data, 0, temp, 0, size);
		        data = temp;
		        capacity = size;
		    }
	}

	public boolean insert(int index, T value) throws IndexOutOfBoundsException {

		if(index < 0){
			throw new IndexOutOfBoundsException("Index out of bound bro!");
		}
		
		if(index >= size){
			System.out.println("Index is bigger than actual current size, inserting " + value + " at end");
			add(value);
			return true;
		}
		if (capacity == size) {
			ensureCapacity(capacity*2);
		}
		@SuppressWarnings( "unchecked" )  
		final T[] temp = Arrays.copyOf(data, capacity);
		for (int i = 0; i < index; i++) {
			temp[i] = data[i];
		}
		temp[index - 1] = value;
		for (int i = index; i < size + 1; i++) {
			temp[i] = data[i - 1];
		}
		size++;
		data = temp;
		return true;
	}

	public boolean add(T value) {
		if (capacity == size) {
			ensureCapacity(capacity*2);
		}
		data[size++] = value;
		return true;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException("No such index for the DynArray!");
		}
		return data[index-1];
	}
	
	public T remove(int index) throws IndexOutOfBoundsException {
		index-=1;
		T tempo = data[index];
		//System.out.println("tempo " + tempo);
		if(index >=0 && index < size){
		//	System.out.println(data[index]);
			for(int i = index; i < size-1; i++){
				data[i] = data[i+1];
			}
			data[size-1] = null;
			size--;
			downSizeCapacity();
			return tempo;
		}
		throw new IndexOutOfBoundsException("Bad index bro " + index);
	}
	
	public boolean pop(){
		if(size > 0){
			data[size-1] = null;
			size --;
			downSizeCapacity();
			return true;
		}
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public int capacity(){
		return capacity;
	}
	
	
	public T[] getData() {
		return data;
	}
	
	public void print(){
		System.out.println("DynArray: " + Arrays.toString(data) + "\n" + "Size: " + size + "\n" +  "Capacity: " + capacity);
	}

	public static void main(String[] args) {
		DynArray<Integer> arr = new DynArray<Integer>();
		for(int i = 0; i < 3; i++){
			arr.add(i);
		}
//		arr.add(25);
//		arr.insert(5, 33);
//		arr.remove(5);
////		
////		arr.pop();
////		
////		arr.remove(12);
////		arr.remove(12);
////		arr.remove(12);
////		arr.remove(12);
////		arr.remove(5);
////		arr.remove(3);
////		arr.remove(3);
////		arr.remove(3);
////		arr.remove(3);
////		//arr.remove(3);
//		arr.print();
//		arr.pop();
//		arr.print();
//		arr.add(5);
//		arr.print();
		
//		
		arr.print();
		arr.pop();
		arr.print();
		arr.pop();
		arr.print();
		arr.pop();
		arr.print();
		arr.pop();
		arr.print();
		arr.add(5);
		arr.print();
	}
	

}
