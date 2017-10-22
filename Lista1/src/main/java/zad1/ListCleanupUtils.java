package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListCleanupUtils {

    public static void removeDuplicates(List[] possibleChars, int j) {
        possibleChars[j] = (List)
                possibleChars[j].stream().distinct().collect(Collectors.toList());
    }


    public static void cleanupPossibleChars(List[] possibleChars) {
        changeUppercaseToLowerWherePossible(possibleChars);
        moveNumbersToEnd(possibleChars);
        orderPunctuation(possibleChars);
    }

    private static void changeUppercaseToLowerWherePossible(List[] possibleChars) {
        for (List l: possibleChars) {
            List<Character> toRemove = new ArrayList<>();
            l.stream().forEach(
                    (character) -> {
                        if (Character.isUpperCase((Character) character))
                            if (l.contains(Character.toLowerCase((Character) character)))
                                toRemove.add((Character) character);
                    }
            );
            l.removeAll(toRemove);
        }
    }

    private static void moveNumbersToEnd(List[] possibleChars) {
        for (List l: possibleChars) {
            List<Character> toRemove = new ArrayList<>();
            l.stream().forEach(
                    (character) -> {
                        if (Character.isDigit((Character) character))
                            toRemove.add((Character) character);
                    }
            );
            l.removeAll(toRemove);
            l.addAll(toRemove);
        }
    }

    private static void orderPunctuation(List[] possibleChars) {
        for (List l: possibleChars) {
            List<Character> toRemove = new ArrayList<>();
            l.stream().forEach(
                    (character) -> {
                        if (    (Character) character == '"' ||
                                (Character) character == '(' ||
                                (Character) character == ')' ||
                                (Character) character == '\''||
                                (Character) character == '-' ||
                                (Character) character == '?' ||
                                (Character) character == '!' ||
                                (Character) character == '.' ||
                                (Character) character == ',' ||
                                (Character) character == ':' ||
                                (Character) character == ';'
                                )
                            toRemove.add((Character) character);
                    }
            );
            l.removeAll(toRemove);
            l.addAll(toRemove);
        }
    }

}
