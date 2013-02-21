package jscratch.interpreteur.parser;

/**
 *
 * @author Newbo.O
 * @author Adrien DUROY
 */
public class WarningOrError {
    private final int lineNumber;
	private final int carPosInLine;
    private final boolean isError;
    private final String details;

    public WarningOrError(int parLine, int carPos, boolean parIsError, String parDetails) {
        lineNumber = parLine;
		carPosInLine = carPos;
        isError = parIsError;
        details = parDetails;
    }

    public int getLineNumber() {
        return lineNumber;
    }
	
	public int getCarPosInLine() {
		return carPosInLine;
	}

    public boolean isError() {
        return isError;
    }

    public String getDetails() {
        return details;
    }
	
	@Override
	public String toString() {
		String type = isError?"ERROR - ":"WARNING - ";
		return type + lineNumber + ":" + carPosInLine + " > " + details;
	}
}
