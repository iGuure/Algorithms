public class LIS {
	public static void main(String[] args) {
		int[] sequence = {1, 7, 2, 8, 3, 4};

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
							if (sequence[i - 1] < min[i - 1]) {
								min[i] = sequence[i - 1];
							}
						} else {
							min[i] = min[i - 1];
						}
						break;
					}
				}
			}
		}

		for (int i = 0; i <= 6; i++) {
			System.out.println(len[i] + " " + min[i]);
		}
	}
}