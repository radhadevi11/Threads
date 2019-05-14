package producerconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

@RunWith(MockitoJUnitRunner.class)

public class ProducerRunnableTest {

    @Mock
    private LinkedList<Double> numbers ;

    @Test
    public void testProducerRunnable() throws InterruptedException {
        Runnable producerRunnable = new ProducerRunnable(numbers);
        Thread thread = new Thread(producerRunnable,"ProducerThread");

        Mockito.doNothing().when(producerRunnable).wait();
        Mockito.doNothing().when(producerRunnable).notifyAll();

        thread.start();

        Mockito.verify(producerRunnable).wait();
        Mockito.verify(producerRunnable).notifyAll();
    }


}