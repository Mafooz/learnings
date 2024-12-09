import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UserPoints {

    static class Transaction implements Comparable<Transaction>{
        public String payer;
        public int points;
        public long timeStamp;

        public Transaction(String payer, int points, long timeStamp) {
            this.payer = payer;
            this.points = points;
            this.timeStamp = timeStamp;
        }
        @Override
        public int compareTo(Transaction currentTransaction) {
            return Long.compare(this.timeStamp, currentTransaction.timeStamp);
        }
    }

    private static PriorityQueue<Transaction> priorityQueue = new PriorityQueue<>();
    private static Map<String, Integer> payerDetails = new HashMap<>();
    public static void addTransaction(String payerName, int points, long timstamp) {
        if (!payerDetails.containsKey(payerName)) {
            payerDetails.put(payerName, 0);
        }
        payerDetails.put(payerName, payerDetails.get(payerName) + points);
        priorityQueue.add(new Transaction(payerName, points, timstamp));
    }
    public static void spend(int points) {
        while(points>0) {
            Transaction top = priorityQueue.poll();
            if (top==null) {
                System.out.println("Insufficient amount");
                break;
            }
            if (top.points > points) {
                payerDetails.put(top.payer, payerDetails.get(top.payer)-points);
                top.points -= points;
                priorityQueue.add(top);
                points = 0;
            } else if (top.points == points) {
                payerDetails.put(top.payer, payerDetails.get(top.payer)-points);
                payerDetails.put(top.payer, top.points - points);
                points = 0;
            } else {
                points -= top.points;
                payerDetails.put(top.payer, payerDetails.get(top.payer)- top.points);
            }
        }
    }
    public static void balance() {
        for (String payer : payerDetails.keySet()) {
            System.out.println(payer + ": " + payerDetails.get(payer));
        }
    }

    public static void main(String [] args) {
        addTransaction( "DANNON", 1000, parse("2020-11-02T14:00:00Z"));
        addTransaction( "UNILEVER", 200, parse("2020-10-31T11:00:00Z"));
        addTransaction( "DANNON", -200, parse("2020-10-31T15:00:00Z"));
        addTransaction( "MILLER COORS", 10000, parse("2020-11-01T14:00:00Z"));
        addTransaction( "DANNON", 300, parse("2020-10-31T10:00:00Z"));
        balance();
        spend(5000);
        balance();
    }
    public static long parse(String dateTime) {
        String date = dateTime.split("T")[0];
        String time = dateTime.split("T")[1];
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt(time.split(":")[2].split("Z")[0]);
        return new Date(year, month-1, day, hour, min, sec).getTime();
    }
}
