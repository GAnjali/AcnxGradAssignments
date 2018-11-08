package assignment_4;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable{
    Resource resource;

    int i=0;

    public Consumer(Resource buffer){
        this.resource=buffer;
    }
    @Override
    public void run() {
        while (true){
            //System.out.println("Consumes:");
            resource.consume();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
