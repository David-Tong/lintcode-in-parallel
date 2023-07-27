public class Main {

    public static void main(String[] args) {

        Object o = new Object();

        try {
            new Thread(new Solution(1, o)).start();
            new Thread(new Solution(2, o)).start();
            new Thread(new Solution(3, o)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}