import java.util.*;

class MyList {

	private List<Integer> instance;

	public void setInstance(List<Integer> instance) {
		this.instance = instance;
	}

	public List<Integer> getInstance() {
		return instance;
	}

	public void initList(Collection<? extends Integer> a) {
		instance = new ArrayList<Integer>(a);

		// or:

		// instance = new LinkedList<Integer>(a);
	}

	public void destroyList() {
		instance = null;
	}

	public void clearList() {
		instance.clear();
	}

	public boolean listEmpty() {
		return instance.size() == 0;
	}

	public int listLength() {
		return instance.size();
	}

	public int getElem(int i) {
		return instance.get(i);
	}

	// public int locateElem(int e, function compare)

	public int priorElem(int e) {
		for (int i = 0; i < instance.size(); i ++) {
			if (instance.get(i) == e) {
				return i == 0 ? -1 : i - 1;
			}
		}
		return -1;
	}

	public int nextElem(int e) {
		for (int i = 0; i < instance.size(); i ++) {
			if (instance.get(i) == e)
				return i == instance.size() - 1 ? -1 : i + 1;
		}
		return -1;
	}

	public void listInsert(int i, int e) {
		instance.add(null);
		for (int j = instance.size() - 1; j > i; j--) {
			instance.set(j, instance.get(j - 1));
		}
		instance.set(i, e);

		// or just simply:

		// instance.add(i, e);
	}

	public int listDelete(int i) {
		int result = instance.get(i);
		for (int j = i; j < instance.size() - 1; j++) {
			instance.set(j, instance.get(j + 1));
		}
		instance.remove(instance.size() - 1);
		return result;

		// or just simply:

		// int result = instance.get(i);
		// instance.remove(i);
		// return result;
	}

	// public void listTraverse(function visit)

	public void listPrint() {
		System.out.println(instance);
	}

	public void union(MyList lb) {
		// 将所有在线性表lb中但不在该实例中的数据元素插入到该实例中
		List<Integer> lbList = lb.getInstance();
		boolean isNew;
		for (int i = 0; i < lbList.size(); i++) {
			isNew = true;
			for (int j = 0; j < instance.size(); j++) {
				if (lbList.get(i) == instance.get(j))	isNew = false;
			}
			if (isNew)	instance.add(lbList.get(i));
		}
	}

}

public class MyListImpl {
	public static void main(String[] args) {
		
		MyList myList = new MyList();
		// test init list
		System.out.println(myList.getInstance());
		myList.initList(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(myList.getInstance());
		// test destroy list
		myList.destroyList();
		System.out.println(myList.getInstance());
		// test clear list
		myList.initList(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(myList.getInstance());
		myList.clearList();
		System.out.println(myList.getInstance());
		// test list empty
		System.out.println(myList.listEmpty());
		myList.initList(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(myList.listEmpty());
		// test list length
		System.out.println(myList.listLength());
		// test get elem
		System.out.println(myList.getElem(1));
		// test prior elem
		System.out.println(myList.priorElem(3));
		System.out.println(myList.priorElem(7));
		// test next elem
		System.out.println(myList.nextElem(3));
		System.out.println(myList.nextElem(5));
		// test list insert
		System.out.println(myList.getInstance());
		myList.listInsert(2, 10);
		System.out.println(myList.getInstance());
		// test list delete
		System.out.println(myList.listDelete(2));
		System.out.println(myList.getInstance());
		// test list print
		myList.listPrint();
		// test union
		MyList myList2 = new MyList();
		myList2.initList(Arrays.asList(2, 23, 13));
		System.out.println(myList2.getInstance());
		myList.union(myList2);
		System.out.println(myList.getInstance());

		MyList myListA = new MyList();
		myListA.initList(Arrays.asList(1, 3, 5, 7, 9));
		MyList myListB = new MyList();
		myListB.initList(Arrays.asList(2, 4, 6, 8, 10));
		MyList myListC = mergeList(myListA, myListB);
		System.out.println(myListC.getInstance());

	}

	public static MyList mergeList(MyList la, MyList lb) {
		List<Integer> laList = la.getInstance();
		List<Integer> lbList = lb.getInstance();

		int laSize = laList.size();
		int lbSize = lbList.size();

		int m = 0, n = 0;

		MyList result = new MyList();
		result.initList(Arrays.asList());
		for (int i = 0; i < laSize + lbSize; i++) {
			if (m >= laSize)						result.listInsert(result.listLength(), lbList.get(n++));
			else if (n >= lbSize) 					result.listInsert(result.listLength(), laList.get(m++));
			else if (laList.get(m) < lbList.get(n))	result.listInsert(result.listLength(), laList.get(m++));
			else									result.listInsert(result.listLength(), lbList.get(n++));
		}
		return result;
	}

}