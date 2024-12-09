import java.util.*;

public class MutualRank {
    private static final Map<String, List<String>> entries = new HashMap<>();

    private static String getMutualChoice(String user, int m) {
        String MthChoice = getNthChoice(user, m);
        if (MthChoice!=null && user.equals(getNthChoice(MthChoice, m))) {
            return MthChoice;
        }
        return null;
    }
    private static String getMutualFirstChoice(String user) {
        return getMutualChoice(user, 0);
    }
    private static String getNthChoice(String user, int m) {
        List<String> rankings = entries.get(user);
        if (rankings==null || rankings.size()<=m) {
            return null;
        }
        return rankings.get(m);
    }

    private static void populateEntries(Map<String, List<String>> entries) {
        entries.put("a", new ArrayList<String>(Arrays.asList("c", "d")));
        entries.put("b", new ArrayList<String>(Arrays.asList("d", "a", "c")));
        entries.put("c", new ArrayList<String>(Arrays.asList("a", "b")));
        entries.put("d", new ArrayList<String>(Arrays.asList("c", "a", "b")));
    }
    private static boolean hasMutualChoice(String user, int m) {
        return getMutualChoice(user, m)!=null;
    }

    private static boolean hasMutualFirstChoice(String user) {
        return getMutualFirstChoice(user)!=null;
    }

    private static List<String> changedPairings(String user, int m) {
        List<String> result = new ArrayList<>();
        if (hasMutualChoice(user, m)) {
            result.add(getMutualChoice(user, m));
        }
        String userAtM = getNthChoice(user, m);
        String userPrecedingM = getNthChoice(user, m-1);
        if (userAtM!=null && user.equals(getNthChoice(userAtM, m-1))) {
            result.add(userAtM);
        }
        if (userPrecedingM!=null && user.equals(getNthChoice(userPrecedingM, m))) {
            result.add(userPrecedingM);
        }
        return result;
    }
    public static void main(String[] args) {
        populateEntries(entries);
        System.out.println(hasMutualFirstChoice("a"));
        System.out.println(hasMutualFirstChoice("b"));
        System.out.println(hasMutualChoice("a", 1));
        System.out.println(hasMutualChoice("a", 0));
        System.out.println(changedPairings("d",1));
        System.out.println(changedPairings("b",1));
        System.out.println(changedPairings("b",2));
    }
}
