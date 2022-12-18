package PhoneShop;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Shop {

    
    public static void main(String[] args) {
        
        
        
        
        
                                                  //Default Run(Static)
        
        Store x = new Store(10);
        
        
                                                 
        
            Thread ProducerThread0=new Thread(new Supporter(x,1,"1","Supporter1"));
            Thread ProducerThread1=new Thread(new Supporter(x,1,"2","Supporter2"));
            Thread ProducerThread2=new Thread(new Supporter(x,1,"3","Supporter3"));
            Thread ProducerThread3=new Thread(new Supporter(x,1,"4","Supporter4"));
            Thread ProducerThread4=new Thread(new Supporter(x,1,"5","Supporter5"));
            
            Thread ConsumerThread0=new Thread(new Customer(x,1,"Customer1"));
            Thread ConsumerThread1=new Thread(new Customer(x,1,"Customer2"));
            Thread ConsumerThread2=new Thread(new Customer(x,1,"Customer3"));
            Thread ConsumerThread3=new Thread(new Customer(x,1,"Customer4"));
            ConsumerThread0.start();
            ConsumerThread1.start();
            ConsumerThread2.start();
            ConsumerThread3.start();
            
            
            ProducerThread0.start();
            ProducerThread1.start();
            ProducerThread2.start();
            ProducerThread3.start();
            ProducerThread4.start();
            

        
        
        
        
        
                
    }  
 }  
        
        
