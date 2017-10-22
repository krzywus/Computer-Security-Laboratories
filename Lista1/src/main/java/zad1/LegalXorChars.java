package zad1;

import java.util.*;
import java.util.stream.Collectors;

import static zad1.Parser.xor;

public class LegalXorChars {

    private static Map<String, List<Pair>> legalChars = new HashMap<>();

    public static void generate() {
        Map<Pair, String> pairToString = new HashMap<>();
        for (int i = ' '; i <= 'z'; i++) {
            if (isSkipped(i)) continue;
            for (int j = i; j <= 'z'; j++) {
                if (isSkipped(j)) continue;
                String s1 = Integer.toBinaryString(i);
                String s2 = Integer.toBinaryString(j);
                pairToString.put(new Pair(i, j), xor(s1, s2));
            }
        }
//        System.out.println(pairToString.values().size());
//        System.out.println(pairToString.values().stream().distinct().collect(Collectors.toList()).size());
//        System.out.println(pairToString.values().stream().distinct().collect(Collectors.toList()));
        for (String s: pairToString.values().stream().distinct().collect(Collectors.toList())) {
            List<Pair> list = new ArrayList<>();
            for (Pair pair: pairToString.keySet())
                if (pairToString.get(pair).equals(s))
                    list.add(pair);
            legalChars.put(s, list);
        }
//        System.out.println(legalChars.size());
    }

    public static List<Pair> getLegalChars(String s) {
        return legalChars.get(s);
    }

    public static boolean isLegalChar(char c) {
        return legalChars.containsValue(Integer.toBinaryString(c));
    }


    private static boolean  isSkipped(int i) {
        return
                i == '@' ||
                i == '$' ||
                i == '=' ||
                i == '#' ||
                i == '/' ||
                i == '\\'||
                i == '&' ||
                i == '*' ||
                i == '^' ||
                i == '[' || i == ']' ||
                i == '+' ||
                i == '`' ||
                i == '\'' ||
                i == 'x' || i == 'X' ||
                i == 'q' || i == 'Q' ||
//                i == 'v' || i == 'V' ||
                i == '_' ||
                i == ';' ||
                i == '%' ||
                i == '<' || i == '>'
                ;
    }

    private static boolean isNumber(int i){
        return i == '0' || i == '1' ||
                i == '2' || i == '3' ||
                i == '4' || i == '5' ||
                i == '6' || i == '7' ||
                i == '8' || i == '9';
    }

    private static boolean isInterpunct(int i){
        return i == '.' || i == '"' ||
                i == '\'' || i == ',' ||
                i == '?' || i == '!' ||
                i == '-' || i == '_' ||
                i == ':' || i == ';' ||
                i == '(' || i == ')';
    }

}
