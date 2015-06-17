package tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import searches.BinarySearch;

public class Quadroplets {
	private BinarySearch bs = new BinarySearch();

	public int zero_quadruplets_count(Integer[] a, Integer[] b, Integer[] c, Integer[] d) {
		Integer[] concated = prepareAndConcat(a,b,c,d);
		//unfinished
		return 0;
	}

	private Integer[] prepareAndConcat(Integer[] a, Integer[] b, Integer[] c, Integer[] d) {
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		Arrays.sort(d);
		return concatAll(a,b,c,d);
	}
	
	public <T> T[] concatAll(T[] first, T[]... rest) {
		  int totalLength = first.length;
		  for (T[] array : rest) {
		    totalLength += array.length;
		  }
		  T[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (T[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}

	public int fourSum(int[] array) {
		int count = 0;
		List<Integer> summedPairs = summedPairs(array);
		Integer[] arr = summedPairs.toArray(new Integer[summedPairs.size()]);
		Arrays.sort(arr);

		int i = 0;
		while (i < arr.length && arr[i] <= 0) {

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == 0) {
					System.out.println(arr[i] + " + " + arr[j]);
					count++;
				}
			}
			i++;
		}
		return count;
	}

	List<Integer> summedPairs(int[] array) {
		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (i != j) {
					res.add(array[i] + array[j]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, -6 };
		// List<Integer> summedPairs = new Quadroplets().summedPairs(array);
		// System.out.println(summedPairs);
		System.out.println(new Quadroplets().fourSum(array));

	}
}
