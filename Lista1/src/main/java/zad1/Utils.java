package zad1;

import java.util.*;

public class Utils {

    public static int longerCipherLength(String[] c0, String[] c1) {
        return c0.length > c1.length ? c0.length : c1.length;
    }

    public static int shorterCipherLength(String[] c0, String[] c1) {
        return c0.length > c1.length ? c1.length : c0.length;
    }

    public static long startTimer(String s) {
        long start = System.currentTimeMillis();
        System.out.println(s);
        return start;
    }

    public static void endTimer(long start, String s) {
        long end = System.currentTimeMillis();
        System.out.println(s + " Took: " + (end - start)+"ms");
    }

    public static List[] createPossibleCharsSetArray(String[] c0) {
        List[] lists = new ArrayList[c0.length];
        for (int j=0; j < c0.length; j++) {
            lists[j] = new ArrayList<Character>();
        }
        return lists;
    }

    public static void printPossibilities(List[] possibleChars) {
        int max = 0;
        boolean any;
        for (List<Pair> list: possibleChars) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        for (int i=0; i < possibleChars.length; i++) {
            any = false;
            List<Character> list = possibleChars[i];
            Iterator<Character> it = list.iterator();
            for (int j=0; j < max; j++){
                for (int k=0; k < j && it.hasNext(); k++)
                    it.next();
                if (it.hasNext()) {
                    char c = it.next();
                    System.out.print("   "  + c + "   ");
                    any = true;
                } else {
                    System.out.print("         ");
                }
            }
            if (any)
                System.out.println();
        }
    }


    public static void printFromPossibleChars(List[] possibleChars) {
        for (int i=0 ; i < 8; i++) {
            for (List list: possibleChars) {
                if (list.size() > i) {
                    char c = (char) list.get(i);
                    if (c == ' ') System.out.print('_');
                    else System.out.print(c);
                } else
                if (i == 0)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printCipher(String[] c0) {
        for (String s: c0)
            System.out.print(s + " ");
        System.out.println();
    }

}
