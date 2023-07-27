public class Actions {

    public void enter(String name) throws InterruptedException {
        System.out.println(name + " entering");
        Thread.sleep(200);
    }

    public void pass(String name) {
        System.out.println(name + " passed");
    }

}
