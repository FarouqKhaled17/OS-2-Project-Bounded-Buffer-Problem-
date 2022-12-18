
package pc;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Pc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Buffer sharedBuffer = new BoundedBuffer();
        Thread producerThread1= new Thread(new Producer(sharedBuffer));
        Thread producerThread2 = new Thread(new Producer(sharedBuffer));
         Thread consumerThread1 = new Thread(new Consumer(sharedBuffer));
        Thread consumerThread2 = new Thread(new Consumer(sharedBuffer));
          producerThread1.start();
        producerThread2.start();
         consumerThread1.start();
        consumerThread2.start();

        producerThread1.join();
        producerThread2.join();
        consumerThread1.join();
        consumerThread2.join();
    }
    
}
