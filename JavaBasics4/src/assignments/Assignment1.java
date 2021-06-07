package assignments;

public class Assignment1 {
    // Singleton

    private static Assignment1 singleton = null;

    private String s;

    private Assignment1() {
        this.s = "hello";
    }

    public static Assignment1 getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Assignment1();
                }
            }
        }
        return singleton;
    }
}
