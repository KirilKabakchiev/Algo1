package tasks;

import helper.Tuple;

import java.util.Arrays;

import searches.BinarySearch;

public class BirthdayRanges {

	private final BinarySearch bs = new BinarySearch();

	public int[] birthday_count(int[] birthdays, Tuple[] ranges) {
		Arrays.sort(birthdays);
		int[] res = new int[ranges.length];
		for (int i = 0; i < ranges.length; i++) {
			Tuple tuple = ranges[i];

			int firstToCount = bs.binarySearchGreaterOrEq(birthdays, tuple.left, 0,
					birthdays.length - 1);
			if (tuple.left > birthdays[birthdays.length - 1]) {
				res[i] = 0;
				continue;
			}

			// na purvo vreme e first to not count..
			int lastToCount = bs.binarySearchGreaterOrEq(birthdays, tuple.right, 0,
					birthdays.length - 1);
			if (tuple.right < birthdays[0]) {
				res[i] = 0;
				continue;
			}
			if (tuple.right < birthdays[lastToCount]) {
				lastToCount--;
			}

			res[i] = lastToCount - firstToCount + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] birthdays = { 3, 5, 8, 12, 333 };
		Tuple[] ranges = { new Tuple(3, 5), new Tuple(3, 345),new Tuple(2,345),
				new Tuple(7, 11), new Tuple(0, 2), new Tuple(344, 355), new Tuple(0,2) };
		
		System.out.println(Arrays.toString(new BirthdayRanges().birthday_count(birthdays,ranges)));
//		
//		Tuple[] ranges2 = {new Tuple(7,18)};
//		System.out.println(Arrays.toString(new BirthdayRanges().birthday_count(birthdays,ranges2)));
		
	}
}
