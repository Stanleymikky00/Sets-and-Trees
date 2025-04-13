package task;

public class Duplicates {
    public static StringSet findDuplicates(String text) {
        StringSet set = new StringSetImpl();
        StringSet returnSet = new StringSetImpl();
        String cleanText = text.replaceAll("\\s+", " ").replaceAll("[^a-zA-Z]", "");
        for (String element : cleanText.split(" ")) {
            if(!set.add(element)) {
                returnSet.add(element);
            }
        }
        return returnSet;
    }
}
