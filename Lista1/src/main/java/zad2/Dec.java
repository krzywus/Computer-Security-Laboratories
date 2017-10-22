package zad2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Dec {

    private static final char[] lang = {
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f',
    };
    private static List<Character> langList = new ArrayList<>();
    private static String iv;
    private static String key_ending;
    private static String cipher;
    private static int key_begg_length;

    public static void main(String[] args) {
        Preconditions.checkPreconditions(args);
        initFromArgs(args);
        System.setProperty("rx2.computation-threads","4");
        BruteForcePipe pipe = new BruteForcePipe(iv, key_ending, cipher);

        char[] guess = getFirstGuess();
        compute(pipe, guess.clone());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void compute(final BruteForcePipe pipe, char[] guess) {
        for (int i = 0; i < Math.pow(lang.length, key_begg_length-1) ; i++) {
            List<String> guessList = new ArrayList<>();
            for (int j = 0; j < lang.length; j++) {
                increment(guess, 0);
                guessList.add(valueOf(guess));
            }
            pipe.subcribe(guessList.toArray(new String[0]));
        }
    }

    private static void increment(char[] guess, int i) {
        if (guess[i] == lang[lang.length-1]) {
            guess[i] = lang[0];
            if (i+1 < key_begg_length)
                increment(guess, i+1);
        } else {
            int pos = langList.indexOf(guess[i]);
            guess[i] = lang[pos+1];
        }
    }

    private static void initFromArgs(String[] args) {
        iv = args[0];
        key_ending = args[1];
        int key_length = parseInt(args[2]);
        cipher = args[3];
        key_begg_length = key_length - key_ending.length();
        for (char c: lang) {
            langList.add(c);
        }
    }

    private static char[] getFirstGuess() {
        char[] guess = new char[key_begg_length];
        for (int i=0; i < key_begg_length; i++) {
            guess[i] = lang[0];
        }
        return guess;
    }

}
