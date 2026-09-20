public class Metrics {

    private long comparisons;
    private int maxDepth;
    private long startTime;
    private long elapsedNanos;

    public void reset() {
        comparisons = 0;
        maxDepth = 0;
        startTime = 0;
        elapsedNanos = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        elapsedNanos = System.nanoTime() - startTime;
    }

    public void comparison() {
        comparisons++;
    }

    public void recordDepth(int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public long getComparisons() {
        return comparisons;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public double getTimeMs() {
        return elapsedNanos / 1_000_000.0;
    }
}