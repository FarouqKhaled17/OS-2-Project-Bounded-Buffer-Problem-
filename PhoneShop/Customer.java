package PhoneShop;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer implements Runnable {
    
    private final Store Buffer;
    String item = "";
    int iteration = 0;
    String name;
    
    public Customer(Store buffer , int iteration , String name) {
        this.Buffer = buffer;
        this.iteration=iteration;
        this.name=name;
    }

    @Override
    public /*synchronized*/  void run() {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<iteration;i++){
            if(Buffer.isEmpty()){
                System.out.println(name + " Stock is Empty,Please Wait...");
//                try {
//                    wait();
//                try {
//                   Thread.currentThread().wait(1000);
//               } catch (InterruptedException ex) {
//                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//               }

//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                break;
            }
            else{
                Buffer.sellPhone();
                //System.out.println(Thread.currentThread().getName() + " Shopping "+item+" Number("+ (i+1) +")");
            }
        }
        
        //notifyAll();
        
        System.out.println(name + " End His Shopping");
        
        
        
    }
    
}
