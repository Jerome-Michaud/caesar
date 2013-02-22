// $ANTLR 3.3 Nov 30, 2010 12:50:56 ../grammaire/NXC.g 2013-01-11 15:39:51

/*
 * Le contenu de ce fichier est généré par la biblithèque ANTLR
 * à partir du fichier NXC.g
 */
package jscratch.interpreteur.parser;

import java.util.LinkedList;
import java.util.List;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class NXCLexer extends Lexer {

	public static final int EOF = -1;
	public static final int T__120 = 120;
	public static final int T__121 = 121;
	public static final int T__122 = 122;
	public static final int T__123 = 123;
	public static final int T__124 = 124;
	public static final int T__125 = 125;
	public static final int T__126 = 126;
	public static final int T__127 = 127;
	public static final int T__128 = 128;
	public static final int T__129 = 129;
	public static final int T__130 = 130;
	public static final int ROOT = 4;
	public static final int FUNCTION_DEFINITION = 5;
	public static final int FUNCTION_DECLARATION = 6;
	public static final int PARAMETERS = 7;
	public static final int TASK_DEFINITION = 8;
	public static final int TASK_DECLARATION = 9;
	public static final int VAR_DECLARATION = 10;
	public static final int DIMENSION = 11;
	public static final int STRUCT_FIELD = 12;
	public static final int INITIALIZER = 13;
	public static final int STATEMENTS = 14;
	public static final int CAST = 15;
	public static final int DIMENSION_ACCESS = 16;
	public static final int FIELD_ACCESS = 17;
	public static final int PRE = 18;
	public static final int POST = 19;
	public static final int FUNC_CALL = 20;
	public static final int ARGUMENTS = 21;
	public static final int LABEL = 22;
	public static final int TERNARY = 23;
	public static final int T_VOID = 24;
	public static final int T_S8 = 25;
	public static final int T_U8 = 26;
	public static final int T_S16 = 27;
	public static final int T_U16 = 28;
	public static final int T_S32 = 29;
	public static final int T_U32 = 30;
	public static final int T_FLOAT = 31;
	public static final int T_STRING = 32;
	public static final int T_MUTEX = 33;
	public static final int SAFECALL = 34;
	public static final int INLINE = 35;
	public static final int IDENTIFIER = 36;
	public static final int TASK = 37;
	public static final int TYPEDEF = 38;
	public static final int CONST = 39;
	public static final int VOID = 40;
	public static final int SUB = 41;
	public static final int CHAR = 42;
	public static final int UNSIGNED = 43;
	public static final int BOOL = 44;
	public static final int BYTE = 45;
	public static final int SHORT = 46;
	public static final int INT = 47;
	public static final int LONG = 48;
	public static final int FLOAT = 49;
	public static final int STRING = 50;
	public static final int MUTEX = 51;
	public static final int ENUM = 52;
	public static final int DECIMAL_LITERAL = 53;
	public static final int HEX_LITERAL = 54;
	public static final int STRUCT = 55;
	public static final int CHARACTER_LITERAL = 56;
	public static final int STRING_LITERAL = 57;
	public static final int FLOAT_LITERAL = 58;
	public static final int TRUE = 59;
	public static final int FALSE = 60;
	public static final int IF = 61;
	public static final int SWITCH = 62;
	public static final int ELSE = 63;
	public static final int CASE = 64;
	public static final int DEFAULT = 65;
	public static final int WHILE = 66;
	public static final int UNTIL = 67;
	public static final int REPEAT = 68;
	public static final int DO = 69;
	public static final int FOR = 70;
	public static final int GOTO = 71;
	public static final int CONTINUE = 72;
	public static final int BREAK = 73;
	public static final int RETURN = 74;
	public static final int START = 75;
	public static final int STOP = 76;
	public static final int PRIORITY = 77;
	public static final int PLUSPLUS = 78;
	public static final int PLUS = 79;
	public static final int MINUSMINUS = 80;
	public static final int MINUS = 81;
	public static final int STAR = 82;
	public static final int DIVIDE = 83;
	public static final int MOD = 84;
	public static final int LSHIFT = 85;
	public static final int RSHIFT = 86;
	public static final int AND = 87;
	public static final int OR = 88;
	public static final int XOR = 89;
	public static final int TILDE = 90;
	public static final int NOT = 91;
	public static final int ANDAND = 92;
	public static final int OROR = 93;
	public static final int EQUAL = 94;
	public static final int NOTEQUAL = 95;
	public static final int LESSEQUAL = 96;
	public static final int LESSTHAN = 97;
	public static final int GREATEREQUAL = 98;
	public static final int GREATERTHAN = 99;
	public static final int ASSIGN = 100;
	public static final int PLUSASSIGN = 101;
	public static final int MINUSASSIGN = 102;
	public static final int STARASSIGN = 103;
	public static final int DIVASSIGN = 104;
	public static final int MODASSIGN = 105;
	public static final int LSHIFTASSIGN = 106;
	public static final int RSHIFTASSIGN = 107;
	public static final int ANDASSIGN = 108;
	public static final int ORASSIGN = 109;
	public static final int XORASSIGN = 110;
	public static final int LETTER = 111;
	public static final int EscapeSequence = 112;
	public static final int HexDigit = 113;
	public static final int Exponent = 114;
	public static final int EOL = 115;
	public static final int WHITESPACE = 116;
	public static final int COMMENT = 117;
	public static final int LINE_COMMENT = 118;
	public static final int UNK = 119;
	List<WarningOrError> compilMessages = new LinkedList<WarningOrError>();

	@Override
	public void emitErrorMessage(String msg) {
	}

	@Override
	public void reportError(RecognitionException e) {
		this.compilMessages.add(new WarningOrError(e.line, e.charPositionInLine, true, "Problème avec le caractère " + Character.toString((char) e.c)));
	}

	public List<WarningOrError> getCompilMessages() {
		return this.compilMessages;
	}

	// delegates
	// delegators
	public NXCLexer() { }

	public NXCLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public NXCLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	@Override
	public String getGrammarFileName() {
		return "../grammaire/NXC.g";
	}

	// $ANTLR start "T__120"
	public final void mT__120() throws RecognitionException {
		try {
			int _type = T__120;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:27:8: ( '(' )
			// ../grammaire/NXC.g:27:10: '('
			{
				match('(');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__120"

	// $ANTLR start "T__121"
	public final void mT__121() throws RecognitionException {
		try {
			int _type = T__121;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:28:8: ( ')' )
			// ../grammaire/NXC.g:28:10: ')'
			{
				match(')');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__121"

	// $ANTLR start "T__122"
	public final void mT__122() throws RecognitionException {
		try {
			int _type = T__122;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:29:8: ( ';' )
			// ../grammaire/NXC.g:29:10: ';'
			{
				match(';');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__122"

	// $ANTLR start "T__123"
	public final void mT__123() throws RecognitionException {
		try {
			int _type = T__123;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:30:8: ( ',' )
			// ../grammaire/NXC.g:30:10: ','
			{
				match(',');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__123"

	// $ANTLR start "T__124"
	public final void mT__124() throws RecognitionException {
		try {
			int _type = T__124;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:31:8: ( '{' )
			// ../grammaire/NXC.g:31:10: '{'
			{
				match('{');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__124"

	// $ANTLR start "T__125"
	public final void mT__125() throws RecognitionException {
		try {
			int _type = T__125;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:32:8: ( '}' )
			// ../grammaire/NXC.g:32:10: '}'
			{
				match('}');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__125"

	// $ANTLR start "T__126"
	public final void mT__126() throws RecognitionException {
		try {
			int _type = T__126;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:33:8: ( '[' )
			// ../grammaire/NXC.g:33:10: '['
			{
				match('[');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__126"

	// $ANTLR start "T__127"
	public final void mT__127() throws RecognitionException {
		try {
			int _type = T__127;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:34:8: ( ']' )
			// ../grammaire/NXC.g:34:10: ']'
			{
				match(']');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__127"

	// $ANTLR start "T__128"
	public final void mT__128() throws RecognitionException {
		try {
			int _type = T__128;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:35:8: ( '.' )
			// ../grammaire/NXC.g:35:10: '.'
			{
				match('.');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__128"

	// $ANTLR start "T__129"
	public final void mT__129() throws RecognitionException {
		try {
			int _type = T__129;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:36:8: ( '?' )
			// ../grammaire/NXC.g:36:10: '?'
			{
				match('?');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__129"

	// $ANTLR start "T__130"
	public final void mT__130() throws RecognitionException {
		try {
			int _type = T__130;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:37:8: ( ':' )
			// ../grammaire/NXC.g:37:10: ':'
			{
				match(':');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "T__130"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:479:5: ( 'bool' )
			// ../grammaire/NXC.g:479:9: 'bool'
			{
				match("bool");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:479:6: ( 'break' )
			// ../grammaire/NXC.g:479:9: 'break'
			{
				match("break");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "BYTE"
	public final void mBYTE() throws RecognitionException {
		try {
			int _type = BYTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:479:5: ( 'byte' )
			// ../grammaire/NXC.g:479:8: 'byte'
			{
				match("byte");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "BYTE"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:479:5: ( 'case' )
			// ../grammaire/NXC.g:479:8: 'case'
			{
				match("case");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:480:5: ( 'char' )
			// ../grammaire/NXC.g:480:8: 'char'
			{
				match("char");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:480:6: ( 'const' )
			// ../grammaire/NXC.g:480:9: 'const'
			{
				match("const");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "CONST"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:480:9: ( 'continue' )
			// ../grammaire/NXC.g:480:11: 'continue'
			{
				match("continue");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:480:8: ( 'default' )
			// ../grammaire/NXC.g:480:10: 'default'
			{
				match("default");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:481:3: ( 'do' )
			// ../grammaire/NXC.g:481:7: 'do'
			{
				match("do");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:481:5: ( 'else' )
			// ../grammaire/NXC.g:481:8: 'else'
			{
				match("else");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:481:5: ( 'enum' )
			// ../grammaire/NXC.g:481:8: 'enum'
			{
				match("enum");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ENUM"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:481:6: ( 'false' )
			// ../grammaire/NXC.g:481:9: 'false'
			{
				match("false");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:482:6: ( 'float' )
			// ../grammaire/NXC.g:482:9: 'float'
			{
				match("float");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:482:4: ( 'for' )
			// ../grammaire/NXC.g:482:7: 'for'
			{
				match("for");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "GOTO"
	public final void mGOTO() throws RecognitionException {
		try {
			int _type = GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:482:5: ( 'goto' )
			// ../grammaire/NXC.g:482:8: 'goto'
			{
				match("goto");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "GOTO"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:482:3: ( 'if' )
			// ../grammaire/NXC.g:482:7: 'if'
			{
				match("if");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "INLINE"
	public final void mINLINE() throws RecognitionException {
		try {
			int _type = INLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:483:7: ( 'inline' )
			// ../grammaire/NXC.g:483:10: 'inline'
			{
				match("inline");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "INLINE"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:483:4: ( 'int' )
			// ../grammaire/NXC.g:483:7: 'int'
			{
				match("int");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "LONG"
	public final void mLONG() throws RecognitionException {
		try {
			int _type = LONG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:483:5: ( 'long' )
			// ../grammaire/NXC.g:483:8: 'long'
			{
				match("long");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LONG"

	// $ANTLR start "MUTEX"
	public final void mMUTEX() throws RecognitionException {
		try {
			int _type = MUTEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:483:6: ( 'mutex' )
			// ../grammaire/NXC.g:483:9: 'mutex'
			{
				match("mutex");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MUTEX"

	// $ANTLR start "PRIORITY"
	public final void mPRIORITY() throws RecognitionException {
		try {
			int _type = PRIORITY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:484:9: ( 'priority' )
			// ../grammaire/NXC.g:484:11: 'priority'
			{
				match("priority");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "PRIORITY"

	// $ANTLR start "REPEAT"
	public final void mREPEAT() throws RecognitionException {
		try {
			int _type = REPEAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:484:7: ( 'repeat' )
			// ../grammaire/NXC.g:484:10: 'repeat'
			{
				match("repeat");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "REPEAT"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:484:7: ( 'return' )
			// ../grammaire/NXC.g:484:10: 'return'
			{
				match("return");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "SAFECALL"
	public final void mSAFECALL() throws RecognitionException {
		try {
			int _type = SAFECALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:484:9: ( 'safecall' )
			// ../grammaire/NXC.g:484:11: 'safecall'
			{
				match("safecall");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "SAFECALL"

	// $ANTLR start "SHORT"
	public final void mSHORT() throws RecognitionException {
		try {
			int _type = SHORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:485:6: ( 'short' )
			// ../grammaire/NXC.g:485:9: 'short'
			{
				match("short");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "SHORT"

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:485:6: ( 'start' )
			// ../grammaire/NXC.g:485:9: 'start'
			{
				match("start");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "STOP"
	public final void mSTOP() throws RecognitionException {
		try {
			int _type = STOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:485:5: ( 'stop' )
			// ../grammaire/NXC.g:485:8: 'stop'
			{
				match("stop");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STOP"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:485:7: ( 'string' )
			// ../grammaire/NXC.g:485:10: 'string'
			{
				match("string");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "STRUCT"
	public final void mSTRUCT() throws RecognitionException {
		try {
			int _type = STRUCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:486:7: ( 'struct' )
			// ../grammaire/NXC.g:486:10: 'struct'
			{
				match("struct");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STRUCT"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:486:4: ( 'sub' )
			// ../grammaire/NXC.g:486:7: 'sub'
			{
				match("sub");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "SWITCH"
	public final void mSWITCH() throws RecognitionException {
		try {
			int _type = SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:486:7: ( 'switch' )
			// ../grammaire/NXC.g:486:10: 'switch'
			{
				match("switch");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "SWITCH"

	// $ANTLR start "TASK"
	public final void mTASK() throws RecognitionException {
		try {
			int _type = TASK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:486:5: ( 'task' )
			// ../grammaire/NXC.g:486:8: 'task'
			{
				match("task");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "TASK"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:487:5: ( 'true' )
			// ../grammaire/NXC.g:487:8: 'true'
			{
				match("true");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "TYPEDEF"
	public final void mTYPEDEF() throws RecognitionException {
		try {
			int _type = TYPEDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:487:8: ( 'typedef' )
			// ../grammaire/NXC.g:487:10: 'typedef'
			{
				match("typedef");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "TYPEDEF"

	// $ANTLR start "UNSIGNED"
	public final void mUNSIGNED() throws RecognitionException {
		try {
			int _type = UNSIGNED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:487:9: ( 'unsigned' )
			// ../grammaire/NXC.g:487:11: 'unsigned'
			{
				match("unsigned");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "UNSIGNED"

	// $ANTLR start "UNTIL"
	public final void mUNTIL() throws RecognitionException {
		try {
			int _type = UNTIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:487:6: ( 'until' )
			// ../grammaire/NXC.g:487:9: 'until'
			{
				match("until");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "UNTIL"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:488:5: ( 'void' )
			// ../grammaire/NXC.g:488:8: 'void'
			{
				match("void");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:488:6: ( 'while' )
			// ../grammaire/NXC.g:488:9: 'while'
			{
				match("while");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "PLUSPLUS"
	public final void mPLUSPLUS() throws RecognitionException {
		try {
			int _type = PLUSPLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:490:9: ( '++' )
			// ../grammaire/NXC.g:490:11: '++'
			{
				match("++");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "PLUSPLUS"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:490:5: ( '+' )
			// ../grammaire/NXC.g:490:8: '+'
			{
				match('+');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUSMINUS"
	public final void mMINUSMINUS() throws RecognitionException {
		try {
			int _type = MINUSMINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:490:11: ( '--' )
			// ../grammaire/NXC.g:490:13: '--'
			{
				match("--");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MINUSMINUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:490:6: ( '-' )
			// ../grammaire/NXC.g:490:9: '-'
			{
				match('-');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:491:5: ( '*' )
			// ../grammaire/NXC.g:491:8: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:491:7: ( '/' )
			// ../grammaire/NXC.g:491:10: '/'
			{
				match('/');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:491:4: ( '%' )
			// ../grammaire/NXC.g:491:7: '%'
			{
				match('%');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "LSHIFT"
	public final void mLSHIFT() throws RecognitionException {
		try {
			int _type = LSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:491:7: ( '<<' )
			// ../grammaire/NXC.g:491:10: '<<'
			{
				match("<<");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LSHIFT"

	// $ANTLR start "RSHIFT"
	public final void mRSHIFT() throws RecognitionException {
		try {
			int _type = RSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:492:7: ( '>>' )
			// ../grammaire/NXC.g:492:10: '>>'
			{
				match(">>");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RSHIFT"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:492:4: ( '&' )
			// ../grammaire/NXC.g:492:7: '&'
			{
				match('&');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:492:3: ( '|' )
			// ../grammaire/NXC.g:492:7: '|'
			{
				match('|');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "XOR"
	public final void mXOR() throws RecognitionException {
		try {
			int _type = XOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:492:4: ( '^' )
			// ../grammaire/NXC.g:492:7: '^'
			{
				match('^');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "XOR"

	// $ANTLR start "TILDE"
	public final void mTILDE() throws RecognitionException {
		try {
			int _type = TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:493:6: ( '~' )
			// ../grammaire/NXC.g:493:9: '~'
			{
				match('~');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "TILDE"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:493:4: ( '!' )
			// ../grammaire/NXC.g:493:7: '!'
			{
				match('!');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "ANDAND"
	public final void mANDAND() throws RecognitionException {
		try {
			int _type = ANDAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:493:7: ( '&&' )
			// ../grammaire/NXC.g:493:10: '&&'
			{
				match("&&");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ANDAND"

	// $ANTLR start "OROR"
	public final void mOROR() throws RecognitionException {
		try {
			int _type = OROR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:493:5: ( '||' )
			// ../grammaire/NXC.g:493:8: '||'
			{
				match("||");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "OROR"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:494:6: ( '==' )
			// ../grammaire/NXC.g:494:9: '=='
			{
				match("==");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "NOTEQUAL"
	public final void mNOTEQUAL() throws RecognitionException {
		try {
			int _type = NOTEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:494:9: ( '!=' )
			// ../grammaire/NXC.g:494:11: '!='
			{
				match("!=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "NOTEQUAL"

	// $ANTLR start "LESSEQUAL"
	public final void mLESSEQUAL() throws RecognitionException {
		try {
			int _type = LESSEQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:494:10: ( '<=' )
			// ../grammaire/NXC.g:494:12: '<='
			{
				match("<=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LESSEQUAL"

	// $ANTLR start "LESSTHAN"
	public final void mLESSTHAN() throws RecognitionException {
		try {
			int _type = LESSTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:494:9: ( '<' )
			// ../grammaire/NXC.g:494:11: '<'
			{
				match('<');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LESSTHAN"

	// $ANTLR start "GREATEREQUAL"
	public final void mGREATEREQUAL() throws RecognitionException {
		try {
			int _type = GREATEREQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:495:13: ( '>=' )
			// ../grammaire/NXC.g:495:14: '>='
			{
				match(">=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "GREATEREQUAL"

	// $ANTLR start "GREATERTHAN"
	public final void mGREATERTHAN() throws RecognitionException {
		try {
			int _type = GREATERTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:495:12: ( '>' )
			// ../grammaire/NXC.g:495:13: '>'
			{
				match('>');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "GREATERTHAN"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:495:7: ( '=' )
			// ../grammaire/NXC.g:495:10: '='
			{
				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "PLUSASSIGN"
	public final void mPLUSASSIGN() throws RecognitionException {
		try {
			int _type = PLUSASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:495:11: ( '+=' )
			// ../grammaire/NXC.g:495:13: '+='
			{
				match("+=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "PLUSASSIGN"

	// $ANTLR start "MINUSASSIGN"
	public final void mMINUSASSIGN() throws RecognitionException {
		try {
			int _type = MINUSASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:496:12: ( '-=' )
			// ../grammaire/NXC.g:496:13: '-='
			{
				match("-=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MINUSASSIGN"

	// $ANTLR start "STARASSIGN"
	public final void mSTARASSIGN() throws RecognitionException {
		try {
			int _type = STARASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:496:11: ( '*=' )
			// ../grammaire/NXC.g:496:13: '*='
			{
				match("*=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STARASSIGN"

	// $ANTLR start "DIVASSIGN"
	public final void mDIVASSIGN() throws RecognitionException {
		try {
			int _type = DIVASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:496:10: ( '/=' )
			// ../grammaire/NXC.g:496:12: '/='
			{
				match("/=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "DIVASSIGN"

	// $ANTLR start "MODASSIGN"
	public final void mMODASSIGN() throws RecognitionException {
		try {
			int _type = MODASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:496:10: ( '%=' )
			// ../grammaire/NXC.g:496:12: '%='
			{
				match("%=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "MODASSIGN"

	// $ANTLR start "LSHIFTASSIGN"
	public final void mLSHIFTASSIGN() throws RecognitionException {
		try {
			int _type = LSHIFTASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:497:13: ( '<<=' )
			// ../grammaire/NXC.g:497:14: '<<='
			{
				match("<<=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LSHIFTASSIGN"

	// $ANTLR start "RSHIFTASSIGN"
	public final void mRSHIFTASSIGN() throws RecognitionException {
		try {
			int _type = RSHIFTASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:497:13: ( '>>=' )
			// ../grammaire/NXC.g:497:14: '>>='
			{
				match(">>=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "RSHIFTASSIGN"

	// $ANTLR start "ANDASSIGN"
	public final void mANDASSIGN() throws RecognitionException {
		try {
			int _type = ANDASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:497:10: ( '&=' )
			// ../grammaire/NXC.g:497:12: '&='
			{
				match("&=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ANDASSIGN"

	// $ANTLR start "ORASSIGN"
	public final void mORASSIGN() throws RecognitionException {
		try {
			int _type = ORASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:497:9: ( '|=' )
			// ../grammaire/NXC.g:497:11: '|='
			{
				match("|=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "ORASSIGN"

	// $ANTLR start "XORASSIGN"
	public final void mXORASSIGN() throws RecognitionException {
		try {
			int _type = XORASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:498:10: ( '^=' )
			// ../grammaire/NXC.g:498:12: '^='
			{
				match("^=");


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "XORASSIGN"

	// $ANTLR start "IDENTIFIER"
	public final void mIDENTIFIER() throws RecognitionException {
		try {
			int _type = IDENTIFIER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:501:2: ( LETTER ( LETTER | '0' .. '9' )* )
			// ../grammaire/NXC.g:501:4: LETTER ( LETTER | '0' .. '9' )*
			{
				mLETTER();
				// ../grammaire/NXC.g:501:11: ( LETTER | '0' .. '9' )*
				loop1:
				do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if (((LA1_0 >= '0' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || LA1_0 == '_' || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
						alt1 = 1;
					}


					switch (alt1) {
						case 1: // ../grammaire/NXC.g:
						{
							if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
						break;

						default:
							break loop1;
					}
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "IDENTIFIER"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// ../grammaire/NXC.g:506:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
			// ../grammaire/NXC.g:
			{
				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}


			}

		} finally {
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "CHARACTER_LITERAL"
	public final void mCHARACTER_LITERAL() throws RecognitionException {
		try {
			int _type = CHARACTER_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:511:19: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
			// ../grammaire/NXC.g:511:21: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
			{
				match('\'');
				// ../grammaire/NXC.g:511:26: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
				int alt2 = 2;
				int LA2_0 = input.LA(1);

				if ((LA2_0 == '\\')) {
					alt2 = 1;
				} else if (((LA2_0 >= '\u0000' && LA2_0 <= '&') || (LA2_0 >= '(' && LA2_0 <= '[') || (LA2_0 >= ']' && LA2_0 <= '\uFFFF'))) {
					alt2 = 2;
				} else {
					NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);

					throw nvae;
				}
				switch (alt2) {
					case 1: // ../grammaire/NXC.g:511:28: EscapeSequence
					{
						mEscapeSequence();

					}
					break;
					case 2: // ../grammaire/NXC.g:511:45: ~ ( '\\'' | '\\\\' )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
					break;

				}

				match('\'');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "CHARACTER_LITERAL"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:513:16: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
			// ../grammaire/NXC.g:513:18: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
			{
				match('\"');
				// ../grammaire/NXC.g:513:22: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
				loop3:
				do {
					int alt3 = 3;
					int LA3_0 = input.LA(1);

					if ((LA3_0 == '\\')) {
						alt3 = 1;
					} else if (((LA3_0 >= '\u0000' && LA3_0 <= '!') || (LA3_0 >= '#' && LA3_0 <= '[') || (LA3_0 >= ']' && LA3_0 <= '\uFFFF'))) {
						alt3 = 2;
					}


					switch (alt3) {
						case 1: // ../grammaire/NXC.g:513:24: EscapeSequence
						{
							mEscapeSequence();

						}
						break;
						case 2: // ../grammaire/NXC.g:513:41: ~ ( '\\\\' | '\"' )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
						break;

						default:
							break loop3;
					}
				} while (true);

				match('\"');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "HEX_LITERAL"
	public final void mHEX_LITERAL() throws RecognitionException {
		try {
			int _type = HEX_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:515:13: ( '0' ( 'x' | 'X' ) ( HexDigit )+ )
			// ../grammaire/NXC.g:515:15: '0' ( 'x' | 'X' ) ( HexDigit )+
			{
				match('0');
				if (input.LA(1) == 'X' || input.LA(1) == 'x') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// ../grammaire/NXC.g:515:29: ( HexDigit )+
				int cnt4 = 0;
				loop4:
				do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if (((LA4_0 >= '0' && LA4_0 <= '9') || (LA4_0 >= 'A' && LA4_0 <= 'F') || (LA4_0 >= 'a' && LA4_0 <= 'f'))) {
						alt4 = 1;
					}


					switch (alt4) {
						case 1: // ../grammaire/NXC.g:515:29: HexDigit
						{
							mHexDigit();

						}
						break;

						default:
							if (cnt4 >= 1) {
								break loop4;
							}
							EarlyExitException eee =
									new EarlyExitException(4, input);
							throw eee;
					}
					cnt4++;
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "HEX_LITERAL"

	// $ANTLR start "DECIMAL_LITERAL"
	public final void mDECIMAL_LITERAL() throws RecognitionException {
		try {
			int _type = DECIMAL_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:517:17: ( ( '0' .. '9' )+ )
			// ../grammaire/NXC.g:517:19: ( '0' .. '9' )+
			{
				// ../grammaire/NXC.g:517:19: ( '0' .. '9' )+
				int cnt5 = 0;
				loop5:
				do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if (((LA5_0 >= '0' && LA5_0 <= '9'))) {
						alt5 = 1;
					}


					switch (alt5) {
						case 1: // ../grammaire/NXC.g:517:19: '0' .. '9'
						{
							matchRange('0', '9');

						}
						break;

						default:
							if (cnt5 >= 1) {
								break loop5;
							}
							EarlyExitException eee =
									new EarlyExitException(5, input);
							throw eee;
					}
					cnt5++;
				} while (true);


			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "DECIMAL_LITERAL"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// ../grammaire/NXC.g:520:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// ../grammaire/NXC.g:520:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
			{
				if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}


			}

		} finally {
		}
	}
	// $ANTLR end "HexDigit"

	// $ANTLR start "FLOAT_LITERAL"
	public final void mFLOAT_LITERAL() throws RecognitionException {
		try {
			int _type = FLOAT_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:523:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | '.' ( '0' .. '9' )+ ( Exponent )? | ( '0' .. '9' )+ Exponent )
			int alt12 = 3;
			alt12 = dfa12.predict(input);
			switch (alt12) {
				case 1: // ../grammaire/NXC.g:523:7: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )?
				{
					// ../grammaire/NXC.g:523:7: ( '0' .. '9' )+
					int cnt6 = 0;
					loop6:
					do {
						int alt6 = 2;
						int LA6_0 = input.LA(1);

						if (((LA6_0 >= '0' && LA6_0 <= '9'))) {
							alt6 = 1;
						}


						switch (alt6) {
							case 1: // ../grammaire/NXC.g:523:8: '0' .. '9'
							{
								matchRange('0', '9');

							}
							break;

							default:
								if (cnt6 >= 1) {
									break loop6;
								}
								EarlyExitException eee =
										new EarlyExitException(6, input);
								throw eee;
						}
						cnt6++;
					} while (true);

					match('.');
					// ../grammaire/NXC.g:523:23: ( '0' .. '9' )*
					loop7:
					do {
						int alt7 = 2;
						int LA7_0 = input.LA(1);

						if (((LA7_0 >= '0' && LA7_0 <= '9'))) {
							alt7 = 1;
						}


						switch (alt7) {
							case 1: // ../grammaire/NXC.g:523:24: '0' .. '9'
							{
								matchRange('0', '9');

							}
							break;

							default:
								break loop7;
						}
					} while (true);

					// ../grammaire/NXC.g:523:35: ( Exponent )?
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == 'E' || LA8_0 == 'e')) {
						alt8 = 1;
					}
					switch (alt8) {
						case 1: // ../grammaire/NXC.g:523:35: Exponent
						{
							mExponent();

						}
						break;

					}


				}
				break;
				case 2: // ../grammaire/NXC.g:524:7: '.' ( '0' .. '9' )+ ( Exponent )?
				{
					match('.');
					// ../grammaire/NXC.g:524:11: ( '0' .. '9' )+
					int cnt9 = 0;
					loop9:
					do {
						int alt9 = 2;
						int LA9_0 = input.LA(1);

						if (((LA9_0 >= '0' && LA9_0 <= '9'))) {
							alt9 = 1;
						}


						switch (alt9) {
							case 1: // ../grammaire/NXC.g:524:12: '0' .. '9'
							{
								matchRange('0', '9');

							}
							break;

							default:
								if (cnt9 >= 1) {
									break loop9;
								}
								EarlyExitException eee =
										new EarlyExitException(9, input);
								throw eee;
						}
						cnt9++;
					} while (true);

					// ../grammaire/NXC.g:524:23: ( Exponent )?
					int alt10 = 2;
					int LA10_0 = input.LA(1);

					if ((LA10_0 == 'E' || LA10_0 == 'e')) {
						alt10 = 1;
					}
					switch (alt10) {
						case 1: // ../grammaire/NXC.g:524:23: Exponent
						{
							mExponent();

						}
						break;

					}


				}
				break;
				case 3: // ../grammaire/NXC.g:525:7: ( '0' .. '9' )+ Exponent
				{
					// ../grammaire/NXC.g:525:7: ( '0' .. '9' )+
					int cnt11 = 0;
					loop11:
					do {
						int alt11 = 2;
						int LA11_0 = input.LA(1);

						if (((LA11_0 >= '0' && LA11_0 <= '9'))) {
							alt11 = 1;
						}


						switch (alt11) {
							case 1: // ../grammaire/NXC.g:525:8: '0' .. '9'
							{
								matchRange('0', '9');

							}
							break;

							default:
								if (cnt11 >= 1) {
									break loop11;
								}
								EarlyExitException eee =
										new EarlyExitException(11, input);
								throw eee;
						}
						cnt11++;
					} while (true);

					mExponent();

				}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "FLOAT_LITERAL"

	// $ANTLR start "Exponent"
	public final void mExponent() throws RecognitionException {
		try {
			// ../grammaire/NXC.g:529:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// ../grammaire/NXC.g:529:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
				if (input.LA(1) == 'E' || input.LA(1) == 'e') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				// ../grammaire/NXC.g:529:22: ( '+' | '-' )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);

				if ((LA13_0 == '+' || LA13_0 == '-')) {
					alt13 = 1;
				}
				switch (alt13) {
					case 1: // ../grammaire/NXC.g:
					{
						if (input.LA(1) == '+' || input.LA(1) == '-') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}


					}
					break;

				}

				// ../grammaire/NXC.g:529:33: ( '0' .. '9' )+
				int cnt14 = 0;
				loop14:
				do {
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if (((LA14_0 >= '0' && LA14_0 <= '9'))) {
						alt14 = 1;
					}


					switch (alt14) {
						case 1: // ../grammaire/NXC.g:529:34: '0' .. '9'
						{
							matchRange('0', '9');

						}
						break;

						default:
							if (cnt14 >= 1) {
								break loop14;
							}
							EarlyExitException eee =
									new EarlyExitException(14, input);
							throw eee;
					}
					cnt14++;
				} while (true);


			}

		} finally {
		}
	}
	// $ANTLR end "Exponent"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// ../grammaire/NXC.g:533:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
			// ../grammaire/NXC.g:533:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
			{
				match('\\');
				if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}


			}

		} finally {
		}
	}
	// $ANTLR end "EscapeSequence"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:535:5: ( ( '\\r' '\\n' | '\\r' | '\\n' ) )
			// ../grammaire/NXC.g:535:7: ( '\\r' '\\n' | '\\r' | '\\n' )
			{
				// ../grammaire/NXC.g:535:7: ( '\\r' '\\n' | '\\r' | '\\n' )
				int alt15 = 3;
				int LA15_0 = input.LA(1);

				if ((LA15_0 == '\r')) {
					int LA15_1 = input.LA(2);

					if ((LA15_1 == '\n')) {
						alt15 = 1;
					} else {
						alt15 = 2;
					}
				} else if ((LA15_0 == '\n')) {
					alt15 = 3;
				} else {
					NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);

					throw nvae;
				}
				switch (alt15) {
					case 1: // ../grammaire/NXC.g:535:8: '\\r' '\\n'
					{
						match('\r');
						match('\n');

					}
					break;
					case 2: // ../grammaire/NXC.g:535:20: '\\r'
					{
						match('\r');

					}
					break;
					case 3: // ../grammaire/NXC.g:535:27: '\\n'
					{
						match('\n');

					}
					break;

				}

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:537:13: ( ( ' ' | '\\t' | '\\u000C' ) )
			// ../grammaire/NXC.g:537:16: ( ' ' | '\\t' | '\\u000C' )
			{
				if (input.LA(1) == '\t' || input.LA(1) == '\f' || input.LA(1) == ' ') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}

				skip();

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:540:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// ../grammaire/NXC.g:540:7: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// ../grammaire/NXC.g:540:12: ( options {greedy=false; } : . )*
				loop16:
				do {
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if ((LA16_0 == '*')) {
						int LA16_1 = input.LA(2);

						if ((LA16_1 == '/')) {
							alt16 = 2;
						} else if (((LA16_1 >= '\u0000' && LA16_1 <= '.') || (LA16_1 >= '0' && LA16_1 <= '\uFFFF'))) {
							alt16 = 1;
						}


					} else if (((LA16_0 >= '\u0000' && LA16_0 <= ')') || (LA16_0 >= '+' && LA16_0 <= '\uFFFF'))) {
						alt16 = 1;
					}


					switch (alt16) {
						case 1: // ../grammaire/NXC.g:540:40: .
						{
							matchAny();

						}
						break;

						default:
							break loop16;
					}
				} while (true);

				match("*/");

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:543:5: ( '//' (~ ( '\\n' | '\\r' ) )* EOL )
			// ../grammaire/NXC.g:543:7: '//' (~ ( '\\n' | '\\r' ) )* EOL
			{
				match("//");

				// ../grammaire/NXC.g:543:12: (~ ( '\\n' | '\\r' ) )*
				loop17:
				do {
					int alt17 = 2;
					int LA17_0 = input.LA(1);

					if (((LA17_0 >= '\u0000' && LA17_0 <= '\t') || (LA17_0 >= '\u000B' && LA17_0 <= '\f') || (LA17_0 >= '\u000E' && LA17_0 <= '\uFFFF'))) {
						alt17 = 1;
					}


					switch (alt17) {
						case 1: // ../grammaire/NXC.g:543:12: ~ ( '\\n' | '\\r' )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(null, input);
								recover(mse);
								throw mse;
							}


						}
						break;

						default:
							break loop17;
					}
				} while (true);

				mEOL();
				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "UNK"
	public final void mUNK() throws RecognitionException {
		try {
			int _type = UNK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ../grammaire/NXC.g:545:5: ( . )
			// ../grammaire/NXC.g:545:7: .
			{
				matchAny();
				_channel = HIDDEN;
				this.compilMessages.add(new WarningOrError(state.tokenStartLine, state.tokenStartCharPositionInLine, false, "Caractère " + getText() + " ignoré car non reconnu."));

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}
	// $ANTLR end "UNK"

	@Override
	public void mTokens() throws RecognitionException {
		// ../grammaire/NXC.g:1:8: ( T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | BOOL | BREAK | BYTE | CASE | CHAR | CONST | CONTINUE | DEFAULT | DO | ELSE | ENUM | FALSE | FLOAT | FOR | GOTO | IF | INLINE | INT | LONG | MUTEX | PRIORITY | REPEAT | RETURN | SAFECALL | SHORT | START | STOP | STRING | STRUCT | SUB | SWITCH | TASK | TRUE | TYPEDEF | UNSIGNED | UNTIL | VOID | WHILE | PLUSPLUS | PLUS | MINUSMINUS | MINUS | STAR | DIVIDE | MOD | LSHIFT | RSHIFT | AND | OR | XOR | TILDE | NOT | ANDAND | OROR | EQUAL | NOTEQUAL | LESSEQUAL | LESSTHAN | GREATEREQUAL | GREATERTHAN | ASSIGN | PLUSASSIGN | MINUSASSIGN | STARASSIGN | DIVASSIGN | MODASSIGN | LSHIFTASSIGN | RSHIFTASSIGN | ANDASSIGN | ORASSIGN | XORASSIGN | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | FLOAT_LITERAL | EOL | WHITESPACE | COMMENT | LINE_COMMENT | UNK )
		int alt18 = 93;
		alt18 = dfa18.predict(input);
		switch (alt18) {
			case 1: // ../grammaire/NXC.g:1:10: T__120
			{
				mT__120();

			}
			break;
			case 2: // ../grammaire/NXC.g:1:17: T__121
			{
				mT__121();

			}
			break;
			case 3: // ../grammaire/NXC.g:1:24: T__122
			{
				mT__122();

			}
			break;
			case 4: // ../grammaire/NXC.g:1:31: T__123
			{
				mT__123();

			}
			break;
			case 5: // ../grammaire/NXC.g:1:38: T__124
			{
				mT__124();

			}
			break;
			case 6: // ../grammaire/NXC.g:1:45: T__125
			{
				mT__125();

			}
			break;
			case 7: // ../grammaire/NXC.g:1:52: T__126
			{
				mT__126();

			}
			break;
			case 8: // ../grammaire/NXC.g:1:59: T__127
			{
				mT__127();

			}
			break;
			case 9: // ../grammaire/NXC.g:1:66: T__128
			{
				mT__128();

			}
			break;
			case 10: // ../grammaire/NXC.g:1:73: T__129
			{
				mT__129();

			}
			break;
			case 11: // ../grammaire/NXC.g:1:80: T__130
			{
				mT__130();

			}
			break;
			case 12: // ../grammaire/NXC.g:1:87: BOOL
			{
				mBOOL();

			}
			break;
			case 13: // ../grammaire/NXC.g:1:92: BREAK
			{
				mBREAK();

			}
			break;
			case 14: // ../grammaire/NXC.g:1:98: BYTE
			{
				mBYTE();

			}
			break;
			case 15: // ../grammaire/NXC.g:1:103: CASE
			{
				mCASE();

			}
			break;
			case 16: // ../grammaire/NXC.g:1:108: CHAR
			{
				mCHAR();

			}
			break;
			case 17: // ../grammaire/NXC.g:1:113: CONST
			{
				mCONST();

			}
			break;
			case 18: // ../grammaire/NXC.g:1:119: CONTINUE
			{
				mCONTINUE();

			}
			break;
			case 19: // ../grammaire/NXC.g:1:128: DEFAULT
			{
				mDEFAULT();

			}
			break;
			case 20: // ../grammaire/NXC.g:1:136: DO
			{
				mDO();

			}
			break;
			case 21: // ../grammaire/NXC.g:1:139: ELSE
			{
				mELSE();

			}
			break;
			case 22: // ../grammaire/NXC.g:1:144: ENUM
			{
				mENUM();

			}
			break;
			case 23: // ../grammaire/NXC.g:1:149: FALSE
			{
				mFALSE();

			}
			break;
			case 24: // ../grammaire/NXC.g:1:155: FLOAT
			{
				mFLOAT();

			}
			break;
			case 25: // ../grammaire/NXC.g:1:161: FOR
			{
				mFOR();

			}
			break;
			case 26: // ../grammaire/NXC.g:1:165: GOTO
			{
				mGOTO();

			}
			break;
			case 27: // ../grammaire/NXC.g:1:170: IF
			{
				mIF();

			}
			break;
			case 28: // ../grammaire/NXC.g:1:173: INLINE
			{
				mINLINE();

			}
			break;
			case 29: // ../grammaire/NXC.g:1:180: INT
			{
				mINT();

			}
			break;
			case 30: // ../grammaire/NXC.g:1:184: LONG
			{
				mLONG();

			}
			break;
			case 31: // ../grammaire/NXC.g:1:189: MUTEX
			{
				mMUTEX();

			}
			break;
			case 32: // ../grammaire/NXC.g:1:195: PRIORITY
			{
				mPRIORITY();

			}
			break;
			case 33: // ../grammaire/NXC.g:1:204: REPEAT
			{
				mREPEAT();

			}
			break;
			case 34: // ../grammaire/NXC.g:1:211: RETURN
			{
				mRETURN();

			}
			break;
			case 35: // ../grammaire/NXC.g:1:218: SAFECALL
			{
				mSAFECALL();

			}
			break;
			case 36: // ../grammaire/NXC.g:1:227: SHORT
			{
				mSHORT();

			}
			break;
			case 37: // ../grammaire/NXC.g:1:233: START
			{
				mSTART();

			}
			break;
			case 38: // ../grammaire/NXC.g:1:239: STOP
			{
				mSTOP();

			}
			break;
			case 39: // ../grammaire/NXC.g:1:244: STRING
			{
				mSTRING();

			}
			break;
			case 40: // ../grammaire/NXC.g:1:251: STRUCT
			{
				mSTRUCT();

			}
			break;
			case 41: // ../grammaire/NXC.g:1:258: SUB
			{
				mSUB();

			}
			break;
			case 42: // ../grammaire/NXC.g:1:262: SWITCH
			{
				mSWITCH();

			}
			break;
			case 43: // ../grammaire/NXC.g:1:269: TASK
			{
				mTASK();

			}
			break;
			case 44: // ../grammaire/NXC.g:1:274: TRUE
			{
				mTRUE();

			}
			break;
			case 45: // ../grammaire/NXC.g:1:279: TYPEDEF
			{
				mTYPEDEF();

			}
			break;
			case 46: // ../grammaire/NXC.g:1:287: UNSIGNED
			{
				mUNSIGNED();

			}
			break;
			case 47: // ../grammaire/NXC.g:1:296: UNTIL
			{
				mUNTIL();

			}
			break;
			case 48: // ../grammaire/NXC.g:1:302: VOID
			{
				mVOID();

			}
			break;
			case 49: // ../grammaire/NXC.g:1:307: WHILE
			{
				mWHILE();

			}
			break;
			case 50: // ../grammaire/NXC.g:1:313: PLUSPLUS
			{
				mPLUSPLUS();

			}
			break;
			case 51: // ../grammaire/NXC.g:1:322: PLUS
			{
				mPLUS();

			}
			break;
			case 52: // ../grammaire/NXC.g:1:327: MINUSMINUS
			{
				mMINUSMINUS();

			}
			break;
			case 53: // ../grammaire/NXC.g:1:338: MINUS
			{
				mMINUS();

			}
			break;
			case 54: // ../grammaire/NXC.g:1:344: STAR
			{
				mSTAR();

			}
			break;
			case 55: // ../grammaire/NXC.g:1:349: DIVIDE
			{
				mDIVIDE();

			}
			break;
			case 56: // ../grammaire/NXC.g:1:356: MOD
			{
				mMOD();

			}
			break;
			case 57: // ../grammaire/NXC.g:1:360: LSHIFT
			{
				mLSHIFT();

			}
			break;
			case 58: // ../grammaire/NXC.g:1:367: RSHIFT
			{
				mRSHIFT();

			}
			break;
			case 59: // ../grammaire/NXC.g:1:374: AND
			{
				mAND();

			}
			break;
			case 60: // ../grammaire/NXC.g:1:378: OR
			{
				mOR();

			}
			break;
			case 61: // ../grammaire/NXC.g:1:381: XOR
			{
				mXOR();

			}
			break;
			case 62: // ../grammaire/NXC.g:1:385: TILDE
			{
				mTILDE();

			}
			break;
			case 63: // ../grammaire/NXC.g:1:391: NOT
			{
				mNOT();

			}
			break;
			case 64: // ../grammaire/NXC.g:1:395: ANDAND
			{
				mANDAND();

			}
			break;
			case 65: // ../grammaire/NXC.g:1:402: OROR
			{
				mOROR();

			}
			break;
			case 66: // ../grammaire/NXC.g:1:407: EQUAL
			{
				mEQUAL();

			}
			break;
			case 67: // ../grammaire/NXC.g:1:413: NOTEQUAL
			{
				mNOTEQUAL();

			}
			break;
			case 68: // ../grammaire/NXC.g:1:422: LESSEQUAL
			{
				mLESSEQUAL();

			}
			break;
			case 69: // ../grammaire/NXC.g:1:432: LESSTHAN
			{
				mLESSTHAN();

			}
			break;
			case 70: // ../grammaire/NXC.g:1:441: GREATEREQUAL
			{
				mGREATEREQUAL();

			}
			break;
			case 71: // ../grammaire/NXC.g:1:454: GREATERTHAN
			{
				mGREATERTHAN();

			}
			break;
			case 72: // ../grammaire/NXC.g:1:466: ASSIGN
			{
				mASSIGN();

			}
			break;
			case 73: // ../grammaire/NXC.g:1:473: PLUSASSIGN
			{
				mPLUSASSIGN();

			}
			break;
			case 74: // ../grammaire/NXC.g:1:484: MINUSASSIGN
			{
				mMINUSASSIGN();

			}
			break;
			case 75: // ../grammaire/NXC.g:1:496: STARASSIGN
			{
				mSTARASSIGN();

			}
			break;
			case 76: // ../grammaire/NXC.g:1:507: DIVASSIGN
			{
				mDIVASSIGN();

			}
			break;
			case 77: // ../grammaire/NXC.g:1:517: MODASSIGN
			{
				mMODASSIGN();

			}
			break;
			case 78: // ../grammaire/NXC.g:1:527: LSHIFTASSIGN
			{
				mLSHIFTASSIGN();

			}
			break;
			case 79: // ../grammaire/NXC.g:1:540: RSHIFTASSIGN
			{
				mRSHIFTASSIGN();

			}
			break;
			case 80: // ../grammaire/NXC.g:1:553: ANDASSIGN
			{
				mANDASSIGN();

			}
			break;
			case 81: // ../grammaire/NXC.g:1:563: ORASSIGN
			{
				mORASSIGN();

			}
			break;
			case 82: // ../grammaire/NXC.g:1:572: XORASSIGN
			{
				mXORASSIGN();

			}
			break;
			case 83: // ../grammaire/NXC.g:1:582: IDENTIFIER
			{
				mIDENTIFIER();

			}
			break;
			case 84: // ../grammaire/NXC.g:1:593: CHARACTER_LITERAL
			{
				mCHARACTER_LITERAL();

			}
			break;
			case 85: // ../grammaire/NXC.g:1:611: STRING_LITERAL
			{
				mSTRING_LITERAL();

			}
			break;
			case 86: // ../grammaire/NXC.g:1:626: HEX_LITERAL
			{
				mHEX_LITERAL();

			}
			break;
			case 87: // ../grammaire/NXC.g:1:638: DECIMAL_LITERAL
			{
				mDECIMAL_LITERAL();

			}
			break;
			case 88: // ../grammaire/NXC.g:1:654: FLOAT_LITERAL
			{
				mFLOAT_LITERAL();

			}
			break;
			case 89: // ../grammaire/NXC.g:1:668: EOL
			{
				mEOL();

			}
			break;
			case 90: // ../grammaire/NXC.g:1:672: WHITESPACE
			{
				mWHITESPACE();

			}
			break;
			case 91: // ../grammaire/NXC.g:1:683: COMMENT
			{
				mCOMMENT();

			}
			break;
			case 92: // ../grammaire/NXC.g:1:691: LINE_COMMENT
			{
				mLINE_COMMENT();

			}
			break;
			case 93: // ../grammaire/NXC.g:1:704: UNK
			{
				mUNK();

			}
			break;

		}

	}
	protected DFA12 dfa12 = new DFA12(this);
	protected DFA18 dfa18 = new DFA18(this);
	static final String DFA12_eotS =
			"\5\uffff";
	static final String DFA12_eofS =
			"\5\uffff";
	static final String DFA12_minS =
			"\2\56\3\uffff";
	static final String DFA12_maxS =
			"\1\71\1\145\3\uffff";
	static final String DFA12_acceptS =
			"\2\uffff\1\2\1\1\1\3";
	static final String DFA12_specialS =
			"\5\uffff}>";
	static final String[] DFA12_transitionS = {
		"\1\2\1\uffff\12\1",
		"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
		"",
		"",
		""
	};
	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}

		public String getDescription() {
			return "522:1: FLOAT_LITERAL : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | '.' ( '0' .. '9' )+ ( Exponent )? | ( '0' .. '9' )+ Exponent );";
		}
	}
	static final String DFA18_eotS =
			"\11\uffff\1\72\2\uffff\20\101\1\140\1\143\1\145\1\151\1\153\1\156"
			+ "\1\161\1\164\1\167\1\171\1\uffff\1\174\1\176\1\uffff\2\61\2\u0082"
			+ "\20\uffff\3\101\1\uffff\4\101\1\u008d\6\101\1\u0094\20\101\16\uffff"
			+ "\1\u00ab\2\uffff\1\u00ad\23\uffff\1\u0082\2\uffff\7\101\1\uffff"
			+ "\4\101\1\u00ba\1\101\1\uffff\1\101\1\u00bd\12\101\1\u00c9\10\101"
			+ "\4\uffff\1\u00d2\1\101\1\u00d4\1\u00d5\1\u00d6\3\101\1\u00da\1\u00db"
			+ "\2\101\1\uffff\1\u00de\1\101\1\uffff\1\u00e0\7\101\1\u00e8\2\101"
			+ "\1\uffff\1\101\1\u00ec\1\u00ed\3\101\1\u00f1\1\101\1\uffff\1\u00f3"
			+ "\3\uffff\1\u00f4\2\101\2\uffff\1\u00f7\1\u00f8\1\uffff\1\101\1\uffff"
			+ "\1\u00fa\4\101\1\u00ff\1\u0100\1\uffff\3\101\2\uffff\2\101\1\u0106"
			+ "\1\uffff\1\u0107\2\uffff\2\101\2\uffff\1\u010a\1\uffff\1\101\1\u010c"
			+ "\1\u010d\1\101\2\uffff\1\u010f\1\u0110\1\u0111\2\101\2\uffff\1\101"
			+ "\1\u0115\1\uffff\1\101\2\uffff\1\101\3\uffff\1\u0118\1\101\1\u011a"
			+ "\1\uffff\1\u011b\1\u011c\1\uffff\1\u011d\4\uffff";
	static final String DFA18_eofS =
			"\u011e\uffff";
	static final String DFA18_minS =
			"\1\0\10\uffff\1\60\2\uffff\1\157\1\141\1\145\1\154\1\141\1\157\1"
			+ "\146\1\157\1\165\1\162\1\145\2\141\1\156\1\157\1\150\1\53\1\55\1"
			+ "\75\1\52\1\75\1\74\1\75\1\46\2\75\1\uffff\2\75\1\uffff\2\0\2\56"
			+ "\20\uffff\1\157\1\145\1\164\1\uffff\1\163\1\141\1\156\1\146\1\60"
			+ "\1\163\1\165\1\154\1\157\1\162\1\164\1\60\1\154\1\156\1\164\1\151"
			+ "\1\160\1\146\1\157\1\141\1\142\1\151\1\163\1\165\1\160\1\163\2\151"
			+ "\16\uffff\1\75\2\uffff\1\75\23\uffff\1\56\2\uffff\1\154\1\141\2"
			+ "\145\1\162\1\163\1\141\1\uffff\1\145\1\155\1\163\1\141\1\60\1\157"
			+ "\1\uffff\1\151\1\60\1\147\1\145\1\157\1\145\1\165\1\145\2\162\1"
			+ "\160\1\151\1\60\1\164\1\153\2\145\2\151\1\144\1\154\4\uffff\1\60"
			+ "\1\153\3\60\1\164\1\151\1\165\2\60\1\145\1\164\1\uffff\1\60\1\156"
			+ "\1\uffff\1\60\1\170\1\162\1\141\1\162\1\143\2\164\1\60\1\156\1\143"
			+ "\1\uffff\1\143\2\60\1\144\1\147\1\154\1\60\1\145\1\uffff\1\60\3"
			+ "\uffff\1\60\1\156\1\154\2\uffff\2\60\1\uffff\1\145\1\uffff\1\60"
			+ "\1\151\1\164\1\156\1\141\2\60\1\uffff\1\147\1\164\1\150\2\uffff"
			+ "\1\145\1\156\1\60\1\uffff\1\60\2\uffff\1\165\1\164\2\uffff\1\60"
			+ "\1\uffff\1\164\2\60\1\154\2\uffff\3\60\1\146\1\145\2\uffff\1\145"
			+ "\1\60\1\uffff\1\171\2\uffff\1\154\3\uffff\1\60\1\144\1\60\1\uffff"
			+ "\2\60\1\uffff\1\60\4\uffff";
	static final String DFA18_maxS =
			"\1\uffff\10\uffff\1\71\2\uffff\1\171\2\157\1\156\2\157\1\156\1\157"
			+ "\1\165\1\162\1\145\1\167\1\171\1\156\1\157\1\150\6\75\1\76\1\75"
			+ "\1\174\1\75\1\uffff\2\75\1\uffff\2\uffff\1\170\1\145\20\uffff\1"
			+ "\157\1\145\1\164\1\uffff\1\163\1\141\1\156\1\146\1\172\1\163\1\165"
			+ "\1\154\1\157\1\162\1\164\1\172\1\164\1\156\1\164\1\151\1\164\1\146"
			+ "\1\157\1\162\1\142\1\151\1\163\1\165\1\160\1\164\2\151\16\uffff"
			+ "\1\75\2\uffff\1\75\23\uffff\1\145\2\uffff\1\154\1\141\2\145\1\162"
			+ "\1\164\1\141\1\uffff\1\145\1\155\1\163\1\141\1\172\1\157\1\uffff"
			+ "\1\151\1\172\1\147\1\145\1\157\1\145\1\165\1\145\2\162\1\160\1\165"
			+ "\1\172\1\164\1\153\2\145\2\151\1\144\1\154\4\uffff\1\172\1\153\3"
			+ "\172\1\164\1\151\1\165\2\172\1\145\1\164\1\uffff\1\172\1\156\1\uffff"
			+ "\1\172\1\170\1\162\1\141\1\162\1\143\2\164\1\172\1\156\1\143\1\uffff"
			+ "\1\143\2\172\1\144\1\147\1\154\1\172\1\145\1\uffff\1\172\3\uffff"
			+ "\1\172\1\156\1\154\2\uffff\2\172\1\uffff\1\145\1\uffff\1\172\1\151"
			+ "\1\164\1\156\1\141\2\172\1\uffff\1\147\1\164\1\150\2\uffff\1\145"
			+ "\1\156\1\172\1\uffff\1\172\2\uffff\1\165\1\164\2\uffff\1\172\1\uffff"
			+ "\1\164\2\172\1\154\2\uffff\3\172\1\146\1\145\2\uffff\1\145\1\172"
			+ "\1\uffff\1\171\2\uffff\1\154\3\uffff\1\172\1\144\1\172\1\uffff\2"
			+ "\172\1\uffff\1\172\4\uffff";
	static final String DFA18_acceptS =
			"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\13\32\uffff"
			+ "\1\76\2\uffff\1\123\4\uffff\2\131\1\132\1\135\1\1\1\2\1\3\1\4\1"
			+ "\5\1\6\1\7\1\10\1\11\1\130\1\12\1\13\3\uffff\1\123\34\uffff\1\62"
			+ "\1\111\1\63\1\64\1\112\1\65\1\113\1\66\1\114\1\133\1\134\1\67\1"
			+ "\115\1\70\1\uffff\1\104\1\105\1\uffff\1\106\1\107\1\100\1\120\1"
			+ "\73\1\101\1\121\1\74\1\122\1\75\1\76\1\103\1\77\1\102\1\110\1\124"
			+ "\1\125\1\126\1\127\1\uffff\1\131\1\132\7\uffff\1\24\6\uffff\1\33"
			+ "\25\uffff\1\116\1\71\1\117\1\72\14\uffff\1\31\2\uffff\1\35\13\uffff"
			+ "\1\51\10\uffff\1\14\1\uffff\1\16\1\17\1\20\3\uffff\1\25\1\26\2\uffff"
			+ "\1\32\1\uffff\1\36\7\uffff\1\46\3\uffff\1\53\1\54\3\uffff\1\60\1"
			+ "\uffff\1\15\1\21\2\uffff\1\27\1\30\1\uffff\1\37\4\uffff\1\44\1\45"
			+ "\5\uffff\1\57\1\61\2\uffff\1\34\1\uffff\1\41\1\42\1\uffff\1\47\1"
			+ "\50\1\52\3\uffff\1\23\2\uffff\1\55\1\uffff\1\22\1\40\1\43\1\56";
	static final String DFA18_specialS =
			"\1\0\51\uffff\1\1\1\2\u00f2\uffff}>";
	static final String[] DFA18_transitionS = {
		"\11\61\1\60\1\57\1\61\1\60\1\56\22\61\1\60\1\47\1\53\2\61\1"
		+ "\40\1\43\1\52\1\1\1\2\1\36\1\34\1\4\1\35\1\11\1\37\1\54\11\55"
		+ "\1\13\1\3\1\41\1\50\1\42\1\12\1\61\32\51\1\7\1\61\1\10\1\45"
		+ "\1\51\1\61\1\51\1\14\1\15\1\16\1\17\1\20\1\21\1\51\1\22\2\51"
		+ "\1\23\1\24\2\51\1\25\1\51\1\26\1\27\1\30\1\31\1\32\1\33\3\51"
		+ "\1\5\1\44\1\6\1\46\uff81\61",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"\12\73",
		"",
		"",
		"\1\76\2\uffff\1\77\6\uffff\1\100",
		"\1\102\6\uffff\1\103\6\uffff\1\104",
		"\1\105\11\uffff\1\106",
		"\1\107\1\uffff\1\110",
		"\1\111\12\uffff\1\112\2\uffff\1\113",
		"\1\114",
		"\1\115\7\uffff\1\116",
		"\1\117",
		"\1\120",
		"\1\121",
		"\1\122",
		"\1\123\6\uffff\1\124\13\uffff\1\125\1\126\1\uffff\1\127",
		"\1\130\20\uffff\1\131\6\uffff\1\132",
		"\1\133",
		"\1\134",
		"\1\135",
		"\1\136\21\uffff\1\137",
		"\1\141\17\uffff\1\142",
		"\1\144",
		"\1\147\4\uffff\1\150\15\uffff\1\146",
		"\1\152",
		"\1\154\1\155",
		"\1\160\1\157",
		"\1\162\26\uffff\1\163",
		"\1\166\76\uffff\1\165",
		"\1\170",
		"",
		"\1\173",
		"\1\175",
		"",
		"\47\177\1\uffff\uffd8\177",
		"\0\u0080",
		"\1\73\1\uffff\12\u0083\13\uffff\1\73\22\uffff\1\u0081\14\uffff"
		+ "\1\73\22\uffff\1\u0081",
		"\1\73\1\uffff\12\u0083\13\uffff\1\73\37\uffff\1\73",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"\1\u0086",
		"\1\u0087",
		"\1\u0088",
		"",
		"\1\u0089",
		"\1\u008a",
		"\1\u008b",
		"\1\u008c",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u008e",
		"\1\u008f",
		"\1\u0090",
		"\1\u0091",
		"\1\u0092",
		"\1\u0093",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u0095\7\uffff\1\u0096",
		"\1\u0097",
		"\1\u0098",
		"\1\u0099",
		"\1\u009a\3\uffff\1\u009b",
		"\1\u009c",
		"\1\u009d",
		"\1\u009e\15\uffff\1\u009f\2\uffff\1\u00a0",
		"\1\u00a1",
		"\1\u00a2",
		"\1\u00a3",
		"\1\u00a4",
		"\1\u00a5",
		"\1\u00a6\1\u00a7",
		"\1\u00a8",
		"\1\u00a9",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"\1\u00aa",
		"",
		"",
		"\1\u00ac",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"\1\73\1\uffff\12\u0083\13\uffff\1\73\37\uffff\1\73",
		"",
		"",
		"\1\u00ae",
		"\1\u00af",
		"\1\u00b0",
		"\1\u00b1",
		"\1\u00b2",
		"\1\u00b3\1\u00b4",
		"\1\u00b5",
		"",
		"\1\u00b6",
		"\1\u00b7",
		"\1\u00b8",
		"\1\u00b9",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00bb",
		"",
		"\1\u00bc",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00be",
		"\1\u00bf",
		"\1\u00c0",
		"\1\u00c1",
		"\1\u00c2",
		"\1\u00c3",
		"\1\u00c4",
		"\1\u00c5",
		"\1\u00c6",
		"\1\u00c7\13\uffff\1\u00c8",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00ca",
		"\1\u00cb",
		"\1\u00cc",
		"\1\u00cd",
		"\1\u00ce",
		"\1\u00cf",
		"\1\u00d0",
		"\1\u00d1",
		"",
		"",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00d3",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00d7",
		"\1\u00d8",
		"\1\u00d9",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00dc",
		"\1\u00dd",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00df",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00e1",
		"\1\u00e2",
		"\1\u00e3",
		"\1\u00e4",
		"\1\u00e5",
		"\1\u00e6",
		"\1\u00e7",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00e9",
		"\1\u00ea",
		"",
		"\1\u00eb",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00ee",
		"\1\u00ef",
		"\1\u00f0",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00f2",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00f5",
		"\1\u00f6",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\1\u00f9",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u00fb",
		"\1\u00fc",
		"\1\u00fd",
		"\1\u00fe",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\1\u0101",
		"\1\u0102",
		"\1\u0103",
		"",
		"",
		"\1\u0104",
		"\1\u0105",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"",
		"\1\u0108",
		"\1\u0109",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\1\u010b",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u010e",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u0112",
		"\1\u0113",
		"",
		"",
		"\1\u0114",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\1\u0116",
		"",
		"",
		"\1\u0117",
		"",
		"",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\1\u0119",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"\12\101\7\uffff\32\101\4\uffff\1\101\1\uffff\32\101",
		"",
		"",
		"",
		""
	};
	static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
	static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
	static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
	static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
	static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
	static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
	static final short[][] DFA18_transition;

	static {
		int numStates = DFA18_transitionS.length;
		DFA18_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
		}
	}

	class DFA18 extends DFA {

		public DFA18(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 18;
			this.eot = DFA18_eot;
			this.eof = DFA18_eof;
			this.min = DFA18_min;
			this.max = DFA18_max;
			this.accept = DFA18_accept;
			this.special = DFA18_special;
			this.transition = DFA18_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | BOOL | BREAK | BYTE | CASE | CHAR | CONST | CONTINUE | DEFAULT | DO | ELSE | ENUM | FALSE | FLOAT | FOR | GOTO | IF | INLINE | INT | LONG | MUTEX | PRIORITY | REPEAT | RETURN | SAFECALL | SHORT | START | STOP | STRING | STRUCT | SUB | SWITCH | TASK | TRUE | TYPEDEF | UNSIGNED | UNTIL | VOID | WHILE | PLUSPLUS | PLUS | MINUSMINUS | MINUS | STAR | DIVIDE | MOD | LSHIFT | RSHIFT | AND | OR | XOR | TILDE | NOT | ANDAND | OROR | EQUAL | NOTEQUAL | LESSEQUAL | LESSTHAN | GREATEREQUAL | GREATERTHAN | ASSIGN | PLUSASSIGN | MINUSASSIGN | STARASSIGN | DIVASSIGN | MODASSIGN | LSHIFTASSIGN | RSHIFTASSIGN | ANDASSIGN | ORASSIGN | XORASSIGN | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | FLOAT_LITERAL | EOL | WHITESPACE | COMMENT | LINE_COMMENT | UNK );";
		}

		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
				case 0:
					int LA18_0 = input.LA(1);

					s = -1;
					if ((LA18_0 == '(')) {
						s = 1;
					} else if ((LA18_0 == ')')) {
						s = 2;
					} else if ((LA18_0 == ';')) {
						s = 3;
					} else if ((LA18_0 == ',')) {
						s = 4;
					} else if ((LA18_0 == '{')) {
						s = 5;
					} else if ((LA18_0 == '}')) {
						s = 6;
					} else if ((LA18_0 == '[')) {
						s = 7;
					} else if ((LA18_0 == ']')) {
						s = 8;
					} else if ((LA18_0 == '.')) {
						s = 9;
					} else if ((LA18_0 == '?')) {
						s = 10;
					} else if ((LA18_0 == ':')) {
						s = 11;
					} else if ((LA18_0 == 'b')) {
						s = 12;
					} else if ((LA18_0 == 'c')) {
						s = 13;
					} else if ((LA18_0 == 'd')) {
						s = 14;
					} else if ((LA18_0 == 'e')) {
						s = 15;
					} else if ((LA18_0 == 'f')) {
						s = 16;
					} else if ((LA18_0 == 'g')) {
						s = 17;
					} else if ((LA18_0 == 'i')) {
						s = 18;
					} else if ((LA18_0 == 'l')) {
						s = 19;
					} else if ((LA18_0 == 'm')) {
						s = 20;
					} else if ((LA18_0 == 'p')) {
						s = 21;
					} else if ((LA18_0 == 'r')) {
						s = 22;
					} else if ((LA18_0 == 's')) {
						s = 23;
					} else if ((LA18_0 == 't')) {
						s = 24;
					} else if ((LA18_0 == 'u')) {
						s = 25;
					} else if ((LA18_0 == 'v')) {
						s = 26;
					} else if ((LA18_0 == 'w')) {
						s = 27;
					} else if ((LA18_0 == '+')) {
						s = 28;
					} else if ((LA18_0 == '-')) {
						s = 29;
					} else if ((LA18_0 == '*')) {
						s = 30;
					} else if ((LA18_0 == '/')) {
						s = 31;
					} else if ((LA18_0 == '%')) {
						s = 32;
					} else if ((LA18_0 == '<')) {
						s = 33;
					} else if ((LA18_0 == '>')) {
						s = 34;
					} else if ((LA18_0 == '&')) {
						s = 35;
					} else if ((LA18_0 == '|')) {
						s = 36;
					} else if ((LA18_0 == '^')) {
						s = 37;
					} else if ((LA18_0 == '~')) {
						s = 38;
					} else if ((LA18_0 == '!')) {
						s = 39;
					} else if ((LA18_0 == '=')) {
						s = 40;
					} else if (((LA18_0 >= 'A' && LA18_0 <= 'Z') || LA18_0 == '_' || LA18_0 == 'a' || LA18_0 == 'h' || (LA18_0 >= 'j' && LA18_0 <= 'k') || (LA18_0 >= 'n' && LA18_0 <= 'o') || LA18_0 == 'q' || (LA18_0 >= 'x' && LA18_0 <= 'z'))) {
						s = 41;
					} else if ((LA18_0 == '\'')) {
						s = 42;
					} else if ((LA18_0 == '\"')) {
						s = 43;
					} else if ((LA18_0 == '0')) {
						s = 44;
					} else if (((LA18_0 >= '1' && LA18_0 <= '9'))) {
						s = 45;
					} else if ((LA18_0 == '\r')) {
						s = 46;
					} else if ((LA18_0 == '\n')) {
						s = 47;
					} else if ((LA18_0 == '\t' || LA18_0 == '\f' || LA18_0 == ' ')) {
						s = 48;
					} else if (((LA18_0 >= '\u0000' && LA18_0 <= '\b') || LA18_0 == '\u000B' || (LA18_0 >= '\u000E' && LA18_0 <= '\u001F') || (LA18_0 >= '#' && LA18_0 <= '$') || LA18_0 == '@' || LA18_0 == '\\' || LA18_0 == '`' || (LA18_0 >= '\u007F' && LA18_0 <= '\uFFFF'))) {
						s = 49;
					}

					if (s >= 0) {
						return s;
					}
					break;
				case 1:
					int LA18_42 = input.LA(1);

					s = -1;
					if (((LA18_42 >= '\u0000' && LA18_42 <= '&') || (LA18_42 >= '(' && LA18_42 <= '\uFFFF'))) {
						s = 127;
					} else {
						s = 49;
					}

					if (s >= 0) {
						return s;
					}
					break;
				case 2:
					int LA18_43 = input.LA(1);

					s = -1;
					if (((LA18_43 >= '\u0000' && LA18_43 <= '\uFFFF'))) {
						s = 128;
					} else {
						s = 49;
					}

					if (s >= 0) {
						return s;
					}
					break;
			}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 18, _s, input);
			error(nvae);
			throw nvae;
		}
	}
}