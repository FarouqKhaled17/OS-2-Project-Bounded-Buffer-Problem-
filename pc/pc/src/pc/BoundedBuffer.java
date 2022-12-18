
package pc;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Semaphore;
 
class BoundedBuffer implements Buffer{ 
    int item;
      private static final int BUFFER_SIZE = 3; //max size of buffer array
      private int count; //number of items currently in the buffer
      private int in;   // points to the next free position in the buffer
      private int out;  // points to the first filled position in the buffer
      private Object[] buffer; //array of Objects
      private Semaphore mutex; //provides limited access to the buffer (mutual exclusion)
      private Semaphore empty; //keep track of the number of empty elements in the array
      private Semaphore full; //keep track of the number of filled elements in the array
       
       public BoundedBuffer(){
      // buffer is initially empty
         item=0;
         count = 0;
         in = 0;
         out = 0;
         buffer = new Object[BUFFER_SIZE];
         mutex = new Semaphore(1); //1 for mutual exclusion
         empty = new Semaphore(BUFFER_SIZE); //array begins with all empty elements
         full = new Semaphore(0); //array begins with no elements
      }
   
   // producer calls this method
       public void insert() {

         try{
            empty.acquire(); //keep track of number of empty elements (value--)
            mutex.acquire(); //mutual exclusion
         }
             catch (InterruptedException e) { 
               System.out.println("ERROR in insert(): " + e);
            }
           Date date= new Date();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" in critical section "+date);


           // add an item to the buffer
         ++count;
         buffer[in] = item;
         in = (in + 1) % BUFFER_SIZE;

           item++;
      
       
         mutex.release(); //mutual exclusion
           System.out.println("Thread: "+Thread.currentThread().getName()  +" left critical section");

           full.release(); //keep track of number of elements (value++)
           System.out.println( Thread.currentThread().getName() +"turn"+ Arrays.toString(buffer)+"-> "+count);

           //If buffer was empty, then this wakes up the Consumer
          try {
              Thread.sleep(2000);
          } catch (InterruptedException ex) {
              java.util.logging.Logger.getLogger(BoundedBuffer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
       }
   
   // consumer calls this method
       public Object remove() {
         Object item=null;

       try{
            mutex.acquire(); //mutual exclusion
            full.acquire(); //keep track of number of elements (value--)


         }
             catch (InterruptedException e) { 
               System.out.println("ERROR in try(): " + e);
            }
           Date date= new Date();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" in critical section "+date);
      	
      // remove an item from the buffer
         --count;
         item = buffer[out]; 
         out = (out + 1) % BUFFER_SIZE;

    System.out.println("Consumer consumed  " + item );

         mutex.release(); //mutual exclusion
           System.out.println("Thread: "+Thread.currentThread().getName()  +" left critical section");

           empty.release(); //keep track of number of empty elements (value++)
           System.out.println( Thread.currentThread().getName()  +"turn "+ item+"-> "+count);


           //if buffer was full, then this wakes up the Producer
          try {
              Thread.sleep(3000);
          } catch (InterruptedException ex) {
              java.util.logging.Logger.getLogger(BoundedBuffer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        
        
         return item;
      }
   
   }