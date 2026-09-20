public final class MergeSort {

    private static final int CUTOFF = 15;

    private MergeSort() {
    }

    public static void sort(int[] a, Metrics metrics) {

        metrics.reset();
        metrics.start();

        int[] buffer = new int[a.length];

        if (a.length > 0) {
            mergeSort(
                    a,
                    buffer,
                    0,
                    a.length - 1,
                    metrics,
                    1
            );
        }

        metrics.stop();
    }

    private static void mergeSort(
            int[] a,
            int[] buffer,
            int lo,
            int hi,
            Metrics metrics,
            int depth
    ) {

        metrics.recordDepth(depth);

        if (lo >= hi) {
            return;
        }

        if (hi - lo + 1 <= CUTOFF) {

            InsertionSort.sortRange(
                    a,
                    lo,
                    hi,
                    metrics
            );

            return;
        }

        int mid = lo + (hi - lo) / 2;

        mergeSort(
                a,
                buffer,
                lo,
                mid,
                metrics,
                depth + 1
        );

        mergeSort(
                a,
                buffer,
                mid + 1,
                hi,
                metrics,
                depth + 1
        );

        merge(
                a,
                buffer,
                lo,
                mid,
                hi,
                metrics
        );
    }

    private static void merge(
            int[] a,
            int[] buffer,
            int lo,
            int mid,
            int hi,
            Metrics metrics
    ) {

        for (int i = lo; i <= hi; i++) {
            buffer[i] = a[i];
        }

        int left = lo;
        int right = mid + 1;
        int current = lo;

        while (left <= mid && right <= hi) {

            metrics.comparison();

            if (buffer[left] <= buffer[right]) {

                a[current] = buffer[left];
                left++;

            } else {

                a[current] = buffer[right];
                right++;
            }

            current++;
        }

        while (left <= mid) {
            a[current] = buffer[left];
            current++;
            left++;
        }

        while (right <= hi) {
            a[current] = buffer[right];
            current++;
            right++;
        }
    }
}