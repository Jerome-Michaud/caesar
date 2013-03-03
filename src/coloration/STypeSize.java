package coloration;

/**
 *
 * @author Newbo.O
 */
public enum STypeSize {
    S8(0), U8(1), S16(2), U16(3), S32(4), U32(5);

    private final int rank;

    private STypeSize(int parRank) {
        this.rank = parRank;
    }

    public static STypeSize maxSize(STypeSize parSize1, STypeSize parSize2) {
        return parSize1.rank > parSize2.rank ? parSize1 : parSize2;
    }
}