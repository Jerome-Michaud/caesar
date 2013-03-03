package editeurNXC.langage;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Newbo.O
 */
public class SMutex extends SType {
    public static final SMutex DEFAULT_MUTEX = new SMutex();
    private final ReentrantLock mutex;

    public SMutex() {
        this.mutex = new ReentrantLock();
    }

    public void lock() throws InterruptedException {
        this.mutex.lockInterruptibly();
    }

    public void unlock() {
        this.mutex.unlock();
    }

    @Override
    public boolean hasSameType(SType parOther) {
        return parOther instanceof SMutex;
    }

    @Override
    public SType clone() {
        return new SMutex();
    }
}