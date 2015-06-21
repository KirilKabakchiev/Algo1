package com.KthMin;

import java.util.ArrayList;
import java.util.List;

import com.structs.Heap;

public class KthMin {
	public int kthMin(List<Integer> numbers, int k){
		Heap<Integer> heap = new Heap<>();
		heap.makeHeap(numbers);
		Integer min = null; int i;
		for(i = 0; i < k; i++){
			min = heap.peek();
			heap.pop();
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i < 5; i++){
			list.add(i);
		}
		System.out.println(new KthMin().kthMin(list, 3));
	}
}
