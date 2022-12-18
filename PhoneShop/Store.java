package PhoneShop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Store {
    int bufferSize;
    ArrayList<String> Buffer = new ArrayList<>(bufferSize);
    private final Semaphore Mutex;//to check critical sections
    private final Semaphore Empty;//to check empty place
    private final Semaphore Full;//to check full
    
    

    
    
    public Store (int size) {
        this.bufferSize = size;
        Buffer = new ArrayList<>(bufferSize);
        Mutex = new Semaphore(1,true);// to solve starvation
       
        Empty = new Semaphore(bufferSize);//to solve
        Full = new Semaphore(0);
    }
      
    
    public synchronized boolean isEmpty() {
        return Buffer.isEmpty();
    }
    
    
    public synchronized boolean isFull() {
        return Buffer.size() == this.bufferSize;
    }
     
     
    public void buyPhone(String item){
        
        if (isFull()){
            
            System.out.println("Storage is Full,Sorry Try again Later");
           
        }
        else{ 
            try {
            Empty.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            try {
            Mutex.acquire();
            } catch (InterruptedException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            Buffer.add(item);

           
            Mutex.release();
            Full.release();
            /*System.out.println("In Index "+);*/
            
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            Logger.getLogger(BoundedBuffer.class.getName()).log(Level.SEVERE, null, ex);
            
            
            }*/
            
           
        }
    }
    
    
    
    
    
    
    public  String sellPhone() {
         String item = "Noting";
         int out = 0;       
            if ( isEmpty() ) {
                System.out.println("We do not have any fruits for Sell");
                
             
            }
            
            else  {
                Empty.release();
                
                
             try {
                 Mutex.acquire();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
             }
             
                item = Buffer.remove(0);
                //item = Buffer.remove(out);
                out++;
                System.out.println( item + " is Recived");
                
                
                
                
                
                Mutex.release();
                
             try {
                 Full.acquire();
             } catch (InterruptedException ex) {
                 Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
           

            return item;
            
            
            
            
    }
    
    
    
    
    
    
    
    
}
