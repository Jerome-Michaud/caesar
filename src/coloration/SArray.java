package coloration;

/**
 *
 * @author Newbo.O
 */
public class SArray extends SType {
    private final SType eltType;
    protected SType[] values;
    
    public SArray(SType parType) {
        this.eltType = parType;
    }
    
    public SArray(SType parType, long parSize) {
        this.eltType = parType;
        this.values = new SType[(int)parSize];
        for (int i = 0; i < parSize; ++i)
            this.values[i] = parType.clone();
    }

    public SType getElementType() {
        return this.eltType;
    }

    public SType getElement(int parIndex) {
        return this.values[parIndex];
    }

    @Override
    public boolean hasSameType(SType parOther) {
        return parOther instanceof SArray && this.eltType.hasSameType(((SArray)parOther).eltType);
    }

    @Override
    public SArray clone() {
        if (this.values == null)
            return new SArray(this.eltType);
        
        int locLen = this.values.length;
        SArray locClone = new SArray(this.eltType, locLen);
        for (int i = 0; i < locLen; ++i)
            locClone.values[i] = this.values[i].clone();
        return locClone;
    }
}