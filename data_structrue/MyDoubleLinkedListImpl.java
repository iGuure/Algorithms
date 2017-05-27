class Node {
	String data;
	Node pre;
	Node next;
	public Node(String data) {
		this.data = data;
	}
}

class MyDoubleLinkedList {
	Node head;
	Node tail;

	public MyDoubleLinkedList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

	public void traverse() {
		Node temp = head;
		while (temp.next.data != null) {
			temp = temp.next;
			System.out.print(temp.data);
		}
		System.out.println();
	}

	public void invertedTraverse() {
		Node temp = tail;
		while (temp.pre.data != null) {
			temp = temp.pre;
			System.out.print(temp.data);
		}
		System.out.println();
	}

	public void insert(int i, String data) {
		Node newNode = new Node(data);
		Node temp = head;
		while (i-- != 1) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		newNode.pre = temp;
		temp.next.pre = newNode;
		temp.next = newNode;
	}

	public void remove(int i) {
		Node temp = head;
		while (i-- != 0) {
			temp = temp.next;
		}

		temp.next.pre = temp.pre;
		temp.pre.next = temp.next;
	}

}

public class MyDoubleLinkedListImpl {
	public static void main(String[] args) {
		Node head = new Node(null);
		Node wo = new Node("我");
		Node ai = new Node("爱");
		Node ni = new Node("你");
		Node tail = new Node(null);
		
		head.next = wo;
		wo.next = ai;
		ai.next = ni;
		ni.next = tail;

		tail.pre = ni;
		ni.pre = ai;
		ai.pre = wo;
		wo.pre = head;

		MyDoubleLinkedList dll = new MyDoubleLinkedList(head, tail);
		dll.traverse();
		dll.invertedTraverse();

		dll.remove(2);
		dll.insert(2, "喜欢");
		dll.traverse();
		dll.invertedTraverse();
	}
}