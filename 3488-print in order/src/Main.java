import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Judge judge = new Judge();

    private static PrintWriter pw;

    static class PrintFirst implements Runnable {
        @Override
        public void run() {
            if (judge.isFirst()) {
                pw.write("First");
            }
        }
    }

    static class PrintSecond implements Runnable {
        @Override
        public void run() {
            if (judge.isSecond()) {
                pw.write("Second");
            }
        }
    }

    static class PrintThird implements Runnable {
        @Override
        public void run() {
            if (judge.isThird()) {
                pw.write("Third");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {

        //String inputPath = args[0];
        //String outputPath = args[1];
        //Scanner sc = new Scanner(new FileReader(inputPath));
        //pw = new PrintWriter(outputPath, "UTF-8");
    	pw = new PrintWriter(System.out);

        Solution solution = new Solution();
        Thread t1 = new Thread(() -> {
            try {
                solution.first(new PrintFirst());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "first");
        Thread t2 = new Thread(() -> {
            try {
                solution.second(new PrintSecond());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "second");
        Thread t3 = new Thread(() -> {
            try {
                solution.third(new PrintThird());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "third");

        Map<Integer, Thread> threadMap = new HashMap<>(3);
        threadMap.put(1, t1);
        threadMap.put(2, t2);
        threadMap.put(3, t3);

        //int[] threadList = judge.parseIntArray(sc.nextLine());
        //judge.runJudge(threadList, threadMap);
        
        t1.start();
        t2.start();
        t3.start();

        //sc.close();
        pw.close();

    }
}