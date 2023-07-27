import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            //String inputPath = args[0];
            //String outputPath = args[1];
        	String outputPath = "";
            //Scanner sc = new Scanner(new FileReader(inputPath));
            
            Function function = new Function();
            Store store = new Store(function);
            //int n = sc.nextInt();
            int n = 4;
            
            runThreads(n, store);

            Judge judge = new Judge(function, n, outputPath);
            judge.inputJudge();
            judge.runJudge();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void runThreads(int n, Store store) throws InterruptedException {
        int times = n / 3;
        int extra = n % 3;
        List<Thread> threads = new ArrayList<>(4);
        threads.add(new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    store.provider();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Provider"));

        threads.add(new Thread(() -> {
            for (int i = 0; i < (extra > 0 ? times + 1 : times); i++) {
                try {
                    store.customer1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Customer1"));
        threads.add(new Thread(() -> {
            for (int i = 0; i < (extra > 1 ? times + 1 : times); i++) {
                try {
                    store.customer2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Customer2"));
        threads.add(new Thread(() -> {
            for (int i = 0; i < times; i++) {
                try {
                    store.customer3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Customer3"));

        Collections.shuffle(threads);

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}