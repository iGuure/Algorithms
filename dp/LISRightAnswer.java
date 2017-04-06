/*

	这个才是正确的解法！
	这个才是正确的解法！
	这个才是正确的解法！

	动态规划经典题目：LIS
	问题是：找出所给数组中升序排列的最长子数组

	详见注释！

*/
public class LISRightAnswer {
	public static void main(String[] args) {
		int[] sequence = {6, 7, 8, 1, 2, 0, 3, 4};
		
		// lis的每一位表示以sequence对应位置上的数结尾的升序排列的最长子数组的长度
		int[] lis = new int[sequence.length];

		// 初始化为1
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < sequence.length; i++) {
			for (int j = 0; j < i; j++) {
				// 从sequence中找出该位之前所有比它小的数
				if (sequence[j] < sequence[i]) {
					// 找出这些数中对应lis的最大值，加1即该位lis的值
					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
					}
				}
			}
		}

		for (int i = 0; i < lis.length; i++) {
			System.out.println(i + " " + lis[i]);
		}
	}
}