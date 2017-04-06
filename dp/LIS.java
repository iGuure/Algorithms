/*

	以下解法是错误的！千万不要看！
	以下解法是错误的！千万不要看！
	以下解法是错误的！千万不要看！

	不删除只是为了留个纪念！
	不删除只是为了留个纪念！
	不删除只是为了留个纪念！

	动态规划经典题目：LIS
	问题是：找出所给数组中升序排列的最长子数组的长度
	先定义一下常量：DEFINE 升序排列的最长子数组 SXZC数组
	以下是我的愣头青解法：
	设置两个辅助数组，len和min
	len[n]表示前n项SXZC数组的长度
	min[n]表示前n项SXZC数组的最后一位的最小值（因为升序排列的最长子数组可能有多组）
	首先给出基本情况：len[0] = 0，min[0] = 0，不解释
	然后再看看一般情况，len[n]和min[n]
	对于len[n]，我们看第n项（即sequence[n - 1]）的值是否大于min[n -1]
	如果是，则意味着我们可以将这一项加入前面的SXZC数组中，组成新的SXZC数组
	这时候，len[n] = len[n - 1] + 1
	如果不是，则意味着前n项不可能比前n - 1项组成更长的SXZC数组，因此len[n] = len[n - 1]
	对于min[n]，情况则复杂一些
	首先还是看第n项（即sequence[n - 1]）的值是否大于min[n -1]
	如果是，则可以组成新的SXZC数组，此时min[n] = sequence[n - 1];
	如果不是，我们需要找到在len[n - 1]之前上一个等于len[n - 1] - 1的len[m],求出m值
	然后判断sequence[n - 1]是否大于min[m]
	如果是，则说明可以组成一个长度等于len[n - 1]的SXZC数组
	而且我们已经知道，此时sequence[n - 1]小于min[n -1]，因此min[n] = sequence[n - 1]
	如果不是，那么说明不可能组成这样的数组，所以前n项的SXZC数组还是前n - 1项的SXZC数组
	因此min[n] = min[n - 1]
*/
public class LIS {
	public static void main(String[] args) {
		int[] sequence = {6, 7, 8, 1, 2, 0, 3, 4};

		int[] len = new int[sequence.length + 1];
		int[] min = new int[sequence.length + 1];

		len[0] = 0;
		min[0] = 0;

		for (int i = 1; i < sequence.length + 1; i++) {
			if (sequence[i - 1] > min[i - 1]) {
				len[i] = len[i - 1] + 1;
				min[i] = sequence[i - 1];
			} else {
				len[i] = len[i - 1];

				for (int j = i - 2; j >= 0; j--) {
					if (len[j] == len[i - 1] - 1) {
						if (sequence[i - 1] > min[j]) {
							min[i] = sequence[i - 1];
						} else {
							min[i] = min[i - 1];
						}
						break;
					}
				}
			}
		}

		for (int i = 0; i < len.length; i++) {
			System.out.println(len[i] + " " + min[i]);
		}
	}
}