package com.sorts;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	private int[] inputArray;
	private int[] tempArray;
	private int length;

	public void sort(int inputArray[]) {
		this.inputArray = inputArray;
		this.length = inputArray.length;
		tempArray = new int[length];
		mergeSort(0, length - 1);
	}

	private void mergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

			mergeSort(lowerIndex, middle);

			mergeSort(middle + 1, higherIndex);

			mergeIt(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeIt(int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempArray[i] = inputArray[i];
		}

		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;

		while (i <= middle && j <= higherIndex) {
			if (tempArray[i] <= tempArray[j]) {
				inputArray[k] = tempArray[i];
				i++;
			} else {
				inputArray[k] = tempArray[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			inputArray[k] = tempArray[i];
			k++;
			i++;
		}

//		while (j <= higherIndex) {
//			inputArray[k] = tempArray[j];
//			k++;
//			j++;
//		}
	}
	
	public static void main(String[] args) {
		Random gen = new Random();
		int[] array = new int[50];
		for(int i = 0; i < array.length; i++){
			array[i] = gen.nextInt(150);
		}
		
		new MergeSort().sort(array);
		System.out.println(Arrays.toString(array));
	}
}
