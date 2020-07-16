import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class LiveCycle implements Runnable {

    static final AtomicInteger count = new AtomicInteger(0);

    public void run() {
        synchronized (count)
        {
            count.incrementAndGet();
        }
        spawn(count);
        eat(count);
        breed();
        die(count);
    }

    private void spawn(AtomicInteger index)
    {
        System.out.println("Rabbit " + index.get() + " spawned.");
    }

    private void eat(AtomicInteger index)
    {
        System.out.println("Rabbit " + index.get() + " eat.");
    }

    private void breed()
    {
        if (count.get() <= 50000)
        {
            new Thread(new LiveCycle()).start();
            new Thread(new LiveCycle()).start();
        }
    }

    private void die(AtomicInteger index)
    {
        currentThread().interrupt();
        System.out.println("Rabbit " + index.get() + " die.");
        synchronized (count)
        {
            count.decrementAndGet();
        }
    }
}
