package producerconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.LinkedList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ProducerRunnableTest {
    @InjectMocks
    @Spy
    private ProducerRunnable producerRunnable ;
    @Mock
    private LinkedList<Double> numbers ;


    @Test
    public void testProducerRunnable() throws InterruptedException {

        doNothing().when(numbers).wait();
        doNothing().when(numbers).notifyAll();

        producerRunnable.run();

        Mockito.verify(numbers).wait();
        Mockito.verify(numbers).notifyAll();
    }


}