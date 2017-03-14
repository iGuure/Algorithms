public class StringEqualsOrNot {
	public static void main(String[] args) {

		/* 通过new初始化的String，heap中储存着每一个实例 */
		/* hashCode根据String的值计算，相等 */
		/* s1和s2指向不同的对象，因此s1 != s2 */
		/* s1和s2根据String的值判断，两个对象是相等的 */

		/* 该例子适用于所有的Object */
		String s1 = new String("I am Sam");
		String s2 = new String("I am Sam");
		System.out.println("s1的hashCode：" + s1.hashCode());
		System.out.println("s2的hashCode：" + s2.hashCode());
		System.out.println("s1 ==     s2 -> " + (s1 == s2));
		System.out.println("s1 equals s2 -> " + (s1.equals(s2)));

		/* 通过双引号初始化的String，为常量（Static）定义法 */
		/* 初始化时首先在常量池中声明String类型常量"I am Dean"（只能存在一个） */
		/* 当heap需要引用时，从常量池中拷贝一份过去（也只能存在一个） */
		/* 因此，s3和s4指向的是同一个对象 */
		/* 当两个对象的引用a和b指向同一个对象时，a == b */
		String s3 = "I am Dean";
		String s4 = "I am Dean";
		System.out.println("s3的hashCode：" + s3.hashCode());
		System.out.println("s4的hashCode：" + s4.hashCode());
		System.out.println("s3 ==     s4 -> " + (s3 == s4));
		System.out.println("s3 equals s4 -> " + (s3.equals(s4)));

		/* 此时，将s3通过new方式实例化，同样的字符串 */
		/* 可以看到，此时s3指向heap中单独的一个对象，s3 != s4 */
		s3 = new String("I am Dean");
		System.out.println("s3的hashCode：" + s3.hashCode());
		System.out.println("s3 ==     s4 -> " + (s3 == s4));
		System.out.println("s3 equals s4 -> " + (s3.equals(s4)));

	}
}