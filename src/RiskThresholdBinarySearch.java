class RiskThresholdBinarySearch {
    public static void main(String[] args) {
        int arr[] = {10, 25, 50, 100};
        int key = 30;

        int floor = -1, ceil = -1;

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < key) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
    }
}