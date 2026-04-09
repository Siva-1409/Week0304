class Asset {
    String name;
    int returnRate;
    int volatility;

    Asset(String n, int r, int v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

class PortfolioSorting {
    static void merge(Asset arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        Asset L[] = new Asset[n1], R[] = new Asset[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2)
            arr[k++] = (L[i].returnRate <= R[j].returnRate) ? L[i++] : R[j++];

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void mergeSort(Asset arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Asset arr[] = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 3)
        };

        mergeSort(arr, 0, arr.length - 1);

        for (Asset a : arr)
            System.out.println(a.name + " " + a.returnRate);
    }
}