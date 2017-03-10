/* 矩阵相乘（方阵） */
public class Matrix {

	public static void main(String[] args) {
		
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{1, 2}, {3, 4}};

		int[][] c = new int[2][2];

		int n = c.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					/* 关键：矩阵相乘的定义 */
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		for (int[] i : c) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

}