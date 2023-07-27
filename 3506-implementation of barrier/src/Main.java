import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            String inputPath = args[0];
            String outputPath = args[1];
            Scanner sc = new Scanner(new FileReader(inputPath));
            int threads = sc.nextInt();

            IBarrier barrier = new IBarrier(threads);
            Judge judge = new Judge(threads, outputPath, barrier);

            judge.runThreads();
            judge.runJudge();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
