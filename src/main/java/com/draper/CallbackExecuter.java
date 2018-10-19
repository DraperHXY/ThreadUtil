package com.draper;

public class CallbackExecuter {

    private Thread thread;

    public CallbackExecuter(Runnable runnable){
        thread = new Thread(runnable);
    }

    public void start(){
        thread.start();
    }




}
