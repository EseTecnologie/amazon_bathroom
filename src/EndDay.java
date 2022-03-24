public class EndDay extends Thread{
    @Override
    public void run() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nDay ended\n\n");
        Shared.timeLeft = true;
        return;
    }
}
