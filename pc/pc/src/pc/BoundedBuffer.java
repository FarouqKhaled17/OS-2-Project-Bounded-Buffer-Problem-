
package pc;
import java.util.Date;
import java.util.concurrent.Semaphore;
 
class BoundedBuffer implements Buffer{ 
    int buff;
      private static final int BUFFER_SIZE = 3;
      private int count;
      private int in;
      private int out;
      private Object[] buffer;
      private Semaphore mutex;
      private Semaphore empty;
      private Semaphore full;
       
       public BoundedBuffer(){
         buff =0;
         count = 0;
         in = 0;
         out = 0;
         buffer = new Object[BUFFER_SIZE];
         mutex = new Semaphore(1);
         empty = new Semaphore(BUFFER_SIZE);
         full = new Semaphore(0);
      }

       public void insert() {

         try{
            empty.acquire();
            mutex.acquire();
         }
             catch (InterruptedException e) { 
               System.out.println("Error in insert(): " + e);
            }
           Date date= new Date();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" entered critical section "+date);


         ++count;
         buffer[in] = buff;
         in = (in + 1) % BUFFER_SIZE;

           buff++;
      
       
         mutex.release();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" left critical section");

           full.release();


          try {
              Thread.sleep(2000);
          } catch (InterruptedException ex) {
              java.util.logging.Logger.getLogger(BoundedBuffer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
       }
   

       public Object remove() {
         Object item=null;

       try{
            full.acquire();
            mutex.acquire();


         }
             catch (InterruptedException e) { 
               System.out.println("ERROR in try(): " + e);
            }
           Date date= new Date();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" in the critical section "+date);
      	

         --count;
         item = buffer[out]; 
         out = (out + 1) % BUFFER_SIZE;

    System.out.println("Consumer consumed  " + item );

         mutex.release();
           System.out.println("Thread: "+Thread.currentThread().getName()  +" left the critical section"+count);

           empty.release();



          try {
              Thread.sleep(3000);
          } catch (InterruptedException ex) {
              java.util.logging.Logger.getLogger(BoundedBuffer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        
        
         return item;
      }
   
   }