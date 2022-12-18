package PhoneShop;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Supporter implements Runnable {
    
    private final Store Buffer;
    String item = "";
    int iteration;
    String name;


    public Supporter(Store buffer ,int iteration ,String item , String name) {
        this.Buffer = buffer;
        this.item=item;
        this.iteration=iteration;
        this.name=name;

    }

    @Override
    public/* synchronized*/  void run() {
        
        for(int i=0;i<iteration;i++){
            if(Buffer.isFull()){
                System.out.println("Store is full");
//                try {
//                    wait();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Supporter.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                break;
            }
            else{
                Buffer.buyPhone(item);           
                System.out.println(name + " Put "+item+" Number("+ (i+1) +")");
                try {
                Thread.sleep(1000);
                }   catch (InterruptedException ex) {
                 Logger.getLogger(Supporter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        } 
        
      // notifyAll();
        
        System.out.println( name + " End His Work");  
    }
        
    }

    
        
