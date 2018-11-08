package assignment_4;

import java.util.ArrayList;

public class Resource {
    private ArrayList<Integer> buffer = new ArrayList<Integer>();
    static final int BUFFER_LIMIT = 5;

    public synchronized void produce(int item){
        while(buffer.size() >= BUFFER_LIMIT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Produced: "+item);
            buffer.add(item);
            notifyAll();
    }

    public synchronized int consume(){
        while(buffer.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = buffer.remove(0);
        System.out.println("Consumed: "+item);
        notifyAll();
        return item;
    }
}
