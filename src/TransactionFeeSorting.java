import java.util.*;

class Transaction {
    String id;
    double fee;
    String ts;

    Transaction(String id, double fee, String ts) {
        this.id = id;
        this.fee = fee;
        this.ts = ts;
    }
}

class TransactionFeeSorting {
    public static void main(String[] args) {
        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        for (Transaction t : list)
            System.out.println(t.id + " " + t.fee);

        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee && list.get(j).ts.compareTo(key.ts) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        for (Transaction t : list)
            if (t.fee > 50)
                System.out.println("Outlier: " + t.id);
    }
}