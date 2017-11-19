package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Parser {

    public static final String FILE_NAME
            = "/home/krzywus/workspace/Idea/BezpieczenstwoKomputerowe/Lista1/src/main/java/zad1/data";

    static void parseData(List<String[]> ciphers) {
        try {
            FileReader input = new FileReader(FILE_NAME);
            BufferedReader bufRead = new BufferedReader(input);
            String line;
            while ((line = bufRead.readLine()) != null) {
                if (!line.startsWith("kryptogram") && !line.equals(""))
                    ciphers.add(line.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char getChar(String s2) {
        return (char) getInt(s2);
    }

    public static int getInt(String s2) {
        return Integer.parseInt(s2, 2);
    }

    public static String xor(String s, char c){
        String charString = Integer.toBinaryString(c);
        while (charString.length() < s.length())
            charString = "0" + charString;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < 8; i++) {
            int i1 = Integer.parseInt(s.substring(i, i + 1));
            int i2 = Integer.parseInt(charString.substring(i, i + 1));
            char m = (i1 ^ i2) == 0 ? '0' : '1';
            sb.append(m);
        }
        return sb.toString();
    }

    public static String xor(String s, String c){
        StringBuilder sb = new StringBuilder();
        while (s.length() < 8)
            s = "0" + s;
        while (c.length() < 8)
            c = "0" + c;
        for (int i=0; i < 8; i++) {
            int i1 = Integer.parseInt(s.substring(i, i + 1));
            int i2 = Integer.parseInt(c.substring(i, i + 1));
            char m = (i1 ^ i2) == 0 ? '0' : '1';
            sb.append(m);
        }
        return sb.toString();
    }
}