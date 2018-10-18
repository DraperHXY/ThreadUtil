public class CallbackThread implements Runnable {

    private Listener listener;

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
        listener.action(datas);

    }

    public void setActionListener(Listener listener) {
        this.listener = listener;
    }

}
