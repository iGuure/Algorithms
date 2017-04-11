import java.util.Collections;

public class Sort {

	public static void exch(double[] d, int i, int j) {
		double temp;
		temp = d[i];
		d[i] = d[j];
		d[j] = temp;
	}

	/* 选择排序 */
	public static void seletionSort(double[] d) {
		int N = d.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (d[i] > d[j]) {
					exch(d, i, j);
				}
			}
		}
	}

	/* 插入排序 */
	public static void insertionSort(double[] d) {
		int N = d.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (d[j] < d[j - 1]) {
					exch(d, j - 1, j);
				}
			}
		}
	}

	/* 冒泡排序 */
	public static void bubbleSort(double[] d) {
		int N = d.length;
		for (int i = 1; i < N; i++) {
			for (int j = N - 1; j >= i; j--) {
				if (d[j] < d[j - 1]) {
					exch(d, j - 1, j);
				}
			}
		}
	}

	/* 希尔排序 */
	public static void shellSort(double[] d) {
		int N = d.length;
		int h = 1;
		while (h < N / 3) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (d[j] < d[j - h]) {
						exch(d, j - h, j);
					}
				}
			}
			h /= 3;
		}
	}

	/* 归并排序 */
	public static double[] aux;

	public static void mergeSort(double[] d) {
		aux = new double[d.length];
		mergeSort(d, 0, d.length - 1);
	}

	public static void mergeSort(double[] d, int lo, int hi) {
		if (lo >= hi)	return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(d, lo, mid);
		mergeSort(d, mid + 1, hi);
		merge(d, lo, mid, hi);
	}

	public static void merge(double[] d, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = d[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)				d[k] = aux[j++];
			else if (j > hi)			d[k] = aux[i++];
			else if (aux[j] < aux[i])	d[k] = aux[j++];
			else						d[k] = aux[i++];
		}
	}

	/* 快速排序 */
	public static void quickSort(double[] d) {
		quickSort(d, 0, d.length - 1);
	}

	public static void quickSort(double[] d, int lo, int hi) {
		if (lo >= hi)	return;
		int p = partition(d, lo, hi);
		quickSort(d, lo, p - 1);
		quickSort(d, p + 1, hi);
	}

	public static int partition(double[] d, int lo, int hi) {
		int i = lo, j = hi + 1;
		double v = d[lo];
		while (true) {
			while (d[++i] < v)	if (i == hi)	break;
			while (d[--j] > v)	if (j == lo)	break;
			if (i >= j)	break;
			exch(d, i, j);
		}
		exch(d, lo, j);
		return j;
	}

	public static void main(String[] args) {
		
		double d1[] = {34, 26, 74, 5, 20, 11};
		seletionSort(d1);

		System.out.print("选择排序：");
		for (double num : d1) {
			System.out.print(num + " ");
		}
		System.out.println();


		double d2[] = {34, 26, 74, 5, 20, 11};
		insertionSort(d2);

		System.out.print("插入排序：");
		for (double num : d2) {
			System.out.print(num + " ");
		}
		System.out.println();


		double d3[] = {34, 26, 74, 5, 20, 11};
		bubbleSort(d3);

		System.out.print("冒泡排序：");
		for (double num : d3) {
			System.out.print(num + " ");
		}
		System.out.println();


		double d4[] = {34, 26, 74, 5, 20, 11};
		shellSort(d4);

		System.out.print("希尔排序：");
		for (double num : d4) {
			System.out.print(num + " ");
		}
		System.out.println();


		double d5[] = {34, 26, 74, 5, 20, 11};
		mergeSort(d5);

		System.out.print("归并排序：");
		for (double num : d5) {
			System.out.print(num + " ");
		}
		System.out.println();


		double d6[] = {34, 26, 74, 5, 20, 11};
		quickSort(d6);

		System.out.print("快速排序：");
		for (double num : d6) {
			System.out.print(num + " ");
		}
		System.out.println();

	}
}