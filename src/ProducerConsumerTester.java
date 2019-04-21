import java.util.LinkedList;

class ProducerRunnable implements Runnable{
    LinkedList<Double> numbers ;
    public ProducerRunnable(LinkedList<Double> numbers){
        this.numbers = numbers;
    }
    public void run(){

        for(int i = 0; i < 10; i++) {
            double number = Math.floor(Math.random() * 100);
            synchronized (numbers) {
                numbers.addLast(number);
                numbers.notifyAll();
            }

            System.out.println("produced value is " + number);

        }

    }
}


class ConsumerRunnable implements Runnable{

    LinkedList<Double> numbers ;
    public ConsumerRunnable(LinkedList<Double> numbers){
        this.numbers = numbers;
    }
    public void run(){
        double number;
        for(int i = 0; i < 10; i++) {
            synchronized (numbers) {
                if (numbers.size() == 0) {
                    try {
                        numbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                number = numbers.removeFirst();
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
