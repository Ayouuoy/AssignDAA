final class InsertionSort {

    private InsertionSort() {
    }

    static void sortRange(int[] a, int lo, int hi, Metrics metrics) {

        for (int i = lo + 1; i <= hi; i++) {

            int value = a[i];
            int j = i - 1;

            while (j >= lo) {

                metrics.comparison();

                if (a[j] <= value) {
                    break;
                }

                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = value;
        }
    }
}