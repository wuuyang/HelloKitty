package com.example.database_helper.model;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private final Executor mDiskIo;

    private final Executor mNetworkIo;

    private final Executor mMainThread;

    private AppExecutors(Executor diskIo, Executor networkIo, Executor mainThread){
        this.mDiskIo = diskIo;
        this.mNetworkIo = networkIo;
        this.mMainThread = mainThread;
    }

    public AppExecutors(){
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3),new MainThreadExecutor());
    }

    public Executor diskIo(){
        return mDiskIo;
    }

    public Executor networkIo(){
        return mNetworkIo;
    }

    public Executor mainThread(){
        return mMainThread;
    }

    private static class MainThreadExecutor implements Executor{

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
