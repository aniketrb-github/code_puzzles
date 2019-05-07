package data_structures_algorithms;

import java.util.Scanner;

public class LinkedList {
	
	// head of list
	Node head;
	
	// static class so that main() can access it
	static class Node {
		int data;
		Node next;
		
		// constructor for a new node creation
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		LinkedList linkList = new LinkedList();
		linkList = createLinkedList(linkList);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a Integer number to create & append a Node: ");
		int inputData = in.nextInt();
		
		appendNodeToList(linkList, inputData);
		
		System.out.println("Please enter a Integer number to create & prefix a Node: ");
		inputData = in.nextInt();
		prefixNodeToList(linkList, inputData);
		
		in.close();
	}
	
	/**
	 * Creates an initial linked list with 3 nodes namely, 1->2->3->null 
	 * @param linkList
	 * @return
	 */
	private static LinkedList createLinkedList(LinkedList linkList) {
		// Creating a Node
		Node node1 = createNewNode(1);
		linkList.head = node1;		// assigning node1 as the head node
		
		// Create a 2nd Node 
		Node node2 = createNewNode(2);
		linkList.head.next = node2;	// attach 2nd node to 1st node
		
		// Create a 3rd Node 
		Node node3 = createNewNode(3);
		node2.next = node3;
		printLinkedList(linkList);
		return linkList;
	}

	/**
	 * Create a new node for given data
	 * @param data is the content with which we need to create a new node
	 * @return the newly created node
	 */
	public static Node createNewNode(int data) {
		return new Node(data);
	}
	 
	/**
	 * Prints the given list
	 * @param list
	 */
	public static void printLinkedList(LinkedList list) {
		Node currentNode = null;
		if(list.head != null) {
			currentNode = list.head;
			
			System.out.print("LinkedList: ");
			
			while(currentNode != null) {
				System.out.print(currentNode.data +" ");
				currentNode = currentNode.next; // increment to next node
			}
		} else {
			System.out.println("The Linked List is Empty!");
		}
		System.out.println();
	}
	
	/**
	 * Creates a new node & appends the new node at end of the existing list
	 * @param list the existing linked list
	 * @param data the node to be created & inserted 
	 * @return list with the new node appended to it
	 */
	public static LinkedList appendNodeToList(LinkedList list, int data) {
		Node newNode = createNewNode(data);
		
		// if given list is empty, then make the incoming node as 1st node
		if(list.head == null) {
			list.head = newNode;
		} else {
			Node lastNode = list.head;
			// traverse to the end of the list to get hold of the last node
			while (lastNode.next != null) {
				lastNode = lastNode.next; // increment to next node
			}
			// once last node is found, we make the newNode as the lastNode
			lastNode.next = newNode;
		}
		printLinkedList(list);
		return list;
	}
	
	/**
	 * Creates a new node with given data & prefixes that node to the start of the given linked list
	 * @param list
	 * @param data
	 * @return list with the new node prefixed to it
	 */
	public static LinkedList prefixNodeToList(LinkedList list, int data) {
		Node newNode = createNewNode(data);
		
		// if List is empty, the created node becomes the 1st node & the only node in the list
		if(list.head == null) {
			list.head = newNode;
		} else {
		// if list is not empty, prefix the created node to be the 1st node of existing list
			
			Node oldFirstNode = list.head; 	// get hold of the existing 1st node
			list.head = newNode;			// make newNode as 1st node in list
			list.head.next = oldFirstNode;	// append oldFirstNode to latest/newest 1st node
		}
		printLinkedList(list);
		return list;
	}
	
	/**
	 * 
	 * @param list
	 * @param data
	 * @return
	 */
	public static LinkedList insertNodeAfter(LinkedList list, int data, int afterNodeData) {
		Node newNode = createNewNode(data);
		Node currentNode = list.head;
		boolean isNodePresent = false;
		// check if afterNodeData exist in the given list
		while(currentNode.next != null) {
			if(currentNode.data == afterNodeData) {
				isNodePresent = true;
				break;
			}
			currentNode = currentNode.next; // increment to next node
		}
		
		Node tempNode = null;
		if(isNodePresent) {
			currentNode = list.head;
			while(currentNode.next != null) {
				if(currentNode.data == afterNodeData) {
					tempNode = currentNode;
				}
				currentNode = currentNode.next;
			}
			
		} else {
			System.out.println("Given Node does not exist in the Linked List!");
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param list
	 * @param data
	 * @return
	 */
	public static LinkedList insertNodeBefore(LinkedList list, int data, int beforeNodeData) {
		Node newNode = createNewNode(data);
		
		return list;
	}
	
}
