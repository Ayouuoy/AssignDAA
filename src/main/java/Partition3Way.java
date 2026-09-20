import java.util.Random;

final class Partition3Way {

    private Partition3Way() {
    }

    static void partition(
            int[] a,
            int lo,
            int hi,
            Metrics metrics,
            Random random,
            int[] equalRange
    ) {

        int pivotIndex =
                lo + random.nextInt(hi - lo + 1);

        int pivot = a[pivotIndex];

        int lt = lo;
        int i = lo;
        int gt = hi;

        while (i <= gt) {

            metrics.comparison();

            if (a[i] < pivot) {

                swap(a, lt, i);

                lt++;
                i++;

            } else {

                metrics.comparison();

                if (a[i] > pivot) {

                    swap(a, i, gt);
                    gt--;

                } else {

                    i++;
                }
            }
        }

        equalRange[0] = lt;
        equalRange[1] = gt;
    }

    private static void swap(
            int[] a,
            int i,
            int j
    ) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}