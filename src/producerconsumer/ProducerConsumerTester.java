package producerconsumer;

import java.util.LinkedList;

import static java.lang.Thread.sleep;


class ConsumerRunnable implements Runnable{

    LinkedList<Double> numbers ;
    public ConsumerRunnable(LinkedList<Double> numbers){
        this.numbers = numbers;
    }
    public void run(){
        double number;
        while (true){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (numbers) {
                if (numbers.size() == 0) {
                    System.out.println("List is empty you can't consume");
                    try {
                        numbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                number = numbers.removeFirst();
                numbers.notifyAll();
                System.out.println("consumed value is " + number);

            }


        }
    }

}


public class ProducerConsumerTester {
    public static void main(String[] args) throws InterruptedException {

        LinkedList<Double> numbers = new LinkedList<>();

        Runnable producerRunnable = new ProducerRunnable(numbers);
        Runnable consumerRunnable = new ConsumerRunnable(numbers);

        Thread thread = new Thread(producerRunnable,"ProducerThread");
        Thread thread1 = new Thread(consumerRunnable, "ConsumerThread");

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();


    }

}
