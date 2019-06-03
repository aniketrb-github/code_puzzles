package data_structures_algorithms;

/**
 * This question was asked as at FIS Global in 1st round(pen-paper puzzle)
 * @author Aniket Bharsakale
 */
public class FindMidElementOfSLL {
	
	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		list = SingleLinkList.createLinkedList(list);
		System.out.println("middle Index of list: "+SingleLinkList.findTheCentreIndexOfList(list));
	}

}

/**
 * Single linked list
 * @author Aniket Bharsakale
 */
class SingleLinkList {
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
	 * Returns the middle index location of the linked list
	 * @param list
	 * @return
	 */
	public static int findTheCentreIndexOfList(SingleLinkList list) {
		Node currentNode = list.head;
		int count = 0;
		int mid = 0;
		
		while (currentNode != null) {
			currentNode = currentNode.next;
			count++;

			if (count % 2 == 0)
				mid++;
			else if(currentNode == null && count % 2 != 0)
				mid++;
		}
		
		return mid;
	}
	
	/**
	 * manual node creation for time being to solve the actual puzzle
	 * @param linkList
	 * @return
	 */
	public static SingleLinkList createLinkedList(SingleLinkList linkList) {
		// Creating a Node
		Node node1 = createSingleNode(1);
		linkList.head = node1;		// assigning node1 as the head node
		
		// Create a 2nd Node 
		Node node2 = createSingleNode(2);
		linkList.head.next = node2;	// attach 2nd node to 1st node
		
		// Create a 3rd Node 
		Node node3 = createSingleNode(3);
		node2.next = node3;
		
		Node node4 = createSingleNode(4);
		node3.next = node4;
		
		Node node5 = createSingleNode(5);
		node4.next = node5;
		
		Node node6 = createSingleNode(6);
		node5.next = node6;
		
		Node node7 = createSingleNode(7);
		node6.next = node7;
		
		printList(linkList);
		return linkList;
	}
	
	public static Node createSingleNode(int data) {
		return new Node(data);
	}
	
	public static void printList(SingleLinkList list ) {
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
	
}