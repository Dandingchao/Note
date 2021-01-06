package entity;

public class Testentity3ThreadCountNumber implements Runnable{
    private static int count=0;

    @Override
    public void run() {
        /*while (true){
            try {
                //Thread.sleep(1000);
                System.out.println(count++);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        System.out.println(count++);
    }
}
