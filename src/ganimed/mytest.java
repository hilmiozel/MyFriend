/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ganimed;

/**
 *
 * @author Rasit
 */
public class mytest extends Thread{
    long minPrime;
         mytest(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             System.out.println("ganimed.mytest.run()");
             while(true)
             {
                 System.out.println("ganimed.mytest.run()");
                 run(5);
                 
             }
         }
         public void run(int x) {
             System.out.println("ganimed.mytest.run()");
             while(true)
             {
                 System.out.println("ganimed.mytest.run()");
             }
         }
         public static void main(String[] args)
	{
		mytest client = new mytest(2);
		client.start();
	}
}

