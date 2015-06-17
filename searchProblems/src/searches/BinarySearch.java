package searches;

public class BinarySearch {
	public static final int KEY_MISSING = -122534;

	public int binarySearch(int A[], int key, int from, int to) {
		int mid = 0;
		while (to - from >= 0) {
			mid = from + (to - from) / 2;
			if (key == A[mid]) {
				return mid;
			} else if (A[mid] > key) {
				to = mid - 1;
			} else {
				from = mid + 1;
			}
		}
		return mid;
	}
	
	public int binarySearchGreaterOrEq(int A[], int key, int from, int to) {
		int mid = 0;
		while (to - from >= 0) {
			mid = from + (to - from) / 2;
			if (key == A[mid]) {
				return mid;
			} else if (A[mid] > key) {
				if(from == to){
					return mid;
				}
				to = mid;
			} else {
				from = mid + 1;
			}
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int array[] = { 5,8,22,45,66,88};
		int[] birthdays = { 3, 5, 8, 12, 333 };
		int binarySearch = new BinarySearch().binarySearch(array, 6, 0, array.length-1);
		System.out.println(binarySearch);
	}
}
