import java.util.*;


public class HTTPHeaderParser {
    public static  void convert(HashMap<String, List<String>> mapOfLanguages, String[] listOfLanguagesList) {
        for (String s : listOfLanguagesList) {
            String firstPart = s.split("-")[0];
            if (!mapOfLanguages.containsKey(firstPart)) {
                mapOfLanguages.put(firstPart, new ArrayList<>());
            }
            mapOfLanguages.get(firstPart).add(s);
            if (!mapOfLanguages.containsKey(s)) {
                mapOfLanguages.put(s, null);
            }
        }
    }

    public static List<String> parse_accept_language(String listOfLanguages, String[] acceptedLanguages) {
        Set<String> addedLanguages = new HashSet<>();
        List<String> parsedList = new ArrayList<>();
        String[] listOfLanguagesList = listOfLanguages.split(", ");
        HashMap<String, List<String>> mapOfLanguages = new HashMap<>();
        convert(mapOfLanguages, acceptedLanguages);
        for (String s : listOfLanguagesList) {
            if (s.equals("*")) {
                for (String pref: acceptedLanguages) {
                    if (!addedLanguages.contains(pref)) {
                        addedLanguages.add(pref);
                        parsedList.add(pref);
                    }
                }
                break;
            }
            if (mapOfLanguages.containsKey(s)) {
                if (mapOfLanguages.get(s)!=null) {
                    for (String language: mapOfLanguages.get(s)) {
                        if (!addedLanguages.contains(language)) {
                            addedLanguages.add(language);
                            parsedList.add(language);
                        }
                    }
                }
                else {
                    if (!addedLanguages.contains(s)) {
                        addedLanguages.add(s);
                        parsedList.add(s);
                    }
                }
            }
        }
        return parsedList;
    }

    public static void main(String[] args) {
        System.out.println(parse_accept_language("en-US, fr-CA, fr-FR", new String[] {"fr-FR", "en-US"}));
        System.out.println(parse_accept_language("fr-CA, fr-FR", new String[]{"en-US", "fr-FR"}));
        System.out.println(parse_accept_language("en-US", new String[]{"en-US", "fr-FR"}));
        System.out.println( parse_accept_language("en", new String[]{"en-US", "fr-CA", "fr-FR"}));
        System.out.println( parse_accept_language("fr", new String[]{"en-US", "fr-CA", "fr-FR"}));
        System.out.println( parse_accept_language("fr-FR, fr", new String[]{"en-US", "fr-CA", "fr-FR"}));
        System.out.println( parse_accept_language("en-US, *", new String[]{"en-US", "fr-CA", "fr-FR"}));
        System.out.println( parse_accept_language("fr-FR, fr, *", new String[]{"en-US", "fr-CA", "fr-FR"}));
    }
}
