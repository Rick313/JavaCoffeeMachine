package utils;

/**
 * Simple date struct
 * @param <A>
 * @param <B>
 */
public class Pair<A, B> {
    public A first;
    public B second;
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}