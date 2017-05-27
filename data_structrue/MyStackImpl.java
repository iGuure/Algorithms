import java.util.*;

class MyStack {

	public List<Double> instance;

	public void init() {
		instance = new ArrayList<Double>();
	}

	public void destroy() {
		instance = null;
	}

	public void clear() {
		instance.clear();
	}

	public boolean empty() {
		return instance.size() == 0 ? true : false;
	}

	public int length() {
		return instance.size();
	}

	public double getTop() {
		return instance.get(0);
	}

	public void push(double d) {
		instance.add(0, d);
	}

	public double pop() {
		return instance.remove(0);
	}

	public void traverse() {
		for (double d : instance) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}

public class MyStackImpl {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		myStack.init();
		System.out.println(myStack.instance);

		System.out.println(myStack.empty());

		myStack.push(20);
		myStack.push(40);

		System.out.println(myStack.length());
		System.out.println(myStack.getTop());
		myStack.traverse();

		System.out.println(myStack.pop());
		myStack.traverse();

		myStack.clear();
		System.out.println(myStack.instance);

		myStack.destroy();
		System.out.println(myStack.instance);
	}
}