package assignment_4;

public class ConsumptionInfo {
    private Thread prevConsumer = null;
    private Thread secondPrevConsumer = null;

    public boolean checkSelfishness(Thread thread) {
        if (this.prevConsumer == this.secondPrevConsumer && this.prevConsumer == thread) {
            this.secondPrevConsumer = this.prevConsumer;
            this.prevConsumer = thread;
            return true;
        } else {
            this.secondPrevConsumer = this.prevConsumer;
            this.prevConsumer = thread;
            return false;
        }
    }
}
