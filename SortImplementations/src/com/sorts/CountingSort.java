package com.sorts;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public void countingSort(int[] array){
		int count[] = new int[Arrays.stream(array).max().getAsInt() + 1];
		//calculate frequency of each element
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		
		// noviq count[i] ste sudurja poziciqta na elementa v outputa
	    for (int i = 1; i <= count.length; ++i){
	        count[i] += count[i-1];
	    }
		
	    int[] result = new int[array.length];
	    
	    for(int i = 0; i < array.length; i++){
	    	
	    	result[count[array[i]]] = array[i];
	    	count[array[i]]--;
	    }
	    
		array = result;
	}
	
	public static void main(String[] args) {
			Random gen = new Random();
			int[] array = new int[50];
			for(int i = 0; i < array.length; i++){
				array[i] = gen.nextInt(150);
			}
			new QuickSort().sort(array);
			System.out.println(Arrays.toString(array));
		
	}
}
