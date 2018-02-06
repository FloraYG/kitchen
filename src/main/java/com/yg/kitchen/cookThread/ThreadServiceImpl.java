package com.yg.kitchen.cookThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by guang.yang on 2018-01-15.
 */
public class ThreadServiceImpl implements Runnable{
    ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(16);

    @Override
    public void run() {

    }
}
