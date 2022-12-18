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
            
            
            
                                                      //Rum By ThreadPool(Dynamic)
        
        

        
        /*int ID,Num,Size;
        String Name , name;
        Scanner input=new Scanner(System.in);
        Scanner input2=new Scanner(System.in);
        Scanner input3=new Scanner(System.in);
        Scanner input4=new Scanner(System.in);
                                                      
        System.out.println("*********Hello Owner******** ");
        System.out.println("Enter Your Store Size ");
        Size=input4.nextInt();
        Store x = new Store(Size);
        
        
        
        
        for(int i =0; ; i++){ 
            System.out.println("Hello Sir,Have a Nice Day");
            System.out.println("------------------------------");
            System.out.println("1--> For Support ");
            System.out.println("2-->For Shopping ");
            System.out.println("Enter Your ID : ");
            ID=input.nextInt();
            switch(ID){
            
            case 1 -> {
                System.out.println("************You log As Supporter**************");
                System.out.println("Enter Your Name");
                name=input3.nextLine();
                
                System.out.println("Enter Name Of Your Items");
                Name=input2.nextLine();
                
                System.out.println("Enter Number Of Your Items");
                Num=input.nextInt();
                ExecutorService Producer = Executors.newFixedThreadPool(Num);//creating a pool of 5 threads
                for (int y = 0; y < 1; y++) {
                    Runnable worker = new Supporter(x,Num,Name,name);
                    
                    Producer.execute(worker);//calling execute method of ExecutorService
                }
                Producer.shutdown();
                while (!Producer.isTerminated()) {   }
                
                //System.out.println("Finished all threads");
                System.out.println("-------------------------------");
                }
            case 2 -> {
                System.out.println("***************You log As Customer*************");
                System.out.println("Enter Your Name");
                name=input3.nextLine();
                System.out.println("Enter Number Of Items You Need");
                Num=input.nextInt();
                ExecutorService Consumer = Executors.newFixedThreadPool(1);//creating a pool of 5 threads
                for (int y = 0; y < 1; y++) {
                    Runnable worker = new Customer(x,Num,name);
                    
                    Consumer.execute(worker);//calling execute method of ExecutorService
                }
                Consumer.shutdown();
                while (!Consumer.isTerminated()) {   }
                
                //System.out.println("Finished all threads");
                System.out.println("-------------------------------");
                }
            default -> System.out.println("Wrong input,TryAgain");
                
            }
        }  */     
            
        
        
        
        
        
        
                
    }  
 }  
        
        
