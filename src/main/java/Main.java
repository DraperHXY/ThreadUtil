public class Main {

    public static void main(String[] args) throws InterruptedException {

        CallbackThread callbackThread = new CallbackThread();

        //设置监听，当线程执行完毕执行执行刷新
        callbackThread.setActionListener(o -> System.out.println(o + ":主线程刷新 UI"));

        //启动线程开始下载
        new Thread(callbackThread).start();

        //模拟主线程一直在运行
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(500);
            System.out.println(i);
        }
    }

}
