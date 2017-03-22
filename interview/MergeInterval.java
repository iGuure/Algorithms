/*

	问题描述：向函数传递一个List<Interval>，函数对所有的Interval进行合并处理，
			  最终返回合并后的结果。

		例如：输入：[1, 3], [2, 5]				输出：[1, 5]
			  输入：[1, 4], [4, 7], [10, 12]	输出：[1, 7], [10, 12]

		总结：1. List<Interval> ls = new List<Interval>()是典型的错误方法=。=
				 我是HR的话估计也不会录用你，抱歉；
			  2. “temp未初始化”不等于“temp == null”；
			  3. 查看List中的元素用List.get(int index)；
			  4. 修改List中的元素用List.set(int index, Object o);
			  5. 查看List的长度用List.size()。

*/
import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeInterval {
	public static void main(String[] args) {
		MergeInterval mi = new MergeInterval();

		List<Interval> ls1 = new ArrayList<Interval>();
		ls1.add(new Interval(1, 3));
		ls1.add(new Interval(2, 5));

		List<Interval> re1 = mi.merge(ls1);

		for (Interval i : re1)
			System.out.print(i.start + " " + i.end + "  ");
		System.out.println();

		List<Interval> ls2 = new ArrayList<Interval>();
		ls2.add(new Interval(1, 4));
		ls2.add(new Interval(4, 7));
		ls2.add(new Interval(10, 12));

		List<Interval> re2 = mi.merge(ls2);

		for (Interval i : re2)
			System.out.print(i.start + " " + i.end + "  ");
		System.out.println();
	}

	public List<Interval> merge(List<Interval> li) {
		List<Interval> result = li;
		List<Interval> temp;
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = i + 1; j < result.size(); j++) {
				temp = mergeTwo(result.get(i), result.get(j));
				if (temp.size() == 1) {
					result.set(i, temp.get(0));
					result.remove(j);
					j--;
				}
			}
		}

		return result;
	}

	public List<Interval> mergeTwo(Interval a, Interval b) {
		List<Interval> result = new ArrayList<Interval>();
		Interval temp = null;

		if (a.end == b.start)							temp = new Interval(a.start, b.end);
		else if (b.end == a.start)						temp = new Interval(b.start, a.end);
		else if (a.start < b.end && a.end > b.start)	temp = new Interval(a.start, b.end);
		else if (b.start < a.end && b.end > a.start)	temp = new Interval(b.start, a.end);
		else if (a.start < b.start && a.end > b.end)	temp = new Interval(a.start, a.end);
		else if (b.start < a.start && b.end > a.end)	temp = new Interval(b.start, b.end);

		if (temp != null)
			result.add(temp);
		else {
			result.add(a);
			result.add(b);
		}

		return result;
	}
}