/*

递归函数中，当返回值为两个或两个以上、可能多次返回的函数调用时，更好的实现如下：

1.创建递归函数入口a，在a中声明数组，并为数组中的每一位赋值，该值不能等于递归函数的基本情况；

2.创建递归函数b，通过a将数组作为参数传进b。先判断是否基本情况，如果是则直接返回值；再判断对应数组中的值是否已被修改，如果没被修改，则相应的值等于递归函数b的调用，然后返回相应的值。

*/
public class ImprovedFibonacci2
{
    public static double binomial(int n, int k, double p, Counter c)
    {
        double[][] v = new double[n+1][k+1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                v[i][j] = -1;
        
        return binomial(v, n, k, p, c);
    }
    
    public static double binomial(double[][] v, int n, int k, double p, Counter c)
    {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        
        if (v[n][k] == -1)
        {
            c.increment();
            v[n][k] = (1.0 - p) * binomial(v, n-1, k, p, c) + p * binomial(v, n-1, k-1, p, c);
        }
        
        return v[n][k];
    }
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]),
            k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        
        Counter c = new Counter("calls");
        
        double b = binomial(n, k, p, c);
        
        StdOut.println(b);
        StdOut.println(c);
        // java Ex_1_1_27b   10    5 0.5:        50 calls
        // java Ex_1_1_27b   20   10 0.5:       175 calls
        // java Ex_1_1_27b   30   15 0.5:       375 calls
        // java Ex_1_1_27b  100   50 0.5:     3,875 calls
        // java Ex_1_1_27b 1000  500 0.5:   376,250 calls
        // java Ex_1_1_27b 4000 2000 0.5: 6,005,000 calls
    }
}