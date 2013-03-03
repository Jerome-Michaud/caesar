package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public abstract class SNumeric extends SType {
    protected final STypeSize size;
    
    SNumeric(STypeSize parSize) {
        this.size = parSize;
    }

    public abstract boolean getBoolValue();
    public abstract long getLongValue();
    public abstract float getFloatValue();

    public STypeSize getSize() {
        return this.size;
    }

    @Override
    public boolean hasSameType(SType parOther) {
        return parOther instanceof SNumeric;
    }
}