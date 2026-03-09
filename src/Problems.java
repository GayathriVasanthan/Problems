import java.util.*;

public class Problems {

    static HashMap<String, Integer> userMap = new HashMap<>();
    static HashMap<String, Integer> userAttempts = new HashMap<>();

    public static boolean checkAvailability(String username) {
        userAttempts.put(username, userAttempts.getOrDefault(username, 0) + 1);
        return !userMap.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String alt = username + i;
            if (!userMap.containsKey(alt)) {
                suggestions.add(alt);
            }
        }
        String modified = username.replace("_", ".");
        if (!userMap.containsKey(modified)) {
            suggestions.add(modified);
        }
        return suggestions;
    }

    public static String getMostAttempted() {
        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> e : userAttempts.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                result = e.getKey();
            }
        }
        return result + " (" + max + " attempts)";
    }

    public static void main(String[] args) {
        userMap.put("john_doe", 1);
        userMap.put("admin", 2);

        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));
        System.out.println(suggestAlternatives("john_doe"));
        for (int i = 0; i < 10543; i++) {
            checkAvailability("admin");
        }
        System.out.println(getMostAttempted());
    }
}