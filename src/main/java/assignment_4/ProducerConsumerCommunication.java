package assignment_4;

public class ProducerConsumerCommunication {
    public static void main(String[] args) {
        Resource resource = new Resource();
        DBConnection dbConnection = new DBConnection();
        ConsumptionInfo consumptionInfo = new ConsumptionInfo();
        Thread producer = new Thread(new Producer(resource, dbConnection));
        Thread consumer1 = new Thread(new Consumer(resource, consumptionInfo));
        Thread consumer2 = new Thread(new Consumer(resource, consumptionInfo));
        Thread consumer3 = new Thread(new Consumer(resource, consumptionInfo));
        Thread consumer4 = new Thread(new Consumer(resource, consumptionInfo));
        Thread consumer5 = new Thread(new Consumer(resource, consumptionInfo));

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
    }
}
