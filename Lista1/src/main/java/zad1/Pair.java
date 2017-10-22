package zad1;

public class Pair {
    public final char a;
    public final char b;

    public Pair(int i, int j) {
        a = (char) i;
        b = (char) j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (a == pair.a && b == pair.b)
            return true;
        if (a == pair.b && b == pair.a)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "(" + a + " " + b + ")";
    }
}