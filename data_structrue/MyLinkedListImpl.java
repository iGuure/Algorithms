class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;
	public LinkedList(Node head) {
		this.head = head;
	}
	public LinkedList(int num) {
		head = new Node(0);
		Node preNode = head;
		while (num-- != 0) {
			Node newNode = new Node(num);
			preNode.next = newNode;
			preNode = newNode;
		}
		preNode.next = null;
	}

	public void traverse() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	public int getElem(int i) {
		Node temp = head;
		while (i-- != 0) {
			temp = temp.next;
		}
		return temp == null ? null : temp.data;
	}

	public void insert(int i, int data) {
		if (i <= 0)	return;
		Node newNode = new Node(data);

		Node temp = head;
		while (i-- != 1) {
			temp = temp.next;
			if (temp == null)	return;
		}

		
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public void delete(int i) {
		if (i <= 0)	return;
		Node temp = head;
		while (i-- != 1) {
			temp = temp.next;
			if (temp == null)	return;
		}
		if (temp.next == null) return;
		temp.next = temp.next.next;
	}

}

public class MyLinkedListImpl {
	public static void main(String[] args) {
		Node head = new Node(0);
		LinkedList ll = new LinkedList(head);
		ll.insert(1, 2);
		ll.insert(2, 5);
		ll.insert(3, 10);
		ll.insert(4, 23);
		ll.traverse();

		Node head2 = new Node(0);
		LinkedList ll2 = new LinkedList(head2);
		ll2.insert(1, 4);
		ll2.insert(2, 6);
		ll2.insert(3, 40);
		ll2.traverse();

		LinkedList ll3 = merge(ll, ll2);
		ll3.traverse();
	}

	public static LinkedList merge(LinkedList la, LinkedList lb) {
		Node head = new Node(0);
		Node temp = head, na = la.head, nb = lb.head;
		na = na.next;
		nb = nb.next;
		while (na != null && nb != null) {
			if (na.data < nb.data) {
				temp.next = na;
				na = na.next;
				temp = temp.next;
			} else {
				temp.next = nb;
				nb = nb.next;
				temp = temp.next;
			}
		}
		if (na == null)	temp.next = nb;
		else	temp.next.next = na;
		LinkedList result = new LinkedList(head);
		return result;
	}

}