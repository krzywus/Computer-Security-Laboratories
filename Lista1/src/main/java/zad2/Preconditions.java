package zad2;

public class Preconditions {
    public static void checkPreconditions(String[] args) {
        if (args.length < 4) {
            System.out.println("Wrong usage. Provide arguments: " +
                    "[iv]" +
                    "[key-sufiks]" +
                    "[key length]" +
                    "[cipher]");
            System.exit(1);
        }
    }
}