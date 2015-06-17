package com.sorts;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	
	public void insertionSort(int array[]) {
		int n = array.length;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}
	
	
	public static void main(String[] args) {
		Random gen = new Random();
		int[] array = new int[50];
		for(int i = 0; i < array.length; i++){
			array[i] = gen.nextInt(150);
		}
		
		new InsertionSort().insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
