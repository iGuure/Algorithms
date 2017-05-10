/*

问题：给定一个有序（非降序）数组A，可含有重复元素，求最小的i使得A[i]等于target，不存在则返回-1。

*/
public class BinarySearchDuplicateElements {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        if (a[lo] == key)   return lo;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 9, 9, 9, 11};
        int key = 9;
        System.out.println(rank(key, a));
        key = 8;
        System.out.println(rank(key, a));
    }
}