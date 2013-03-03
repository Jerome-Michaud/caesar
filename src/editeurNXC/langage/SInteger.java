package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public class SInteger extends SNumeric {
    public static final SInteger TRUE = new SInteger(true);
    public static final SInteger FALSE = new SInteger(false);
    public static final SInteger DEFAULT_S8 = new SInteger(STypeSize.S8);
    public static final SInteger DEFAULT_U8 = new SInteger(STypeSize.U8);
    public static final SInteger DEFAULT_S16 = new SInteger(STypeSize.S16);
    public static final SInteger DEFAULT_U16 = new SInteger(STypeSize.U16);
    public static final SInteger DEFAULT_S32 = new SInteger(STypeSize.S32);
    public static final SInteger DEFAULT_U32 = new SInteger(STypeSize.U32);
    private long value;

    public SInteger(STypeSize parSize) {
        super(parSize);
    }
    
    public SInteger(long parValue, STypeSize parSize) {
        super(parSize);
        this.value = computeRealValue(parValue, parSize);
    }

    private static long computeRealValue(long parValue, STypeSize parSize) {
        switch (parSize) {
            case S8:    return (parValue&0x80) == 0 ? parValue&0xFF : parValue|~0xFFL;
            case U8:    return parValue&0xFF;
            case S16:   return (parValue&0x8000) == 0 ? parValue&0xFFFF : parValue|~0xFFFFL;
            case U16:   return parValue&0xFFFF;
            case S32:   return (parValue&0x80000000) == 0 ? parValue&0xFFFFFFFF : parValue|~0xFFFFFFFFL;
            case U32:   return parValue&0xFFFFFFFF;
            default:    return 0;
        }
    }

    public SInteger(boolean parValue) {
        super(STypeSize.U8);
        this.value = parValue ? 1 : 0;
    }

    @Override
    public float getFloatValue() {
        return (float) this.value;
    }

    @Override
    public long getLongValue() {
        return this.value;
    }

    @Override
    public boolean getBoolValue() {
        return this.value != 0;
    }

    @Override
    public void setValue(SType parValue) {
        assert(parValue instanceof SNumeric);
        this.value = computeRealValue(((SNumeric) parValue).getLongValue(), this.size);
    }

    @Override
    public SInteger clone() {
        return new SInteger(this.value, this.size);
    }
}