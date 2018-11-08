package assignment_4;

public class ProducerConsumerCommunication {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread producer = new Thread(new Producer(resource, 1));
        Thread consumer = new Thread(new Consumer(resource));

        producer.start();
        consumer.start();
    }
}
