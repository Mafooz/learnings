import java.util.ArrayList;
import java.util.List;

public class ServerPenalty {
    public static int compute_penalty(String logs, int timeRemoved) {
        String[] logArray = logs.split(" ");
        boolean removed=false;
        int count=0;
        for(int i=0;i<logArray.length;i++) {
            if (timeRemoved<=i) {
                removed=true;
            }
            if (removed && "0".equals(logArray[i])) {
                count++;
            }
            if (!removed && "1".equals(logArray[i])) {
                count++;
            }
        }
        return count;
    }
    public static int find_best_removal_time(String logs) {
        int count=Integer.MAX_VALUE;
        int n=logs.split(" ").length;
        int bestTime=-1;
        for(int i=0;i<=n;i++) {
            int currentPenalty = compute_penalty(logs, i);
            if (count>currentPenalty) {
                count=currentPenalty;
                bestTime = i;
            }
        }
        return bestTime;
    }
    public static List<Integer> get_best_removal_times(String logs) {
        List<Integer> bestRemovalTimes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean foundBegin=false;
        for(int i=0;i<logs.length();i++) {
            if (logs.charAt(i)=='B') {
                sb.delete(0, sb.length());
                i=i+4;
                foundBegin=true;
            }
            else if(logs.charAt(i)=='E') {
                if (!sb.isEmpty()) {
                    bestRemovalTimes.add(find_best_removal_time(sb.toString()));
                    sb.delete(0, sb.length());
                }
                foundBegin=false;
            }
            else {
                if (logs.charAt(i)=='\\') {
                    i += 1;
                }
                else if(logs.charAt(i)=='0' && foundBegin) {
                    sb.append("0 ");
                }
                else if (logs.charAt(i)=='1' && foundBegin) {
                    sb.append("1 ");
                }
            }
        }
        return bestRemovalTimes;
    }

    public static void main(String [] args) {
        System.out.println(compute_penalty("0 0 1 0", 0));
        System.out.println(compute_penalty("0 0 1 0", 4));
        System.out.println(find_best_removal_time("0 0 1 1"));
        System.out.println(get_best_removal_times("BEGIN BEGIN \nBEGIN 1 1 BEGIN 1 1 0 0 0 0 1 1\n END 1 1 BEGIN BEGIN 1 1 0 0 0 0 END BEGIN1 1\n END END"));
    }
}
