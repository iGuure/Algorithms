public class ImprovedFibonacci {
	public static long Fib(int N) {
	    long[] f = new long[N+1];
	    return Fib(N, f);
	}

	public static long Fib(int N, long[] f) {
	    if (f[N] == 0)
	    {
	        if (N == 1)
	            f[N] = 1;
	        else if (N > 1)
	            f[N] = Fib(N-1, f) + Fib(N-2, f);
	    }
	    
	    return f[N];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			System.out.println(i + " " + Fib(i));
	}
}