package zad1;


import java.util.*;

import static zad1.LegalXorChars.getLegalChars;
import static zad1.ListCleanupUtils.cleanupPossibleChars;
import static zad1.ListCleanupUtils.removeDuplicates;
import static zad1.Parser.parseData;
import static zad1.Parser.xor;
import static zad1.Utils.*;

public class Dec {

    private static Map<Pair, String[]> xors = new HashMap<>();
    private static List<String[]> ciphers = new ArrayList<>();

    public static void main(String[] args) {
        parseData(ciphers);
        LegalXorChars.generate();

        List<List[]> possibilities = new ArrayList<>();
        for(int k=0; k < ciphers.size(); k++) {
            createPossibleChars(possibilities, k);
        }

       for (List[] p: possibilities)
            printFromPossibleChars(p);

    }

    private static void createPossibleChars(List<List[]> possibilities, int k) {
        String[] c0 = ciphers.get(k);
        List[] possibleChars = createPossibleCharsSetArray(c0);

        for (int i=0; i < ciphers.size(); i++) {
            if (i==k) continue;
            String[] c1 = ciphers.get(i);
            Pair pair = new Pair(k, i);

            xorCiphers(c0, c1, pair);

            intersectPossibleChars(k, c0, possibleChars, i, c1, pair);
        }
        cleanupPossibleChars(possibleChars);
        possibilities.add(possibleChars);
    }

    private static void xorCiphers(String[] c0, String[] c1, Pair pair) {
        List<String> currentXors = createXorsForCiphers(c0, c1);
        xors.put(pair, currentXors.toArray(new String[currentXors.size()]));
    }

    private static List<String> createXorsForCiphers(String[] c0, String[] c1) {
        List<String> currentXors = new ArrayList<>();
        for (int i = 0; i < shorterCipherLength(c0, c1); i++) {
            String xor = xor(c0[i], c1[i]);
            currentXors.add(xor);
        }
        return currentXors;
    }

    private static void intersectPossibleChars(int k, String[] c0, List[] possibleChars, int i, String[] c1, Pair pair) {
        for (int j = 0; j < shorterCipherLength(c0, c1); j++) {
            if (isFirstSet(k, i)) {
                List<Pair> legalChars = getLegalChars(xors.get(pair)[j]);
                addAllCharsToList(possibleChars[j], legalChars);
            } else {
                List<Pair> legalChars = getLegalChars(xors.get(pair)[j]);
                List<Character> c0LegalChars = new ArrayList<>();
                addAllCharsToList(c0LegalChars, legalChars);
                possibleChars[j].retainAll(c0LegalChars);
                removeDuplicates(possibleChars, j);
            }
        }
    }

    private static boolean isFirstSet(int k, int i) {
        return i == 0 && k > i || k == 0 && i == 1;
    }

    private static void addAllCharsToList(List possibleChar, List<Pair> legalChars) {
        for (Pair p: legalChars) {
            possibleChar.add(p.a);
            possibleChar.add(p.b);
        }
    }

}
