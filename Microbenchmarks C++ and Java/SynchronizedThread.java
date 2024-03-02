import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedThread extends Thread {
    static int sharedVariable = 0;
    static Lock l = new ReentrantLock();

    @Override
    public void run() {
        l.lock();
        try {
            sharedVariable++;
        } finally {
            l.unlock();
        }
    }
}
