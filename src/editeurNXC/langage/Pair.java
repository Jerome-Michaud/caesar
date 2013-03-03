package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public class Pair<T,U> {
    private final T first;
    private final U second;

    public Pair(T parFirst, U parSecond) {
        this.first = parFirst;
        this.second = parSecond;
    }

    public T first() {
        return this.first;
    }

    public U second() {
        return this.second;
    }
}
