/*

	问题描述：向函数传递一个字符串，内容为用逗号隔开的两个值，第一个是字符串，编码格式为UTF-8，
			  第二个是字节数。
			  要求函数返回字节数长度的子字符串。

		例如：输入：你好ABCD, 7		输出：你好A
			  输入：ABCD你好, 6		输出：ABCD

		总结：1. String转int的方法为Integer.parseInt(String s)，不能直接使用强制类型转换；
			  2. 查看数组长度的方法是String.length()，不是String.length；
			  3. 判断一个UTF-8字符是否字母可以使用String.matches("[a-zA-Z]")；
			  	 String不能直接转换成int，需要先使用String.charAt(0)转换成char，再使用(int)转换成int，
			  	 通过int值可以判断该字符是否为字母（A：65，a：97）；
			  4. String中取单个字符可以使用String.substring(int start, int end)：
			  	 从下标为start的位置开始，取到下标为end的位置（end位置上的字符不取），
			  	 子字符串长度为end - start。

*/
public class OutputSubstring {

	public String output(String str) {
		String[] s = new String[2];
		s = str.split(", ");
		int num = Integer.parseInt(s[1]);

		String result = "";

		for (int i = 0; i < s[0].length(); i++) {
			if (num > 0) {
				if (s[0].substring(i, i + 1).matches("[a-zA-z]")) {
					result += s[0].substring(i, i + 1);
					num -= 1;
				} else {
					if (num >= 3) {
						result += s[0].substring(i, i + 1);
						num -= 3;
					}
				}
			} else {
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		OutputSubstring os = new OutputSubstring();
		System.out.println(os.output("你好ABCD, 7"));
		System.out.println(os.output("ABCD你好, 6"));
	}
}