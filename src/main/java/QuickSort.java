import java.util.Random;

public final class QuickSort {

    private QuickSort() {
    }

    public static void sort(
            int[] a,
            Metrics metrics
    ) {

        metrics.reset();
        metrics.start();

        if (a.length > 1) {

            int[] equalRange = new int[2];

            quickSort(
                    a,
                    0,
                    a.length - 1,
                    metrics,
                    new Random(),
                    equalRange,
                    1
            );
        }

        metrics.stop();
    }

    private static void quickSort(
            int[] a,
            int lo,
            int hi,
            Metrics metrics,
            Random random,
            int[] equalRange,
            int depth
    ) {

        while (lo < hi) {

            metrics.recordDepth(depth);

            Partition3Way.partition(
                    a,
                    lo,
                    hi,
                    metrics,
                    random,
                    equalRange
            );

            int lt = equalRange[0];
            int gt = equalRange[1];

            int leftSize = lt - lo;
            int rightSize = hi - gt;

            if (leftSize < rightSize) {

                if (leftSize > 1) {

                    quickSort(
                            a,
                            lo,
                            lt - 1,
                            metrics,
                            random,
                            equalRange,
                            depth + 1
                    );
                }

                lo = gt + 1;

            } else {

                if (rightSize > 1) {

                    quickSort(
                            a,
                            gt + 1,
                            hi,
                            metrics,
                            random,
                            equalRange,
                            depth + 1
                    );
                }

                hi = lt - 1;
            }
        }
    }
}