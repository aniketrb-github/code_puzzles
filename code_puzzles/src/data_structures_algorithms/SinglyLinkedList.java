package data_structures_algorithms;

import java.util.Scanner;

/**
 * Singly Linked List(SLL) Implementation in Java
 * Basic Linked List operations over SLL like follows: 
 * DONE -> 1.a) appendTheNodeAtEnd 1.b) prefixTheNodeAtStart 1.c) insertNodeBefore 1.d) insertNodeAfter
 * TODO -> 2.a) delete a given node
 * TODO -> 3.a) modifyNodeAtEnd 3.b) modifyNodeAtStart 3.c) modifyNodeInBetween
 * 
 * @author Aniket Bharsakale
 */
public class SinglyLinkedList {
	
	// Reference to the Static Inner Class represents as the Head pointer of Linked List
	Node head;
	
	// The Node class is made static class so that main() can access it.
	static class Node {
		int data;
		Node next;
		
		// constructor for a new node creation
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Driver Method
	public static void main(String[] args) {
		SinglyLinkedList linkList = new SinglyLinkedList();
		linkList = createLinkedList(linkList);
		int inputData = 0;
		int afterNodeData = 0;
		
		Scanner in = new Scanner(System.in);
		
		// APPEND NODE
		System.out.println("Enter an INTEGER no. to create & APPEND this node at the end of the existing List: ");
		inputData = in.nextInt();
		appendNodeToList(linkList, inputData);

		// PREFIX A NODE TO LIST
		System.out.println("Enter an INTEGER no. to create & PREFIX this node a Node: ");
		inputData = in.nextInt();
		prefixNodeToList(linkList, inputData);

		// INSERT NODE 
		System.out.println("Please enter an Integer number to insert it in between the linked list: ");
		inputData = in.nextInt();
		System.out.println("After which node do u want to insert the new node? Please enter a Integer number: ");
		afterNodeData = in.nextInt();
		insertNodeAfter(linkList, inputData, afterNodeData);
		
		// INSERT NODE BEFORE A NODE
		System.out.println("Please enter an Integer number to insert it in between the linked list: ");
		inputData = in.nextInt();
		System.out.println("After which node do u want to insert the new node? Please enter a Integer number: ");
		afterNodeData = in.nextInt();
		insertNodeBefore(linkList, inputData, afterNodeData);
		
		
		System.out.println("Please enter an integer number to DELETE from linked list: ");
		inputData = in.nextInt();
		printLinkedList(linkList);
		deleteGivenNode(linkList, inputData);
		
		
		System.out.println("Please enter an integer number to UPDATE from linked list: ");
		inputData = in.nextInt();
		System.out.println("Enter the new Data to update in list");
		int newData = in.nextInt();
		updateGivenNode(linkList, inputData, newData);
		
		in.close();
	}
	
	/**
	 * Creates an initial linked list with 3 nodes namely, 1->2->3->null 
	 * @param linkList
	 * @return
	 */
	private static SinglyLinkedList createLinkedList(SinglyLinkedList linkList) {
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
	public static void printLinkedList(SinglyLinkedList list) {
		Node currentNode = null;
		if(list.head != null) {
			currentNode = list.head;
			
			System.out.print("LinkedList: ");
			
			// traverse through the linked list i.e head reaches the null value
			while(currentNode != null) {
				System.out.print("["+currentNode.data +"] -> ");
				currentNode = currentNode.next; // increment to next node
			}
			System.out.println("NULL");
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
	public static void appendNodeToList(SinglyLinkedList list, int data) {
		Node newNode = createNewNode(data);
		Node lastNode = null;
		// if given list is empty, then make the incoming node as 1st node
		if(list.head == null) {
			list.head = newNode;
		} else {
			lastNode = list.head; // assume head as the only node in list or there can be many more 
			
			// traverse to the LAST NODE of the list & capture the last node
			while(lastNode.next != null) {
				lastNode = lastNode.next; // increment to next node
			}
			// once last node is found, we make the newNode as the lastNode
			lastNode.next = newNode;
		}
		printLinkedList(list);
	}
	
	/**
	 * Creates a new node with given data & prefixes that node to the start of the given linked list
	 * @param list
	 * @param data
	 * @return list with the new node prefixed to it
	 */
	public static void prefixNodeToList(SinglyLinkedList list, int data) {
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
	}
	
	/**
	 * Creates a Node of given data & inserts this node after the mentioned node in the given list
	 * @param list
	 * @param data
	 * @return
	 */
	public static void insertNodeAfter(SinglyLinkedList list, int data, int afterNodeData) {
		Node newNode = createNewNode(data);	// create new node to be inserted using given data
		Node currentNode = list.head;		// get hold of 1st node in list

		// check if the given node exist in given linked List 
		boolean isNodePresent = checkIfNodeExistInList(list, afterNodeData);
		
		Node nextNode = null;
		if(isNodePresent) {
			currentNode = list.head;	// get the 1st node
			
			// traverse through the linked list i.e head reaches the null value
			while(currentNode != null) {
				if(currentNode.data == afterNodeData) {
					nextNode = currentNode.next;// get hold of nextNode 
					currentNode.next = newNode;	// make the currentNode point to the newNode
					newNode.next = nextNode;	// make the newNode point to the saved nextNode
					break;
				}
				currentNode = currentNode.next;
			}
			
		} else {
			System.out.println("Given Node does not exist in the Linked List!");
		}
		printLinkedList(list);
	}
	
	/**
	 * 
	 * @param list
	 * @param data
	 * @return 
	 */
	public static void insertNodeBefore(SinglyLinkedList list, int data, int beforeNodeData) {
		Node newNode = createNewNode(data);
		Node currentNode = list.head;
		Node previousNode = null;
		
		// check if the given node exist in given linked List 
		boolean isNodePresent = checkIfNodeExistInList(list, beforeNodeData);
		
		if(isNodePresent) {
			
			while(currentNode != null) {
				if(currentNode.data == beforeNodeData) {
					
					// if we want to append a node before the 1st node of the list
					if(previousNode == null) {
						newNode.next = list.head;	// make the newNode point to the existing 1st node of the list
						list.head = newNode;		// now make the newNode the new/latest/updated head pointer of list
					} else { 	
						previousNode.next = newNode;
						newNode.next = currentNode;
					}
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.next;	// node incrementor 
			}
		}
		printLinkedList(list);
	}
	
	/**
	 * Checks if a node is present in the given list or not
	 * @param Linked list containing nodes
	 * @param nodeToCheck is the node to be checked in the given list
	 * @return returns true/false boolean value as result
	 */
	private static boolean checkIfNodeExistInList(SinglyLinkedList list, int nodeToCheck) {
		Node currentNode = list.head;
		
		// traverse until last node in list, i.e until head pointer reaches the null value
		while (currentNode != null) {
			if (currentNode.data == nodeToCheck)
				return true;
			currentNode = currentNode.next; // increment to next node
		}
		return false;
	}
	
	/**
	 * Deletes a given node from the given linked list
	 * @param list
	 * @param nodeToDelete
	 */
	private static void deleteGivenNode(SinglyLinkedList list, int nodeToDelete) {
		if(checkIfNodeExistInList(list, nodeToDelete) ) {
			Node currentNode = list.head;
			Node previousNode = null;
			
			while(currentNode != null) {
				if (currentNode.data == nodeToDelete) {
					if (previousNode == null) {
						list.head = currentNode.next; 
						currentNode.next = null; // deleting a node is nothing but isolating & separating it from list
					} else {
						previousNode.next = currentNode.next; // attaching the next node with previous node
						currentNode.next = null;
					}
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.next; // increment
			}
		} else {
			System.out.println("Given Node does not exist in the Linked List!");
		}
		printLinkedList(list);
	}
	
	/**
	 * Updates the value of a given node to desired value in given linked list
	 * @param list
	 * @param nodeToDelete
	 */
	private static void updateGivenNode(SinglyLinkedList list, int nodeToUpdate, int newData) {
		if(checkIfNodeExistInList(list, nodeToUpdate) ) {
			Node currentNode = list.head;
			
			while(currentNode != null) {
				if (currentNode.data == nodeToUpdate) {
					currentNode.data = newData;
					break;
				}
				currentNode = currentNode.next; // increment node wise
			}
		} else {
			System.out.println("Given Node does not exist in the Linked List!");
		}
		printLinkedList(list);
	}
	
}
