public class Tasks {

    public void pileDriving() {
        System.out.println("@Pile-driving");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buildBridge() {
        System.out.println("@Build the bridge");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
