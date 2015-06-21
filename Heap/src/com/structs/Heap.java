package com.structs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>> {

	private static final int top = 0;
	private List<T> heap;
	
	public Heap(){
		heap = new ArrayList<>();
	}

	public int getParent(int index) {
		return (index - 1) / 2;
	}

	public int getLeftChild(int index) {
		return 2 * index + 1;
	}

	public int getRightChild(int index) {
		return 2 * (index + 1);
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public int size() {
		return heap.size() - 1;
	}

	public void push(T data) {
		heap.add(data);
		siftUp(size());
	}

	public void pop() {
		heap.set(top, heap.get(size()));
		heap.remove(size());
		siftDown(top);
	}

	public T peek() {
		return heap.get(top);
	}

	public void makeHeap(List<T> data) {
		heap.addAll(data);
		// get the parent of the last element
		int current = getParent(heap.size());
		// while not on top => push the current element down, sorting the heap
		while (current >= 0) {
			siftDown(current);
			current--;
		}

	}

	public void siftUp(int index) {
		int currentIndex = index;
		int parentIndex = getParent(currentIndex);
		while (currentIndex >= top && heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
			Collections.swap(heap, currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = getParent(currentIndex);
		}
	}

	public void siftDown(int index) {
		int current = index;
	    int leftChild = getLeftChild(current);
	    int rightChild = getRightChild(current);
	    
	    while((leftChild <= size() && heap.get(current).compareTo(heap.get(leftChild)) > 0) ||
	            (rightChild <= size() && heap.get(current).compareTo(heap.get(rightChild)) > 0))
	    {
	    	 if(leftChild <= size() && rightChild <= size())
	         {
	             if(heap.get(leftChild).compareTo(heap.get(rightChild)) > 0)
	             {
	                 Collections.swap(heap, current, rightChild);
	                 current = rightChild;
	                 leftChild = getLeftChild(current);
	                 rightChild = getRightChild(current);
	             }
	             else
	             {
	            	 Collections.swap(heap, current, leftChild);
	                 current = leftChild;
	                 leftChild = getLeftChild(current);
	                 rightChild = getRightChild(current);
	             }
	         }
	         else if(rightChild <= size())
	         {
	        	 Collections.swap(heap, current, rightChild);
	             current = rightChild;
	             leftChild = getLeftChild(current);
	             rightChild = getRightChild(current);
	         }
	         else if(leftChild <= size())
	         {
	        	 Collections.swap(heap, current, leftChild);
	             current = leftChild;
	             leftChild = getLeftChild(current);
	             rightChild = getRightChild(current);
	         }
	    }
	   
	}
	
	public void heapSort(List<T> data){
    	makeHeap(data);
    	List<T> data2 = new ArrayList<>();
    	while(!heap.isEmpty()){
    		T elem = peek();
    		data2.add(elem);
    		pop();
    	}
    	Collections.copy(data, data2);
    }
	
	
	public static void main(String[] args) {
		Integer[] arr = { 5,6,8,9,2,1,3};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		new Heap<Integer>().heapSort(list);
		System.out.println(list);
	}

}
