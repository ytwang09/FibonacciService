package com.android.team1887.fibonacci_service.fibonacciservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by ytwang on 2014/12/11.
 */
public class FibonacciService extends Service {
    private IFibonacciServiceImpl service;

    @Override
    public void onCreate() {
        super.onCreate();
        this.service = new IFibonacciServiceImpl();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.service;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        this.service = null;
        super.onDestroy();
    }
}
