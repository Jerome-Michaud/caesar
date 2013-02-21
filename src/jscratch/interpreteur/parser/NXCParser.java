// $ANTLR 3.3 Nov 30, 2010 12:50:56 ../grammaire/NXC.g 2013-01-11 15:39:49

/*
 * Le contenu de ce fichier est généré par la biblithèque ANTLR
 * à partir du fichier NXC.g
 */
package jscratch.interpreteur.parser;

import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class NXCParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ROOT", "FUNCTION_DEFINITION", "FUNCTION_DECLARATION", "PARAMETERS", "TASK_DEFINITION", "TASK_DECLARATION", "VAR_DECLARATION", "DIMENSION", "STRUCT_FIELD", "INITIALIZER", "STATEMENTS", "CAST", "DIMENSION_ACCESS", "FIELD_ACCESS", "PRE", "POST", "FUNC_CALL", "ARGUMENTS", "LABEL", "TERNARY", "T_VOID", "T_S8", "T_U8", "T_S16", "T_U16", "T_S32", "T_U32", "T_FLOAT", "T_STRING", "T_MUTEX", "SAFECALL", "INLINE", "IDENTIFIER", "TASK", "TYPEDEF", "CONST", "VOID", "SUB", "CHAR", "UNSIGNED", "BOOL", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "STRING", "MUTEX", "ENUM", "DECIMAL_LITERAL", "HEX_LITERAL", "STRUCT", "CHARACTER_LITERAL", "STRING_LITERAL", "FLOAT_LITERAL", "TRUE", "FALSE", "IF", "SWITCH", "ELSE", "CASE", "DEFAULT", "WHILE", "UNTIL", "REPEAT", "DO", "FOR", "GOTO", "CONTINUE", "BREAK", "RETURN", "START", "STOP", "PRIORITY", "PLUSPLUS", "PLUS", "MINUSMINUS", "MINUS", "STAR", "DIVIDE", "MOD", "LSHIFT", "RSHIFT", "AND", "OR", "XOR", "TILDE", "NOT", "ANDAND", "OROR", "EQUAL", "NOTEQUAL", "LESSEQUAL", "LESSTHAN", "GREATEREQUAL", "GREATERTHAN", "ASSIGN", "PLUSASSIGN", "MINUSASSIGN", "STARASSIGN", "DIVASSIGN", "MODASSIGN", "LSHIFTASSIGN", "RSHIFTASSIGN", "ANDASSIGN", "ORASSIGN", "XORASSIGN", "LETTER", "EscapeSequence", "HexDigit", "Exponent", "EOL", "WHITESPACE", "COMMENT", "LINE_COMMENT", "UNK", "'('", "')'", "';'", "','", "'{'", "'}'", "'['", "']'", "'.'", "'?'", "':'"
    };
    public static final int EOF=-1;
    public static final int T__120=120;
    public static final int T__121=121;
    public static final int T__122=122;
    public static final int T__123=123;
    public static final int T__124=124;
    public static final int T__125=125;
    public static final int T__126=126;
    public static final int T__127=127;
    public static final int T__128=128;
    public static final int T__129=129;
    public static final int T__130=130;
    public static final int ROOT=4;
    public static final int FUNCTION_DEFINITION=5;
    public static final int FUNCTION_DECLARATION=6;
    public static final int PARAMETERS=7;
    public static final int TASK_DEFINITION=8;
    public static final int TASK_DECLARATION=9;
    public static final int VAR_DECLARATION=10;
    public static final int DIMENSION=11;
    public static final int STRUCT_FIELD=12;
    public static final int INITIALIZER=13;
    public static final int STATEMENTS=14;
    public static final int CAST=15;
    public static final int DIMENSION_ACCESS=16;
    public static final int FIELD_ACCESS=17;
    public static final int PRE=18;
    public static final int POST=19;
    public static final int FUNC_CALL=20;
    public static final int ARGUMENTS=21;
    public static final int LABEL=22;
    public static final int TERNARY=23;
    public static final int T_VOID=24;
    public static final int T_S8=25;
    public static final int T_U8=26;
    public static final int T_S16=27;
    public static final int T_U16=28;
    public static final int T_S32=29;
    public static final int T_U32=30;
    public static final int T_FLOAT=31;
    public static final int T_STRING=32;
    public static final int T_MUTEX=33;
    public static final int SAFECALL=34;
    public static final int INLINE=35;
    public static final int IDENTIFIER=36;
    public static final int TASK=37;
    public static final int TYPEDEF=38;
    public static final int CONST=39;
    public static final int VOID=40;
    public static final int SUB=41;
    public static final int CHAR=42;
    public static final int UNSIGNED=43;
    public static final int BOOL=44;
    public static final int BYTE=45;
    public static final int SHORT=46;
    public static final int INT=47;
    public static final int LONG=48;
    public static final int FLOAT=49;
    public static final int STRING=50;
    public static final int MUTEX=51;
    public static final int ENUM=52;
    public static final int DECIMAL_LITERAL=53;
    public static final int HEX_LITERAL=54;
    public static final int STRUCT=55;
    public static final int CHARACTER_LITERAL=56;
    public static final int STRING_LITERAL=57;
    public static final int FLOAT_LITERAL=58;
    public static final int TRUE=59;
    public static final int FALSE=60;
    public static final int IF=61;
    public static final int SWITCH=62;
    public static final int ELSE=63;
    public static final int CASE=64;
    public static final int DEFAULT=65;
    public static final int WHILE=66;
    public static final int UNTIL=67;
    public static final int REPEAT=68;
    public static final int DO=69;
    public static final int FOR=70;
    public static final int GOTO=71;
    public static final int CONTINUE=72;
    public static final int BREAK=73;
    public static final int RETURN=74;
    public static final int START=75;
    public static final int STOP=76;
    public static final int PRIORITY=77;
    public static final int PLUSPLUS=78;
    public static final int PLUS=79;
    public static final int MINUSMINUS=80;
    public static final int MINUS=81;
    public static final int STAR=82;
    public static final int DIVIDE=83;
    public static final int MOD=84;
    public static final int LSHIFT=85;
    public static final int RSHIFT=86;
    public static final int AND=87;
    public static final int OR=88;
    public static final int XOR=89;
    public static final int TILDE=90;
    public static final int NOT=91;
    public static final int ANDAND=92;
    public static final int OROR=93;
    public static final int EQUAL=94;
    public static final int NOTEQUAL=95;
    public static final int LESSEQUAL=96;
    public static final int LESSTHAN=97;
    public static final int GREATEREQUAL=98;
    public static final int GREATERTHAN=99;
    public static final int ASSIGN=100;
    public static final int PLUSASSIGN=101;
    public static final int MINUSASSIGN=102;
    public static final int STARASSIGN=103;
    public static final int DIVASSIGN=104;
    public static final int MODASSIGN=105;
    public static final int LSHIFTASSIGN=106;
    public static final int RSHIFTASSIGN=107;
    public static final int ANDASSIGN=108;
    public static final int ORASSIGN=109;
    public static final int XORASSIGN=110;
    public static final int LETTER=111;
    public static final int EscapeSequence=112;
    public static final int HexDigit=113;
    public static final int Exponent=114;
    public static final int EOL=115;
    public static final int WHITESPACE=116;
    public static final int COMMENT=117;
    public static final int LINE_COMMENT=118;
    public static final int UNK=119;

    // delegates
    // delegators

    protected static class Type_scope {
        Object type;
    }
    protected Stack Type_stack = new Stack();


        public NXCParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public NXCParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[181+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return NXCParser.tokenNames; }
    public String getGrammarFileName() { return "../grammaire/NXC.g"; }


    private Map<String,Object> typeTranslation = new HashMap<String,Object>();
    private Map<String,Integer> enumValues = new HashMap<String,Integer>();
    private List<WarningOrError> compilMessages = new LinkedList<WarningOrError>();

    /*
     * Test du parser.
     */
    public static void main(String[] args) throws Exception {
    	NXCLexer lex = new NXCLexer(new ANTLRStringStream(
    			"task main() {\n" +
    			"long nb = 13;\n" +
    			"int i;\n" +
    			"for(i = 0; i < 2; i = i + 1) {\n" +
    				"OnFwd(OUT_A, (90 + nb)/2);\n" +
    				"Wait(3);\n" +
    			"}\n" +
    			"Off(OUT_A);\n" +
    			"}"));
    	CommonTokenStream tokens = new CommonTokenStream(lex);

    	NXCParser parser = new NXCParser(tokens);

    	try {
    		NXCParser.translation_unit_return ret = parser.translation_unit();
    		if(parser.getNumberOfSyntaxErrors() != 0) {
        			System.err.println("Erreur de syntaxe !");
    				for(Object o: parser.compilMessages)
    					System.out.println(o);
    		}
    		else {
    			CommonTree tree = (CommonTree)ret.getTree();
    			System.out.println(tree.toStringTree());
    		}    
    	} catch (RecognitionException e) {
    		e.printStackTrace();
    	}
    	System.out.println("Fin test");
    }

    /**
     * Parse un code source NXC et retourne l'arbre syntaxique abstrait.
     *
     * @param code le code source
     * @return l'arbre syntaxique antlr ou null en cas d'échec.
     */
    public static Tree parseCode(String code) {
        NXCLexer lex = new NXCLexer(new ANTLRStringStream(code));
    	CommonTokenStream tokens = new CommonTokenStream(lex);

    	NXCParser parser = new NXCParser(tokens);

    	try {
    		NXCParser.translation_unit_return ret = parser.translation_unit();
    		if(parser.getNumberOfSyntaxErrors() != 0) {
        			System.err.println("Erreur de syntaxe !");
    		}
    		else {
    			return (Tree)ret.getTree();
    		}
    	} catch (RecognitionException e) {
    		System.err.println(e.getMessage());
    	}
    	return null;
    }

    boolean isTypeName(String name) {
    	return typeTranslation.containsKey(name);
    }

    Object translateType(String name) {
    	return typeTranslation.get(name);
    }

    public Map<String,Integer> getEnumValues() {
    	return enumValues;
    }

    /**
     * Error messages are not emited.
     */
    @Override
    public void emitErrorMessage(String msg) {}

    /**
     * Tente de récupérer un élément manquant ou supplémentaire.
     * Enregistre une erreur pour chaque élément.
     */
    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    	if ( mismatchIsUnwantedToken(input, ttype) ) {
    		UnwantedTokenException e = new UnwantedTokenException(ttype, input);
    		beginResync();
    		input.consume();
    		endResync();
    		reportError(e);
    		Object matchedSymbol = getCurrentInputSymbol(input);
    		input.consume();
    		this.compilMessages.add(new WarningOrError(e.line, e.charPositionInLine, true, "Token `"+e.getUnexpectedToken().getText()+"` ignoré avant `"+this.getTokenNames()[ttype]+"`."));
    		return matchedSymbol;
    	}
    	if ( mismatchIsMissingToken(input, follow) ) {
    		Object inserted = getMissingSymbol(input, null, ttype, follow);
    		MissingTokenException e = new MissingTokenException(ttype, input, inserted);
    		reportError(e);
    		this.compilMessages.add(new WarningOrError(e.line, e.charPositionInLine, true, "Token `"+this.getTokenNames()[ttype]+"` ajouté avant `"+e.token.getText()+"`."));
    		return inserted;
    	}
    	throw new MismatchedTokenException(ttype, input);
    }

    public List<WarningOrError> getCompilMessages() {
    	return this.compilMessages;
    }


    public static class translation_unit_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "translation_unit"
    // ../grammaire/NXC.g:176:1: translation_unit : ( external_declaration )+ -> ^( ROOT ( external_declaration )+ ) ;
    public final NXCParser.translation_unit_return translation_unit() throws RecognitionException {
        NXCParser.translation_unit_return retval = new NXCParser.translation_unit_return();
        retval.start = input.LT(1);
        int translation_unit_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.external_declaration_return external_declaration1 = null;


        RewriteRuleSubtreeStream stream_external_declaration=new RewriteRuleSubtreeStream(adaptor,"rule external_declaration");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // ../grammaire/NXC.g:177:2: ( ( external_declaration )+ -> ^( ROOT ( external_declaration )+ ) )
            // ../grammaire/NXC.g:177:4: ( external_declaration )+
            {
            // ../grammaire/NXC.g:177:4: ( external_declaration )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../grammaire/NXC.g:0:0: external_declaration
            	    {
            	    pushFollow(FOLLOW_external_declaration_in_translation_unit229);
            	    external_declaration1=external_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_external_declaration.add(external_declaration1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: external_declaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 177:26: -> ^( ROOT ( external_declaration )+ )
            {
                // ../grammaire/NXC.g:177:29: ^( ROOT ( external_declaration )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);

                if ( !(stream_external_declaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_external_declaration.hasNext() ) {
                    adaptor.addChild(root_1, stream_external_declaration.nextTree());

                }
                stream_external_declaration.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, translation_unit_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "translation_unit"

    public static class external_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "external_declaration"
    // ../grammaire/NXC.g:180:1: external_declaration options {k=1; } : ( ( ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{' )=> function_definition | ( TASK IDENTIFIER '(' ')' '{' )=> task_definition | ( ( TYPEDEF )? STRUCT )=> struct_definition | ( ENUM )=> enum_declaration | declaration );
    public final NXCParser.external_declaration_return external_declaration() throws RecognitionException {
        NXCParser.external_declaration_return retval = new NXCParser.external_declaration_return();
        retval.start = input.LT(1);
        int external_declaration_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.function_definition_return function_definition2 = null;

        NXCParser.task_definition_return task_definition3 = null;

        NXCParser.struct_definition_return struct_definition4 = null;

        NXCParser.enum_declaration_return enum_declaration5 = null;

        NXCParser.declaration_return declaration6 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // ../grammaire/NXC.g:182:2: ( ( ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{' )=> function_definition | ( TASK IDENTIFIER '(' ')' '{' )=> task_definition | ( ( TYPEDEF )? STRUCT )=> struct_definition | ( ENUM )=> enum_declaration | declaration )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../grammaire/NXC.g:182:4: ( ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{' )=> function_definition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_definition_in_external_declaration280);
                    function_definition2=function_definition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition2.getTree());

                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:183:4: ( TASK IDENTIFIER '(' ')' '{' )=> task_definition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_task_definition_in_external_declaration299);
                    task_definition3=task_definition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, task_definition3.getTree());

                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:184:4: ( ( TYPEDEF )? STRUCT )=> struct_definition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_struct_definition_in_external_declaration313);
                    struct_definition4=struct_definition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_definition4.getTree());

                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:185:4: ( ENUM )=> enum_declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enum_declaration_in_external_declaration324);
                    enum_declaration5=enum_declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_declaration5.getTree());

                    }
                    break;
                case 5 :
                    // ../grammaire/NXC.g:186:4: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_external_declaration329);
                    declaration6=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration6.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, external_declaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "external_declaration"

    public static class function_definition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function_definition"
    // ../grammaire/NXC.g:189:1: function_definition : ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' compound_statement -> ^( FUNCTION_DEFINITION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) compound_statement ) ;
    public final NXCParser.function_definition_return function_definition() throws RecognitionException {
        NXCParser.function_definition_return retval = new NXCParser.function_definition_return();
        retval.start = input.LT(1);
        int function_definition_StartIndex = input.index();
        Object root_0 = null;

        Token SAFECALL7=null;
        Token INLINE8=null;
        Token IDENTIFIER9=null;
        Token char_literal10=null;
        Token char_literal12=null;
        NXCParser.type_specifier_return type = null;

        NXCParser.parameter_list_return parameter_list11 = null;

        NXCParser.compound_statement_return compound_statement13 = null;


        Object SAFECALL7_tree=null;
        Object INLINE8_tree=null;
        Object IDENTIFIER9_tree=null;
        Object char_literal10_tree=null;
        Object char_literal12_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_SAFECALL=new RewriteRuleTokenStream(adaptor,"token SAFECALL");
        RewriteRuleTokenStream stream_INLINE=new RewriteRuleTokenStream(adaptor,"token INLINE");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_type_specifier=new RewriteRuleSubtreeStream(adaptor,"rule type_specifier");
        RewriteRuleSubtreeStream stream_compound_statement=new RewriteRuleSubtreeStream(adaptor,"rule compound_statement");
        RewriteRuleSubtreeStream stream_parameter_list=new RewriteRuleSubtreeStream(adaptor,"rule parameter_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // ../grammaire/NXC.g:190:2: ( ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' compound_statement -> ^( FUNCTION_DEFINITION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) compound_statement ) )
            // ../grammaire/NXC.g:190:4: ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' compound_statement
            {
            // ../grammaire/NXC.g:190:4: ( SAFECALL )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: SAFECALL
                    {
                    SAFECALL7=(Token)match(input,SAFECALL,FOLLOW_SAFECALL_in_function_definition340); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SAFECALL.add(SAFECALL7);


                    }
                    break;

            }

            // ../grammaire/NXC.g:190:14: ( INLINE )?
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: INLINE
                    {
                    INLINE8=(Token)match(input,INLINE,FOLLOW_INLINE_in_function_definition343); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INLINE.add(INLINE8);


                    }
                    break;

            }

            pushFollow(FOLLOW_type_specifier_in_function_definition348);
            type=type_specifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type_specifier.add(type.getTree());
            IDENTIFIER9=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_function_definition350); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER9);

            char_literal10=(Token)match(input,120,FOLLOW_120_in_function_definition352); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(char_literal10);

            // ../grammaire/NXC.g:190:57: ( parameter_list )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: parameter_list
                    {
                    pushFollow(FOLLOW_parameter_list_in_function_definition354);
                    parameter_list11=parameter_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parameter_list.add(parameter_list11.getTree());

                    }
                    break;

            }

            char_literal12=(Token)match(input,121,FOLLOW_121_in_function_definition357); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(char_literal12);

            pushFollow(FOLLOW_compound_statement_in_function_definition359);
            compound_statement13=compound_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_compound_statement.add(compound_statement13.getTree());


            // AST REWRITE
            // elements: parameter_list, SAFECALL, IDENTIFIER, compound_statement, type
            // token labels: 
            // rule labels: retval, type
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.tree:null);

            root_0 = (Object)adaptor.nil();
            // 190:96: -> ^( FUNCTION_DEFINITION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) compound_statement )
            {
                // ../grammaire/NXC.g:190:99: ^( FUNCTION_DEFINITION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) compound_statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_DEFINITION, "FUNCTION_DEFINITION"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                // ../grammaire/NXC.g:190:138: ( SAFECALL )?
                if ( stream_SAFECALL.hasNext() ) {
                    adaptor.addChild(root_1, stream_SAFECALL.nextNode());

                }
                stream_SAFECALL.reset();
                // ../grammaire/NXC.g:190:148: ^( PARAMETERS ( parameter_list )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMETERS, "PARAMETERS"), root_2);

                // ../grammaire/NXC.g:190:161: ( parameter_list )?
                if ( stream_parameter_list.hasNext() ) {
                    adaptor.addChild(root_2, stream_parameter_list.nextTree());

                }
                stream_parameter_list.reset();

                adaptor.addChild(root_1, root_2);
                }
                adaptor.addChild(root_1, stream_compound_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, function_definition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "function_definition"

    public static class task_definition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "task_definition"
    // ../grammaire/NXC.g:192:1: task_definition : TASK IDENTIFIER '(' ')' compound_statement -> ^( TASK_DEFINITION T_VOID IDENTIFIER compound_statement ) ;
    public final NXCParser.task_definition_return task_definition() throws RecognitionException {
        NXCParser.task_definition_return retval = new NXCParser.task_definition_return();
        retval.start = input.LT(1);
        int task_definition_StartIndex = input.index();
        Object root_0 = null;

        Token TASK14=null;
        Token IDENTIFIER15=null;
        Token char_literal16=null;
        Token char_literal17=null;
        NXCParser.compound_statement_return compound_statement18 = null;


        Object TASK14_tree=null;
        Object IDENTIFIER15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal17_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_TASK=new RewriteRuleTokenStream(adaptor,"token TASK");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_compound_statement=new RewriteRuleSubtreeStream(adaptor,"rule compound_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // ../grammaire/NXC.g:193:2: ( TASK IDENTIFIER '(' ')' compound_statement -> ^( TASK_DEFINITION T_VOID IDENTIFIER compound_statement ) )
            // ../grammaire/NXC.g:193:4: TASK IDENTIFIER '(' ')' compound_statement
            {
            TASK14=(Token)match(input,TASK,FOLLOW_TASK_in_task_definition391); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TASK.add(TASK14);

            IDENTIFIER15=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_task_definition393); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER15);

            char_literal16=(Token)match(input,120,FOLLOW_120_in_task_definition395); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_120.add(char_literal16);

            char_literal17=(Token)match(input,121,FOLLOW_121_in_task_definition397); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_121.add(char_literal17);

            pushFollow(FOLLOW_compound_statement_in_task_definition399);
            compound_statement18=compound_statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_compound_statement.add(compound_statement18.getTree());


            // AST REWRITE
            // elements: compound_statement, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 193:47: -> ^( TASK_DEFINITION T_VOID IDENTIFIER compound_statement )
            {
                // ../grammaire/NXC.g:193:50: ^( TASK_DEFINITION T_VOID IDENTIFIER compound_statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TASK_DEFINITION, "TASK_DEFINITION"), root_1);

                adaptor.addChild(root_1, (Object)adaptor.create(T_VOID, "T_VOID"));
                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                adaptor.addChild(root_1, stream_compound_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, task_definition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "task_definition"

    public static class declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // ../grammaire/NXC.g:195:1: declaration : ( TYPEDEF type_specifier IDENTIFIER ';' -> | ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';' -> ^( FUNCTION_DECLARATION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) ) | TASK IDENTIFIER '(' ')' ';' -> ^( TASK_DECLARATION T_VOID IDENTIFIER ) | declaration_specifiers init_declarator_list ';' -> init_declarator_list );
    public final NXCParser.declaration_return declaration() throws RecognitionException {
        Type_stack.push(new Type_scope());

        NXCParser.declaration_return retval = new NXCParser.declaration_return();
        retval.start = input.LT(1);
        int declaration_StartIndex = input.index();
        Object root_0 = null;

        Token TYPEDEF19=null;
        Token IDENTIFIER21=null;
        Token char_literal22=null;
        Token SAFECALL23=null;
        Token INLINE24=null;
        Token IDENTIFIER25=null;
        Token char_literal26=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token TASK30=null;
        Token IDENTIFIER31=null;
        Token char_literal32=null;
        Token char_literal33=null;
        Token char_literal34=null;
        Token char_literal37=null;
        NXCParser.type_specifier_return type = null;

        NXCParser.type_specifier_return type_specifier20 = null;

        NXCParser.parameter_list_return parameter_list27 = null;

        NXCParser.declaration_specifiers_return declaration_specifiers35 = null;

        NXCParser.init_declarator_list_return init_declarator_list36 = null;


        Object TYPEDEF19_tree=null;
        Object IDENTIFIER21_tree=null;
        Object char_literal22_tree=null;
        Object SAFECALL23_tree=null;
        Object INLINE24_tree=null;
        Object IDENTIFIER25_tree=null;
        Object char_literal26_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object TASK30_tree=null;
        Object IDENTIFIER31_tree=null;
        Object char_literal32_tree=null;
        Object char_literal33_tree=null;
        Object char_literal34_tree=null;
        Object char_literal37_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_TASK=new RewriteRuleTokenStream(adaptor,"token TASK");
        RewriteRuleTokenStream stream_SAFECALL=new RewriteRuleTokenStream(adaptor,"token SAFECALL");
        RewriteRuleTokenStream stream_INLINE=new RewriteRuleTokenStream(adaptor,"token INLINE");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_TYPEDEF=new RewriteRuleTokenStream(adaptor,"token TYPEDEF");
        RewriteRuleSubtreeStream stream_declaration_specifiers=new RewriteRuleSubtreeStream(adaptor,"rule declaration_specifiers");
        RewriteRuleSubtreeStream stream_init_declarator_list=new RewriteRuleSubtreeStream(adaptor,"rule init_declarator_list");
        RewriteRuleSubtreeStream stream_type_specifier=new RewriteRuleSubtreeStream(adaptor,"rule type_specifier");
        RewriteRuleSubtreeStream stream_parameter_list=new RewriteRuleSubtreeStream(adaptor,"rule parameter_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // ../grammaire/NXC.g:197:2: ( TYPEDEF type_specifier IDENTIFIER ';' -> | ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';' -> ^( FUNCTION_DECLARATION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) ) | TASK IDENTIFIER '(' ')' ';' -> ^( TASK_DECLARATION T_VOID IDENTIFIER ) | declaration_specifiers init_declarator_list ';' -> init_declarator_list )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../grammaire/NXC.g:197:4: TYPEDEF type_specifier IDENTIFIER ';'
                    {
                    TYPEDEF19=(Token)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_declaration426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPEDEF.add(TYPEDEF19);

                    pushFollow(FOLLOW_type_specifier_in_declaration428);
                    type_specifier20=type_specifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_specifier.add(type_specifier20.getTree());
                    IDENTIFIER21=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration430); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER21);

                    char_literal22=(Token)match(input,122,FOLLOW_122_in_declaration432); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal22);

                    if ( state.backtracking==0 ) {
                       typeTranslation.put((IDENTIFIER21!=null?IDENTIFIER21.getText():null), (type_specifier20!=null?((Object)type_specifier20.tree):null)); 
                    }


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 197:107: ->
                    {
                        root_0 = null;
                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:198:4: ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';'
                    {
                    // ../grammaire/NXC.g:198:4: ( SAFECALL )?
                    int alt6=2;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: SAFECALL
                            {
                            SAFECALL23=(Token)match(input,SAFECALL,FOLLOW_SAFECALL_in_declaration442); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SAFECALL.add(SAFECALL23);


                            }
                            break;

                    }

                    // ../grammaire/NXC.g:198:14: ( INLINE )?
                    int alt7=2;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: INLINE
                            {
                            INLINE24=(Token)match(input,INLINE,FOLLOW_INLINE_in_declaration445); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_INLINE.add(INLINE24);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_type_specifier_in_declaration450);
                    type=type_specifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_specifier.add(type.getTree());
                    IDENTIFIER25=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER25);

                    char_literal26=(Token)match(input,120,FOLLOW_120_in_declaration454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal26);

                    // ../grammaire/NXC.g:198:57: ( parameter_list )?
                    int alt8=2;
                    alt8 = dfa8.predict(input);
                    switch (alt8) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: parameter_list
                            {
                            pushFollow(FOLLOW_parameter_list_in_declaration456);
                            parameter_list27=parameter_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_parameter_list.add(parameter_list27.getTree());

                            }
                            break;

                    }

                    char_literal28=(Token)match(input,121,FOLLOW_121_in_declaration459); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal28);

                    char_literal29=(Token)match(input,122,FOLLOW_122_in_declaration461); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal29);



                    // AST REWRITE
                    // elements: SAFECALL, type, IDENTIFIER, parameter_list
                    // token labels: 
                    // rule labels: retval, type
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type",type!=null?type.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 198:81: -> ^( FUNCTION_DECLARATION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) )
                    {
                        // ../grammaire/NXC.g:198:84: ^( FUNCTION_DECLARATION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION_DECLARATION, "FUNCTION_DECLARATION"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());
                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // ../grammaire/NXC.g:198:124: ( SAFECALL )?
                        if ( stream_SAFECALL.hasNext() ) {
                            adaptor.addChild(root_1, stream_SAFECALL.nextNode());

                        }
                        stream_SAFECALL.reset();
                        // ../grammaire/NXC.g:198:134: ^( PARAMETERS ( parameter_list )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAMETERS, "PARAMETERS"), root_2);

                        // ../grammaire/NXC.g:198:147: ( parameter_list )?
                        if ( stream_parameter_list.hasNext() ) {
                            adaptor.addChild(root_2, stream_parameter_list.nextTree());

                        }
                        stream_parameter_list.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:199:4: TASK IDENTIFIER '(' ')' ';'
                    {
                    TASK30=(Token)match(input,TASK,FOLLOW_TASK_in_declaration487); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TASK.add(TASK30);

                    IDENTIFIER31=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration489); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER31);

                    char_literal32=(Token)match(input,120,FOLLOW_120_in_declaration491); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal32);

                    char_literal33=(Token)match(input,121,FOLLOW_121_in_declaration493); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal33);

                    char_literal34=(Token)match(input,122,FOLLOW_122_in_declaration495); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal34);



                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 199:32: -> ^( TASK_DECLARATION T_VOID IDENTIFIER )
                    {
                        // ../grammaire/NXC.g:199:35: ^( TASK_DECLARATION T_VOID IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TASK_DECLARATION, "TASK_DECLARATION"), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(T_VOID, "T_VOID"));
                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:200:4: declaration_specifiers init_declarator_list ';'
                    {
                    pushFollow(FOLLOW_declaration_specifiers_in_declaration510);
                    declaration_specifiers35=declaration_specifiers();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_declaration_specifiers.add(declaration_specifiers35.getTree());
                    if ( state.backtracking==0 ) {
                      ((Type_scope)Type_stack.peek()).type = (declaration_specifiers35!=null?((Object)declaration_specifiers35.tree):null);
                    }
                    pushFollow(FOLLOW_init_declarator_list_in_declaration514);
                    init_declarator_list36=init_declarator_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_init_declarator_list.add(init_declarator_list36.getTree());
                    char_literal37=(Token)match(input,122,FOLLOW_122_in_declaration516); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal37);



                    // AST REWRITE
                    // elements: init_declarator_list
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 200:98: -> init_declarator_list
                    {
                        adaptor.addChild(root_0, stream_init_declarator_list.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, declaration_StartIndex); }
            Type_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class declaration_specifiers_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration_specifiers"
    // ../grammaire/NXC.g:203:1: declaration_specifiers : ( CONST )? type_specifier ;
    public final NXCParser.declaration_specifiers_return declaration_specifiers() throws RecognitionException {
        NXCParser.declaration_specifiers_return retval = new NXCParser.declaration_specifiers_return();
        retval.start = input.LT(1);
        int declaration_specifiers_StartIndex = input.index();
        Object root_0 = null;

        Token CONST38=null;
        NXCParser.type_specifier_return type_specifier39 = null;


        Object CONST38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // ../grammaire/NXC.g:204:2: ( ( CONST )? type_specifier )
            // ../grammaire/NXC.g:204:4: ( CONST )? type_specifier
            {
            root_0 = (Object)adaptor.nil();

            // ../grammaire/NXC.g:204:4: ( CONST )?
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: CONST
                    {
                    CONST38=(Token)match(input,CONST,FOLLOW_CONST_in_declaration_specifiers531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CONST38_tree = (Object)adaptor.create(CONST38);
                    adaptor.addChild(root_0, CONST38_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_type_specifier_in_declaration_specifiers534);
            type_specifier39=type_specifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, type_specifier39.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, declaration_specifiers_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declaration_specifiers"

    public static class init_declarator_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "init_declarator_list"
    // ../grammaire/NXC.g:207:1: init_declarator_list : (d= init_declarator -> ^( VAR_DECLARATION $d) ) ( ',' d= init_declarator -> $init_declarator_list ^( VAR_DECLARATION $d) )* ;
    public final NXCParser.init_declarator_list_return init_declarator_list() throws RecognitionException {
        NXCParser.init_declarator_list_return retval = new NXCParser.init_declarator_list_return();
        retval.start = input.LT(1);
        int init_declarator_list_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal40=null;
        NXCParser.init_declarator_return d = null;


        Object char_literal40_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_init_declarator=new RewriteRuleSubtreeStream(adaptor,"rule init_declarator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // ../grammaire/NXC.g:208:2: ( (d= init_declarator -> ^( VAR_DECLARATION $d) ) ( ',' d= init_declarator -> $init_declarator_list ^( VAR_DECLARATION $d) )* )
            // ../grammaire/NXC.g:208:4: (d= init_declarator -> ^( VAR_DECLARATION $d) ) ( ',' d= init_declarator -> $init_declarator_list ^( VAR_DECLARATION $d) )*
            {
            // ../grammaire/NXC.g:208:4: (d= init_declarator -> ^( VAR_DECLARATION $d) )
            // ../grammaire/NXC.g:208:5: d= init_declarator
            {
            pushFollow(FOLLOW_init_declarator_in_init_declarator_list548);
            d=init_declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_init_declarator.add(d.getTree());


            // AST REWRITE
            // elements: d
            // token labels: 
            // rule labels: retval, d
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

            root_0 = (Object)adaptor.nil();
            // 208:23: -> ^( VAR_DECLARATION $d)
            {
                // ../grammaire/NXC.g:208:26: ^( VAR_DECLARATION $d)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);

                adaptor.addChild(root_1, ((Type_scope)Type_stack.peek()).type);
                adaptor.addChild(root_1, stream_d.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:208:63: ( ',' d= init_declarator -> $init_declarator_list ^( VAR_DECLARATION $d) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==123) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../grammaire/NXC.g:208:64: ',' d= init_declarator
            	    {
            	    char_literal40=(Token)match(input,123,FOLLOW_123_in_init_declarator_list563); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_123.add(char_literal40);

            	    pushFollow(FOLLOW_init_declarator_in_init_declarator_list567);
            	    d=init_declarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_init_declarator.add(d.getTree());


            	    // AST REWRITE
            	    // elements: init_declarator_list, d
            	    // token labels: 
            	    // rule labels: retval, d
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 208:86: -> $init_declarator_list ^( VAR_DECLARATION $d)
            	    {
            	        adaptor.addChild(root_0, stream_retval.nextTree());
            	        // ../grammaire/NXC.g:208:111: ^( VAR_DECLARATION $d)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);

            	        adaptor.addChild(root_1, ((Type_scope)Type_stack.peek()).type);
            	        adaptor.addChild(root_1, stream_d.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, init_declarator_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "init_declarator_list"

    public static class init_declarator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "init_declarator"
    // ../grammaire/NXC.g:211:1: init_declarator : ( declarator -> declarator ) ( '=' initializer -> $init_declarator ^( INITIALIZER initializer ) )? ;
    public final NXCParser.init_declarator_return init_declarator() throws RecognitionException {
        NXCParser.init_declarator_return retval = new NXCParser.init_declarator_return();
        retval.start = input.LT(1);
        int init_declarator_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal42=null;
        NXCParser.declarator_return declarator41 = null;

        NXCParser.initializer_return initializer43 = null;


        Object char_literal42_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_declarator=new RewriteRuleSubtreeStream(adaptor,"rule declarator");
        RewriteRuleSubtreeStream stream_initializer=new RewriteRuleSubtreeStream(adaptor,"rule initializer");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // ../grammaire/NXC.g:212:2: ( ( declarator -> declarator ) ( '=' initializer -> $init_declarator ^( INITIALIZER initializer ) )? )
            // ../grammaire/NXC.g:212:4: ( declarator -> declarator ) ( '=' initializer -> $init_declarator ^( INITIALIZER initializer ) )?
            {
            // ../grammaire/NXC.g:212:4: ( declarator -> declarator )
            // ../grammaire/NXC.g:212:5: declarator
            {
            pushFollow(FOLLOW_declarator_in_init_declarator595);
            declarator41=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declarator.add(declarator41.getTree());


            // AST REWRITE
            // elements: declarator
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 212:16: -> declarator
            {
                adaptor.addChild(root_0, stream_declarator.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:212:31: ( '=' initializer -> $init_declarator ^( INITIALIZER initializer ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ASSIGN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../grammaire/NXC.g:212:32: '=' initializer
                    {
                    char_literal42=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_init_declarator603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(char_literal42);

                    pushFollow(FOLLOW_initializer_in_init_declarator605);
                    initializer43=initializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_initializer.add(initializer43.getTree());


                    // AST REWRITE
                    // elements: init_declarator, initializer
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 212:48: -> $init_declarator ^( INITIALIZER initializer )
                    {
                        adaptor.addChild(root_0, stream_retval.nextTree());
                        // ../grammaire/NXC.g:212:68: ^( INITIALIZER initializer )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INITIALIZER, "INITIALIZER"), root_1);

                        adaptor.addChild(root_1, stream_initializer.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, init_declarator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "init_declarator"

    public static class type_specifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_specifier"
    // ../grammaire/NXC.g:215:1: type_specifier : ( VOID -> T_VOID | SUB -> T_VOID | CHAR -> T_S8 | UNSIGNED CHAR -> T_U8 | BOOL -> T_U8 | BYTE -> T_U8 | SHORT -> T_S16 | INT -> T_S16 | UNSIGNED INT -> T_U16 | LONG -> T_S32 | UNSIGNED LONG -> T_U32 | FLOAT -> T_FLOAT | STRING -> T_STRING | MUTEX -> T_MUTEX | type_id );
    public final NXCParser.type_specifier_return type_specifier() throws RecognitionException {
        NXCParser.type_specifier_return retval = new NXCParser.type_specifier_return();
        retval.start = input.LT(1);
        int type_specifier_StartIndex = input.index();
        Object root_0 = null;

        Token VOID44=null;
        Token SUB45=null;
        Token CHAR46=null;
        Token UNSIGNED47=null;
        Token CHAR48=null;
        Token BOOL49=null;
        Token BYTE50=null;
        Token SHORT51=null;
        Token INT52=null;
        Token UNSIGNED53=null;
        Token INT54=null;
        Token LONG55=null;
        Token UNSIGNED56=null;
        Token LONG57=null;
        Token FLOAT58=null;
        Token STRING59=null;
        Token MUTEX60=null;
        NXCParser.type_id_return type_id61 = null;


        Object VOID44_tree=null;
        Object SUB45_tree=null;
        Object CHAR46_tree=null;
        Object UNSIGNED47_tree=null;
        Object CHAR48_tree=null;
        Object BOOL49_tree=null;
        Object BYTE50_tree=null;
        Object SHORT51_tree=null;
        Object INT52_tree=null;
        Object UNSIGNED53_tree=null;
        Object INT54_tree=null;
        Object LONG55_tree=null;
        Object UNSIGNED56_tree=null;
        Object LONG57_tree=null;
        Object FLOAT58_tree=null;
        Object STRING59_tree=null;
        Object MUTEX60_tree=null;
        RewriteRuleTokenStream stream_CHAR=new RewriteRuleTokenStream(adaptor,"token CHAR");
        RewriteRuleTokenStream stream_BYTE=new RewriteRuleTokenStream(adaptor,"token BYTE");
        RewriteRuleTokenStream stream_SHORT=new RewriteRuleTokenStream(adaptor,"token SHORT");
        RewriteRuleTokenStream stream_SUB=new RewriteRuleTokenStream(adaptor,"token SUB");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_UNSIGNED=new RewriteRuleTokenStream(adaptor,"token UNSIGNED");
        RewriteRuleTokenStream stream_VOID=new RewriteRuleTokenStream(adaptor,"token VOID");
        RewriteRuleTokenStream stream_LONG=new RewriteRuleTokenStream(adaptor,"token LONG");
        RewriteRuleTokenStream stream_MUTEX=new RewriteRuleTokenStream(adaptor,"token MUTEX");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_BOOL=new RewriteRuleTokenStream(adaptor,"token BOOL");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // ../grammaire/NXC.g:216:2: ( VOID -> T_VOID | SUB -> T_VOID | CHAR -> T_S8 | UNSIGNED CHAR -> T_U8 | BOOL -> T_U8 | BYTE -> T_U8 | SHORT -> T_S16 | INT -> T_S16 | UNSIGNED INT -> T_U16 | LONG -> T_S32 | UNSIGNED LONG -> T_U32 | FLOAT -> T_FLOAT | STRING -> T_STRING | MUTEX -> T_MUTEX | type_id )
            int alt13=15;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../grammaire/NXC.g:216:4: VOID
                    {
                    VOID44=(Token)match(input,VOID,FOLLOW_VOID_in_type_specifier629); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VOID.add(VOID44);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 216:9: -> T_VOID
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_VOID, "T_VOID"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:217:4: SUB
                    {
                    SUB45=(Token)match(input,SUB,FOLLOW_SUB_in_type_specifier638); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUB.add(SUB45);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 217:8: -> T_VOID
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_VOID, "T_VOID"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:218:4: CHAR
                    {
                    CHAR46=(Token)match(input,CHAR,FOLLOW_CHAR_in_type_specifier647); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR.add(CHAR46);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 218:9: -> T_S8
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_S8, "T_S8"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:219:4: UNSIGNED CHAR
                    {
                    UNSIGNED47=(Token)match(input,UNSIGNED,FOLLOW_UNSIGNED_in_type_specifier656); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNSIGNED.add(UNSIGNED47);

                    CHAR48=(Token)match(input,CHAR,FOLLOW_CHAR_in_type_specifier658); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR.add(CHAR48);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 219:18: -> T_U8
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U8, "T_U8"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // ../grammaire/NXC.g:220:4: BOOL
                    {
                    BOOL49=(Token)match(input,BOOL,FOLLOW_BOOL_in_type_specifier667); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOL.add(BOOL49);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 220:9: -> T_U8
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U8, "T_U8"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // ../grammaire/NXC.g:221:4: BYTE
                    {
                    BYTE50=(Token)match(input,BYTE,FOLLOW_BYTE_in_type_specifier676); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BYTE.add(BYTE50);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 221:9: -> T_U8
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U8, "T_U8"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // ../grammaire/NXC.g:222:4: SHORT
                    {
                    SHORT51=(Token)match(input,SHORT,FOLLOW_SHORT_in_type_specifier685); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHORT.add(SHORT51);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 222:10: -> T_S16
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_S16, "T_S16"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // ../grammaire/NXC.g:223:4: INT
                    {
                    INT52=(Token)match(input,INT,FOLLOW_INT_in_type_specifier694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT52);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 223:8: -> T_S16
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_S16, "T_S16"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // ../grammaire/NXC.g:224:4: UNSIGNED INT
                    {
                    UNSIGNED53=(Token)match(input,UNSIGNED,FOLLOW_UNSIGNED_in_type_specifier703); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNSIGNED.add(UNSIGNED53);

                    INT54=(Token)match(input,INT,FOLLOW_INT_in_type_specifier705); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT54);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 224:17: -> T_U16
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U16, "T_U16"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // ../grammaire/NXC.g:225:4: LONG
                    {
                    LONG55=(Token)match(input,LONG,FOLLOW_LONG_in_type_specifier714); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LONG.add(LONG55);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 225:9: -> T_S32
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_S32, "T_S32"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // ../grammaire/NXC.g:226:4: UNSIGNED LONG
                    {
                    UNSIGNED56=(Token)match(input,UNSIGNED,FOLLOW_UNSIGNED_in_type_specifier723); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNSIGNED.add(UNSIGNED56);

                    LONG57=(Token)match(input,LONG,FOLLOW_LONG_in_type_specifier725); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LONG.add(LONG57);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 226:18: -> T_U32
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U32, "T_U32"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // ../grammaire/NXC.g:227:4: FLOAT
                    {
                    FLOAT58=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_type_specifier734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(FLOAT58);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 227:10: -> T_FLOAT
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_FLOAT, "T_FLOAT"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 13 :
                    // ../grammaire/NXC.g:228:4: STRING
                    {
                    STRING59=(Token)match(input,STRING,FOLLOW_STRING_in_type_specifier743); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING59);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 228:11: -> T_STRING
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_STRING, "T_STRING"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 14 :
                    // ../grammaire/NXC.g:229:4: MUTEX
                    {
                    MUTEX60=(Token)match(input,MUTEX,FOLLOW_MUTEX_in_type_specifier752); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MUTEX.add(MUTEX60);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 229:10: -> T_MUTEX
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_MUTEX, "T_MUTEX"));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 15 :
                    // ../grammaire/NXC.g:230:4: type_id
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_type_id_in_type_specifier761);
                    type_id61=type_id();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id61.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, type_specifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_specifier"

    public static class type_id_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_id"
    // ../grammaire/NXC.g:233:1: type_id : {...}? IDENTIFIER ->;
    public final NXCParser.type_id_return type_id() throws RecognitionException {
        NXCParser.type_id_return retval = new NXCParser.type_id_return();
        retval.start = input.LT(1);
        int type_id_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER62=null;

        Object IDENTIFIER62_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // ../grammaire/NXC.g:234:5: ({...}? IDENTIFIER ->)
            // ../grammaire/NXC.g:234:9: {...}? IDENTIFIER
            {
            if ( !(( isTypeName(input.LT(1).getText()) )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "type_id", " isTypeName(input.LT(1).getText()) ");
            }
            IDENTIFIER62=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_id779); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER62);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 234:59: ->
            {
                adaptor.addChild(root_0,  translateType((IDENTIFIER62!=null?IDENTIFIER62.getText():null)) );

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, type_id_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_id"

    public static class enum_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enum_declaration"
    // ../grammaire/NXC.g:238:1: enum_declaration : ENUM ( (n= IDENTIFIER -> T_U32 ) )? '{' enum_declaration_list '}' ';' ->;
    public final NXCParser.enum_declaration_return enum_declaration() throws RecognitionException {
        NXCParser.enum_declaration_return retval = new NXCParser.enum_declaration_return();
        retval.start = input.LT(1);
        int enum_declaration_StartIndex = input.index();
        Object root_0 = null;

        Token n=null;
        Token ENUM63=null;
        Token char_literal64=null;
        Token char_literal66=null;
        Token char_literal67=null;
        NXCParser.enum_declaration_list_return enum_declaration_list65 = null;


        Object n_tree=null;
        Object ENUM63_tree=null;
        Object char_literal64_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_ENUM=new RewriteRuleTokenStream(adaptor,"token ENUM");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_enum_declaration_list=new RewriteRuleSubtreeStream(adaptor,"rule enum_declaration_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // ../grammaire/NXC.g:239:5: ( ENUM ( (n= IDENTIFIER -> T_U32 ) )? '{' enum_declaration_list '}' ';' ->)
            // ../grammaire/NXC.g:239:7: ENUM ( (n= IDENTIFIER -> T_U32 ) )? '{' enum_declaration_list '}' ';'
            {
            ENUM63=(Token)match(input,ENUM,FOLLOW_ENUM_in_enum_declaration801); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ENUM.add(ENUM63);

            // ../grammaire/NXC.g:239:12: ( (n= IDENTIFIER -> T_U32 ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../grammaire/NXC.g:239:13: (n= IDENTIFIER -> T_U32 )
                    {
                    // ../grammaire/NXC.g:239:13: (n= IDENTIFIER -> T_U32 )
                    // ../grammaire/NXC.g:239:14: n= IDENTIFIER
                    {
                    n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_declaration807); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(n);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 239:27: -> T_U32
                    {
                        adaptor.addChild(root_0, (Object)adaptor.create(T_U32, "T_U32"));

                    }

                    retval.tree = root_0;}
                    }

                    if ( state.backtracking==0 ) {
                      typeTranslation.put((n!=null?n.getText():null), ((Object)retval.tree));
                    }

                    }
                    break;

            }

            char_literal64=(Token)match(input,124,FOLLOW_124_in_enum_declaration818); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(char_literal64);

            pushFollow(FOLLOW_enum_declaration_list_in_enum_declaration820);
            enum_declaration_list65=enum_declaration_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_enum_declaration_list.add(enum_declaration_list65.getTree());
            char_literal66=(Token)match(input,125,FOLLOW_125_in_enum_declaration822); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal66);

            char_literal67=(Token)match(input,122,FOLLOW_122_in_enum_declaration824); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(char_literal67);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 239:129: ->
            {
                root_0 = null;
            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, enum_declaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "enum_declaration"

    protected static class enum_declaration_list_scope {
        int value;
    }
    protected Stack enum_declaration_list_stack = new Stack();

    public static class enum_declaration_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enum_declaration_list"
    // ../grammaire/NXC.g:242:1: enum_declaration_list : enum_declarator ( ',' enum_declarator )* ;
    public final NXCParser.enum_declaration_list_return enum_declaration_list() throws RecognitionException {
        enum_declaration_list_stack.push(new enum_declaration_list_scope());
        NXCParser.enum_declaration_list_return retval = new NXCParser.enum_declaration_list_return();
        retval.start = input.LT(1);
        int enum_declaration_list_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal69=null;
        NXCParser.enum_declarator_return enum_declarator68 = null;

        NXCParser.enum_declarator_return enum_declarator70 = null;


        Object char_literal69_tree=null;

        ((enum_declaration_list_scope)enum_declaration_list_stack.peek()).value = 0;
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // ../grammaire/NXC.g:245:5: ( enum_declarator ( ',' enum_declarator )* )
            // ../grammaire/NXC.g:245:7: enum_declarator ( ',' enum_declarator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_enum_declarator_in_enum_declaration_list853);
            enum_declarator68=enum_declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_declarator68.getTree());
            // ../grammaire/NXC.g:245:23: ( ',' enum_declarator )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==123) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../grammaire/NXC.g:245:24: ',' enum_declarator
            	    {
            	    char_literal69=(Token)match(input,123,FOLLOW_123_in_enum_declaration_list856); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal69_tree = (Object)adaptor.create(char_literal69);
            	    adaptor.addChild(root_0, char_literal69_tree);
            	    }
            	    pushFollow(FOLLOW_enum_declarator_in_enum_declaration_list858);
            	    enum_declarator70=enum_declarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_declarator70.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, enum_declaration_list_StartIndex); }
            enum_declaration_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "enum_declaration_list"

    public static class enum_declarator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enum_declarator"
    // ../grammaire/NXC.g:248:1: enum_declarator : n= IDENTIFIER ( '=' (v= DECIMAL_LITERAL | v= HEX_LITERAL ) )? ;
    public final NXCParser.enum_declarator_return enum_declarator() throws RecognitionException {
        NXCParser.enum_declarator_return retval = new NXCParser.enum_declarator_return();
        retval.start = input.LT(1);
        int enum_declarator_StartIndex = input.index();
        Object root_0 = null;

        Token n=null;
        Token v=null;
        Token char_literal71=null;

        Object n_tree=null;
        Object v_tree=null;
        Object char_literal71_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // ../grammaire/NXC.g:249:5: (n= IDENTIFIER ( '=' (v= DECIMAL_LITERAL | v= HEX_LITERAL ) )? )
            // ../grammaire/NXC.g:249:7: n= IDENTIFIER ( '=' (v= DECIMAL_LITERAL | v= HEX_LITERAL ) )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_declarator879); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // ../grammaire/NXC.g:249:20: ( '=' (v= DECIMAL_LITERAL | v= HEX_LITERAL ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ASSIGN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../grammaire/NXC.g:249:21: '=' (v= DECIMAL_LITERAL | v= HEX_LITERAL )
                    {
                    char_literal71=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_enum_declarator882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (Object)adaptor.create(char_literal71);
                    adaptor.addChild(root_0, char_literal71_tree);
                    }
                    // ../grammaire/NXC.g:249:25: (v= DECIMAL_LITERAL | v= HEX_LITERAL )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==DECIMAL_LITERAL) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==HEX_LITERAL) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../grammaire/NXC.g:249:26: v= DECIMAL_LITERAL
                            {
                            v=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_enum_declarator887); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            v_tree = (Object)adaptor.create(v);
                            adaptor.addChild(root_0, v_tree);
                            }

                            }
                            break;
                        case 2 :
                            // ../grammaire/NXC.g:249:46: v= HEX_LITERAL
                            {
                            v=(Token)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_enum_declarator893); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            v_tree = (Object)adaptor.create(v);
                            adaptor.addChild(root_0, v_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      ((enum_declaration_list_scope)enum_declaration_list_stack.peek()).value = Integer.decode((v!=null?v.getText():null)).intValue();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              enumValues.put((n!=null?n.getText():null), new Integer(((enum_declaration_list_scope)enum_declaration_list_stack.peek()).value++));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, enum_declarator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "enum_declarator"

    public static class struct_definition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "struct_definition"
    // ../grammaire/NXC.g:253:1: struct_definition options {k=3; } : ( ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' ) -> ^( STRUCT $n struct_declaration_list ) ) ->;
    public final NXCParser.struct_definition_return struct_definition() throws RecognitionException {
        NXCParser.struct_definition_return retval = new NXCParser.struct_definition_return();
        retval.start = input.LT(1);
        int struct_definition_StartIndex = input.index();
        Object root_0 = null;

        Token n=null;
        Token TYPEDEF72=null;
        Token STRUCT73=null;
        Token char_literal74=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token STRUCT78=null;
        Token char_literal79=null;
        Token char_literal81=null;
        Token char_literal82=null;
        NXCParser.struct_declaration_list_return struct_declaration_list75 = null;

        NXCParser.struct_declaration_list_return struct_declaration_list80 = null;


        Object n_tree=null;
        Object TYPEDEF72_tree=null;
        Object STRUCT73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal76_tree=null;
        Object char_literal77_tree=null;
        Object STRUCT78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_STRUCT=new RewriteRuleTokenStream(adaptor,"token STRUCT");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_TYPEDEF=new RewriteRuleTokenStream(adaptor,"token TYPEDEF");
        RewriteRuleSubtreeStream stream_struct_declaration_list=new RewriteRuleSubtreeStream(adaptor,"rule struct_declaration_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // ../grammaire/NXC.g:255:2: ( ( ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' ) -> ^( STRUCT $n struct_declaration_list ) ) ->)
            // ../grammaire/NXC.g:255:4: ( ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' ) -> ^( STRUCT $n struct_declaration_list ) )
            {
            // ../grammaire/NXC.g:255:4: ( ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' ) -> ^( STRUCT $n struct_declaration_list ) )
            // ../grammaire/NXC.g:255:6: ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' )
            {
            // ../grammaire/NXC.g:255:6: ( TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';' | STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==TYPEDEF) ) {
                alt18=1;
            }
            else if ( (LA18_0==STRUCT) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../grammaire/NXC.g:255:7: TYPEDEF STRUCT '{' struct_declaration_list '}' n= IDENTIFIER ';'
                    {
                    TYPEDEF72=(Token)match(input,TYPEDEF,FOLLOW_TYPEDEF_in_struct_definition928); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPEDEF.add(TYPEDEF72);

                    STRUCT73=(Token)match(input,STRUCT,FOLLOW_STRUCT_in_struct_definition930); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRUCT.add(STRUCT73);

                    char_literal74=(Token)match(input,124,FOLLOW_124_in_struct_definition932); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(char_literal74);

                    pushFollow(FOLLOW_struct_declaration_list_in_struct_definition934);
                    struct_declaration_list75=struct_declaration_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_struct_declaration_list.add(struct_declaration_list75.getTree());
                    char_literal76=(Token)match(input,125,FOLLOW_125_in_struct_definition936); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(char_literal76);

                    n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_definition940); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(n);

                    char_literal77=(Token)match(input,122,FOLLOW_122_in_struct_definition942); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal77);


                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:256:5: STRUCT n= IDENTIFIER '{' struct_declaration_list '}' ';'
                    {
                    STRUCT78=(Token)match(input,STRUCT,FOLLOW_STRUCT_in_struct_definition948); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRUCT.add(STRUCT78);

                    n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_definition952); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(n);

                    char_literal79=(Token)match(input,124,FOLLOW_124_in_struct_definition954); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(char_literal79);

                    pushFollow(FOLLOW_struct_declaration_list_in_struct_definition956);
                    struct_declaration_list80=struct_declaration_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_struct_declaration_list.add(struct_declaration_list80.getTree());
                    char_literal81=(Token)match(input,125,FOLLOW_125_in_struct_definition958); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(char_literal81);

                    char_literal82=(Token)match(input,122,FOLLOW_122_in_struct_definition960); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal82);


                    }
                    break;

            }



            // AST REWRITE
            // elements: n, STRUCT, struct_declaration_list
            // token labels: n
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 257:5: -> ^( STRUCT $n struct_declaration_list )
            {
                // ../grammaire/NXC.g:257:8: ^( STRUCT $n struct_declaration_list )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_STRUCT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_n.nextNode());
                adaptor.addChild(root_1, stream_struct_declaration_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            if ( state.backtracking==0 ) {
               typeTranslation.put((n!=null?n.getText():null), ((Object)retval.tree)); 
            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 258:65: ->
            {
                root_0 = null;
            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, struct_definition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "struct_definition"

    public static class struct_declaration_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "struct_declaration_list"
    // ../grammaire/NXC.g:261:1: struct_declaration_list : ( struct_declaration )+ ;
    public final NXCParser.struct_declaration_list_return struct_declaration_list() throws RecognitionException {
        NXCParser.struct_declaration_list_return retval = new NXCParser.struct_declaration_list_return();
        retval.start = input.LT(1);
        int struct_declaration_list_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.struct_declaration_return struct_declaration83 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // ../grammaire/NXC.g:262:2: ( ( struct_declaration )+ )
            // ../grammaire/NXC.g:262:4: ( struct_declaration )+
            {
            root_0 = (Object)adaptor.nil();

            // ../grammaire/NXC.g:262:4: ( struct_declaration )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // ../grammaire/NXC.g:0:0: struct_declaration
            	    {
            	    pushFollow(FOLLOW_struct_declaration_in_struct_declaration_list995);
            	    struct_declaration83=struct_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declaration83.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, struct_declaration_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "struct_declaration_list"

    public static class struct_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "struct_declaration"
    // ../grammaire/NXC.g:265:1: struct_declaration : type= type_specifier struct_declarator_list ';' -> struct_declarator_list ;
    public final NXCParser.struct_declaration_return struct_declaration() throws RecognitionException {
        Type_stack.push(new Type_scope());

        NXCParser.struct_declaration_return retval = new NXCParser.struct_declaration_return();
        retval.start = input.LT(1);
        int struct_declaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal85=null;
        NXCParser.type_specifier_return type = null;

        NXCParser.struct_declarator_list_return struct_declarator_list84 = null;


        Object char_literal85_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleSubtreeStream stream_struct_declarator_list=new RewriteRuleSubtreeStream(adaptor,"rule struct_declarator_list");
        RewriteRuleSubtreeStream stream_type_specifier=new RewriteRuleSubtreeStream(adaptor,"rule type_specifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // ../grammaire/NXC.g:267:2: (type= type_specifier struct_declarator_list ';' -> struct_declarator_list )
            // ../grammaire/NXC.g:267:4: type= type_specifier struct_declarator_list ';'
            {
            pushFollow(FOLLOW_type_specifier_in_struct_declaration1014);
            type=type_specifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type_specifier.add(type.getTree());
            if ( state.backtracking==0 ) {
              ((Type_scope)Type_stack.peek()).type = (type!=null?((Object)type.tree):null);
            }
            pushFollow(FOLLOW_struct_declarator_list_in_struct_declaration1018);
            struct_declarator_list84=struct_declarator_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_struct_declarator_list.add(struct_declarator_list84.getTree());
            char_literal85=(Token)match(input,122,FOLLOW_122_in_struct_declaration1020); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(char_literal85);



            // AST REWRITE
            // elements: struct_declarator_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 267:79: -> struct_declarator_list
            {
                adaptor.addChild(root_0, stream_struct_declarator_list.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, struct_declaration_StartIndex); }
            Type_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "struct_declaration"

    public static class struct_declarator_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "struct_declarator_list"
    // ../grammaire/NXC.g:270:1: struct_declarator_list : (d= declarator -> ^( STRUCT_FIELD $d) ) ( ',' d= declarator -> $struct_declarator_list ^( STRUCT_FIELD $d) )* ;
    public final NXCParser.struct_declarator_list_return struct_declarator_list() throws RecognitionException {
        NXCParser.struct_declarator_list_return retval = new NXCParser.struct_declarator_list_return();
        retval.start = input.LT(1);
        int struct_declarator_list_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal86=null;
        NXCParser.declarator_return d = null;


        Object char_literal86_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_declarator=new RewriteRuleSubtreeStream(adaptor,"rule declarator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // ../grammaire/NXC.g:271:2: ( (d= declarator -> ^( STRUCT_FIELD $d) ) ( ',' d= declarator -> $struct_declarator_list ^( STRUCT_FIELD $d) )* )
            // ../grammaire/NXC.g:271:4: (d= declarator -> ^( STRUCT_FIELD $d) ) ( ',' d= declarator -> $struct_declarator_list ^( STRUCT_FIELD $d) )*
            {
            // ../grammaire/NXC.g:271:4: (d= declarator -> ^( STRUCT_FIELD $d) )
            // ../grammaire/NXC.g:271:5: d= declarator
            {
            pushFollow(FOLLOW_declarator_in_struct_declarator_list1038);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declarator.add(d.getTree());


            // AST REWRITE
            // elements: d
            // token labels: 
            // rule labels: retval, d
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

            root_0 = (Object)adaptor.nil();
            // 271:18: -> ^( STRUCT_FIELD $d)
            {
                // ../grammaire/NXC.g:271:21: ^( STRUCT_FIELD $d)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_FIELD, "STRUCT_FIELD"), root_1);

                adaptor.addChild(root_1, ((Type_scope)Type_stack.peek()).type);
                adaptor.addChild(root_1, stream_d.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:271:55: ( ',' d= declarator -> $struct_declarator_list ^( STRUCT_FIELD $d) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==123) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../grammaire/NXC.g:271:56: ',' d= declarator
            	    {
            	    char_literal86=(Token)match(input,123,FOLLOW_123_in_struct_declarator_list1053); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_123.add(char_literal86);

            	    pushFollow(FOLLOW_declarator_in_struct_declarator_list1057);
            	    d=declarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_declarator.add(d.getTree());


            	    // AST REWRITE
            	    // elements: struct_declarator_list, d
            	    // token labels: 
            	    // rule labels: retval, d
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 271:73: -> $struct_declarator_list ^( STRUCT_FIELD $d)
            	    {
            	        adaptor.addChild(root_0, stream_retval.nextTree());
            	        // ../grammaire/NXC.g:271:100: ^( STRUCT_FIELD $d)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_FIELD, "STRUCT_FIELD"), root_1);

            	        adaptor.addChild(root_1, ((Type_scope)Type_stack.peek()).type);
            	        adaptor.addChild(root_1, stream_d.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, struct_declarator_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "struct_declarator_list"

    public static class declarator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarator"
    // ../grammaire/NXC.g:274:1: declarator : (i= IDENTIFIER -> $i) ( declarator_dimensions -> $declarator declarator_dimensions )* ;
    public final NXCParser.declarator_return declarator() throws RecognitionException {
        NXCParser.declarator_return retval = new NXCParser.declarator_return();
        retval.start = input.LT(1);
        int declarator_StartIndex = input.index();
        Object root_0 = null;

        Token i=null;
        NXCParser.declarator_dimensions_return declarator_dimensions87 = null;


        Object i_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_declarator_dimensions=new RewriteRuleSubtreeStream(adaptor,"rule declarator_dimensions");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // ../grammaire/NXC.g:275:2: ( (i= IDENTIFIER -> $i) ( declarator_dimensions -> $declarator declarator_dimensions )* )
            // ../grammaire/NXC.g:275:4: (i= IDENTIFIER -> $i) ( declarator_dimensions -> $declarator declarator_dimensions )*
            {
            // ../grammaire/NXC.g:275:4: (i= IDENTIFIER -> $i)
            // ../grammaire/NXC.g:275:5: i= IDENTIFIER
            {
            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declarator1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(i);



            // AST REWRITE
            // elements: i
            // token labels: i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 275:18: -> $i
            {
                adaptor.addChild(root_0, stream_i.nextNode());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:275:25: ( declarator_dimensions -> $declarator declarator_dimensions )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==126) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../grammaire/NXC.g:275:26: declarator_dimensions
            	    {
            	    pushFollow(FOLLOW_declarator_dimensions_in_declarator1096);
            	    declarator_dimensions87=declarator_dimensions();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_declarator_dimensions.add(declarator_dimensions87.getTree());


            	    // AST REWRITE
            	    // elements: declarator_dimensions, declarator
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 275:48: -> $declarator declarator_dimensions
            	    {
            	        adaptor.addChild(root_0, stream_retval.nextTree());
            	        adaptor.addChild(root_0, stream_declarator_dimensions.nextTree());

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, declarator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declarator"

    public static class declarator_dimensions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarator_dimensions"
    // ../grammaire/NXC.g:277:1: declarator_dimensions : '[' ( constant )? ']' -> ^( DIMENSION ( constant )? ) ;
    public final NXCParser.declarator_dimensions_return declarator_dimensions() throws RecognitionException {
        NXCParser.declarator_dimensions_return retval = new NXCParser.declarator_dimensions_return();
        retval.start = input.LT(1);
        int declarator_dimensions_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal88=null;
        Token char_literal90=null;
        NXCParser.constant_return constant89 = null;


        Object char_literal88_tree=null;
        Object char_literal90_tree=null;
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // ../grammaire/NXC.g:278:2: ( '[' ( constant )? ']' -> ^( DIMENSION ( constant )? ) )
            // ../grammaire/NXC.g:278:4: '[' ( constant )? ']'
            {
            char_literal88=(Token)match(input,126,FOLLOW_126_in_declarator_dimensions1116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(char_literal88);

            // ../grammaire/NXC.g:278:8: ( constant )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=DECIMAL_LITERAL && LA22_0<=HEX_LITERAL)||(LA22_0>=CHARACTER_LITERAL && LA22_0<=FALSE)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: constant
                    {
                    pushFollow(FOLLOW_constant_in_declarator_dimensions1118);
                    constant89=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_constant.add(constant89.getTree());

                    }
                    break;

            }

            char_literal90=(Token)match(input,127,FOLLOW_127_in_declarator_dimensions1121); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_127.add(char_literal90);



            // AST REWRITE
            // elements: constant
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 278:22: -> ^( DIMENSION ( constant )? )
            {
                // ../grammaire/NXC.g:278:25: ^( DIMENSION ( constant )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIMENSION, "DIMENSION"), root_1);

                // ../grammaire/NXC.g:278:37: ( constant )?
                if ( stream_constant.hasNext() ) {
                    adaptor.addChild(root_1, stream_constant.nextTree());

                }
                stream_constant.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, declarator_dimensions_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declarator_dimensions"

    public static class parameter_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter_list"
    // ../grammaire/NXC.g:281:1: parameter_list : parameter_declaration ( ',' parameter_declaration )* -> ( parameter_declaration )+ ;
    public final NXCParser.parameter_list_return parameter_list() throws RecognitionException {
        NXCParser.parameter_list_return retval = new NXCParser.parameter_list_return();
        retval.start = input.LT(1);
        int parameter_list_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal92=null;
        NXCParser.parameter_declaration_return parameter_declaration91 = null;

        NXCParser.parameter_declaration_return parameter_declaration93 = null;


        Object char_literal92_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_parameter_declaration=new RewriteRuleSubtreeStream(adaptor,"rule parameter_declaration");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // ../grammaire/NXC.g:282:2: ( parameter_declaration ( ',' parameter_declaration )* -> ( parameter_declaration )+ )
            // ../grammaire/NXC.g:282:4: parameter_declaration ( ',' parameter_declaration )*
            {
            pushFollow(FOLLOW_parameter_declaration_in_parameter_list1141);
            parameter_declaration91=parameter_declaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_parameter_declaration.add(parameter_declaration91.getTree());
            // ../grammaire/NXC.g:282:26: ( ',' parameter_declaration )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==123) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../grammaire/NXC.g:282:27: ',' parameter_declaration
            	    {
            	    char_literal92=(Token)match(input,123,FOLLOW_123_in_parameter_list1144); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_123.add(char_literal92);

            	    pushFollow(FOLLOW_parameter_declaration_in_parameter_list1146);
            	    parameter_declaration93=parameter_declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_parameter_declaration.add(parameter_declaration93.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);



            // AST REWRITE
            // elements: parameter_declaration
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 282:55: -> ( parameter_declaration )+
            {
                if ( !(stream_parameter_declaration.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_parameter_declaration.hasNext() ) {
                    adaptor.addChild(root_0, stream_parameter_declaration.nextTree());

                }
                stream_parameter_declaration.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parameter_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parameter_list"

    public static class parameter_declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter_declaration"
    // ../grammaire/NXC.g:285:1: parameter_declaration : declaration_specifiers declarator -> ^( VAR_DECLARATION declaration_specifiers declarator ) ;
    public final NXCParser.parameter_declaration_return parameter_declaration() throws RecognitionException {
        NXCParser.parameter_declaration_return retval = new NXCParser.parameter_declaration_return();
        retval.start = input.LT(1);
        int parameter_declaration_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.declaration_specifiers_return declaration_specifiers94 = null;

        NXCParser.declarator_return declarator95 = null;


        RewriteRuleSubtreeStream stream_declaration_specifiers=new RewriteRuleSubtreeStream(adaptor,"rule declaration_specifiers");
        RewriteRuleSubtreeStream stream_declarator=new RewriteRuleSubtreeStream(adaptor,"rule declarator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // ../grammaire/NXC.g:286:2: ( declaration_specifiers declarator -> ^( VAR_DECLARATION declaration_specifiers declarator ) )
            // ../grammaire/NXC.g:286:4: declaration_specifiers declarator
            {
            pushFollow(FOLLOW_declaration_specifiers_in_parameter_declaration1164);
            declaration_specifiers94=declaration_specifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declaration_specifiers.add(declaration_specifiers94.getTree());
            pushFollow(FOLLOW_declarator_in_parameter_declaration1166);
            declarator95=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declarator.add(declarator95.getTree());


            // AST REWRITE
            // elements: declarator, declaration_specifiers
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 286:38: -> ^( VAR_DECLARATION declaration_specifiers declarator )
            {
                // ../grammaire/NXC.g:286:41: ^( VAR_DECLARATION declaration_specifiers declarator )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);

                adaptor.addChild(root_1, stream_declaration_specifiers.nextTree());
                adaptor.addChild(root_1, stream_declarator.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parameter_declaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parameter_declaration"

    public static class initializer_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initializer"
    // ../grammaire/NXC.g:289:1: initializer : ( assignment_expression | '{' assignment_expression ( ',' assignment_expression )* '}' );
    public final NXCParser.initializer_return initializer() throws RecognitionException {
        NXCParser.initializer_return retval = new NXCParser.initializer_return();
        retval.start = input.LT(1);
        int initializer_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal97=null;
        Token char_literal99=null;
        Token char_literal101=null;
        NXCParser.assignment_expression_return assignment_expression96 = null;

        NXCParser.assignment_expression_return assignment_expression98 = null;

        NXCParser.assignment_expression_return assignment_expression100 = null;


        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        Object char_literal101_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // ../grammaire/NXC.g:290:2: ( assignment_expression | '{' assignment_expression ( ',' assignment_expression )* '}' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENTIFIER||(LA25_0>=DECIMAL_LITERAL && LA25_0<=HEX_LITERAL)||(LA25_0>=CHARACTER_LITERAL && LA25_0<=FALSE)||(LA25_0>=PLUSPLUS && LA25_0<=MINUS)||(LA25_0>=TILDE && LA25_0<=NOT)||LA25_0==120) ) {
                alt25=1;
            }
            else if ( (LA25_0==124) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../grammaire/NXC.g:290:4: assignment_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assignment_expression_in_initializer1188);
                    assignment_expression96=assignment_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression96.getTree());

                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:291:4: '{' assignment_expression ( ',' assignment_expression )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal97=(Token)match(input,124,FOLLOW_124_in_initializer1193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    pushFollow(FOLLOW_assignment_expression_in_initializer1195);
                    assignment_expression98=assignment_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression98.getTree());
                    // ../grammaire/NXC.g:291:30: ( ',' assignment_expression )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==123) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../grammaire/NXC.g:291:31: ',' assignment_expression
                    	    {
                    	    char_literal99=(Token)match(input,123,FOLLOW_123_in_initializer1198); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal99_tree = (Object)adaptor.create(char_literal99);
                    	    adaptor.addChild(root_0, char_literal99_tree);
                    	    }
                    	    pushFollow(FOLLOW_assignment_expression_in_initializer1200);
                    	    assignment_expression100=assignment_expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression100.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    char_literal101=(Token)match(input,125,FOLLOW_125_in_initializer1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                    adaptor.addChild(root_0, char_literal101_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, initializer_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "initializer"

    public static class argument_expression_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument_expression_list"
    // ../grammaire/NXC.g:296:1: argument_expression_list : assignment_expression ( ',' assignment_expression )* -> ( assignment_expression )+ ;
    public final NXCParser.argument_expression_list_return argument_expression_list() throws RecognitionException {
        NXCParser.argument_expression_list_return retval = new NXCParser.argument_expression_list_return();
        retval.start = input.LT(1);
        int argument_expression_list_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal103=null;
        NXCParser.assignment_expression_return assignment_expression102 = null;

        NXCParser.assignment_expression_return assignment_expression104 = null;


        Object char_literal103_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_assignment_expression=new RewriteRuleSubtreeStream(adaptor,"rule assignment_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // ../grammaire/NXC.g:297:2: ( assignment_expression ( ',' assignment_expression )* -> ( assignment_expression )+ )
            // ../grammaire/NXC.g:297:6: assignment_expression ( ',' assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1219);
            assignment_expression102=assignment_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignment_expression.add(assignment_expression102.getTree());
            // ../grammaire/NXC.g:297:28: ( ',' assignment_expression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==123) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../grammaire/NXC.g:297:29: ',' assignment_expression
            	    {
            	    char_literal103=(Token)match(input,123,FOLLOW_123_in_argument_expression_list1222); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_123.add(char_literal103);

            	    pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1224);
            	    assignment_expression104=assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignment_expression.add(assignment_expression104.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);



            // AST REWRITE
            // elements: assignment_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 297:57: -> ( assignment_expression )+
            {
                if ( !(stream_assignment_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignment_expression.hasNext() ) {
                    adaptor.addChild(root_0, stream_assignment_expression.nextTree());

                }
                stream_assignment_expression.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, argument_expression_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argument_expression_list"

    public static class additive_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additive_expression"
    // ../grammaire/NXC.g:300:1: additive_expression : (a= multiplicative_expression -> $a) ( (s= '+' | s= '-' ) b= multiplicative_expression -> ^( $s $additive_expression $b) )* ;
    public final NXCParser.additive_expression_return additive_expression() throws RecognitionException {
        NXCParser.additive_expression_return retval = new NXCParser.additive_expression_return();
        retval.start = input.LT(1);
        int additive_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.multiplicative_expression_return a = null;

        NXCParser.multiplicative_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_multiplicative_expression=new RewriteRuleSubtreeStream(adaptor,"rule multiplicative_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // ../grammaire/NXC.g:301:2: ( (a= multiplicative_expression -> $a) ( (s= '+' | s= '-' ) b= multiplicative_expression -> ^( $s $additive_expression $b) )* )
            // ../grammaire/NXC.g:301:4: (a= multiplicative_expression -> $a) ( (s= '+' | s= '-' ) b= multiplicative_expression -> ^( $s $additive_expression $b) )*
            {
            // ../grammaire/NXC.g:301:4: (a= multiplicative_expression -> $a)
            // ../grammaire/NXC.g:301:5: a= multiplicative_expression
            {
            pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1245);
            a=multiplicative_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_multiplicative_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 301:32: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:301:38: ( (s= '+' | s= '-' ) b= multiplicative_expression -> ^( $s $additive_expression $b) )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // ../grammaire/NXC.g:301:39: (s= '+' | s= '-' ) b= multiplicative_expression
            	    {
            	    // ../grammaire/NXC.g:301:39: (s= '+' | s= '-' )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==PLUS) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==MINUS) ) {
            	        alt27=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../grammaire/NXC.g:301:40: s= '+'
            	            {
            	            s=(Token)match(input,PLUS,FOLLOW_PLUS_in_additive_expression1255); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_PLUS.add(s);


            	            }
            	            break;
            	        case 2 :
            	            // ../grammaire/NXC.g:301:48: s= '-'
            	            {
            	            s=(Token)match(input,MINUS,FOLLOW_MINUS_in_additive_expression1261); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_MINUS.add(s);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1266);
            	    b=multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_multiplicative_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: s, b, additive_expression
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 301:83: -> ^( $s $additive_expression $b)
            	    {
            	        // ../grammaire/NXC.g:301:86: ^( $s $additive_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, additive_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "additive_expression"

    public static class multiplicative_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicative_expression"
    // ../grammaire/NXC.g:304:1: multiplicative_expression : (a= cast_expression -> $a) ( (s= '*' | s= '/' | s= '%' ) b= cast_expression -> ^( $s $multiplicative_expression $b) )* ;
    public final NXCParser.multiplicative_expression_return multiplicative_expression() throws RecognitionException {
        NXCParser.multiplicative_expression_return retval = new NXCParser.multiplicative_expression_return();
        retval.start = input.LT(1);
        int multiplicative_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.cast_expression_return a = null;

        NXCParser.cast_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_MOD=new RewriteRuleTokenStream(adaptor,"token MOD");
        RewriteRuleTokenStream stream_DIVIDE=new RewriteRuleTokenStream(adaptor,"token DIVIDE");
        RewriteRuleSubtreeStream stream_cast_expression=new RewriteRuleSubtreeStream(adaptor,"rule cast_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // ../grammaire/NXC.g:305:2: ( (a= cast_expression -> $a) ( (s= '*' | s= '/' | s= '%' ) b= cast_expression -> ^( $s $multiplicative_expression $b) )* )
            // ../grammaire/NXC.g:305:4: (a= cast_expression -> $a) ( (s= '*' | s= '/' | s= '%' ) b= cast_expression -> ^( $s $multiplicative_expression $b) )*
            {
            // ../grammaire/NXC.g:305:4: (a= cast_expression -> $a)
            // ../grammaire/NXC.g:305:5: a= cast_expression
            {
            pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1295);
            a=cast_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cast_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 305:22: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:305:28: ( (s= '*' | s= '/' | s= '%' ) b= cast_expression -> ^( $s $multiplicative_expression $b) )*
            loop30:
            do {
                int alt30=2;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // ../grammaire/NXC.g:305:29: (s= '*' | s= '/' | s= '%' ) b= cast_expression
            	    {
            	    // ../grammaire/NXC.g:305:29: (s= '*' | s= '/' | s= '%' )
            	    int alt29=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // ../grammaire/NXC.g:305:30: s= '*'
            	            {
            	            s=(Token)match(input,STAR,FOLLOW_STAR_in_multiplicative_expression1305); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_STAR.add(s);


            	            }
            	            break;
            	        case 2 :
            	            // ../grammaire/NXC.g:305:38: s= '/'
            	            {
            	            s=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplicative_expression1311); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_DIVIDE.add(s);


            	            }
            	            break;
            	        case 3 :
            	            // ../grammaire/NXC.g:305:46: s= '%'
            	            {
            	            s=(Token)match(input,MOD,FOLLOW_MOD_in_multiplicative_expression1317); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_MOD.add(s);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1322);
            	    b=cast_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cast_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: multiplicative_expression, b, s
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 305:71: -> ^( $s $multiplicative_expression $b)
            	    {
            	        // ../grammaire/NXC.g:305:74: ^( $s $multiplicative_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, multiplicative_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiplicative_expression"

    public static class cast_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cast_expression"
    // ../grammaire/NXC.g:308:1: cast_expression : ( '(' type_specifier ')' unary_expression -> ^( CAST type_specifier unary_expression ) | unary_expression );
    public final NXCParser.cast_expression_return cast_expression() throws RecognitionException {
        NXCParser.cast_expression_return retval = new NXCParser.cast_expression_return();
        retval.start = input.LT(1);
        int cast_expression_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal105=null;
        Token char_literal107=null;
        NXCParser.type_specifier_return type_specifier106 = null;

        NXCParser.unary_expression_return unary_expression108 = null;

        NXCParser.unary_expression_return unary_expression109 = null;


        Object char_literal105_tree=null;
        Object char_literal107_tree=null;
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleSubtreeStream stream_unary_expression=new RewriteRuleSubtreeStream(adaptor,"rule unary_expression");
        RewriteRuleSubtreeStream stream_type_specifier=new RewriteRuleSubtreeStream(adaptor,"rule type_specifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // ../grammaire/NXC.g:309:2: ( '(' type_specifier ')' unary_expression -> ^( CAST type_specifier unary_expression ) | unary_expression )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // ../grammaire/NXC.g:309:4: '(' type_specifier ')' unary_expression
                    {
                    char_literal105=(Token)match(input,120,FOLLOW_120_in_cast_expression1348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal105);

                    pushFollow(FOLLOW_type_specifier_in_cast_expression1350);
                    type_specifier106=type_specifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_specifier.add(type_specifier106.getTree());
                    char_literal107=(Token)match(input,121,FOLLOW_121_in_cast_expression1352); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal107);

                    pushFollow(FOLLOW_unary_expression_in_cast_expression1354);
                    unary_expression108=unary_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary_expression.add(unary_expression108.getTree());


                    // AST REWRITE
                    // elements: unary_expression, type_specifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 309:44: -> ^( CAST type_specifier unary_expression )
                    {
                        // ../grammaire/NXC.g:309:47: ^( CAST type_specifier unary_expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CAST, "CAST"), root_1);

                        adaptor.addChild(root_1, stream_type_specifier.nextTree());
                        adaptor.addChild(root_1, stream_unary_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:310:4: unary_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unary_expression_in_cast_expression1369);
                    unary_expression109=unary_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression109.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, cast_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "cast_expression"

    public static class unary_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary_expression"
    // ../grammaire/NXC.g:313:1: unary_expression : ( postfix_expression | unary_operator cast_expression -> ^( unary_operator cast_expression ) );
    public final NXCParser.unary_expression_return unary_expression() throws RecognitionException {
        NXCParser.unary_expression_return retval = new NXCParser.unary_expression_return();
        retval.start = input.LT(1);
        int unary_expression_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.postfix_expression_return postfix_expression110 = null;

        NXCParser.unary_operator_return unary_operator111 = null;

        NXCParser.cast_expression_return cast_expression112 = null;


        RewriteRuleSubtreeStream stream_cast_expression=new RewriteRuleSubtreeStream(adaptor,"rule cast_expression");
        RewriteRuleSubtreeStream stream_unary_operator=new RewriteRuleSubtreeStream(adaptor,"rule unary_operator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // ../grammaire/NXC.g:314:2: ( postfix_expression | unary_operator cast_expression -> ^( unary_operator cast_expression ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDENTIFIER||(LA32_0>=DECIMAL_LITERAL && LA32_0<=HEX_LITERAL)||(LA32_0>=CHARACTER_LITERAL && LA32_0<=FALSE)||LA32_0==PLUSPLUS||LA32_0==MINUSMINUS||LA32_0==120) ) {
                alt32=1;
            }
            else if ( (LA32_0==PLUS||LA32_0==MINUS||(LA32_0>=TILDE && LA32_0<=NOT)) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../grammaire/NXC.g:314:4: postfix_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfix_expression_in_unary_expression1380);
                    postfix_expression110=postfix_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfix_expression110.getTree());

                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:315:4: unary_operator cast_expression
                    {
                    pushFollow(FOLLOW_unary_operator_in_unary_expression1385);
                    unary_operator111=unary_operator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary_operator.add(unary_operator111.getTree());
                    pushFollow(FOLLOW_cast_expression_in_unary_expression1387);
                    cast_expression112=cast_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cast_expression.add(cast_expression112.getTree());


                    // AST REWRITE
                    // elements: unary_operator, cast_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 315:35: -> ^( unary_operator cast_expression )
                    {
                        // ../grammaire/NXC.g:315:38: ^( unary_operator cast_expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_unary_operator.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_cast_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, unary_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unary_expression"

    public static class postfix_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfix_expression"
    // ../grammaire/NXC.g:318:1: postfix_expression : (a= primary_expression -> $a) ( (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) ) | ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) ) )* ;
    public final NXCParser.postfix_expression_return postfix_expression() throws RecognitionException {
        NXCParser.postfix_expression_return retval = new NXCParser.postfix_expression_return();
        retval.start = input.LT(1);
        int postfix_expression_StartIndex = input.index();
        Object root_0 = null;

        Token l=null;
        Token i=null;
        Token char_literal114=null;
        Token char_literal115=null;
        NXCParser.primary_expression_return a = null;

        NXCParser.expression_return expression113 = null;


        Object l_tree=null;
        Object i_tree=null;
        Object char_literal114_tree=null;
        Object char_literal115_tree=null;
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_primary_expression=new RewriteRuleSubtreeStream(adaptor,"rule primary_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // ../grammaire/NXC.g:319:2: ( (a= primary_expression -> $a) ( (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) ) | ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) ) )* )
            // ../grammaire/NXC.g:319:4: (a= primary_expression -> $a) ( (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) ) | ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) ) )*
            {
            // ../grammaire/NXC.g:319:4: (a= primary_expression -> $a)
            // ../grammaire/NXC.g:319:5: a= primary_expression
            {
            pushFollow(FOLLOW_primary_expression_in_postfix_expression1409);
            a=primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primary_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 319:25: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:320:3: ( (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) ) | ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) ) )*
            loop33:
            do {
                int alt33=3;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../grammaire/NXC.g:320:5: (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) )
            	    {
            	    // ../grammaire/NXC.g:320:5: (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) )
            	    // ../grammaire/NXC.g:320:6: l= '[' expression ']'
            	    {
            	    l=(Token)match(input,126,FOLLOW_126_in_postfix_expression1422); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_126.add(l);

            	    pushFollow(FOLLOW_expression_in_postfix_expression1424);
            	    expression113=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expression.add(expression113.getTree());
            	    char_literal114=(Token)match(input,127,FOLLOW_127_in_postfix_expression1426); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_127.add(char_literal114);



            	    // AST REWRITE
            	    // elements: expression, postfix_expression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 320:27: -> ^( DIMENSION_ACCESS $postfix_expression expression )
            	    {
            	        // ../grammaire/NXC.g:320:30: ^( DIMENSION_ACCESS $postfix_expression expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIMENSION_ACCESS, "DIMENSION_ACCESS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_expression.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../grammaire/NXC.g:321:7: ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) )
            	    {
            	    // ../grammaire/NXC.g:321:7: ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) )
            	    // ../grammaire/NXC.g:321:8: '.' i= IDENTIFIER
            	    {
            	    char_literal115=(Token)match(input,128,FOLLOW_128_in_postfix_expression1447); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_128.add(char_literal115);

            	    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfix_expression1451); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENTIFIER.add(i);



            	    // AST REWRITE
            	    // elements: postfix_expression, i
            	    // token labels: i
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 321:25: -> ^( FIELD_ACCESS $postfix_expression $i)
            	    {
            	        // ../grammaire/NXC.g:321:28: ^( FIELD_ACCESS $postfix_expression $i)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIELD_ACCESS, "FIELD_ACCESS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_i.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, postfix_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "postfix_expression"

    public static class unary_operator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary_operator"
    // ../grammaire/NXC.g:325:1: unary_operator : ( '+' | '-' | '~' | '!' );
    public final NXCParser.unary_operator_return unary_operator() throws RecognitionException {
        NXCParser.unary_operator_return retval = new NXCParser.unary_operator_return();
        retval.start = input.LT(1);
        int unary_operator_StartIndex = input.index();
        Object root_0 = null;

        Token set116=null;

        Object set116_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // ../grammaire/NXC.g:326:2: ( '+' | '-' | '~' | '!' )
            // ../grammaire/NXC.g:
            {
            root_0 = (Object)adaptor.nil();

            set116=(Token)input.LT(1);
            if ( input.LA(1)==PLUS||input.LA(1)==MINUS||(input.LA(1)>=TILDE && input.LA(1)<=NOT) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set116));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, unary_operator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unary_operator"

    public static class primary_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary_expression"
    // ../grammaire/NXC.g:332:1: primary_expression : ( (s= '++' | s= '--' ) IDENTIFIER -> ^( PRE $s IDENTIFIER ) | (a= IDENTIFIER -> $a) ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )? | IDENTIFIER '(' ( argument_expression_list )? ')' -> ^( FUNC_CALL IDENTIFIER ^( ARGUMENTS ( argument_expression_list )? ) ) | constant | '(' assignment_expression ')' -> assignment_expression );
    public final NXCParser.primary_expression_return primary_expression() throws RecognitionException {
        NXCParser.primary_expression_return retval = new NXCParser.primary_expression_return();
        retval.start = input.LT(1);
        int primary_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        Token a=null;
        Token IDENTIFIER117=null;
        Token IDENTIFIER118=null;
        Token char_literal119=null;
        Token char_literal121=null;
        Token char_literal123=null;
        Token char_literal125=null;
        NXCParser.argument_expression_list_return argument_expression_list120 = null;

        NXCParser.constant_return constant122 = null;

        NXCParser.assignment_expression_return assignment_expression124 = null;


        Object s_tree=null;
        Object a_tree=null;
        Object IDENTIFIER117_tree=null;
        Object IDENTIFIER118_tree=null;
        Object char_literal119_tree=null;
        Object char_literal121_tree=null;
        Object char_literal123_tree=null;
        Object char_literal125_tree=null;
        RewriteRuleTokenStream stream_MINUSMINUS=new RewriteRuleTokenStream(adaptor,"token MINUSMINUS");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_PLUSPLUS=new RewriteRuleTokenStream(adaptor,"token PLUSPLUS");
        RewriteRuleSubtreeStream stream_assignment_expression=new RewriteRuleSubtreeStream(adaptor,"rule assignment_expression");
        RewriteRuleSubtreeStream stream_argument_expression_list=new RewriteRuleSubtreeStream(adaptor,"rule argument_expression_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // ../grammaire/NXC.g:333:2: ( (s= '++' | s= '--' ) IDENTIFIER -> ^( PRE $s IDENTIFIER ) | (a= IDENTIFIER -> $a) ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )? | IDENTIFIER '(' ( argument_expression_list )? ')' -> ^( FUNC_CALL IDENTIFIER ^( ARGUMENTS ( argument_expression_list )? ) ) | constant | '(' assignment_expression ')' -> assignment_expression )
            int alt38=5;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../grammaire/NXC.g:333:4: (s= '++' | s= '--' ) IDENTIFIER
                    {
                    // ../grammaire/NXC.g:333:4: (s= '++' | s= '--' )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==PLUSPLUS) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==MINUSMINUS) ) {
                        alt34=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../grammaire/NXC.g:333:5: s= '++'
                            {
                            s=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_primary_expression1509); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PLUSPLUS.add(s);


                            }
                            break;
                        case 2 :
                            // ../grammaire/NXC.g:333:14: s= '--'
                            {
                            s=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_primary_expression1515); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MINUSMINUS.add(s);


                            }
                            break;

                    }

                    IDENTIFIER117=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression1518); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER117);



                    // AST REWRITE
                    // elements: IDENTIFIER, s
                    // token labels: s
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 333:33: -> ^( PRE $s IDENTIFIER )
                    {
                        // ../grammaire/NXC.g:333:36: ^( PRE $s IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRE, "PRE"), root_1);

                        adaptor.addChild(root_1, stream_s.nextNode());
                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:334:4: (a= IDENTIFIER -> $a) ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )?
                    {
                    // ../grammaire/NXC.g:334:4: (a= IDENTIFIER -> $a)
                    // ../grammaire/NXC.g:334:5: a= IDENTIFIER
                    {
                    a=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression1537); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(a);



                    // AST REWRITE
                    // elements: a
                    // token labels: a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 334:18: -> $a
                    {
                        adaptor.addChild(root_0, stream_a.nextNode());

                    }

                    retval.tree = root_0;}
                    }

                    // ../grammaire/NXC.g:334:25: ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )?
                    int alt36=2;
                    alt36 = dfa36.predict(input);
                    switch (alt36) {
                        case 1 :
                            // ../grammaire/NXC.g:334:26: (s= '++' | s= '--' )
                            {
                            // ../grammaire/NXC.g:334:26: (s= '++' | s= '--' )
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==PLUSPLUS) ) {
                                alt35=1;
                            }
                            else if ( (LA35_0==MINUSMINUS) ) {
                                alt35=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 35, 0, input);

                                throw nvae;
                            }
                            switch (alt35) {
                                case 1 :
                                    // ../grammaire/NXC.g:334:27: s= '++'
                                    {
                                    s=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_primary_expression1549); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_PLUSPLUS.add(s);


                                    }
                                    break;
                                case 2 :
                                    // ../grammaire/NXC.g:334:36: s= '--'
                                    {
                                    s=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_primary_expression1555); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_MINUSMINUS.add(s);


                                    }
                                    break;

                            }



                            // AST REWRITE
                            // elements: primary_expression, s
                            // token labels: s
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 334:44: -> ^( POST $s $primary_expression)
                            {
                                // ../grammaire/NXC.g:334:47: ^( POST $s $primary_expression)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(POST, "POST"), root_1);

                                adaptor.addChild(root_1, stream_s.nextNode());
                                adaptor.addChild(root_1, stream_retval.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:335:4: IDENTIFIER '(' ( argument_expression_list )? ')'
                    {
                    IDENTIFIER118=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression1575); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER118);

                    char_literal119=(Token)match(input,120,FOLLOW_120_in_primary_expression1577); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal119);

                    // ../grammaire/NXC.g:335:19: ( argument_expression_list )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==IDENTIFIER||(LA37_0>=DECIMAL_LITERAL && LA37_0<=HEX_LITERAL)||(LA37_0>=CHARACTER_LITERAL && LA37_0<=FALSE)||(LA37_0>=PLUSPLUS && LA37_0<=MINUS)||(LA37_0>=TILDE && LA37_0<=NOT)||LA37_0==120) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: argument_expression_list
                            {
                            pushFollow(FOLLOW_argument_expression_list_in_primary_expression1579);
                            argument_expression_list120=argument_expression_list();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_argument_expression_list.add(argument_expression_list120.getTree());

                            }
                            break;

                    }

                    char_literal121=(Token)match(input,121,FOLLOW_121_in_primary_expression1582); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal121);



                    // AST REWRITE
                    // elements: argument_expression_list, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 335:49: -> ^( FUNC_CALL IDENTIFIER ^( ARGUMENTS ( argument_expression_list )? ) )
                    {
                        // ../grammaire/NXC.g:335:52: ^( FUNC_CALL IDENTIFIER ^( ARGUMENTS ( argument_expression_list )? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC_CALL, "FUNC_CALL"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // ../grammaire/NXC.g:335:75: ^( ARGUMENTS ( argument_expression_list )? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGUMENTS, "ARGUMENTS"), root_2);

                        // ../grammaire/NXC.g:335:87: ( argument_expression_list )?
                        if ( stream_argument_expression_list.hasNext() ) {
                            adaptor.addChild(root_2, stream_argument_expression_list.nextTree());

                        }
                        stream_argument_expression_list.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:336:4: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_primary_expression1602);
                    constant122=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant122.getTree());

                    }
                    break;
                case 5 :
                    // ../grammaire/NXC.g:337:4: '(' assignment_expression ')'
                    {
                    char_literal123=(Token)match(input,120,FOLLOW_120_in_primary_expression1607); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal123);

                    pushFollow(FOLLOW_assignment_expression_in_primary_expression1609);
                    assignment_expression124=assignment_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignment_expression.add(assignment_expression124.getTree());
                    char_literal125=(Token)match(input,121,FOLLOW_121_in_primary_expression1611); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal125);



                    // AST REWRITE
                    // elements: assignment_expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 337:34: -> assignment_expression
                    {
                        adaptor.addChild(root_0, stream_assignment_expression.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, primary_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primary_expression"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // ../grammaire/NXC.g:340:1: constant : ( HEX_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOAT_LITERAL | TRUE | FALSE );
    public final NXCParser.constant_return constant() throws RecognitionException {
        NXCParser.constant_return retval = new NXCParser.constant_return();
        retval.start = input.LT(1);
        int constant_StartIndex = input.index();
        Object root_0 = null;

        Token set126=null;

        Object set126_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // ../grammaire/NXC.g:341:5: ( HEX_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOAT_LITERAL | TRUE | FALSE )
            // ../grammaire/NXC.g:
            {
            root_0 = (Object)adaptor.nil();

            set126=(Token)input.LT(1);
            if ( (input.LA(1)>=DECIMAL_LITERAL && input.LA(1)<=HEX_LITERAL)||(input.LA(1)>=CHARACTER_LITERAL && input.LA(1)<=FALSE) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set126));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, constant_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // ../grammaire/NXC.g:351:1: expression : assignment_expression ( ',' assignment_expression )* -> ( assignment_expression )+ ;
    public final NXCParser.expression_return expression() throws RecognitionException {
        NXCParser.expression_return retval = new NXCParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal128=null;
        NXCParser.assignment_expression_return assignment_expression127 = null;

        NXCParser.assignment_expression_return assignment_expression129 = null;


        Object char_literal128_tree=null;
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_assignment_expression=new RewriteRuleSubtreeStream(adaptor,"rule assignment_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // ../grammaire/NXC.g:352:2: ( assignment_expression ( ',' assignment_expression )* -> ( assignment_expression )+ )
            // ../grammaire/NXC.g:352:4: assignment_expression ( ',' assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_expression1697);
            assignment_expression127=assignment_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignment_expression.add(assignment_expression127.getTree());
            // ../grammaire/NXC.g:352:26: ( ',' assignment_expression )*
            loop39:
            do {
                int alt39=2;
                alt39 = dfa39.predict(input);
                switch (alt39) {
            	case 1 :
            	    // ../grammaire/NXC.g:352:27: ',' assignment_expression
            	    {
            	    char_literal128=(Token)match(input,123,FOLLOW_123_in_expression1700); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_123.add(char_literal128);

            	    pushFollow(FOLLOW_assignment_expression_in_expression1702);
            	    assignment_expression129=assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignment_expression.add(assignment_expression129.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);



            // AST REWRITE
            // elements: assignment_expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 352:55: -> ( assignment_expression )+
            {
                if ( !(stream_assignment_expression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignment_expression.hasNext() ) {
                    adaptor.addChild(root_0, stream_assignment_expression.nextTree());

                }
                stream_assignment_expression.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class assignment_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment_expression"
    // ../grammaire/NXC.g:355:1: assignment_expression : (a= postfix_expression s= assignment_operator b= assignment_expression -> ^( $s $a $b) | conditional_expression );
    public final NXCParser.assignment_expression_return assignment_expression() throws RecognitionException {
        NXCParser.assignment_expression_return retval = new NXCParser.assignment_expression_return();
        retval.start = input.LT(1);
        int assignment_expression_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.postfix_expression_return a = null;

        NXCParser.assignment_operator_return s = null;

        NXCParser.assignment_expression_return b = null;

        NXCParser.conditional_expression_return conditional_expression130 = null;


        RewriteRuleSubtreeStream stream_postfix_expression=new RewriteRuleSubtreeStream(adaptor,"rule postfix_expression");
        RewriteRuleSubtreeStream stream_assignment_operator=new RewriteRuleSubtreeStream(adaptor,"rule assignment_operator");
        RewriteRuleSubtreeStream stream_assignment_expression=new RewriteRuleSubtreeStream(adaptor,"rule assignment_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // ../grammaire/NXC.g:356:2: (a= postfix_expression s= assignment_operator b= assignment_expression -> ^( $s $a $b) | conditional_expression )
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // ../grammaire/NXC.g:356:4: a= postfix_expression s= assignment_operator b= assignment_expression
                    {
                    pushFollow(FOLLOW_postfix_expression_in_assignment_expression1722);
                    a=postfix_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_postfix_expression.add(a.getTree());
                    pushFollow(FOLLOW_assignment_operator_in_assignment_expression1726);
                    s=assignment_operator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignment_operator.add(s.getTree());
                    pushFollow(FOLLOW_assignment_expression_in_assignment_expression1730);
                    b=assignment_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignment_expression.add(b.getTree());


                    // AST REWRITE
                    // elements: b, s, a
                    // token labels: 
                    // rule labels: retval, s, b, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 356:71: -> ^( $s $a $b)
                    {
                        // ../grammaire/NXC.g:356:74: ^( $s $a $b)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_a.nextTree());
                        adaptor.addChild(root_1, stream_b.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:357:4: conditional_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_conditional_expression_in_assignment_expression1748);
                    conditional_expression130=conditional_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional_expression130.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, assignment_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignment_expression"

    public static class assignment_operator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment_operator"
    // ../grammaire/NXC.g:360:1: assignment_operator : ( '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '<<=' | '>>=' | '&=' | '|=' | '^=' );
    public final NXCParser.assignment_operator_return assignment_operator() throws RecognitionException {
        NXCParser.assignment_operator_return retval = new NXCParser.assignment_operator_return();
        retval.start = input.LT(1);
        int assignment_operator_StartIndex = input.index();
        Object root_0 = null;

        Token set131=null;

        Object set131_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // ../grammaire/NXC.g:361:2: ( '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '<<=' | '>>=' | '&=' | '|=' | '^=' )
            // ../grammaire/NXC.g:
            {
            root_0 = (Object)adaptor.nil();

            set131=(Token)input.LT(1);
            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=XORASSIGN) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set131));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, assignment_operator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignment_operator"

    public static class conditional_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditional_expression"
    // ../grammaire/NXC.g:374:1: conditional_expression : (a= logical_or_expression -> $a) ( '?' b= expression ':' c= expression -> ^( TERNARY $conditional_expression $b $c) )? ;
    public final NXCParser.conditional_expression_return conditional_expression() throws RecognitionException {
        NXCParser.conditional_expression_return retval = new NXCParser.conditional_expression_return();
        retval.start = input.LT(1);
        int conditional_expression_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal132=null;
        Token char_literal133=null;
        NXCParser.logical_or_expression_return a = null;

        NXCParser.expression_return b = null;

        NXCParser.expression_return c = null;


        Object char_literal132_tree=null;
        Object char_literal133_tree=null;
        RewriteRuleTokenStream stream_129=new RewriteRuleTokenStream(adaptor,"token 129");
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_logical_or_expression=new RewriteRuleSubtreeStream(adaptor,"rule logical_or_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // ../grammaire/NXC.g:375:2: ( (a= logical_or_expression -> $a) ( '?' b= expression ':' c= expression -> ^( TERNARY $conditional_expression $b $c) )? )
            // ../grammaire/NXC.g:375:4: (a= logical_or_expression -> $a) ( '?' b= expression ':' c= expression -> ^( TERNARY $conditional_expression $b $c) )?
            {
            // ../grammaire/NXC.g:375:4: (a= logical_or_expression -> $a)
            // ../grammaire/NXC.g:375:5: a= logical_or_expression
            {
            pushFollow(FOLLOW_logical_or_expression_in_conditional_expression1823);
            a=logical_or_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logical_or_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 375:28: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:375:34: ( '?' b= expression ':' c= expression -> ^( TERNARY $conditional_expression $b $c) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==129) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../grammaire/NXC.g:375:35: '?' b= expression ':' c= expression
                    {
                    char_literal132=(Token)match(input,129,FOLLOW_129_in_conditional_expression1830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_129.add(char_literal132);

                    pushFollow(FOLLOW_expression_in_conditional_expression1834);
                    b=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(b.getTree());
                    char_literal133=(Token)match(input,130,FOLLOW_130_in_conditional_expression1836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_130.add(char_literal133);

                    pushFollow(FOLLOW_expression_in_conditional_expression1840);
                    c=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(c.getTree());


                    // AST REWRITE
                    // elements: b, c, conditional_expression
                    // token labels: 
                    // rule labels: retval, b, c
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 375:69: -> ^( TERNARY $conditional_expression $b $c)
                    {
                        // ../grammaire/NXC.g:375:72: ^( TERNARY $conditional_expression $b $c)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TERNARY, "TERNARY"), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());
                        adaptor.addChild(root_1, stream_b.nextTree());
                        adaptor.addChild(root_1, stream_c.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, conditional_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "conditional_expression"

    public static class logical_or_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logical_or_expression"
    // ../grammaire/NXC.g:378:1: logical_or_expression : (a= logical_and_expression -> $a) (s= '||' b= logical_and_expression -> ^( $s $logical_or_expression $b) )* ;
    public final NXCParser.logical_or_expression_return logical_or_expression() throws RecognitionException {
        NXCParser.logical_or_expression_return retval = new NXCParser.logical_or_expression_return();
        retval.start = input.LT(1);
        int logical_or_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.logical_and_expression_return a = null;

        NXCParser.logical_and_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_OROR=new RewriteRuleTokenStream(adaptor,"token OROR");
        RewriteRuleSubtreeStream stream_logical_and_expression=new RewriteRuleSubtreeStream(adaptor,"rule logical_and_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // ../grammaire/NXC.g:379:2: ( (a= logical_and_expression -> $a) (s= '||' b= logical_and_expression -> ^( $s $logical_or_expression $b) )* )
            // ../grammaire/NXC.g:379:4: (a= logical_and_expression -> $a) (s= '||' b= logical_and_expression -> ^( $s $logical_or_expression $b) )*
            {
            // ../grammaire/NXC.g:379:4: (a= logical_and_expression -> $a)
            // ../grammaire/NXC.g:379:5: a= logical_and_expression
            {
            pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1872);
            a=logical_and_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logical_and_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 379:29: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:379:35: (s= '||' b= logical_and_expression -> ^( $s $logical_or_expression $b) )*
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // ../grammaire/NXC.g:379:36: s= '||' b= logical_and_expression
            	    {
            	    s=(Token)match(input,OROR,FOLLOW_OROR_in_logical_or_expression1881); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OROR.add(s);

            	    pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1885);
            	    b=logical_and_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logical_and_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: b, logical_or_expression, s
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 379:68: -> ^( $s $logical_or_expression $b)
            	    {
            	        // ../grammaire/NXC.g:379:71: ^( $s $logical_or_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, logical_or_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logical_or_expression"

    public static class logical_and_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logical_and_expression"
    // ../grammaire/NXC.g:382:1: logical_and_expression : (a= inclusive_or_expression -> $a) (s= '&&' b= inclusive_or_expression -> ^( $s $logical_and_expression $b) )* ;
    public final NXCParser.logical_and_expression_return logical_and_expression() throws RecognitionException {
        NXCParser.logical_and_expression_return retval = new NXCParser.logical_and_expression_return();
        retval.start = input.LT(1);
        int logical_and_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.inclusive_or_expression_return a = null;

        NXCParser.inclusive_or_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_ANDAND=new RewriteRuleTokenStream(adaptor,"token ANDAND");
        RewriteRuleSubtreeStream stream_inclusive_or_expression=new RewriteRuleSubtreeStream(adaptor,"rule inclusive_or_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // ../grammaire/NXC.g:383:2: ( (a= inclusive_or_expression -> $a) (s= '&&' b= inclusive_or_expression -> ^( $s $logical_and_expression $b) )* )
            // ../grammaire/NXC.g:383:4: (a= inclusive_or_expression -> $a) (s= '&&' b= inclusive_or_expression -> ^( $s $logical_and_expression $b) )*
            {
            // ../grammaire/NXC.g:383:4: (a= inclusive_or_expression -> $a)
            // ../grammaire/NXC.g:383:5: a= inclusive_or_expression
            {
            pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1914);
            a=inclusive_or_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_inclusive_or_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 383:30: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:383:36: (s= '&&' b= inclusive_or_expression -> ^( $s $logical_and_expression $b) )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // ../grammaire/NXC.g:383:37: s= '&&' b= inclusive_or_expression
            	    {
            	    s=(Token)match(input,ANDAND,FOLLOW_ANDAND_in_logical_and_expression1923); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ANDAND.add(s);

            	    pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1927);
            	    b=inclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_inclusive_or_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: s, logical_and_expression, b
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 383:70: -> ^( $s $logical_and_expression $b)
            	    {
            	        // ../grammaire/NXC.g:383:73: ^( $s $logical_and_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, logical_and_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logical_and_expression"

    public static class inclusive_or_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inclusive_or_expression"
    // ../grammaire/NXC.g:386:1: inclusive_or_expression : (a= exclusive_or_expression -> $a) (s= '|' b= exclusive_or_expression -> ^( $s $inclusive_or_expression $b) )* ;
    public final NXCParser.inclusive_or_expression_return inclusive_or_expression() throws RecognitionException {
        NXCParser.inclusive_or_expression_return retval = new NXCParser.inclusive_or_expression_return();
        retval.start = input.LT(1);
        int inclusive_or_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.exclusive_or_expression_return a = null;

        NXCParser.exclusive_or_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_exclusive_or_expression=new RewriteRuleSubtreeStream(adaptor,"rule exclusive_or_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // ../grammaire/NXC.g:387:2: ( (a= exclusive_or_expression -> $a) (s= '|' b= exclusive_or_expression -> ^( $s $inclusive_or_expression $b) )* )
            // ../grammaire/NXC.g:387:4: (a= exclusive_or_expression -> $a) (s= '|' b= exclusive_or_expression -> ^( $s $inclusive_or_expression $b) )*
            {
            // ../grammaire/NXC.g:387:4: (a= exclusive_or_expression -> $a)
            // ../grammaire/NXC.g:387:5: a= exclusive_or_expression
            {
            pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1956);
            a=exclusive_or_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_exclusive_or_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 387:30: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:387:36: (s= '|' b= exclusive_or_expression -> ^( $s $inclusive_or_expression $b) )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // ../grammaire/NXC.g:387:37: s= '|' b= exclusive_or_expression
            	    {
            	    s=(Token)match(input,OR,FOLLOW_OR_in_inclusive_or_expression1965); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR.add(s);

            	    pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1969);
            	    b=exclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_exclusive_or_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: s, inclusive_or_expression, b
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 387:69: -> ^( $s $inclusive_or_expression $b)
            	    {
            	        // ../grammaire/NXC.g:387:72: ^( $s $inclusive_or_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, inclusive_or_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "inclusive_or_expression"

    public static class exclusive_or_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exclusive_or_expression"
    // ../grammaire/NXC.g:390:1: exclusive_or_expression : (a= and_expression -> $a) (s= '^' b= and_expression -> ^( $s $exclusive_or_expression $b) )* ;
    public final NXCParser.exclusive_or_expression_return exclusive_or_expression() throws RecognitionException {
        NXCParser.exclusive_or_expression_return retval = new NXCParser.exclusive_or_expression_return();
        retval.start = input.LT(1);
        int exclusive_or_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.and_expression_return a = null;

        NXCParser.and_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_XOR=new RewriteRuleTokenStream(adaptor,"token XOR");
        RewriteRuleSubtreeStream stream_and_expression=new RewriteRuleSubtreeStream(adaptor,"rule and_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // ../grammaire/NXC.g:391:2: ( (a= and_expression -> $a) (s= '^' b= and_expression -> ^( $s $exclusive_or_expression $b) )* )
            // ../grammaire/NXC.g:391:4: (a= and_expression -> $a) (s= '^' b= and_expression -> ^( $s $exclusive_or_expression $b) )*
            {
            // ../grammaire/NXC.g:391:4: (a= and_expression -> $a)
            // ../grammaire/NXC.g:391:5: a= and_expression
            {
            pushFollow(FOLLOW_and_expression_in_exclusive_or_expression1998);
            a=and_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_and_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 391:21: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:391:27: (s= '^' b= and_expression -> ^( $s $exclusive_or_expression $b) )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // ../grammaire/NXC.g:391:28: s= '^' b= and_expression
            	    {
            	    s=(Token)match(input,XOR,FOLLOW_XOR_in_exclusive_or_expression2007); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_XOR.add(s);

            	    pushFollow(FOLLOW_and_expression_in_exclusive_or_expression2011);
            	    b=and_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_and_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: b, exclusive_or_expression, s
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 391:51: -> ^( $s $exclusive_or_expression $b)
            	    {
            	        // ../grammaire/NXC.g:391:54: ^( $s $exclusive_or_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, exclusive_or_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exclusive_or_expression"

    public static class and_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and_expression"
    // ../grammaire/NXC.g:394:1: and_expression : (a= equality_expression -> $a) (s= '&' b= equality_expression -> ^( $s $and_expression $b) )* ;
    public final NXCParser.and_expression_return and_expression() throws RecognitionException {
        NXCParser.and_expression_return retval = new NXCParser.and_expression_return();
        retval.start = input.LT(1);
        int and_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.equality_expression_return a = null;

        NXCParser.equality_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_equality_expression=new RewriteRuleSubtreeStream(adaptor,"rule equality_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // ../grammaire/NXC.g:395:2: ( (a= equality_expression -> $a) (s= '&' b= equality_expression -> ^( $s $and_expression $b) )* )
            // ../grammaire/NXC.g:395:4: (a= equality_expression -> $a) (s= '&' b= equality_expression -> ^( $s $and_expression $b) )*
            {
            // ../grammaire/NXC.g:395:4: (a= equality_expression -> $a)
            // ../grammaire/NXC.g:395:5: a= equality_expression
            {
            pushFollow(FOLLOW_equality_expression_in_and_expression2040);
            a=equality_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_equality_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 395:26: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:395:32: (s= '&' b= equality_expression -> ^( $s $and_expression $b) )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // ../grammaire/NXC.g:395:33: s= '&' b= equality_expression
            	    {
            	    s=(Token)match(input,AND,FOLLOW_AND_in_and_expression2049); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(s);

            	    pushFollow(FOLLOW_equality_expression_in_and_expression2053);
            	    b=equality_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_equality_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: s, b, and_expression
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 395:61: -> ^( $s $and_expression $b)
            	    {
            	        // ../grammaire/NXC.g:395:64: ^( $s $and_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, and_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "and_expression"

    public static class equality_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equality_expression"
    // ../grammaire/NXC.g:398:1: equality_expression : (a= relational_expression -> $a) ( (s= '==' | s= '!=' ) b= relational_expression -> ^( $s $equality_expression $b) )* ;
    public final NXCParser.equality_expression_return equality_expression() throws RecognitionException {
        NXCParser.equality_expression_return retval = new NXCParser.equality_expression_return();
        retval.start = input.LT(1);
        int equality_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.relational_expression_return a = null;

        NXCParser.relational_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleTokenStream stream_NOTEQUAL=new RewriteRuleTokenStream(adaptor,"token NOTEQUAL");
        RewriteRuleSubtreeStream stream_relational_expression=new RewriteRuleSubtreeStream(adaptor,"rule relational_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // ../grammaire/NXC.g:399:2: ( (a= relational_expression -> $a) ( (s= '==' | s= '!=' ) b= relational_expression -> ^( $s $equality_expression $b) )* )
            // ../grammaire/NXC.g:399:4: (a= relational_expression -> $a) ( (s= '==' | s= '!=' ) b= relational_expression -> ^( $s $equality_expression $b) )*
            {
            // ../grammaire/NXC.g:399:4: (a= relational_expression -> $a)
            // ../grammaire/NXC.g:399:5: a= relational_expression
            {
            pushFollow(FOLLOW_relational_expression_in_equality_expression2083);
            a=relational_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_relational_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 399:28: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:399:34: ( (s= '==' | s= '!=' ) b= relational_expression -> ^( $s $equality_expression $b) )*
            loop48:
            do {
                int alt48=2;
                alt48 = dfa48.predict(input);
                switch (alt48) {
            	case 1 :
            	    // ../grammaire/NXC.g:399:35: (s= '==' | s= '!=' ) b= relational_expression
            	    {
            	    // ../grammaire/NXC.g:399:35: (s= '==' | s= '!=' )
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==EQUAL) ) {
            	        alt47=1;
            	    }
            	    else if ( (LA47_0==NOTEQUAL) ) {
            	        alt47=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // ../grammaire/NXC.g:399:36: s= '=='
            	            {
            	            s=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_equality_expression2093); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_EQUAL.add(s);


            	            }
            	            break;
            	        case 2 :
            	            // ../grammaire/NXC.g:399:45: s= '!='
            	            {
            	            s=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_equality_expression2099); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_NOTEQUAL.add(s);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relational_expression_in_equality_expression2104);
            	    b=relational_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_relational_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: equality_expression, b, s
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 399:77: -> ^( $s $equality_expression $b)
            	    {
            	        // ../grammaire/NXC.g:399:80: ^( $s $equality_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, equality_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "equality_expression"

    public static class relational_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relational_expression"
    // ../grammaire/NXC.g:402:1: relational_expression : (a= shift_expression -> $a) ( (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression -> ^( $s $relational_expression $b) )* ;
    public final NXCParser.relational_expression_return relational_expression() throws RecognitionException {
        NXCParser.relational_expression_return retval = new NXCParser.relational_expression_return();
        retval.start = input.LT(1);
        int relational_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.shift_expression_return a = null;

        NXCParser.shift_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_LESSTHAN=new RewriteRuleTokenStream(adaptor,"token LESSTHAN");
        RewriteRuleTokenStream stream_GREATEREQUAL=new RewriteRuleTokenStream(adaptor,"token GREATEREQUAL");
        RewriteRuleTokenStream stream_LESSEQUAL=new RewriteRuleTokenStream(adaptor,"token LESSEQUAL");
        RewriteRuleTokenStream stream_GREATERTHAN=new RewriteRuleTokenStream(adaptor,"token GREATERTHAN");
        RewriteRuleSubtreeStream stream_shift_expression=new RewriteRuleSubtreeStream(adaptor,"rule shift_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // ../grammaire/NXC.g:403:2: ( (a= shift_expression -> $a) ( (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression -> ^( $s $relational_expression $b) )* )
            // ../grammaire/NXC.g:403:4: (a= shift_expression -> $a) ( (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression -> ^( $s $relational_expression $b) )*
            {
            // ../grammaire/NXC.g:403:4: (a= shift_expression -> $a)
            // ../grammaire/NXC.g:403:5: a= shift_expression
            {
            pushFollow(FOLLOW_shift_expression_in_relational_expression2133);
            a=shift_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_shift_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 403:23: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:403:29: ( (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression -> ^( $s $relational_expression $b) )*
            loop50:
            do {
                int alt50=2;
                alt50 = dfa50.predict(input);
                switch (alt50) {
            	case 1 :
            	    // ../grammaire/NXC.g:403:30: (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression
            	    {
            	    // ../grammaire/NXC.g:403:30: (s= '<' | s= '>' | s= '<=' | s= '>=' )
            	    int alt49=4;
            	    switch ( input.LA(1) ) {
            	    case LESSTHAN:
            	        {
            	        alt49=1;
            	        }
            	        break;
            	    case GREATERTHAN:
            	        {
            	        alt49=2;
            	        }
            	        break;
            	    case LESSEQUAL:
            	        {
            	        alt49=3;
            	        }
            	        break;
            	    case GREATEREQUAL:
            	        {
            	        alt49=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt49) {
            	        case 1 :
            	            // ../grammaire/NXC.g:403:31: s= '<'
            	            {
            	            s=(Token)match(input,LESSTHAN,FOLLOW_LESSTHAN_in_relational_expression2143); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_LESSTHAN.add(s);


            	            }
            	            break;
            	        case 2 :
            	            // ../grammaire/NXC.g:403:39: s= '>'
            	            {
            	            s=(Token)match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_relational_expression2149); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_GREATERTHAN.add(s);


            	            }
            	            break;
            	        case 3 :
            	            // ../grammaire/NXC.g:403:47: s= '<='
            	            {
            	            s=(Token)match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_relational_expression2155); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_LESSEQUAL.add(s);


            	            }
            	            break;
            	        case 4 :
            	            // ../grammaire/NXC.g:403:56: s= '>='
            	            {
            	            s=(Token)match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_relational_expression2161); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_GREATEREQUAL.add(s);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_shift_expression_in_relational_expression2166);
            	    b=shift_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_shift_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: s, relational_expression, b
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 403:83: -> ^( $s $relational_expression $b)
            	    {
            	        // ../grammaire/NXC.g:403:86: ^( $s $relational_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, relational_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "relational_expression"

    public static class shift_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shift_expression"
    // ../grammaire/NXC.g:406:1: shift_expression : (a= additive_expression -> $a) ( (s= '<<' | s= '>>' ) b= additive_expression -> ^( $s $shift_expression $b) )* ;
    public final NXCParser.shift_expression_return shift_expression() throws RecognitionException {
        NXCParser.shift_expression_return retval = new NXCParser.shift_expression_return();
        retval.start = input.LT(1);
        int shift_expression_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        NXCParser.additive_expression_return a = null;

        NXCParser.additive_expression_return b = null;


        Object s_tree=null;
        RewriteRuleTokenStream stream_RSHIFT=new RewriteRuleTokenStream(adaptor,"token RSHIFT");
        RewriteRuleTokenStream stream_LSHIFT=new RewriteRuleTokenStream(adaptor,"token LSHIFT");
        RewriteRuleSubtreeStream stream_additive_expression=new RewriteRuleSubtreeStream(adaptor,"rule additive_expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // ../grammaire/NXC.g:407:2: ( (a= additive_expression -> $a) ( (s= '<<' | s= '>>' ) b= additive_expression -> ^( $s $shift_expression $b) )* )
            // ../grammaire/NXC.g:407:4: (a= additive_expression -> $a) ( (s= '<<' | s= '>>' ) b= additive_expression -> ^( $s $shift_expression $b) )*
            {
            // ../grammaire/NXC.g:407:4: (a= additive_expression -> $a)
            // ../grammaire/NXC.g:407:5: a= additive_expression
            {
            pushFollow(FOLLOW_additive_expression_in_shift_expression2195);
            a=additive_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_additive_expression.add(a.getTree());


            // AST REWRITE
            // elements: a
            // token labels: 
            // rule labels: retval, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (Object)adaptor.nil();
            // 407:26: -> $a
            {
                adaptor.addChild(root_0, stream_a.nextTree());

            }

            retval.tree = root_0;}
            }

            // ../grammaire/NXC.g:407:32: ( (s= '<<' | s= '>>' ) b= additive_expression -> ^( $s $shift_expression $b) )*
            loop52:
            do {
                int alt52=2;
                alt52 = dfa52.predict(input);
                switch (alt52) {
            	case 1 :
            	    // ../grammaire/NXC.g:407:33: (s= '<<' | s= '>>' ) b= additive_expression
            	    {
            	    // ../grammaire/NXC.g:407:33: (s= '<<' | s= '>>' )
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==LSHIFT) ) {
            	        alt51=1;
            	    }
            	    else if ( (LA51_0==RSHIFT) ) {
            	        alt51=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // ../grammaire/NXC.g:407:34: s= '<<'
            	            {
            	            s=(Token)match(input,LSHIFT,FOLLOW_LSHIFT_in_shift_expression2205); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_LSHIFT.add(s);


            	            }
            	            break;
            	        case 2 :
            	            // ../grammaire/NXC.g:407:43: s= '>>'
            	            {
            	            s=(Token)match(input,RSHIFT,FOLLOW_RSHIFT_in_shift_expression2211); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_RSHIFT.add(s);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_additive_expression_in_shift_expression2216);
            	    b=additive_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_additive_expression.add(b.getTree());


            	    // AST REWRITE
            	    // elements: shift_expression, s, b
            	    // token labels: s
            	    // rule labels: retval, b
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 407:73: -> ^( $s $shift_expression $b)
            	    {
            	        // ../grammaire/NXC.g:407:76: ^( $s $shift_expression $b)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_b.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, shift_expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "shift_expression"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // ../grammaire/NXC.g:412:1: statement : ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement | task_statement | declaration );
    public final NXCParser.statement_return statement() throws RecognitionException {
        NXCParser.statement_return retval = new NXCParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.labeled_statement_return labeled_statement134 = null;

        NXCParser.compound_statement_return compound_statement135 = null;

        NXCParser.expression_statement_return expression_statement136 = null;

        NXCParser.selection_statement_return selection_statement137 = null;

        NXCParser.iteration_statement_return iteration_statement138 = null;

        NXCParser.jump_statement_return jump_statement139 = null;

        NXCParser.task_statement_return task_statement140 = null;

        NXCParser.declaration_return declaration141 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // ../grammaire/NXC.g:413:2: ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement | task_statement | declaration )
            int alt53=8;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../grammaire/NXC.g:413:4: labeled_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_labeled_statement_in_statement2244);
                    labeled_statement134=labeled_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, labeled_statement134.getTree());

                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:414:4: compound_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_compound_statement_in_statement2249);
                    compound_statement135=compound_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_statement135.getTree());

                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:415:4: expression_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_statement_in_statement2254);
                    expression_statement136=expression_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_statement136.getTree());

                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:416:4: selection_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selection_statement_in_statement2259);
                    selection_statement137=selection_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selection_statement137.getTree());

                    }
                    break;
                case 5 :
                    // ../grammaire/NXC.g:417:4: iteration_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_iteration_statement_in_statement2264);
                    iteration_statement138=iteration_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, iteration_statement138.getTree());

                    }
                    break;
                case 6 :
                    // ../grammaire/NXC.g:418:4: jump_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_jump_statement_in_statement2269);
                    jump_statement139=jump_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, jump_statement139.getTree());

                    }
                    break;
                case 7 :
                    // ../grammaire/NXC.g:419:4: task_statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_task_statement_in_statement2274);
                    task_statement140=task_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, task_statement140.getTree());

                    }
                    break;
                case 8 :
                    // ../grammaire/NXC.g:420:4: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement2279);
                    declaration141=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration141.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class labeled_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "labeled_statement"
    // ../grammaire/NXC.g:423:1: labeled_statement : IDENTIFIER ':' statement -> ^( LABEL IDENTIFIER statement ) ;
    public final NXCParser.labeled_statement_return labeled_statement() throws RecognitionException {
        NXCParser.labeled_statement_return retval = new NXCParser.labeled_statement_return();
        retval.start = input.LT(1);
        int labeled_statement_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER142=null;
        Token char_literal143=null;
        NXCParser.statement_return statement144 = null;


        Object IDENTIFIER142_tree=null;
        Object char_literal143_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // ../grammaire/NXC.g:424:2: ( IDENTIFIER ':' statement -> ^( LABEL IDENTIFIER statement ) )
            // ../grammaire/NXC.g:424:4: IDENTIFIER ':' statement
            {
            IDENTIFIER142=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_labeled_statement2290); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER142);

            char_literal143=(Token)match(input,130,FOLLOW_130_in_labeled_statement2292); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_130.add(char_literal143);

            pushFollow(FOLLOW_statement_in_labeled_statement2294);
            statement144=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement144.getTree());


            // AST REWRITE
            // elements: statement, IDENTIFIER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 424:29: -> ^( LABEL IDENTIFIER statement )
            {
                // ../grammaire/NXC.g:424:32: ^( LABEL IDENTIFIER statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LABEL, "LABEL"), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, labeled_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "labeled_statement"

    public static class compound_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compound_statement"
    // ../grammaire/NXC.g:427:1: compound_statement : '{' ( statement_list )? '}' -> ^( STATEMENTS ( statement_list )? ) ;
    public final NXCParser.compound_statement_return compound_statement() throws RecognitionException {
        NXCParser.compound_statement_return retval = new NXCParser.compound_statement_return();
        retval.start = input.LT(1);
        int compound_statement_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal145=null;
        Token char_literal147=null;
        NXCParser.statement_list_return statement_list146 = null;


        Object char_literal145_tree=null;
        Object char_literal147_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // ../grammaire/NXC.g:428:2: ( '{' ( statement_list )? '}' -> ^( STATEMENTS ( statement_list )? ) )
            // ../grammaire/NXC.g:428:4: '{' ( statement_list )? '}'
            {
            char_literal145=(Token)match(input,124,FOLLOW_124_in_compound_statement2315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_124.add(char_literal145);

            // ../grammaire/NXC.g:428:8: ( statement_list )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // ../grammaire/NXC.g:0:0: statement_list
                    {
                    pushFollow(FOLLOW_statement_list_in_compound_statement2317);
                    statement_list146=statement_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement_list.add(statement_list146.getTree());

                    }
                    break;

            }

            char_literal147=(Token)match(input,125,FOLLOW_125_in_compound_statement2320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal147);



            // AST REWRITE
            // elements: statement_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 428:28: -> ^( STATEMENTS ( statement_list )? )
            {
                // ../grammaire/NXC.g:428:31: ^( STATEMENTS ( statement_list )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_1);

                // ../grammaire/NXC.g:428:44: ( statement_list )?
                if ( stream_statement_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement_list.nextTree());

                }
                stream_statement_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, compound_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compound_statement"

    public static class statement_list_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement_list"
    // ../grammaire/NXC.g:431:1: statement_list : ( statement )+ ;
    public final NXCParser.statement_list_return statement_list() throws RecognitionException {
        NXCParser.statement_list_return retval = new NXCParser.statement_list_return();
        retval.start = input.LT(1);
        int statement_list_StartIndex = input.index();
        Object root_0 = null;

        NXCParser.statement_return statement148 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // ../grammaire/NXC.g:432:2: ( ( statement )+ )
            // ../grammaire/NXC.g:432:4: ( statement )+
            {
            root_0 = (Object)adaptor.nil();

            // ../grammaire/NXC.g:432:4: ( statement )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                alt55 = dfa55.predict(input);
                switch (alt55) {
            	case 1 :
            	    // ../grammaire/NXC.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list2340);
            	    statement148=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement148.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, statement_list_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "statement_list"

    public static class expression_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression_statement"
    // ../grammaire/NXC.g:435:1: expression_statement : ( ';' -> ^( TRUE ) | expression ';' -> expression );
    public final NXCParser.expression_statement_return expression_statement() throws RecognitionException {
        NXCParser.expression_statement_return retval = new NXCParser.expression_statement_return();
        retval.start = input.LT(1);
        int expression_statement_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal149=null;
        Token char_literal151=null;
        NXCParser.expression_return expression150 = null;


        Object char_literal149_tree=null;
        Object char_literal151_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // ../grammaire/NXC.g:436:2: ( ';' -> ^( TRUE ) | expression ';' -> expression )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==122) ) {
                alt56=1;
            }
            else if ( (LA56_0==IDENTIFIER||(LA56_0>=DECIMAL_LITERAL && LA56_0<=HEX_LITERAL)||(LA56_0>=CHARACTER_LITERAL && LA56_0<=FALSE)||(LA56_0>=PLUSPLUS && LA56_0<=MINUS)||(LA56_0>=TILDE && LA56_0<=NOT)||LA56_0==120) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../grammaire/NXC.g:436:4: ';'
                    {
                    char_literal149=(Token)match(input,122,FOLLOW_122_in_expression_statement2352); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal149);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 436:8: -> ^( TRUE )
                    {
                        // ../grammaire/NXC.g:436:11: ^( TRUE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TRUE, "TRUE"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:437:4: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_expression_statement2363);
                    expression150=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression150.getTree());
                    char_literal151=(Token)match(input,122,FOLLOW_122_in_expression_statement2365); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal151);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 437:19: -> expression
                    {
                        adaptor.addChild(root_0, stream_expression.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, expression_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression_statement"

    public static class selection_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selection_statement"
    // ../grammaire/NXC.g:440:1: selection_statement : ( IF '(' expression ')' statement ( selection_else )? -> ^( IF expression statement ( selection_else )? ) | SWITCH '(' expression ')' '{' ( selection_case )+ ( selection_default )? '}' -> ^( SWITCH expression ( selection_case )+ ( selection_default )? ) );
    public final NXCParser.selection_statement_return selection_statement() throws RecognitionException {
        NXCParser.selection_statement_return retval = new NXCParser.selection_statement_return();
        retval.start = input.LT(1);
        int selection_statement_StartIndex = input.index();
        Object root_0 = null;

        Token IF152=null;
        Token char_literal153=null;
        Token char_literal155=null;
        Token SWITCH158=null;
        Token char_literal159=null;
        Token char_literal161=null;
        Token char_literal162=null;
        Token char_literal165=null;
        NXCParser.expression_return expression154 = null;

        NXCParser.statement_return statement156 = null;

        NXCParser.selection_else_return selection_else157 = null;

        NXCParser.expression_return expression160 = null;

        NXCParser.selection_case_return selection_case163 = null;

        NXCParser.selection_default_return selection_default164 = null;


        Object IF152_tree=null;
        Object char_literal153_tree=null;
        Object char_literal155_tree=null;
        Object SWITCH158_tree=null;
        Object char_literal159_tree=null;
        Object char_literal161_tree=null;
        Object char_literal162_tree=null;
        Object char_literal165_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_selection_else=new RewriteRuleSubtreeStream(adaptor,"rule selection_else");
        RewriteRuleSubtreeStream stream_selection_case=new RewriteRuleSubtreeStream(adaptor,"rule selection_case");
        RewriteRuleSubtreeStream stream_selection_default=new RewriteRuleSubtreeStream(adaptor,"rule selection_default");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // ../grammaire/NXC.g:441:2: ( IF '(' expression ')' statement ( selection_else )? -> ^( IF expression statement ( selection_else )? ) | SWITCH '(' expression ')' '{' ( selection_case )+ ( selection_default )? '}' -> ^( SWITCH expression ( selection_case )+ ( selection_default )? ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IF) ) {
                alt60=1;
            }
            else if ( (LA60_0==SWITCH) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../grammaire/NXC.g:441:4: IF '(' expression ')' statement ( selection_else )?
                    {
                    IF152=(Token)match(input,IF,FOLLOW_IF_in_selection_statement2380); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF152);

                    char_literal153=(Token)match(input,120,FOLLOW_120_in_selection_statement2382); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal153);

                    pushFollow(FOLLOW_expression_in_selection_statement2384);
                    expression154=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression154.getTree());
                    char_literal155=(Token)match(input,121,FOLLOW_121_in_selection_statement2386); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal155);

                    pushFollow(FOLLOW_statement_in_selection_statement2388);
                    statement156=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement156.getTree());
                    // ../grammaire/NXC.g:441:36: ( selection_else )?
                    int alt57=2;
                    alt57 = dfa57.predict(input);
                    switch (alt57) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: selection_else
                            {
                            pushFollow(FOLLOW_selection_else_in_selection_statement2390);
                            selection_else157=selection_else();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_selection_else.add(selection_else157.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: selection_else, IF, expression, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 441:52: -> ^( IF expression statement ( selection_else )? )
                    {
                        // ../grammaire/NXC.g:441:55: ^( IF expression statement ( selection_else )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());
                        // ../grammaire/NXC.g:441:81: ( selection_else )?
                        if ( stream_selection_else.hasNext() ) {
                            adaptor.addChild(root_1, stream_selection_else.nextTree());

                        }
                        stream_selection_else.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:442:4: SWITCH '(' expression ')' '{' ( selection_case )+ ( selection_default )? '}'
                    {
                    SWITCH158=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_selection_statement2409); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SWITCH.add(SWITCH158);

                    char_literal159=(Token)match(input,120,FOLLOW_120_in_selection_statement2411); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal159);

                    pushFollow(FOLLOW_expression_in_selection_statement2413);
                    expression160=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression160.getTree());
                    char_literal161=(Token)match(input,121,FOLLOW_121_in_selection_statement2415); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal161);

                    char_literal162=(Token)match(input,124,FOLLOW_124_in_selection_statement2417); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_124.add(char_literal162);

                    // ../grammaire/NXC.g:442:34: ( selection_case )+
                    int cnt58=0;
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==CASE) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../grammaire/NXC.g:0:0: selection_case
                    	    {
                    	    pushFollow(FOLLOW_selection_case_in_selection_statement2419);
                    	    selection_case163=selection_case();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_selection_case.add(selection_case163.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt58 >= 1 ) break loop58;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(58, input);
                                throw eee;
                        }
                        cnt58++;
                    } while (true);

                    // ../grammaire/NXC.g:442:50: ( selection_default )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==DEFAULT) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: selection_default
                            {
                            pushFollow(FOLLOW_selection_default_in_selection_statement2422);
                            selection_default164=selection_default();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_selection_default.add(selection_default164.getTree());

                            }
                            break;

                    }

                    char_literal165=(Token)match(input,125,FOLLOW_125_in_selection_statement2425); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(char_literal165);



                    // AST REWRITE
                    // elements: selection_case, expression, SWITCH, selection_default
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 442:73: -> ^( SWITCH expression ( selection_case )+ ( selection_default )? )
                    {
                        // ../grammaire/NXC.g:442:76: ^( SWITCH expression ( selection_case )+ ( selection_default )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_SWITCH.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        if ( !(stream_selection_case.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_selection_case.hasNext() ) {
                            adaptor.addChild(root_1, stream_selection_case.nextTree());

                        }
                        stream_selection_case.reset();
                        // ../grammaire/NXC.g:442:112: ( selection_default )?
                        if ( stream_selection_default.hasNext() ) {
                            adaptor.addChild(root_1, stream_selection_default.nextTree());

                        }
                        stream_selection_default.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, selection_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "selection_statement"

    public static class selection_else_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selection_else"
    // ../grammaire/NXC.g:445:1: selection_else : ( options {k=1; backtrack=false; } : ELSE statement ) -> ^( ELSE statement ) ;
    public final NXCParser.selection_else_return selection_else() throws RecognitionException {
        NXCParser.selection_else_return retval = new NXCParser.selection_else_return();
        retval.start = input.LT(1);
        int selection_else_StartIndex = input.index();
        Object root_0 = null;

        Token ELSE166=null;
        NXCParser.statement_return statement167 = null;


        Object ELSE166_tree=null;
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // ../grammaire/NXC.g:446:2: ( ( options {k=1; backtrack=false; } : ELSE statement ) -> ^( ELSE statement ) )
            // ../grammaire/NXC.g:446:4: ( options {k=1; backtrack=false; } : ELSE statement )
            {
            // ../grammaire/NXC.g:446:4: ( options {k=1; backtrack=false; } : ELSE statement )
            // ../grammaire/NXC.g:446:37: ELSE statement
            {
            ELSE166=(Token)match(input,ELSE,FOLLOW_ELSE_in_selection_else2464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE.add(ELSE166);

            pushFollow(FOLLOW_statement_in_selection_else2466);
            statement167=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement167.getTree());

            }



            // AST REWRITE
            // elements: statement, ELSE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 446:53: -> ^( ELSE statement )
            {
                // ../grammaire/NXC.g:446:56: ^( ELSE statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_ELSE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, selection_else_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "selection_else"

    public static class selection_case_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selection_case"
    // ../grammaire/NXC.g:449:1: selection_case : CASE constant ':' statement_list -> ^( CASE constant ^( STATEMENTS statement_list ) ) ;
    public final NXCParser.selection_case_return selection_case() throws RecognitionException {
        NXCParser.selection_case_return retval = new NXCParser.selection_case_return();
        retval.start = input.LT(1);
        int selection_case_StartIndex = input.index();
        Object root_0 = null;

        Token CASE168=null;
        Token char_literal170=null;
        NXCParser.constant_return constant169 = null;

        NXCParser.statement_list_return statement_list171 = null;


        Object CASE168_tree=null;
        Object char_literal170_tree=null;
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // ../grammaire/NXC.g:450:2: ( CASE constant ':' statement_list -> ^( CASE constant ^( STATEMENTS statement_list ) ) )
            // ../grammaire/NXC.g:450:4: CASE constant ':' statement_list
            {
            CASE168=(Token)match(input,CASE,FOLLOW_CASE_in_selection_case2486); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CASE.add(CASE168);

            pushFollow(FOLLOW_constant_in_selection_case2488);
            constant169=constant();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_constant.add(constant169.getTree());
            char_literal170=(Token)match(input,130,FOLLOW_130_in_selection_case2490); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_130.add(char_literal170);

            pushFollow(FOLLOW_statement_list_in_selection_case2492);
            statement_list171=statement_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement_list.add(statement_list171.getTree());


            // AST REWRITE
            // elements: CASE, statement_list, constant
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 450:37: -> ^( CASE constant ^( STATEMENTS statement_list ) )
            {
                // ../grammaire/NXC.g:450:40: ^( CASE constant ^( STATEMENTS statement_list ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_CASE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_constant.nextTree());
                // ../grammaire/NXC.g:450:56: ^( STATEMENTS statement_list )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_2);

                adaptor.addChild(root_2, stream_statement_list.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, selection_case_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "selection_case"

    public static class selection_default_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selection_default"
    // ../grammaire/NXC.g:453:1: selection_default : DEFAULT ':' statement_list -> ^( DEFAULT ^( STATEMENTS statement_list ) ) ;
    public final NXCParser.selection_default_return selection_default() throws RecognitionException {
        NXCParser.selection_default_return retval = new NXCParser.selection_default_return();
        retval.start = input.LT(1);
        int selection_default_StartIndex = input.index();
        Object root_0 = null;

        Token DEFAULT172=null;
        Token char_literal173=null;
        NXCParser.statement_list_return statement_list174 = null;


        Object DEFAULT172_tree=null;
        Object char_literal173_tree=null;
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");
        RewriteRuleTokenStream stream_DEFAULT=new RewriteRuleTokenStream(adaptor,"token DEFAULT");
        RewriteRuleSubtreeStream stream_statement_list=new RewriteRuleSubtreeStream(adaptor,"rule statement_list");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // ../grammaire/NXC.g:454:2: ( DEFAULT ':' statement_list -> ^( DEFAULT ^( STATEMENTS statement_list ) ) )
            // ../grammaire/NXC.g:454:4: DEFAULT ':' statement_list
            {
            DEFAULT172=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_selection_default2518); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEFAULT.add(DEFAULT172);

            char_literal173=(Token)match(input,130,FOLLOW_130_in_selection_default2520); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_130.add(char_literal173);

            pushFollow(FOLLOW_statement_list_in_selection_default2522);
            statement_list174=statement_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement_list.add(statement_list174.getTree());


            // AST REWRITE
            // elements: statement_list, DEFAULT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 454:31: -> ^( DEFAULT ^( STATEMENTS statement_list ) )
            {
                // ../grammaire/NXC.g:454:34: ^( DEFAULT ^( STATEMENTS statement_list ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_DEFAULT.nextNode(), root_1);

                // ../grammaire/NXC.g:454:44: ^( STATEMENTS statement_list )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(STATEMENTS, "STATEMENTS"), root_2);

                adaptor.addChild(root_2, stream_statement_list.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, selection_default_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "selection_default"

    public static class iteration_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iteration_statement"
    // ../grammaire/NXC.g:457:1: iteration_statement : ( (type= WHILE | type= UNTIL | type= REPEAT ) '(' expression ')' statement -> ^( $type expression statement ) | DO statement (type= WHILE | type= UNTIL ) '(' expression ')' ';' -> ^( DO $type expression statement ) | FOR '(' a= expression_statement b= expression_statement (c= expression )? ')' statement -> ^( FOR ^( DO $a) ^( WHILE $b) ^( REPEAT $c) statement ) );
    public final NXCParser.iteration_statement_return iteration_statement() throws RecognitionException {
        NXCParser.iteration_statement_return retval = new NXCParser.iteration_statement_return();
        retval.start = input.LT(1);
        int iteration_statement_StartIndex = input.index();
        Object root_0 = null;

        Token type=null;
        Token char_literal175=null;
        Token char_literal177=null;
        Token DO179=null;
        Token char_literal181=null;
        Token char_literal183=null;
        Token char_literal184=null;
        Token FOR185=null;
        Token char_literal186=null;
        Token char_literal187=null;
        NXCParser.expression_statement_return a = null;

        NXCParser.expression_statement_return b = null;

        NXCParser.expression_return c = null;

        NXCParser.expression_return expression176 = null;

        NXCParser.statement_return statement178 = null;

        NXCParser.statement_return statement180 = null;

        NXCParser.expression_return expression182 = null;

        NXCParser.statement_return statement188 = null;


        Object type_tree=null;
        Object char_literal175_tree=null;
        Object char_literal177_tree=null;
        Object DO179_tree=null;
        Object char_literal181_tree=null;
        Object char_literal183_tree=null;
        Object char_literal184_tree=null;
        Object FOR185_tree=null;
        Object char_literal186_tree=null;
        Object char_literal187_tree=null;
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_121=new RewriteRuleTokenStream(adaptor,"token 121");
        RewriteRuleTokenStream stream_REPEAT=new RewriteRuleTokenStream(adaptor,"token REPEAT");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_UNTIL=new RewriteRuleTokenStream(adaptor,"token UNTIL");
        RewriteRuleTokenStream stream_120=new RewriteRuleTokenStream(adaptor,"token 120");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expression_statement=new RewriteRuleSubtreeStream(adaptor,"rule expression_statement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // ../grammaire/NXC.g:458:2: ( (type= WHILE | type= UNTIL | type= REPEAT ) '(' expression ')' statement -> ^( $type expression statement ) | DO statement (type= WHILE | type= UNTIL ) '(' expression ')' ';' -> ^( DO $type expression statement ) | FOR '(' a= expression_statement b= expression_statement (c= expression )? ')' statement -> ^( FOR ^( DO $a) ^( WHILE $b) ^( REPEAT $c) statement ) )
            int alt64=3;
            switch ( input.LA(1) ) {
            case WHILE:
            case UNTIL:
            case REPEAT:
                {
                alt64=1;
                }
                break;
            case DO:
                {
                alt64=2;
                }
                break;
            case FOR:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../grammaire/NXC.g:458:4: (type= WHILE | type= UNTIL | type= REPEAT ) '(' expression ')' statement
                    {
                    // ../grammaire/NXC.g:458:4: (type= WHILE | type= UNTIL | type= REPEAT )
                    int alt61=3;
                    switch ( input.LA(1) ) {
                    case WHILE:
                        {
                        alt61=1;
                        }
                        break;
                    case UNTIL:
                        {
                        alt61=2;
                        }
                        break;
                    case REPEAT:
                        {
                        alt61=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }

                    switch (alt61) {
                        case 1 :
                            // ../grammaire/NXC.g:458:5: type= WHILE
                            {
                            type=(Token)match(input,WHILE,FOLLOW_WHILE_in_iteration_statement2548); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WHILE.add(type);


                            }
                            break;
                        case 2 :
                            // ../grammaire/NXC.g:458:18: type= UNTIL
                            {
                            type=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_iteration_statement2554); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_UNTIL.add(type);


                            }
                            break;
                        case 3 :
                            // ../grammaire/NXC.g:458:31: type= REPEAT
                            {
                            type=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_iteration_statement2560); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_REPEAT.add(type);


                            }
                            break;

                    }

                    char_literal175=(Token)match(input,120,FOLLOW_120_in_iteration_statement2563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal175);

                    pushFollow(FOLLOW_expression_in_iteration_statement2565);
                    expression176=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression176.getTree());
                    char_literal177=(Token)match(input,121,FOLLOW_121_in_iteration_statement2567); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal177);

                    pushFollow(FOLLOW_statement_in_iteration_statement2569);
                    statement178=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement178.getTree());


                    // AST REWRITE
                    // elements: statement, type, expression
                    // token labels: type
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 458:73: -> ^( $type expression statement )
                    {
                        // ../grammaire/NXC.g:458:76: ^( $type expression statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_type.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:459:4: DO statement (type= WHILE | type= UNTIL ) '(' expression ')' ';'
                    {
                    DO179=(Token)match(input,DO,FOLLOW_DO_in_iteration_statement2585); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DO.add(DO179);

                    pushFollow(FOLLOW_statement_in_iteration_statement2587);
                    statement180=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement180.getTree());
                    // ../grammaire/NXC.g:459:17: (type= WHILE | type= UNTIL )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==WHILE) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==UNTIL) ) {
                        alt62=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../grammaire/NXC.g:459:18: type= WHILE
                            {
                            type=(Token)match(input,WHILE,FOLLOW_WHILE_in_iteration_statement2592); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_WHILE.add(type);


                            }
                            break;
                        case 2 :
                            // ../grammaire/NXC.g:459:31: type= UNTIL
                            {
                            type=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_iteration_statement2598); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_UNTIL.add(type);


                            }
                            break;

                    }

                    char_literal181=(Token)match(input,120,FOLLOW_120_in_iteration_statement2601); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal181);

                    pushFollow(FOLLOW_expression_in_iteration_statement2603);
                    expression182=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression182.getTree());
                    char_literal183=(Token)match(input,121,FOLLOW_121_in_iteration_statement2605); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal183);

                    char_literal184=(Token)match(input,122,FOLLOW_122_in_iteration_statement2607); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal184);



                    // AST REWRITE
                    // elements: DO, expression, type, statement
                    // token labels: type
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 459:66: -> ^( DO $type expression statement )
                    {
                        // ../grammaire/NXC.g:459:69: ^( DO $type expression statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_DO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_type.nextNode());
                        adaptor.addChild(root_1, stream_expression.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:460:4: FOR '(' a= expression_statement b= expression_statement (c= expression )? ')' statement
                    {
                    FOR185=(Token)match(input,FOR,FOLLOW_FOR_in_iteration_statement2625); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FOR.add(FOR185);

                    char_literal186=(Token)match(input,120,FOLLOW_120_in_iteration_statement2627); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_120.add(char_literal186);

                    pushFollow(FOLLOW_expression_statement_in_iteration_statement2631);
                    a=expression_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression_statement.add(a.getTree());
                    pushFollow(FOLLOW_expression_statement_in_iteration_statement2635);
                    b=expression_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression_statement.add(b.getTree());
                    // ../grammaire/NXC.g:460:59: (c= expression )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==IDENTIFIER||(LA63_0>=DECIMAL_LITERAL && LA63_0<=HEX_LITERAL)||(LA63_0>=CHARACTER_LITERAL && LA63_0<=FALSE)||(LA63_0>=PLUSPLUS && LA63_0<=MINUS)||(LA63_0>=TILDE && LA63_0<=NOT)||LA63_0==120) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: c= expression
                            {
                            pushFollow(FOLLOW_expression_in_iteration_statement2639);
                            c=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(c.getTree());

                            }
                            break;

                    }

                    char_literal187=(Token)match(input,121,FOLLOW_121_in_iteration_statement2642); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_121.add(char_literal187);

                    pushFollow(FOLLOW_statement_in_iteration_statement2644);
                    statement188=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement188.getTree());


                    // AST REWRITE
                    // elements: statement, c, b, FOR, a
                    // token labels: 
                    // rule labels: retval, b, c, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
                    RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 460:86: -> ^( FOR ^( DO $a) ^( WHILE $b) ^( REPEAT $c) statement )
                    {
                        // ../grammaire/NXC.g:460:89: ^( FOR ^( DO $a) ^( WHILE $b) ^( REPEAT $c) statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);

                        // ../grammaire/NXC.g:460:95: ^( DO $a)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DO, "DO"), root_2);

                        adaptor.addChild(root_2, stream_a.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // ../grammaire/NXC.g:460:104: ^( WHILE $b)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_2);

                        adaptor.addChild(root_2, stream_b.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // ../grammaire/NXC.g:460:116: ^( REPEAT $c)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(REPEAT, "REPEAT"), root_2);

                        adaptor.addChild(root_2, stream_c.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, iteration_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "iteration_statement"

    public static class jump_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jump_statement"
    // ../grammaire/NXC.g:463:1: jump_statement : ( GOTO IDENTIFIER ';' -> ^( GOTO IDENTIFIER ) | CONTINUE ';' -> ^( CONTINUE ) | BREAK ';' -> ^( BREAK ) | RETURN ( expression )? ';' -> ^( RETURN ( expression )? ) );
    public final NXCParser.jump_statement_return jump_statement() throws RecognitionException {
        NXCParser.jump_statement_return retval = new NXCParser.jump_statement_return();
        retval.start = input.LT(1);
        int jump_statement_StartIndex = input.index();
        Object root_0 = null;

        Token GOTO189=null;
        Token IDENTIFIER190=null;
        Token char_literal191=null;
        Token CONTINUE192=null;
        Token char_literal193=null;
        Token BREAK194=null;
        Token char_literal195=null;
        Token RETURN196=null;
        Token char_literal198=null;
        NXCParser.expression_return expression197 = null;


        Object GOTO189_tree=null;
        Object IDENTIFIER190_tree=null;
        Object char_literal191_tree=null;
        Object CONTINUE192_tree=null;
        Object char_literal193_tree=null;
        Object BREAK194_tree=null;
        Object char_literal195_tree=null;
        Object RETURN196_tree=null;
        Object char_literal198_tree=null;
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_GOTO=new RewriteRuleTokenStream(adaptor,"token GOTO");
        RewriteRuleTokenStream stream_CONTINUE=new RewriteRuleTokenStream(adaptor,"token CONTINUE");
        RewriteRuleTokenStream stream_BREAK=new RewriteRuleTokenStream(adaptor,"token BREAK");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // ../grammaire/NXC.g:464:2: ( GOTO IDENTIFIER ';' -> ^( GOTO IDENTIFIER ) | CONTINUE ';' -> ^( CONTINUE ) | BREAK ';' -> ^( BREAK ) | RETURN ( expression )? ';' -> ^( RETURN ( expression )? ) )
            int alt66=4;
            switch ( input.LA(1) ) {
            case GOTO:
                {
                alt66=1;
                }
                break;
            case CONTINUE:
                {
                alt66=2;
                }
                break;
            case BREAK:
                {
                alt66=3;
                }
                break;
            case RETURN:
                {
                alt66=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../grammaire/NXC.g:464:4: GOTO IDENTIFIER ';'
                    {
                    GOTO189=(Token)match(input,GOTO,FOLLOW_GOTO_in_jump_statement2684); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GOTO.add(GOTO189);

                    IDENTIFIER190=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_jump_statement2686); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER190);

                    char_literal191=(Token)match(input,122,FOLLOW_122_in_jump_statement2688); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal191);



                    // AST REWRITE
                    // elements: IDENTIFIER, GOTO
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 464:24: -> ^( GOTO IDENTIFIER )
                    {
                        // ../grammaire/NXC.g:464:27: ^( GOTO IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_GOTO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:465:4: CONTINUE ';'
                    {
                    CONTINUE192=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_jump_statement2701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONTINUE.add(CONTINUE192);

                    char_literal193=(Token)match(input,122,FOLLOW_122_in_jump_statement2703); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal193);



                    // AST REWRITE
                    // elements: CONTINUE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 465:17: -> ^( CONTINUE )
                    {
                        // ../grammaire/NXC.g:465:20: ^( CONTINUE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CONTINUE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // ../grammaire/NXC.g:466:4: BREAK ';'
                    {
                    BREAK194=(Token)match(input,BREAK,FOLLOW_BREAK_in_jump_statement2714); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BREAK.add(BREAK194);

                    char_literal195=(Token)match(input,122,FOLLOW_122_in_jump_statement2716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal195);



                    // AST REWRITE
                    // elements: BREAK
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 466:14: -> ^( BREAK )
                    {
                        // ../grammaire/NXC.g:466:17: ^( BREAK )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_BREAK.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // ../grammaire/NXC.g:467:4: RETURN ( expression )? ';'
                    {
                    RETURN196=(Token)match(input,RETURN,FOLLOW_RETURN_in_jump_statement2727); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RETURN.add(RETURN196);

                    // ../grammaire/NXC.g:467:11: ( expression )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==IDENTIFIER||(LA65_0>=DECIMAL_LITERAL && LA65_0<=HEX_LITERAL)||(LA65_0>=CHARACTER_LITERAL && LA65_0<=FALSE)||(LA65_0>=PLUSPLUS && LA65_0<=MINUS)||(LA65_0>=TILDE && LA65_0<=NOT)||LA65_0==120) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../grammaire/NXC.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_jump_statement2729);
                            expression197=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(expression197.getTree());

                            }
                            break;

                    }

                    char_literal198=(Token)match(input,122,FOLLOW_122_in_jump_statement2732); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal198);



                    // AST REWRITE
                    // elements: expression, RETURN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 467:27: -> ^( RETURN ( expression )? )
                    {
                        // ../grammaire/NXC.g:467:30: ^( RETURN ( expression )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);

                        // ../grammaire/NXC.g:467:39: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, jump_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "jump_statement"

    public static class task_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "task_statement"
    // ../grammaire/NXC.g:470:1: task_statement : ( (s= START | s= STOP ) IDENTIFIER ';' -> ^( $s IDENTIFIER ) | PRIORITY IDENTIFIER ',' DECIMAL_LITERAL ';' -> ^( PRIORITY IDENTIFIER DECIMAL_LITERAL ) );
    public final NXCParser.task_statement_return task_statement() throws RecognitionException {
        NXCParser.task_statement_return retval = new NXCParser.task_statement_return();
        retval.start = input.LT(1);
        int task_statement_StartIndex = input.index();
        Object root_0 = null;

        Token s=null;
        Token IDENTIFIER199=null;
        Token char_literal200=null;
        Token PRIORITY201=null;
        Token IDENTIFIER202=null;
        Token char_literal203=null;
        Token DECIMAL_LITERAL204=null;
        Token char_literal205=null;

        Object s_tree=null;
        Object IDENTIFIER199_tree=null;
        Object char_literal200_tree=null;
        Object PRIORITY201_tree=null;
        Object IDENTIFIER202_tree=null;
        Object char_literal203_tree=null;
        Object DECIMAL_LITERAL204_tree=null;
        Object char_literal205_tree=null;
        RewriteRuleTokenStream stream_START=new RewriteRuleTokenStream(adaptor,"token START");
        RewriteRuleTokenStream stream_STOP=new RewriteRuleTokenStream(adaptor,"token STOP");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_PRIORITY=new RewriteRuleTokenStream(adaptor,"token PRIORITY");
        RewriteRuleTokenStream stream_DECIMAL_LITERAL=new RewriteRuleTokenStream(adaptor,"token DECIMAL_LITERAL");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // ../grammaire/NXC.g:471:2: ( (s= START | s= STOP ) IDENTIFIER ';' -> ^( $s IDENTIFIER ) | PRIORITY IDENTIFIER ',' DECIMAL_LITERAL ';' -> ^( PRIORITY IDENTIFIER DECIMAL_LITERAL ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=START && LA68_0<=STOP)) ) {
                alt68=1;
            }
            else if ( (LA68_0==PRIORITY) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../grammaire/NXC.g:471:4: (s= START | s= STOP ) IDENTIFIER ';'
                    {
                    // ../grammaire/NXC.g:471:4: (s= START | s= STOP )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==START) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==STOP) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../grammaire/NXC.g:471:5: s= START
                            {
                            s=(Token)match(input,START,FOLLOW_START_in_task_statement2755); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_START.add(s);


                            }
                            break;
                        case 2 :
                            // ../grammaire/NXC.g:471:15: s= STOP
                            {
                            s=(Token)match(input,STOP,FOLLOW_STOP_in_task_statement2761); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_STOP.add(s);


                            }
                            break;

                    }

                    IDENTIFIER199=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_task_statement2764); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER199);

                    char_literal200=(Token)match(input,122,FOLLOW_122_in_task_statement2766); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal200);



                    // AST REWRITE
                    // elements: s, IDENTIFIER
                    // token labels: s
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 471:38: -> ^( $s IDENTIFIER )
                    {
                        // ../grammaire/NXC.g:471:41: ^( $s IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // ../grammaire/NXC.g:472:4: PRIORITY IDENTIFIER ',' DECIMAL_LITERAL ';'
                    {
                    PRIORITY201=(Token)match(input,PRIORITY,FOLLOW_PRIORITY_in_task_statement2780); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PRIORITY.add(PRIORITY201);

                    IDENTIFIER202=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_task_statement2782); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER202);

                    char_literal203=(Token)match(input,123,FOLLOW_123_in_task_statement2784); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_123.add(char_literal203);

                    DECIMAL_LITERAL204=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_task_statement2786); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECIMAL_LITERAL.add(DECIMAL_LITERAL204);

                    char_literal205=(Token)match(input,122,FOLLOW_122_in_task_statement2788); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_122.add(char_literal205);



                    // AST REWRITE
                    // elements: DECIMAL_LITERAL, PRIORITY, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 472:48: -> ^( PRIORITY IDENTIFIER DECIMAL_LITERAL )
                    {
                        // ../grammaire/NXC.g:472:51: ^( PRIORITY IDENTIFIER DECIMAL_LITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_PRIORITY.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        adaptor.addChild(root_1, stream_DECIMAL_LITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, task_statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "task_statement"

    // $ANTLR start synpred5_NXC
    public final void synpred5_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:182:4: ( ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{' )
        // ../grammaire/NXC.g:182:5: ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{'
        {
        // ../grammaire/NXC.g:182:5: ( SAFECALL )?
        int alt69=2;
        alt69 = dfa69.predict(input);
        switch (alt69) {
            case 1 :
                // ../grammaire/NXC.g:0:0: SAFECALL
                {
                match(input,SAFECALL,FOLLOW_SAFECALL_in_synpred5_NXC258); if (state.failed) return ;

                }
                break;

        }

        // ../grammaire/NXC.g:182:15: ( INLINE )?
        int alt70=2;
        alt70 = dfa70.predict(input);
        switch (alt70) {
            case 1 :
                // ../grammaire/NXC.g:0:0: INLINE
                {
                match(input,INLINE,FOLLOW_INLINE_in_synpred5_NXC261); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_type_specifier_in_synpred5_NXC264);
        type_specifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred5_NXC266); if (state.failed) return ;
        match(input,120,FOLLOW_120_in_synpred5_NXC268); if (state.failed) return ;
        // ../grammaire/NXC.g:182:53: ( parameter_list )?
        int alt71=2;
        alt71 = dfa71.predict(input);
        switch (alt71) {
            case 1 :
                // ../grammaire/NXC.g:0:0: parameter_list
                {
                pushFollow(FOLLOW_parameter_list_in_synpred5_NXC270);
                parameter_list();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,121,FOLLOW_121_in_synpred5_NXC273); if (state.failed) return ;
        match(input,124,FOLLOW_124_in_synpred5_NXC275); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_NXC

    // $ANTLR start synpred6_NXC
    public final void synpred6_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:183:4: ( TASK IDENTIFIER '(' ')' '{' )
        // ../grammaire/NXC.g:183:5: TASK IDENTIFIER '(' ')' '{'
        {
        match(input,TASK,FOLLOW_TASK_in_synpred6_NXC286); if (state.failed) return ;
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred6_NXC288); if (state.failed) return ;
        match(input,120,FOLLOW_120_in_synpred6_NXC290); if (state.failed) return ;
        match(input,121,FOLLOW_121_in_synpred6_NXC292); if (state.failed) return ;
        match(input,124,FOLLOW_124_in_synpred6_NXC294); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_NXC

    // $ANTLR start synpred8_NXC
    public final void synpred8_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:184:4: ( ( TYPEDEF )? STRUCT )
        // ../grammaire/NXC.g:184:5: ( TYPEDEF )? STRUCT
        {
        // ../grammaire/NXC.g:184:5: ( TYPEDEF )?
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==TYPEDEF) ) {
            alt72=1;
        }
        switch (alt72) {
            case 1 :
                // ../grammaire/NXC.g:0:0: TYPEDEF
                {
                match(input,TYPEDEF,FOLLOW_TYPEDEF_in_synpred8_NXC305); if (state.failed) return ;

                }
                break;

        }

        match(input,STRUCT,FOLLOW_STRUCT_in_synpred8_NXC308); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_NXC

    // $ANTLR start synpred9_NXC
    public final void synpred9_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:185:4: ( ENUM )
        // ../grammaire/NXC.g:185:5: ENUM
        {
        match(input,ENUM,FOLLOW_ENUM_in_synpred9_NXC319); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_NXC

    // $ANTLR start synpred17_NXC
    public final void synpred17_NXC_fragment() throws RecognitionException {   
        NXCParser.type_specifier_return type = null;


        // ../grammaire/NXC.g:198:4: ( ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';' )
        // ../grammaire/NXC.g:198:4: ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';'
        {
        // ../grammaire/NXC.g:198:4: ( SAFECALL )?
        int alt73=2;
        alt73 = dfa73.predict(input);
        switch (alt73) {
            case 1 :
                // ../grammaire/NXC.g:0:0: SAFECALL
                {
                match(input,SAFECALL,FOLLOW_SAFECALL_in_synpred17_NXC442); if (state.failed) return ;

                }
                break;

        }

        // ../grammaire/NXC.g:198:14: ( INLINE )?
        int alt74=2;
        alt74 = dfa74.predict(input);
        switch (alt74) {
            case 1 :
                // ../grammaire/NXC.g:0:0: INLINE
                {
                match(input,INLINE,FOLLOW_INLINE_in_synpred17_NXC445); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_type_specifier_in_synpred17_NXC450);
        type=type_specifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred17_NXC452); if (state.failed) return ;
        match(input,120,FOLLOW_120_in_synpred17_NXC454); if (state.failed) return ;
        // ../grammaire/NXC.g:198:57: ( parameter_list )?
        int alt75=2;
        alt75 = dfa75.predict(input);
        switch (alt75) {
            case 1 :
                // ../grammaire/NXC.g:0:0: parameter_list
                {
                pushFollow(FOLLOW_parameter_list_in_synpred17_NXC456);
                parameter_list();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,121,FOLLOW_121_in_synpred17_NXC459); if (state.failed) return ;
        match(input,122,FOLLOW_122_in_synpred17_NXC461); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_NXC

    // $ANTLR start synpred54_NXC
    public final void synpred54_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:309:4: ( '(' type_specifier ')' unary_expression )
        // ../grammaire/NXC.g:309:4: '(' type_specifier ')' unary_expression
        {
        match(input,120,FOLLOW_120_in_synpred54_NXC1348); if (state.failed) return ;
        pushFollow(FOLLOW_type_specifier_in_synpred54_NXC1350);
        type_specifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,121,FOLLOW_121_in_synpred54_NXC1352); if (state.failed) return ;
        pushFollow(FOLLOW_unary_expression_in_synpred54_NXC1354);
        unary_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_NXC

    // $ANTLR start synpred75_NXC
    public final void synpred75_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:352:27: ( ',' assignment_expression )
        // ../grammaire/NXC.g:352:27: ',' assignment_expression
        {
        match(input,123,FOLLOW_123_in_synpred75_NXC1700); if (state.failed) return ;
        pushFollow(FOLLOW_assignment_expression_in_synpred75_NXC1702);
        assignment_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_NXC

    // $ANTLR start synpred76_NXC
    public final void synpred76_NXC_fragment() throws RecognitionException {   
        NXCParser.postfix_expression_return a = null;

        NXCParser.assignment_operator_return s = null;

        NXCParser.assignment_expression_return b = null;


        // ../grammaire/NXC.g:356:4: (a= postfix_expression s= assignment_operator b= assignment_expression )
        // ../grammaire/NXC.g:356:4: a= postfix_expression s= assignment_operator b= assignment_expression
        {
        pushFollow(FOLLOW_postfix_expression_in_synpred76_NXC1722);
        a=postfix_expression();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignment_operator_in_synpred76_NXC1726);
        s=assignment_operator();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignment_expression_in_synpred76_NXC1730);
        b=assignment_expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_NXC

    // $ANTLR start synpred111_NXC
    public final void synpred111_NXC_fragment() throws RecognitionException {   
        // ../grammaire/NXC.g:441:36: ( selection_else )
        // ../grammaire/NXC.g:441:36: selection_else
        {
        pushFollow(FOLLOW_selection_else_in_synpred111_NXC2390);
        selection_else();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_NXC

    // Delegated rules

    public final boolean synpred54_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_NXC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_NXC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA75 dfa75 = new DFA75(this);
    static final String DFA1_eotS =
        "\26\uffff";
    static final String DFA1_eofS =
        "\1\1\25\uffff";
    static final String DFA1_minS =
        "\1\42\25\uffff";
    static final String DFA1_maxS =
        "\1\67\25\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\2\1\1\23\uffff";
    static final String DFA1_specialS =
        "\26\uffff}>";
    static final String[] DFA1_transitionS = {
            "\23\2\2\uffff\1\2",
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
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()+ loopback of 177:4: ( external_declaration )+";
        }
    }
    static final String DFA2_eotS =
        "\27\uffff";
    static final String DFA2_eofS =
        "\27\uffff";
    static final String DFA2_minS =
        "\1\42\21\0\5\uffff";
    static final String DFA2_maxS =
        "\1\67\21\0\5\uffff";
    static final String DFA2_acceptS =
        "\22\uffff\1\3\1\4\1\5\1\1\1\2";
    static final String DFA2_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\16\1\17\1\20\1\21\5\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\2\1\17\1\20\1\21\1\24\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1"+
            "\12\1\13\1\14\1\15\1\16\1\23\2\uffff\1\22",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "180:1: external_declaration options {k=1; } : ( ( ( SAFECALL )? ( INLINE )? type_specifier IDENTIFIER '(' ( parameter_list )? ')' '{' )=> function_definition | ( TASK IDENTIFIER '(' ')' '{' )=> task_definition | ( ( TYPEDEF )? STRUCT )=> struct_definition | ( ENUM )=> enum_declaration | declaration );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_0 = input.LA(1);

                         
                        int index2_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA2_0==SAFECALL) ) {s = 1;}

                        else if ( (LA2_0==INLINE) ) {s = 2;}

                        else if ( (LA2_0==VOID) ) {s = 3;}

                        else if ( (LA2_0==SUB) ) {s = 4;}

                        else if ( (LA2_0==CHAR) ) {s = 5;}

                        else if ( (LA2_0==UNSIGNED) ) {s = 6;}

                        else if ( (LA2_0==BOOL) ) {s = 7;}

                        else if ( (LA2_0==BYTE) ) {s = 8;}

                        else if ( (LA2_0==SHORT) ) {s = 9;}

                        else if ( (LA2_0==INT) ) {s = 10;}

                        else if ( (LA2_0==LONG) ) {s = 11;}

                        else if ( (LA2_0==FLOAT) ) {s = 12;}

                        else if ( (LA2_0==STRING) ) {s = 13;}

                        else if ( (LA2_0==MUTEX) ) {s = 14;}

                        else if ( (LA2_0==IDENTIFIER) ) {s = 15;}

                        else if ( (LA2_0==TASK) ) {s = 16;}

                        else if ( (LA2_0==TYPEDEF) ) {s = 17;}

                        else if ( (LA2_0==STRUCT) && (synpred8_NXC())) {s = 18;}

                        else if ( (LA2_0==ENUM) && (synpred9_NXC())) {s = 19;}

                        else if ( (LA2_0==CONST) ) {s = 20;}

                         
                        input.seek(index2_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA2_10 = input.LA(1);

                         
                        int index2_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA2_11 = input.LA(1);

                         
                        int index2_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_NXC()) ) {s = 21;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred5_NXC()&&( isTypeName(input.LT(1).getText()) ))) ) {s = 21;}

                        else if ( (( isTypeName(input.LT(1).getText()) )) ) {s = 20;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_NXC()) ) {s = 22;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_NXC()) ) {s = 18;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA3_eotS =
        "\20\uffff";
    static final String DFA3_eofS =
        "\20\uffff";
    static final String DFA3_minS =
        "\1\42\17\uffff";
    static final String DFA3_maxS =
        "\1\63\17\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA3_specialS =
        "\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\2\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "190:4: ( SAFECALL )?";
        }
    }
    static final String DFA4_eotS =
        "\17\uffff";
    static final String DFA4_eofS =
        "\17\uffff";
    static final String DFA4_minS =
        "\1\43\16\uffff";
    static final String DFA4_maxS =
        "\1\63\16\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA4_specialS =
        "\17\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\1\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "190:14: ( INLINE )?";
        }
    }
    static final String DFA5_eotS =
        "\20\uffff";
    static final String DFA5_eofS =
        "\20\uffff";
    static final String DFA5_minS =
        "\1\44\17\uffff";
    static final String DFA5_maxS =
        "\1\171\17\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA5_specialS =
        "\20\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\2\uffff\15\1\105\uffff\1\17",
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
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "190:57: ( parameter_list )?";
        }
    }
    static final String DFA9_eotS =
        "\42\uffff";
    static final String DFA9_eofS =
        "\42\uffff";
    static final String DFA9_minS =
        "\1\42\3\uffff\3\44\1\52\11\44\2\uffff\17\0";
    static final String DFA9_maxS =
        "\1\63\3\uffff\3\44\1\60\11\44\2\uffff\17\0";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\16\uffff\1\3\1\4\17\uffff";
    static final String DFA9_specialS =
        "\23\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16}>";
    static final String[] DFA9_transitionS = {
            "\2\2\1\20\1\21\1\1\1\22\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17",
            "",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26\4\uffff\1\27\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "195:1: declaration : ( TYPEDEF type_specifier IDENTIFIER ';' -> | ( SAFECALL )? ( INLINE )? type= type_specifier IDENTIFIER '(' ( parameter_list )? ')' ';' -> ^( FUNCTION_DECLARATION $type IDENTIFIER ( SAFECALL )? ^( PARAMETERS ( parameter_list )? ) ) | TASK IDENTIFIER '(' ')' ';' -> ^( TASK_DECLARATION T_VOID IDENTIFIER ) | declaration_specifiers init_declarator_list ';' -> init_declarator_list );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_19 = input.LA(1);

                         
                        int index9_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_20 = input.LA(1);

                         
                        int index9_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_20);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_21 = input.LA(1);

                         
                        int index9_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_21);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_22 = input.LA(1);

                         
                        int index9_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_22);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_23 = input.LA(1);

                         
                        int index9_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_23);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_24 = input.LA(1);

                         
                        int index9_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_24);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_25 = input.LA(1);

                         
                        int index9_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_25);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_26 = input.LA(1);

                         
                        int index9_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_26);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_27 = input.LA(1);

                         
                        int index9_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_27);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA9_28 = input.LA(1);

                         
                        int index9_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_28);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA9_29 = input.LA(1);

                         
                        int index9_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_29);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA9_30 = input.LA(1);

                         
                        int index9_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA9_31 = input.LA(1);

                         
                        int index9_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_31);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA9_32 = input.LA(1);

                         
                        int index9_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_NXC()) ) {s = 2;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index9_32);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA9_33 = input.LA(1);

                         
                        int index9_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred17_NXC()&&( isTypeName(input.LT(1).getText()) ))) ) {s = 2;}

                        else if ( (( isTypeName(input.LT(1).getText()) )) ) {s = 18;}

                         
                        input.seek(index9_33);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\20\uffff";
    static final String DFA6_minS =
        "\1\42\17\uffff";
    static final String DFA6_maxS =
        "\1\63\17\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA6_specialS =
        "\20\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\2\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "198:4: ( SAFECALL )?";
        }
    }
    static final String DFA7_eotS =
        "\17\uffff";
    static final String DFA7_eofS =
        "\17\uffff";
    static final String DFA7_minS =
        "\1\43\16\uffff";
    static final String DFA7_maxS =
        "\1\63\16\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA7_specialS =
        "\17\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "198:14: ( INLINE )?";
        }
    }
    static final String DFA8_eotS =
        "\20\uffff";
    static final String DFA8_eofS =
        "\20\uffff";
    static final String DFA8_minS =
        "\1\44\17\uffff";
    static final String DFA8_maxS =
        "\1\171\17\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA8_specialS =
        "\20\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\2\uffff\15\1\105\uffff\1\17",
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
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "198:57: ( parameter_list )?";
        }
    }
    static final String DFA10_eotS =
        "\17\uffff";
    static final String DFA10_eofS =
        "\17\uffff";
    static final String DFA10_minS =
        "\1\44\16\uffff";
    static final String DFA10_maxS =
        "\1\63\16\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA10_specialS =
        "\17\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\2\uffff\1\1\14\2",
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
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "204:4: ( CONST )?";
        }
    }
    static final String DFA13_eotS =
        "\21\uffff";
    static final String DFA13_eofS =
        "\21\uffff";
    static final String DFA13_minS =
        "\1\44\3\uffff\1\52\14\uffff";
    static final String DFA13_maxS =
        "\1\63\3\uffff\1\60\14\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\12\1\14\1\15\1\16"+
        "\1\17\1\4\1\11\1\13";
    static final String DFA13_specialS =
        "\21\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\15\3\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14",
            "",
            "",
            "",
            "\1\16\4\uffff\1\17\1\20",
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
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "215:1: type_specifier : ( VOID -> T_VOID | SUB -> T_VOID | CHAR -> T_S8 | UNSIGNED CHAR -> T_U8 | BOOL -> T_U8 | BYTE -> T_U8 | SHORT -> T_S16 | INT -> T_S16 | UNSIGNED INT -> T_U16 | LONG -> T_S32 | UNSIGNED LONG -> T_U32 | FLOAT -> T_FLOAT | STRING -> T_STRING | MUTEX -> T_MUTEX | type_id );";
        }
    }
    static final String DFA19_eotS =
        "\17\uffff";
    static final String DFA19_eofS =
        "\17\uffff";
    static final String DFA19_minS =
        "\1\44\16\uffff";
    static final String DFA19_maxS =
        "\1\175\16\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\2\1\1\14\uffff";
    static final String DFA19_specialS =
        "\17\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\3\uffff\14\2\111\uffff\1\1",
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
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()+ loopback of 262:4: ( struct_declaration )+";
        }
    }
    static final String DFA28_eotS =
        "\30\uffff";
    static final String DFA28_eofS =
        "\1\1\27\uffff";
    static final String DFA28_minS =
        "\1\117\27\uffff";
    static final String DFA28_maxS =
        "\1\u0082\27\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\2\24\uffff\1\1\1\uffff";
    static final String DFA28_specialS =
        "\30\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\26\1\uffff\1\26\3\uffff\5\1\2\uffff\10\1\25\uffff\3\1\1\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\2\1",
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
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()* loopback of 301:38: ( (s= '+' | s= '-' ) b= multiplicative_expression -> ^( $s $additive_expression $b) )*";
        }
    }
    static final String DFA30_eotS =
        "\33\uffff";
    static final String DFA30_eofS =
        "\1\1\32\uffff";
    static final String DFA30_minS =
        "\1\117\32\uffff";
    static final String DFA30_maxS =
        "\1\u0082\32\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\2\26\uffff\1\1\2\uffff";
    static final String DFA30_specialS =
        "\33\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\uffff\1\1\3\30\5\1\2\uffff\10\1\25\uffff\3\1\1\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\2\1",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()* loopback of 305:28: ( (s= '*' | s= '/' | s= '%' ) b= cast_expression -> ^( $s $multiplicative_expression $b) )*";
        }
    }
    static final String DFA31_eotS =
        "\31\uffff";
    static final String DFA31_eofS =
        "\31\uffff";
    static final String DFA31_minS =
        "\2\44\21\uffff\1\0\5\uffff";
    static final String DFA31_maxS =
        "\2\170\21\uffff\1\0\5\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\4\uffff\1\1\21\uffff";
    static final String DFA31_specialS =
        "\23\uffff\1\0\5\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\20\uffff\2\2\1\uffff\5\2\21\uffff\4\2\10\uffff\2\2\34\uffff"+
            "\1\1",
            "\1\23\3\uffff\14\7\1\uffff\2\2\1\uffff\5\2\21\uffff\4\2\10"+
            "\uffff\2\2\34\uffff\1\2",
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
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "308:1: cast_expression : ( '(' type_specifier ')' unary_expression -> ^( CAST type_specifier unary_expression ) | unary_expression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_19 = input.LA(1);

                         
                        int index31_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred54_NXC()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\36\uffff";
    static final String DFA33_eofS =
        "\1\1\35\uffff";
    static final String DFA33_minS =
        "\1\117\35\uffff";
    static final String DFA33_maxS =
        "\1\u0082\35\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\3\32\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\36\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\uffff\11\1\2\uffff\23\1\12\uffff\3\1\1\uffff\1\1\1\34"+
            "\1\1\1\35\2\1",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "()* loopback of 320:3: ( (l= '[' expression ']' -> ^( DIMENSION_ACCESS $postfix_expression expression ) ) | ( '.' i= IDENTIFIER -> ^( FIELD_ACCESS $postfix_expression $i) ) )*";
        }
    }
    static final String DFA38_eotS =
        "\46\uffff";
    static final String DFA38_eofS =
        "\3\uffff\1\7\42\uffff";
    static final String DFA38_minS =
        "\1\44\2\uffff\1\116\42\uffff";
    static final String DFA38_maxS =
        "\1\170\2\uffff\1\u0082\42\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\3\1\2\36\uffff";
    static final String DFA38_specialS =
        "\46\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\3\20\uffff\2\4\1\uffff\5\4\21\uffff\1\1\1\uffff\1\1\47\uffff"+
            "\1\5",
            "",
            "",
            "\14\7\2\uffff\23\7\11\uffff\1\6\3\7\1\uffff\6\7",
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
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "332:1: primary_expression : ( (s= '++' | s= '--' ) IDENTIFIER -> ^( PRE $s IDENTIFIER ) | (a= IDENTIFIER -> $a) ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )? | IDENTIFIER '(' ( argument_expression_list )? ')' -> ^( FUNC_CALL IDENTIFIER ^( ARGUMENTS ( argument_expression_list )? ) ) | constant | '(' assignment_expression ')' -> assignment_expression );";
        }
    }
    static final String DFA36_eotS =
        "\40\uffff";
    static final String DFA36_eofS =
        "\1\3\37\uffff";
    static final String DFA36_minS =
        "\1\116\37\uffff";
    static final String DFA36_maxS =
        "\1\u0082\37\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\34\uffff";
    static final String DFA36_specialS =
        "\40\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\3\1\1\11\3\2\uffff\23\3\12\uffff\3\3\1\uffff\6\3",
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
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "334:25: ( (s= '++' | s= '--' ) -> ^( POST $s $primary_expression) )?";
        }
    }
    static final String DFA39_eotS =
        "\17\uffff";
    static final String DFA39_eofS =
        "\1\1\16\uffff";
    static final String DFA39_minS =
        "\1\171\2\uffff\1\0\13\uffff";
    static final String DFA39_maxS =
        "\1\u0082\2\uffff\1\0\13\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA39_specialS =
        "\3\uffff\1\0\13\uffff}>";
    static final String[] DFA39_transitionS = {
            "\2\1\1\3\1\uffff\1\1\1\uffff\1\1\2\uffff\1\1",
            "",
            "",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "()* loopback of 352:26: ( ',' assignment_expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\130\uffff";
    static final String DFA40_eofS =
        "\3\uffff\2\6\123\uffff";
    static final String DFA40_minS =
        "\3\44\1\116\1\117\1\44\1\uffff\7\0\33\uffff\2\0\33\uffff\6\0\14"+
        "\uffff";
    static final String DFA40_maxS =
        "\1\170\2\44\2\u0082\1\170\1\uffff\7\0\33\uffff\2\0\33\uffff\6\0"+
        "\14\uffff";
    static final String DFA40_acceptS =
        "\6\uffff\1\2\7\uffff\1\1\111\uffff";
    static final String DFA40_specialS =
        "\7\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\33\uffff\1\7\1\10\33\uffff"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\14\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\3\20\uffff\2\4\1\uffff\5\4\21\uffff\1\1\1\6\1\2\1\6\10\uffff"+
            "\2\6\34\uffff\1\5",
            "\1\7",
            "\1\10",
            "\1\12\1\6\1\13\11\6\2\uffff\10\6\13\16\11\uffff\1\11\3\6\1"+
            "\uffff\1\6\1\14\1\6\1\15\2\6",
            "\1\6\1\uffff\11\6\2\uffff\10\6\13\16\12\uffff\3\6\1\uffff\1"+
            "\6\1\51\1\6\1\52\2\6",
            "\1\110\3\uffff\14\6\1\uffff\2\111\1\uffff\5\111\21\uffff\1"+
            "\106\1\113\1\107\1\113\10\uffff\2\113\34\uffff\1\112",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "355:1: assignment_expression : (a= postfix_expression s= assignment_operator b= assignment_expression -> ^( $s $a $b) | conditional_expression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_9 = input.LA(1);

                         
                        int index40_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_10 = input.LA(1);

                         
                        int index40_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_10);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_13 = input.LA(1);

                         
                        int index40_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_13);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA40_41 = input.LA(1);

                         
                        int index40_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_41);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA40_42 = input.LA(1);

                         
                        int index40_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_42);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA40_70 = input.LA(1);

                         
                        int index40_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_70);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA40_71 = input.LA(1);

                         
                        int index40_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_71);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA40_72 = input.LA(1);

                         
                        int index40_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_72);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA40_73 = input.LA(1);

                         
                        int index40_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_73);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA40_74 = input.LA(1);

                         
                        int index40_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_74);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA40_75 = input.LA(1);

                         
                        int index40_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_NXC()) ) {s = 14;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index40_75);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\12\uffff";
    static final String DFA42_eofS =
        "\1\1\11\uffff";
    static final String DFA42_minS =
        "\1\135\11\uffff";
    static final String DFA42_maxS =
        "\1\u0082\11\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA42_specialS =
        "\12\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\11\33\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 379:35: (s= '||' b= logical_and_expression -> ^( $s $logical_or_expression $b) )*";
        }
    }
    static final String DFA43_eotS =
        "\13\uffff";
    static final String DFA43_eofS =
        "\1\1\12\uffff";
    static final String DFA43_minS =
        "\1\134\12\uffff";
    static final String DFA43_maxS =
        "\1\u0082\12\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\1\2\10\uffff\1\1";
    static final String DFA43_specialS =
        "\13\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\12\1\1\33\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 383:36: (s= '&&' b= inclusive_or_expression -> ^( $s $logical_and_expression $b) )*";
        }
    }
    static final String DFA44_eotS =
        "\14\uffff";
    static final String DFA44_eofS =
        "\1\1\13\uffff";
    static final String DFA44_minS =
        "\1\130\13\uffff";
    static final String DFA44_maxS =
        "\1\u0082\13\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA44_specialS =
        "\14\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\13\3\uffff\2\1\33\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1\uffff"+
            "\2\1",
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
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 387:36: (s= '|' b= exclusive_or_expression -> ^( $s $inclusive_or_expression $b) )*";
        }
    }
    static final String DFA45_eotS =
        "\15\uffff";
    static final String DFA45_eofS =
        "\1\1\14\uffff";
    static final String DFA45_minS =
        "\1\130\14\uffff";
    static final String DFA45_maxS =
        "\1\u0082\14\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA45_specialS =
        "\15\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\1\14\2\uffff\2\1\33\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\2\1",
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
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 391:27: (s= '^' b= and_expression -> ^( $s $exclusive_or_expression $b) )*";
        }
    }
    static final String DFA46_eotS =
        "\16\uffff";
    static final String DFA46_eofS =
        "\1\1\15\uffff";
    static final String DFA46_minS =
        "\1\127\15\uffff";
    static final String DFA46_maxS =
        "\1\u0082\15\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\2\13\uffff\1\1";
    static final String DFA46_specialS =
        "\16\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\15\2\1\2\uffff\2\1\33\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\2\1",
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
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 395:32: (s= '&' b= equality_expression -> ^( $s $and_expression $b) )*";
        }
    }
    static final String DFA48_eotS =
        "\20\uffff";
    static final String DFA48_eofS =
        "\1\1\17\uffff";
    static final String DFA48_minS =
        "\1\127\17\uffff";
    static final String DFA48_maxS =
        "\1\u0082\17\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA48_specialS =
        "\20\uffff}>";
    static final String[] DFA48_transitionS = {
            "\3\1\2\uffff\2\1\2\16\31\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\2\1",
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
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "()* loopback of 399:34: ( (s= '==' | s= '!=' ) b= relational_expression -> ^( $s $equality_expression $b) )*";
        }
    }
    static final String DFA50_eotS =
        "\24\uffff";
    static final String DFA50_eofS =
        "\1\1\23\uffff";
    static final String DFA50_minS =
        "\1\127\23\uffff";
    static final String DFA50_maxS =
        "\1\u0082\23\uffff";
    static final String DFA50_acceptS =
        "\1\uffff\1\2\16\uffff\1\1\3\uffff";
    static final String DFA50_specialS =
        "\24\uffff}>";
    static final String[] DFA50_transitionS = {
            "\3\1\2\uffff\4\1\4\20\25\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\2\1",
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
            ""
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "()* loopback of 403:29: ( (s= '<' | s= '>' | s= '<=' | s= '>=' ) b= shift_expression -> ^( $s $relational_expression $b) )*";
        }
    }
    static final String DFA52_eotS =
        "\26\uffff";
    static final String DFA52_eofS =
        "\1\1\25\uffff";
    static final String DFA52_minS =
        "\1\125\25\uffff";
    static final String DFA52_maxS =
        "\1\u0082\25\uffff";
    static final String DFA52_acceptS =
        "\1\uffff\1\2\22\uffff\1\1\1\uffff";
    static final String DFA52_specialS =
        "\26\uffff}>";
    static final String[] DFA52_transitionS = {
            "\2\24\3\1\2\uffff\10\1\25\uffff\3\1\1\uffff\1\1\1\uffff\1\1"+
            "\1\uffff\2\1",
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
            "",
            ""
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "()* loopback of 407:32: ( (s= '<<' | s= '>>' ) b= additive_expression -> ^( $s $shift_expression $b) )*";
        }
    }
    static final String DFA53_eotS =
        "\105\uffff";
    static final String DFA53_eofS =
        "\105\uffff";
    static final String DFA53_minS =
        "\1\42\1\44\103\uffff";
    static final String DFA53_maxS =
        "\1\174\1\u0082\103\uffff";
    static final String DFA53_acceptS =
        "\2\uffff\1\2\1\3\5\uffff\1\4\1\uffff\1\5\4\uffff\1\6\3\uffff\1\7"+
        "\2\uffff\1\10\20\uffff\1\1\34\uffff";
    static final String DFA53_specialS =
        "\105\uffff}>";
    static final String[] DFA53_transitionS = {
            "\2\27\1\1\17\27\1\uffff\2\3\1\uffff\5\3\2\11\3\uffff\5\13\4"+
            "\20\3\24\4\3\10\uffff\2\3\34\uffff\1\3\1\uffff\1\3\1\uffff\1"+
            "\2",
            "\1\27\51\uffff\14\3\2\uffff\23\3\11\uffff\1\3\1\uffff\2\3\2"+
            "\uffff\1\3\1\uffff\2\3\1\50",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "412:1: statement : ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement | task_statement | declaration );";
        }
    }
    static final String DFA54_eotS =
        "\51\uffff";
    static final String DFA54_eofS =
        "\51\uffff";
    static final String DFA54_minS =
        "\1\42\50\uffff";
    static final String DFA54_maxS =
        "\1\175\50\uffff";
    static final String DFA54_acceptS =
        "\1\uffff\1\1\46\uffff\1\2";
    static final String DFA54_specialS =
        "\51\uffff}>";
    static final String[] DFA54_transitionS = {
            "\22\1\1\uffff\2\1\1\uffff\7\1\3\uffff\20\1\10\uffff\2\1\34\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\1\1\1\50",
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
            "",
            ""
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "428:8: ( statement_list )?";
        }
    }
    static final String DFA55_eotS =
        "\54\uffff";
    static final String DFA55_eofS =
        "\1\1\53\uffff";
    static final String DFA55_minS =
        "\1\42\53\uffff";
    static final String DFA55_maxS =
        "\1\175\53\uffff";
    static final String DFA55_acceptS =
        "\1\uffff\1\2\3\uffff\1\1\46\uffff";
    static final String DFA55_specialS =
        "\54\uffff}>";
    static final String[] DFA55_transitionS = {
            "\22\5\1\uffff\2\5\1\uffff\7\5\1\uffff\2\1\20\5\10\uffff\2\5"+
            "\34\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\1",
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "()+ loopback of 432:4: ( statement )+";
        }
    }
    static final String DFA57_eotS =
        "\125\uffff";
    static final String DFA57_eofS =
        "\1\2\124\uffff";
    static final String DFA57_minS =
        "\1\42\1\0\123\uffff";
    static final String DFA57_maxS =
        "\1\175\1\0\123\uffff";
    static final String DFA57_acceptS =
        "\2\uffff\1\2\121\uffff\1\1";
    static final String DFA57_specialS =
        "\1\uffff\1\0\123\uffff}>";
    static final String[] DFA57_transitionS = {
            "\22\2\1\uffff\2\2\1\uffff\7\2\1\1\22\2\10\uffff\2\2\34\uffff"+
            "\1\2\1\uffff\1\2\1\uffff\2\2",
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "441:36: ( selection_else )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred111_NXC()) ) {s = 84;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\20\uffff";
    static final String DFA69_eofS =
        "\20\uffff";
    static final String DFA69_minS =
        "\1\42\17\uffff";
    static final String DFA69_maxS =
        "\1\63\17\uffff";
    static final String DFA69_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA69_specialS =
        "\20\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\1\2\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "182:5: ( SAFECALL )?";
        }
    }
    static final String DFA70_eotS =
        "\17\uffff";
    static final String DFA70_eofS =
        "\17\uffff";
    static final String DFA70_minS =
        "\1\43\16\uffff";
    static final String DFA70_maxS =
        "\1\63\16\uffff";
    static final String DFA70_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA70_specialS =
        "\17\uffff}>";
    static final String[] DFA70_transitionS = {
            "\1\1\1\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "182:15: ( INLINE )?";
        }
    }
    static final String DFA71_eotS =
        "\20\uffff";
    static final String DFA71_eofS =
        "\20\uffff";
    static final String DFA71_minS =
        "\1\44\17\uffff";
    static final String DFA71_maxS =
        "\1\171\17\uffff";
    static final String DFA71_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA71_specialS =
        "\20\uffff}>";
    static final String[] DFA71_transitionS = {
            "\1\1\2\uffff\15\1\105\uffff\1\17",
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
            ""
    };

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "182:53: ( parameter_list )?";
        }
    }
    static final String DFA73_eotS =
        "\20\uffff";
    static final String DFA73_eofS =
        "\20\uffff";
    static final String DFA73_minS =
        "\1\42\17\uffff";
    static final String DFA73_maxS =
        "\1\63\17\uffff";
    static final String DFA73_acceptS =
        "\1\uffff\1\1\1\2\15\uffff";
    static final String DFA73_specialS =
        "\20\uffff}>";
    static final String[] DFA73_transitionS = {
            "\1\1\2\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "198:4: ( SAFECALL )?";
        }
    }
    static final String DFA74_eotS =
        "\17\uffff";
    static final String DFA74_eofS =
        "\17\uffff";
    static final String DFA74_minS =
        "\1\43\16\uffff";
    static final String DFA74_maxS =
        "\1\63\16\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA74_specialS =
        "\17\uffff}>";
    static final String[] DFA74_transitionS = {
            "\1\1\1\2\3\uffff\14\2",
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
            ""
    };

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "198:14: ( INLINE )?";
        }
    }
    static final String DFA75_eotS =
        "\20\uffff";
    static final String DFA75_eofS =
        "\20\uffff";
    static final String DFA75_minS =
        "\1\44\17\uffff";
    static final String DFA75_maxS =
        "\1\171\17\uffff";
    static final String DFA75_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA75_specialS =
        "\20\uffff}>";
    static final String[] DFA75_transitionS = {
            "\1\1\2\uffff\15\1\105\uffff\1\17",
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
            ""
    };

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "198:57: ( parameter_list )?";
        }
    }
 

    public static final BitSet FOLLOW_external_declaration_in_translation_unit229 = new BitSet(new long[]{0x009FFFFC00000002L});
    public static final BitSet FOLLOW_function_definition_in_external_declaration280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_task_definition_in_external_declaration299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_definition_in_external_declaration313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_declaration_in_external_declaration324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_external_declaration329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAFECALL_in_function_definition340 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_INLINE_in_function_definition343 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_function_definition348 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_function_definition350 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_function_definition352 = new BitSet(new long[]{0x009FFFFC00000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_parameter_list_in_function_definition354 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_function_definition357 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_compound_statement_in_function_definition359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TASK_in_task_definition391 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_task_definition393 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_task_definition395 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_task_definition397 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_compound_statement_in_task_definition399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEDEF_in_declaration426 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_declaration428 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration430 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declaration432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAFECALL_in_declaration442 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_INLINE_in_declaration445 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_declaration450 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration452 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_declaration454 = new BitSet(new long[]{0x009FFFFC00000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_parameter_list_in_declaration456 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_declaration459 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declaration461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TASK_in_declaration487 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration489 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_declaration491 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_declaration493 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declaration495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_declaration510 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration514 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_declaration516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_declaration_specifiers531 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_declaration_specifiers534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list548 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_init_declarator_list563 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list567 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_declarator_in_init_declarator595 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_init_declarator603 = new BitSet(new long[]{0x1F60001000000000L,0x110000000C03C000L});
    public static final BitSet FOLLOW_initializer_in_init_declarator605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_type_specifier629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_type_specifier638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_type_specifier647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNSIGNED_in_type_specifier656 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_CHAR_in_type_specifier658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_type_specifier667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_in_type_specifier676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_type_specifier685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_type_specifier694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNSIGNED_in_type_specifier703 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_INT_in_type_specifier705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_type_specifier714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNSIGNED_in_type_specifier723 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LONG_in_type_specifier725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_type_specifier734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_type_specifier743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MUTEX_in_type_specifier752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_id_in_type_specifier761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type_id779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_in_enum_declaration801 = new BitSet(new long[]{0x0000001000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enum_declaration807 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_enum_declaration818 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_enum_declaration_list_in_enum_declaration820 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_enum_declaration822 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_enum_declaration824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_declarator_in_enum_declaration_list853 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_enum_declaration_list856 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_enum_declarator_in_enum_declaration_list858 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enum_declarator879 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_enum_declarator882 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_enum_declarator887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_enum_declarator893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEDEF_in_struct_definition928 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRUCT_in_struct_definition930 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_struct_definition932 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_struct_declaration_list_in_struct_definition934 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_struct_definition936 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_definition940 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_struct_definition942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_struct_definition948 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_definition952 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_struct_definition954 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_struct_declaration_list_in_struct_definition956 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_struct_definition958 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_struct_definition960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_declaration_in_struct_declaration_list995 = new BitSet(new long[]{0x000FFF1C00000002L});
    public static final BitSet FOLLOW_type_specifier_in_struct_declaration1014 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_struct_declarator_list_in_struct_declaration1018 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_struct_declaration1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_struct_declarator_list1038 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_struct_declarator_list1053 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_declarator_in_struct_declarator_list1057 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declarator1087 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_declarator_dimensions_in_declarator1096 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_declarator_dimensions1116 = new BitSet(new long[]{0x1F60000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_constant_in_declarator_dimensions1118 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_declarator_dimensions1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_list1141 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_parameter_list1144 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_list1146 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_declaration_specifiers_in_parameter_declaration1164 = new BitSet(new long[]{0x009FFFFC00000000L});
    public static final BitSet FOLLOW_declarator_in_parameter_declaration1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_initializer1193 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer1195 = new BitSet(new long[]{0x0000000000000000L,0x2800000000000000L});
    public static final BitSet FOLLOW_123_in_initializer1198 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer1200 = new BitSet(new long[]{0x0000000000000000L,0x2800000000000000L});
    public static final BitSet FOLLOW_125_in_initializer1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1219 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_argument_expression_list1222 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1224 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1245 = new BitSet(new long[]{0x0000000000000002L,0x0000000000028000L});
    public static final BitSet FOLLOW_PLUS_in_additive_expression1255 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_MINUS_in_additive_expression1261 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1266 = new BitSet(new long[]{0x0000000000000002L,0x0000000000028000L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1295 = new BitSet(new long[]{0x0000000000000002L,0x00000000001C0000L});
    public static final BitSet FOLLOW_STAR_in_multiplicative_expression1305 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplicative_expression1311 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_MOD_in_multiplicative_expression1317 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1322 = new BitSet(new long[]{0x0000000000000002L,0x00000000001C0000L});
    public static final BitSet FOLLOW_120_in_cast_expression1348 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_cast_expression1350 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_cast_expression1352 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_unary_expression_in_cast_expression1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expression_in_cast_expression1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfix_expression_in_unary_expression1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_operator_in_unary_expression1385 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_cast_expression_in_unary_expression1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_postfix_expression1409 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_126_in_postfix_expression1422 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_postfix_expression1424 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_postfix_expression1426 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_postfix_expression1447 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfix_expression1451 = new BitSet(new long[]{0x0000000000000002L,0x4000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_unary_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSPLUS_in_primary_expression1509 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_MINUSMINUS_in_primary_expression1515 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression1537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000014000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_primary_expression1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSMINUS_in_primary_expression1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression1575 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_primary_expression1577 = new BitSet(new long[]{0x1F60001000000000L,0x030000000C03C000L});
    public static final BitSet FOLLOW_argument_expression_list_in_primary_expression1579 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_primary_expression1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primary_expression1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_primary_expression1607 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_primary_expression1609 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_primary_expression1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_expression1697 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_expression1700 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_expression1702 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_postfix_expression_in_assignment_expression1722 = new BitSet(new long[]{0x0000000000000000L,0x00007FF000000000L});
    public static final BitSet FOLLOW_assignment_operator_in_assignment_expression1726 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_assignment_expression1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_expression_in_assignment_expression1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignment_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression1823 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_conditional_expression1830 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_conditional_expression1834 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_conditional_expression1836 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_conditional_expression1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1872 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_OROR_in_logical_or_expression1881 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1885 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1914 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_ANDAND_in_logical_and_expression1923 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1927 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1956 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_OR_in_inclusive_or_expression1965 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1969 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression1998 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_XOR_in_exclusive_or_expression2007 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression2011 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression2040 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_AND_in_and_expression2049 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression2053 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression2083 = new BitSet(new long[]{0x0000000000000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_EQUAL_in_equality_expression2093 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_equality_expression2099 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression2104 = new BitSet(new long[]{0x0000000000000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression2133 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_LESSTHAN_in_relational_expression2143 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_GREATERTHAN_in_relational_expression2149 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_relational_expression2155 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_relational_expression2161 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression2166 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_additive_expression_in_shift_expression2195 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_LSHIFT_in_shift_expression2205 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_RSHIFT_in_shift_expression2211 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_additive_expression_in_shift_expression2216 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_labeled_statement_in_statement2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_statement_in_statement2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_statement_in_statement2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iteration_statement_in_statement2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jump_statement_in_statement2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_task_statement_in_statement2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_labeled_statement2290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_labeled_statement2292 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_labeled_statement2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_compound_statement2315 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x350000000C03FFFCL});
    public static final BitSet FOLLOW_statement_list_in_compound_statement2317 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_compound_statement2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list2340 = new BitSet(new long[]{0x7FFFFFFC00000002L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_122_in_expression_statement2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expression_statement2363 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_expression_statement2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_selection_statement2380 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_selection_statement2382 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_selection_statement2384 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_selection_statement2386 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_selection_statement2388 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_selection_else_in_selection_statement2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_selection_statement2409 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_selection_statement2411 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_selection_statement2413 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_selection_statement2415 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_selection_statement2417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_selection_case_in_selection_statement2419 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000003L});
    public static final BitSet FOLLOW_selection_default_in_selection_statement2422 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_selection_statement2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_selection_else2464 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_selection_else2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_selection_case2486 = new BitSet(new long[]{0x1F60000000000000L});
    public static final BitSet FOLLOW_constant_in_selection_case2488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_selection_case2490 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_list_in_selection_case2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_selection_default2518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_selection_default2520 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_list_in_selection_default2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_iteration_statement2548 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_iteration_statement2554 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_REPEAT_in_iteration_statement2560 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_iteration_statement2563 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement2565 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_iteration_statement2567 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_iteration_statement2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_iteration_statement2585 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_iteration_statement2587 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_WHILE_in_iteration_statement2592 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_UNTIL_in_iteration_statement2598 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_iteration_statement2601 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement2603 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_iteration_statement2605 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_iteration_statement2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_iteration_statement2625 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_iteration_statement2627 = new BitSet(new long[]{0x1F60001000000000L,0x050000000C03C000L});
    public static final BitSet FOLLOW_expression_statement_in_iteration_statement2631 = new BitSet(new long[]{0x1F60001000000000L,0x050000000C03C000L});
    public static final BitSet FOLLOW_expression_statement_in_iteration_statement2635 = new BitSet(new long[]{0x1F60001000000000L,0x030000000C03C000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement2639 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_iteration_statement2642 = new BitSet(new long[]{0x7FFFFFFC00000000L,0x150000000C03FFFCL});
    public static final BitSet FOLLOW_statement_in_iteration_statement2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOTO_in_jump_statement2684 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_jump_statement2686 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_jump_statement2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_jump_statement2701 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_jump_statement2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_jump_statement2714 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_jump_statement2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_jump_statement2727 = new BitSet(new long[]{0x1F60001000000000L,0x050000000C03C000L});
    public static final BitSet FOLLOW_expression_in_jump_statement2729 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_jump_statement2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_START_in_task_statement2755 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_STOP_in_task_statement2761 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_task_statement2764 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_task_statement2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIORITY_in_task_statement2780 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_task_statement2782 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_task_statement2784 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_task_statement2786 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_task_statement2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAFECALL_in_synpred5_NXC258 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_INLINE_in_synpred5_NXC261 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_synpred5_NXC264 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred5_NXC266 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred5_NXC268 = new BitSet(new long[]{0x009FFFFC00000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_parameter_list_in_synpred5_NXC270 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred5_NXC273 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_synpred5_NXC275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TASK_in_synpred6_NXC286 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred6_NXC288 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred6_NXC290 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred6_NXC292 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_synpred6_NXC294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEDEF_in_synpred8_NXC305 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_STRUCT_in_synpred8_NXC308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_in_synpred9_NXC319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAFECALL_in_synpred17_NXC442 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_INLINE_in_synpred17_NXC445 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_synpred17_NXC450 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred17_NXC452 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_synpred17_NXC454 = new BitSet(new long[]{0x009FFFFC00000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_parameter_list_in_synpred17_NXC456 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred17_NXC459 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_synpred17_NXC461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_synpred54_NXC1348 = new BitSet(new long[]{0x000FFF1C00000000L});
    public static final BitSet FOLLOW_type_specifier_in_synpred54_NXC1350 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_synpred54_NXC1352 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_unary_expression_in_synpred54_NXC1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_synpred75_NXC1700 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_synpred75_NXC1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfix_expression_in_synpred76_NXC1722 = new BitSet(new long[]{0x0000000000000000L,0x00007FF000000000L});
    public static final BitSet FOLLOW_assignment_operator_in_synpred76_NXC1726 = new BitSet(new long[]{0x1F60001000000000L,0x010000000C03C000L});
    public static final BitSet FOLLOW_assignment_expression_in_synpred76_NXC1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_else_in_synpred111_NXC2390 = new BitSet(new long[]{0x0000000000000002L});

}