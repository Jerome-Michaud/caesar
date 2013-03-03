package coloration;

/**
 *
 * @author Newbo.O
 */
public class SFloat extends SNumeric {
    public static final SFloat DEFAULT_FLOAT = new SFloat();
    private float value;

    public SFloat() {
        super(STypeSize.S32);
    }

    public SFloat(float parValue) {
        super(STypeSize.S32);
        this.value = parValue;
    }

    public SFloat(boolean parValue) {
        super(STypeSize.S32);
        this.value = parValue ? 1f : 0f;
    }

    public SFloat(double parValue) {
        this((float) parValue);
    }

    @Override
    public boolean getBoolValue() {
        return this.value != 0f;
    }

    @Override
    public long getLongValue() {
        return (long) this.value;
    }

    @Override
    public float getFloatValue() {
        return this.value;
    }

    @Override
    public void setValue(SType parValue) {
        assert(parValue instanceof SNumeric);
        this.value = ((SNumeric) parValue).getFloatValue();
    }

    @Override
    public SFloat clone() {
        return new SFloat(this.value);
    }
}