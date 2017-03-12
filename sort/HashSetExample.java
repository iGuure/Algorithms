/*

	HashSet详解：

	· HashSet特点：
		· 元素无序
		· 元素不可重复

	ps：HashSet与散列表的关系：HashSet在插入元素的过程中使用了散列表查找的原理

	Q：为什么要用散列表查找保证元素不可重复？
	A：如果用一般的查找方式，那么每插入一个新的元素，都要将该元素与之前的所有元素调用equals()，判断是否已经存在相同的元素
		· 如果HashSet中已经存在1000个元素，插入一个新元素，那么将要进行1000次equals()，负担太重

	Q：散列表查找如何保证元素不可重复？
	A：每当插入一个元素时，
		· 首先（根据元素的内存地址）算出该元素的HashCode，即该元素应该放进哪个桶
		· 然后该元素对桶中其他元素调用equals()，如果某次调用返回true，表明该桶中已经有相同的元素，则插入失败

	Q：问题是，其他桶内也可能存在相同的元素，但是并没有调用equals的机会，这个问题如何解决？
	A：针对这种情况，我们需要同时重写equals()和hashCode()，保证如果两个元素调用equals()返回true的话，这两个元素的hashCode一定相等（即一定分配在同一个桶中）

*/

/*

	a == b 							: a和b指向同一个对象
		↓ 可以推出
	a.equals(b) 					: a和b相等（一般是成员变量相等）
		↓ 可以推出
	a.hashCode() == b.hashCode()	: a和b存在于同一个桶中

*/
import java.util.HashSet;

class Point {
	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* 重写hashCode()，保证相同对象（成员变量相等）的hashCode值一定相同，从而分配到同一个桶中 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* 格式相对固定的equals()写法 */
	public boolean equals(Object obj) {
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;
		Point other = (Point) obj;
		if (x != other.x)	return false;
		if (y != other.y)	return false;
		return true;
	}
}

public class HashSetExample {
	public static void main(String[] args) {
		HashSet<Point> hs = new HashSet<Point>();
		Point p1 = new Point(2, 2);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(3, 3);
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		System.out.println(hs.size());
		/* 输出结果是2，表明HashSet认为p1和p2是相同的元素，故p2插入失败 */
	}
}