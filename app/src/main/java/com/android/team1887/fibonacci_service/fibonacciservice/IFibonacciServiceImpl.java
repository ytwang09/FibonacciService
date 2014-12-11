package com.android.team1887.fibonacci_service.fibonacciservice;

/**
 * Created by ytwang on 2014/12/11.
 */

import android.util.Log;
import android.os.SystemClock;

import com.android.team1887.fibonacci_service.fibonaccinative.FibLib;

import team_1887.fibonacci_common_library_project.FibonacciRequest;
import team_1887.fibonacci_common_library_project.FibonacciResponse;
import team_1887.fibonacci_common_library_project.IFibonacciService;

public class IFibonacciServiceImpl extends IFibonacciService.Stub {
    private static final String TAG = "IFibonacciServiceImpl";

    public long fibJR(long n) {
        Log.d(TAG, String.format("fibJN(%d)", n));
        return FibLib.fibJR(n);
    }
    public long fibJI(long n) {
        Log.d(TAG, String.format("fibJI(%d)", n));
        return FibLib.fibJI(n);
    }
    public long fibNI(long n) {
        Log.d(TAG, String.format("fibNI(%d)", n));
        return FibLib.fibNI(n);
    }
    public long fibNR(long n) {
        Log.d(TAG, String.format("fibNR(%d)", n));
        return FibLib.fibNR(n);
    }

    public FibonacciResponse fib(FibonacciRequest request) {
        Log.d(TAG,String.format("fib(%d, %s)", request.getN(), request.getType()));
        long timeInMillis = SystemClock.uptimeMillis();
        long result;
        switch (request.getType()) {
            case ITERATIVE_JAVA:
                result = this.fibJI(request.getN());
                break;
            case RECURSIVE_JAVA:
                result = this.fibJR(request.getN());
                break;
            case ITERATIVE_NATIVE:
                result = this.fibNI(request.getN());
                break;
            case RECURSIVE_NATIVE:
                result = this.fibNR(request.getN());
                break;
            default:
                return null;
        }
        timeInMillis = SystemClock.uptimeMillis() - timeInMillis;
        return new FibonacciResponse(result, timeInMillis);
    }
}
