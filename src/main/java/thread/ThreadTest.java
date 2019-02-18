package thread;

/**
 * @author Maryam Ebrahimi
 */
public class ThreadTest {
    public static void main(String[] args) {

        MultiThread t1 = new MultiThread();
        t1.start();
        Multi2Thread t2 = new Multi2Thread(t1);
        t2.start();
        //or
        Multi3Thread t3 = new Multi3Thread(t1);
        t3.start();
    }
    //this thread is active until its last line it means start then it will be killed.
}
