package com.Klists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.structs.Heap;

public class KLists {

	public class Node implements Comparable<Node> {
		public int value;
		public Node next;

		public Node(int i, Node object) {
			value = i;
			next = object;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}

	public Node mergeLists(List<Node> lists) {
		Heap<GTuple<Integer, Integer>> heap = new Heap<GTuple<Integer, Integer>>();
		Node first = new Node(0, null);
		Node returnVal = first;
		int count = 0;

		for (int i = 0; i < lists.size(); i++) {
			heap.push(new GTuple<Integer, Integer>(lists.get(i).value, i));
			Node tempo = lists.get(i);
			while (tempo != null) {
				count++;
				tempo = tempo.next;
			}
		}

		int i = 0;
		int currentVal = -1234;
		int listNumber;
		while (i < count) {
			currentVal = heap.peek().first;
			listNumber = heap.peek().second;
			heap.pop();
			first.next = new Node(currentVal, null);
			first = first.next;
			if (lists.get(listNumber).next != null) {
				lists.set(listNumber, lists.get(listNumber).next);
				heap.push(new GTuple<Integer, Integer>(
						lists.get(listNumber).value, listNumber));
			}
			i++;
		}
		return returnVal.next;
	}

	public void printList(Node tempo) {
		while (tempo != null) {
			System.out.print(tempo.value + " ");
			tempo = tempo.next;
		}
		System.out.println();
	}
	
	public void sortList(Node tempo) {
		List<Integer> list = new ArrayList<Integer>();
		Node start = tempo;
		while (start != null) {
			list.add(start.value);
			start = start.next;
		}
		list.sort(null);
		for(int i = 0; i < list.size(); i++){
			tempo.value = list.get(i);
			tempo = tempo.next;
		}
		
	}

	public static void main(String[] args) {
		List<Node> lists = new ArrayList<>(5);
		KLists yes = new KLists();
		Random gen = new Random();

		Node node1 = yes.new Node(gen.nextInt(100), null);
		Node node2 = yes.new Node(gen.nextInt(100), null);
		Node node3 = yes.new Node(gen.nextInt(100), null);
		Node node4 = yes.new Node(gen.nextInt(100), null);
		Node node5 = yes.new Node(gen.nextInt(100), null);
		
		Node first = node1;
		Node second = node2;
		Node third = node3;
		Node fourth = node4;
		Node fifth = node5;

		for (int i = 0; i < 5; i++) {
			first.next = yes.new Node(gen.nextInt(100), null);
			second.next = yes.new Node(gen.nextInt(100), null);
			third.next = yes.new Node(gen.nextInt(100), null);
			fourth.next = yes.new Node(gen.nextInt(100), null);
			fifth.next = yes.new Node(gen.nextInt(100), null);

			first = first.next;
			second = second.next;
			third = third.next;
			fourth = fourth.next;
			fifth = fifth.next;
		}

		yes.sortList(node1);
		yes.sortList(node2);
		yes.sortList(node3);
		yes.sortList(node4);
		yes.sortList(node5);
		
		yes.printList(node1);
		yes.printList(node2);
		yes.printList(node3);
		yes.printList(node4);
		yes.printList(node5);
		
		lists.add(node1);
		lists.add(node2);
		lists.add(node3);
		lists.add(node4);
		lists.add(node5);
		
		Node mergeLists = yes.mergeLists(lists);
		yes.printList(mergeLists);
	}
}
