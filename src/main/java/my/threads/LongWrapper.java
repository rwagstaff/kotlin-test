package my.threads;

public class LongWrapper {

    private long i;

    public LongWrapper(long i) {
        this.i = i;
    }

    public long getI() {
        return i;
    }

    public void increment() {
        this.i++;
    }
}
