class Client {
    String name;
    int risk;
    int balance;

    Client(String name, int risk, int balance) {
        this.name = name;
        this.risk = risk;
        this.balance = balance;
    }
}

class ClientRiskRanking {
    public static void main(String[] args) {
        Client arr[] = {
                new Client("A", 20, 1000),
                new Client("B", 50, 2000),
                new Client("C", 80, 500)
        };

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (arr[j].risk < key.risk ||
                    (arr[j].risk == key.risk && arr[j].balance > key.balance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for (int i = 0; i < Math.min(10, n); i++)
            System.out.println(arr[i].name + " " + arr[i].risk);
    }
}