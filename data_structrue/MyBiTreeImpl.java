import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

class MyBiTree {
	Node head;

	public MyBiTree(Node head) {
		this.head = head;
	}

	public boolean empty() {
		return head.left == null;
	}

	public void preOrderTraverse() {
		// if (empty())	return;
		// preOrderTraverseRecursion(head.left);
		// System.out.println();

		List<Node> stack = new ArrayList<Node>();
		System.out.print(head.left.data + " ");
		// 首先将根结点加进来
		stack.add(0, head.left);
		Node temp;
		// 栈不为空时执行三个操作
		while (stack.size() > 0) {
			// 1. 如果栈顶元素为空，则移除；如果不为空，则把栈顶元素的左子树一路入栈到底
			if (stack.get(0) == null) {
				stack.remove(0);
			} else {
				temp = stack.get(0);
				while (temp.left != null) {
					temp = temp.left;
					System.out.print(temp.data + " ");
					stack.add(0, temp);
				}
			}
			// 2. 如果栈不为空，移除栈顶元素，再把栈顶元素的右孩子入栈（有可能是null）
			if (stack.size() > 0) {
				temp = stack.remove(0);
				if (temp.right != null)
					System.out.print(temp.right.data + " ");
				stack.add(0, temp.right);
			}

		}
		System.out.println();
	}

	public void preOrderTraverseRecursion(Node node) {
		if (node == null)	return;
		System.out.print(node.data + " ");
		preOrderTraverseRecursion(node.left);
		preOrderTraverseRecursion(node.right);
	}

	public void inOrderTraverse() {
		// if (empty())	return;
		// inOrderTraverseRecursion(head.left);
		// System.out.println();

		List<Node> stack = new ArrayList<Node>();
		stack.add(0, head.left);
		Node temp;
		while (stack.size() > 0) {
			if (stack.get(0) == null) {
				stack.remove(0);
			} else {
				temp = stack.get(0);
				while (temp.left != null) {
					temp = temp.left;
					stack.add(0, temp);
				}
			}
			if (stack.size() > 0) {
				temp = stack.remove(0);
				System.out.print(temp.data + " ");
				stack.add(0, temp.right);
			}
		}
		System.out.println();
	}

	public void inOrderTraverseRecursion(Node node) {
		if (node == null)	return;
		inOrderTraverseRecursion(node.left);
		System.out.print(node.data + " ");
		inOrderTraverseRecursion(node.right);
	}

	public void postOrderTraverse() {
		// if (empty())	return;
		// postOrderTraverseRecursion(head.left);
		// System.out.println();

		List<Node> stack = new ArrayList<Node>();
		// 先把根结点加进去
		stack.add(0, head.left);
		Node temp, pre = null;
		temp = head.left;
		// 将根结点的左边入栈到底
		while (temp.left != null) {
			temp = temp.left;
			stack.add(0, temp);
		}
		while (stack.size() > 0) {
			temp = stack.get(0);
			// 首先判断栈顶元素有没有右子树
			if (temp.right != null) {
				// 如果有，判断是不是刚刚输出过的
				// 如果不是，则将右结点入栈，再遍历右结点的左子树到底
				if (pre != temp.right) {
					temp = temp.right;
					stack.add(0, temp);
					while (temp.left != null) {
						temp = temp.left;
						stack.add(0, temp);
					}
				// 如果是，直接输出该结点
				} else {
					pre = temp = stack.remove(0);
					System.out.print(temp.data + " ");
				}
			// 如果没有，则直接输出该结点
			} else {
				pre = temp = stack.remove(0);
				System.out.print(temp.data + " ");
			}
		}
		System.out.println();
	}

	public void postOrderTraverseRecursion(Node node) {
		if (node == null)	return;
		postOrderTraverseRecursion(node.left);
		postOrderTraverseRecursion(node.right);
		System.out.print(node.data + " ");
	}
}

public class MyBiTreeImpl {
	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(7);
		Node node2 = new Node(22);
		Node node3 = new Node(23);
		Node node4 = new Node(520);
		Node node5 = new Node(50);
		Node node6 = new Node(10);
		Node node7 = new Node(21);
		head.left = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node5.left = node6;
		node3.left = node7;
		MyBiTree myBiTree = new MyBiTree(head);
		System.out.println(myBiTree.empty());
		myBiTree.preOrderTraverse();
		myBiTree.inOrderTraverse();
		myBiTree.postOrderTraverse();
	}
}