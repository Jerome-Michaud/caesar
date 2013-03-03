package coloration;

/**
 *
 * @author Newbo.O
 */
public class SString extends SArray {
    public SString() {
        super(new SInteger(STypeSize.S8));
    }

    public SString(String parStr) {
        this();
        this.values = new SInteger[parStr.length()];
        for (int i=0; i<parStr.length(); ++i)
            this.values[i] = new SInteger(parStr.charAt(i), STypeSize.S8);
    }
}
