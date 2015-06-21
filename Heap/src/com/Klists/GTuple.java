package com.Klists;


public class GTuple<T extends Comparable<T>, V> implements
		Comparable<GTuple<T, V>> {
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

	@Override
	public int compareTo(GTuple<T, V> o) {
		
		return this.first.compareTo(o.first);
	}

}