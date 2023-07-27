import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        //try {
            //String input = args[0];
            //Scanner sc = new Scanner(new FileReader(input));
            //int num = sc.nextInt();
        	int num = 5;
        	
            ExecutorService pool = Executors.newFixedThreadPool(num + 1);
            CountDownLatch latch = new CountDownLatch(num);
            for (int i = 0; i < num; i++) {
                pool.execute(new Worker(latch));
            }
            pool.execute(new Boss(latch));

            pool.shutdown();
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        
    }
}