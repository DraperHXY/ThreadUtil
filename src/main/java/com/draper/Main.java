package com.draper;


import javafx.util.Callback;

public class Main {

    public static void main1(String[] args) throws InterruptedException {

        CallbackThread callbackThread = new CallbackThread();

        //设置监听，当线程执行完毕执行执行刷新
        callbackThread.setActionListener(b-> System.out.println(b + ":主线程刷新 UI"));

        //启动线程开始下载
        new Thread(callbackThread).start();

        //模拟主线程一直在运行
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(500);
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Callback<Object, Datas> callback = new Callback<Object, Datas>() {
            @Override
            public Datas call(Object param) {
                System.out.println(param + ":主线程刷新 UI");
                return (Datas) param;
            }
        };


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Datas datas = null;
                System.out.println("下载开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                datas = new Datas();
                System.out.println("下载完成");
                callback.call(datas);
            }
        };


//        com.draper.CallbackExecuter callbackExecuter = new com.draper.CallbackExecuter(runnable);
//        callbackExecuter.start();

        Thread thread = new Thread(runnable);
        thread.start();

        //模拟主线程一直在运行
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(500);
            System.out.println(i);
        }


    }

}
