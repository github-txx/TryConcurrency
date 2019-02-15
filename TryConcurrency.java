import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args){
        final String[] arr1 = {"a","b","c","d"};
        String[] arr2 = {"1","2","3","4"};
        //通过匿名内部类的方式创建线程，并且重写其中的run方法
        new Thread(){
            @Override
            public void run(){
                printArr(arr1);
            }
        }.start();
        sleep(1);
        printArr(arr2);
    }

    private static void printArr( String[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
            sleep(2);
        }
    }

    /**
     * Simulate the wait and ignore exception
     * @param seconds
     */
    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
