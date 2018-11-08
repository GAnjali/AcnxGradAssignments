package assignment_4;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    Resource buffer;
    int item;
    public Producer(Resource buffer,int item){
        this.buffer= buffer;
        this.item = item;
    }


    @Override
    public void run() {
        while (item<5){
            //System.out.println("produces:"+item);
            buffer.produce(item++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
