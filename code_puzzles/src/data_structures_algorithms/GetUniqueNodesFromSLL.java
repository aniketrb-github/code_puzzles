package data_structures_algorithms;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Input : 5 -> 3 -> 3 -> 1 -> 1 -> null
 * Output: 5 -> 3 -> 1 -> null
 * Get the distinct nodes from the Singly Linked List
 * 
 * @author Aniket.Bharsakale
 */
public class GetUniqueNodesFromSLL {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		// Integer data[] = {5, 3, 3, 1, 1};
		SingleLinkedList.createLinkedList(list);
		list.getUniqueSinglyLinkedList(list);
	}

}

class SingleLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
	 * deletes the duplicate nodes from a singly linked list
	 * @param list containing duplicate nodes
	 * @return the filtered linked list
	 */
	public SingleLinkedList getUniqueSinglyLinkedList(SingleLinkedList list) {
		Node currentNode = null;
		Set<Integer> set = null;
		if (list != null) {
			currentNode = list.head;
			set = new LinkedHashSet<>();
			
			while (currentNode != null) {
				set.add(currentNode.data);
				currentNode = currentNode.next;
			}
			//LinkedList<Integer> filteredList = new LinkedList<>(set);
			//for(Integer data : filteredList) {
			for(Integer data : set) {
				System.out.print(data+"->");
			}
			System.out.println("NULL");
			
		} else
			return null;

		return list;
	}

	public static Node createNode(int data) {
		return new Node(data);
	}

	public static void printList(SingleLinkedList list) {
		Node currentNode = list.head;
		while (currentNode != null ) {
			System.out.print(currentNode.data + "->");
			currentNode = currentNode.next;
		}
		System.out.println("NULL");
	}
	
	public static SingleLinkedList createLinkedList(SingleLinkedList linkList) {
		// Creating a Node
		Node node1 = createNode(5);
		linkList.head = node1;		// assigning node1 as the head node
		
		// Create a 2nd Node 
		Node node2 = createNode(3);
		linkList.head.next = node2;	// attach 2nd node to 1st node
		
		// Create a 3rd Node 
		Node node3 = createNode(3);
		node2.next = node3;
		
		Node node4 = createNode(1);
		node3.next = node4;
		
		
		Node node5 = createNode(1);
		node4.next = node5;
		
		printList(linkList);
		return linkList;
	}

	/*
	public SingleLinkedList createSLL(Integer data[]) {
		SingleLinkedList sll = null;
		Node newNode = null;
		Node currentNode = null;

		if(data.length != 0) {
			sll = new SingleLinkedList();
			
			for (int i = 0; i < data.length; i++) {
				newNode = createNode(data[i]);

				if(sll.head == null) {
					currentNode = newNode;
					sll.head = currentNode;
				} else {
					currentNode = newNode;
				}

			}	
		} else {
			return new SingleLinkedList();
		}
		return sll;
	}
	*/
}
