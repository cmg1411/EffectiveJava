package Chapter11.Day78;

import java.util.concurrent.TimeUnit;

public class StopThreadRefectoring {

    private static boolean stopRequested;

    private static synchronized void stop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stop();
    }
}