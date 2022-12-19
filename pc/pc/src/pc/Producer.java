/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc;
import java.util.logging.Logger;
import java.lang.System.Logger.Level;
import java.util.Date;

class Producer implements Runnable{
    
      private  Buffer buffer;
             
       public Producer(Buffer b) {
         buffer = b;
      }
   
       public void run(){
        
            for(int i=0;i<10;i++)      
 
            buffer.insert();
            
         }
      }
   
