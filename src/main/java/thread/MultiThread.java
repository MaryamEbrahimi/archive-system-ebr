package thread;

/**
 * @author Maryam Ebrahimi
 */
public class MultiThread extends Thread {
    private boolean isCanceled;
/* in run() , throwing Exception is not permitted , because this method is overridden
 and the main method doesn't throw any exception , so when a method is used in this
    overridden method, instead of throwing exception , a try catch have to be applied.*/

    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(5000);
            }catch(Exception e ){
                System.out.println("an Exception is thrown");
            }
            System.out.println("thread1 is running");
            if (isCanceled) {
                break;
            }
        }
    }
// this will be killed when run () is finished
    public boolean isCanceled() {
        return isCanceled;
    }
    // booleans: getter & setter have specific signatures

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

}
