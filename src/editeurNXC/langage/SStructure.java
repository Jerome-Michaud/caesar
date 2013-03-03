package editeurNXC.langage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Newbo.O
 */
public class SStructure extends SType {
    private final String structName;
    private final Map<String,SType> fields;

    public SStructure(String parName) {
        this.structName = parName;
        this.fields = new HashMap<String,SType>();
    }

    public String getTypeName() {
        return this.structName;
    }

    public void addField(String parName, SType parType) {
        this.fields.put(parName, parType);
    }
    

    public Map<String, SType> getFields() {
		return fields;
	}

	public boolean fieldExists(String parName) {
        return this.fields.containsKey(parName);
    }

    public SType getField(String parName) {
        return this.fields.get(parName);
    }

    @Override
    public void setValue(SType parValue) {
        assert (parValue instanceof SStructure) && ((SStructure)parValue).structName.equals(this.structName);
        SStructure locOtherStruct = (SStructure)parValue;
        for(Map.Entry<String,SType> locEntry : locOtherStruct.fields.entrySet())
            this.fields.put(locEntry.getKey(), locEntry.getValue().clone());
    }

    @Override
    public boolean hasSameType(SType parOther) {
        return parOther instanceof SStructure && this.structName.equals(((SStructure)parOther).structName);
    }

    @Override
    public SStructure clone() {
        SStructure locClone = new SStructure(this.structName);
        for(Map.Entry<String,SType> locEntry : this.fields.entrySet())
            locClone.addField(locEntry.getKey(), locEntry.getValue().clone());
        return locClone;
    }
}