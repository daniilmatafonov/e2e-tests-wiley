package helpers;

import java.util.HashSet;
import java.util.Set;

public class TestData {

    public static Set<String> expectedWhoWeServerItems() {
        Set<String> items = new HashSet<>();
        items.add("Students");
        items.add("Instructors");
        items.add("Book Authors");
        items.add("Professionals");
        items.add("Researchers");
        items.add("Institutions");
        items.add("Librarians");
        items.add("Corporations");
        items.add("Societies");
        items.add("Journal Editors");
        items.add("Bookstores");
        items.add("Government");
        return items;
    }

    public static void printExpectedItems(Set<String> items) {
        for (String name : items) {
            System.out.println(name);
        }
    }
}
