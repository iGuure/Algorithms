public class Coin {
	public static void main(String[] args) {
		int[] min = new int[100];
		for (int i = 0; i < min.length; i++) {
			min[i] = Integer.MAX_VALUE;
		}
		min[0] = 0;

		int[] coin = new int[3];
		coin[0] = 1;
		coin[1] = 3;
		coin[2] = 5;

		for (int i = 1; i < min.length; i++) {
			for (int j = 0; j < coin.length; j++) {
				if (coin[j] <= i && min[i - coin[j]] + 1 < min[i])
					min[i] = min[i - coin[j]] + 1;
			}
		}

		for (int i = 0; i < min.length; i++) {
			System.out.println(i + " " + min[i]);
		}
	}
}