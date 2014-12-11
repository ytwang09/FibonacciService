package com.android.team1887.fibonacci_service.fibonaccinative;

/**
 * Created by ytwang on 2014/12/11.
 */
public class FibLib {
    public static long fibJR(long n) {
        return n <= 0 ? 0 : n == 1 ? 1 : fibJR(n-1)+fibJR(n-2);
    }
    public static long fibJI(long n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        long result = 1;
        long previous = -1;
        for(int i = 0; i <= n; ++i) {
            long temp = result + previous;
            previous = result;
            result = temp;
        }
        return result;
    }

    public native static long fibNR(long n);
    public native static long fibNI(long n);


    static {
        System.loadLibrary("java_FibonacciNative_FibLib");
    }
}
