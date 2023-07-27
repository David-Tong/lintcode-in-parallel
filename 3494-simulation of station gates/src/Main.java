import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        try {
            //String inputPath = args[0];
            //Scanner scanner = new Scanner(new FileReader(inputPath));

            ExecutorService service = Executors.newCachedThreadPool();
            Semaphore semaphore = new Semaphore(3);
            //int total = scanner.nextInt();
            int total = 5;
            
            /*
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PrintStream cache = new PrintStream(stream);
            PrintStream temp = System.out;

            System.setOut(cache);*/

            for (int i = 1; i <= total; i++) {
                Person person = new Person(Integer.toString(i), semaphore, new Actions());
                service.submit(person);
            }
            service.shutdown();

            Thread.sleep(300L * total);

            /*
            String result = stream.toString();
            Judge judge = new Judge(result, total);
            System.setOut(temp);
            judge.run();*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}