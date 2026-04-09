class AccountIDSearch {
    public static void main(String[] args) {
        String arr[] = {"accB", "accA", "accB", "accC"};
        String key = "accB";

        int first = -1, last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println(first + " " + last);

        java.util.Arrays.sort(arr);

        int low = 0, high = arr.length - 1, mid, count = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid].equals(key)) {
                count++;
                break;
            } else if (arr[mid].compareTo(key) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(count);
    }
}