package assignment_4;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    Resource buffer;

    public Consumer(Resource buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.consume();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
