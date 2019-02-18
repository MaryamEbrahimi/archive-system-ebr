package thread;

import java.util.Scanner;

/**
 * @author Maryam Ebrahimi
 */
public class Multi3Thread extends Thread {
    MultiThread t1;
    Multi3Thread (MultiThread multiThread){this.t1 = multiThread;}

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
