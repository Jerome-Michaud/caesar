package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public abstract class SType {
    public static final SType VOID = new SType() {
        @Override
        public boolean hasSameType(SType parOther) {
            return this == parOther;
        }

        @Override
        public SType clone() {
            return this;
        }
    };

    public void setValue(SType parValue) {
        assert false;
    }

    public abstract boolean hasSameType(SType parOther);
    @Override
    public abstract SType clone();
}