package thread;

import java.util.Scanner;

/**
 * @author Maryam Ebrahimi
 */
public class Multi2Thread extends Thread {
    /* this line is executed in the first line of the main when the object of t2 is
     instantiated, because at first instance variables then constructors are made
    when an object is made. */

    MultiThread t1 = new MultiThread();
    private MultiThread t;
    public Multi2Thread (MultiThread t){
        this.t = t;
    }

    // run never has any parameters
    public void run() {
        t1.start();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("enter exit to finish the programmer");
            String next = scanner.next();
            if (next.equals("exit")) {
                t1.setCanceled(true);
                break;
                // break is used here to kill the thread
            }
        }
    }
    // this thread will be killed like thread main until its last line which is run method.
}
