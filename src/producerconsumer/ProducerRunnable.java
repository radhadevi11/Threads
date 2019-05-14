package producerconsumer;

import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class ProducerRunnable implements Runnable {
    LinkedList<Double> numbers ;
    public ProducerRunnable(LinkedList<Double> numbers){
        this.numbers = numbers;
    }
    public void run(){

        while(true) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double number = Math.floor(Math.random() * 100);
            synchronized (numbers) {
                if(numbers.size() >= 10){
                    System.out.println("List is full!! you can't produce");
                    try {
                        numbers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numbers.addLast(number);
                numbers.notifyAll();
            }

            System.out.println("produced value is " + number);

        }

    }
}
