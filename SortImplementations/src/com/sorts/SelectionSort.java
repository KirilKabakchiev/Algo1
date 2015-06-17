package com.sorts;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public int arr[];

	public SelectionSort(int array[]) {
		arr = array;
	}

	public void SelectSort() {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}
	
	public static void main(String[] args) {
		Random gen = new Random();
		int[] array = new int[50];
		for(int i = 0; i < array.length; i++){
			array[i] = gen.nextInt(150);
		}
		new SelectionSort(array).SelectSort();
		System.out.println(Arrays.toString(array));
	}
}
