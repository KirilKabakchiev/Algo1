package helper;

public class GTuple<T, V> {
	public T first;
	public V second;

	public GTuple(T left, V right) {
		first = left;
		second = right;
	}

	@Override
	public String toString() {
		return "(" + first + "; " + second + ")";
	}
}