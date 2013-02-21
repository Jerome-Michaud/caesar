grammar NXC;

options {
    backtrack=true;
    memoize=true;
    k=2;
    output=AST;
}

tokens {
	ROOT;					FUNCTION_DEFINITION;	FUNCTION_DECLARATION;	PARAMETERS;
	TASK_DEFINITION;		TASK_DECLARATION;		VAR_DECLARATION;		DIMENSION;
	STRUCT_FIELD;			INITIALIZER;			STATEMENTS;				CAST;
	DIMENSION_ACCESS;		FIELD_ACCESS;			PRE;					POST;
	FUNC_CALL;				ARGUMENTS;				LABEL;					TERNARY;

	T_VOID;		T_S8;		T_U8;		T_S16;		T_U16;
	T_S32;		T_U32;		T_FLOAT;	T_STRING;	T_MUTEX;
}

scope Type {
Object type;
}

@header {
/*
 * Le contenu de ce fichier est généré par la biblithèque ANTLR
 * à partir du fichier NXC.g
 */
package jscratch.interpreteur.parser;

import java.util.LinkedList;
}

@members {
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
}

@lexer::header {
/*
 * Le contenu de ce fichier est généré par la biblithèque ANTLR
 * à partir du fichier NXC.g
 */
package jscratch.interpreteur.parser;

import java.util.List;
import java.util.LinkedList;
}

@lexer::members {
List<WarningOrError> compilMessages = new LinkedList<WarningOrError>();

public void emitErrorMessage(String msg) {}

public void reportError(RecognitionException e) {
	this.compilMessages.add(new WarningOrError(e.line, e.charPositionInLine, true, "Problème avec le caractère "+Character.toString((char)e.c)));
}

public List<WarningOrError> getCompilMessages() {
	return this.compilMessages;
}
}

translation_unit
	: external_declaration+ -> ^(ROOT external_declaration+)
	;

external_declaration
options {k=1;}
	: (SAFECALL? INLINE? type_specifier IDENTIFIER '(' parameter_list? ')' '{') => function_definition
	| (TASK IDENTIFIER '(' ')' '{') => task_definition
	| (TYPEDEF? STRUCT) => struct_definition
	| (ENUM) => enum_declaration
	| declaration
	;

function_definition
	: SAFECALL? INLINE? type=type_specifier IDENTIFIER '(' parameter_list? ')' compound_statement -> ^(FUNCTION_DEFINITION $type IDENTIFIER SAFECALL? ^(PARAMETERS parameter_list?) compound_statement);

task_definition
	: TASK IDENTIFIER '(' ')' compound_statement -> ^(TASK_DEFINITION T_VOID IDENTIFIER compound_statement );

declaration
scope Type;
	: TYPEDEF type_specifier IDENTIFIER ';' { typeTranslation.put($IDENTIFIER.text, $type_specifier.tree); } -> 
	| SAFECALL? INLINE? type=type_specifier IDENTIFIER '(' parameter_list? ')' ';' -> ^(FUNCTION_DECLARATION $type IDENTIFIER SAFECALL? ^(PARAMETERS parameter_list?))
	| TASK IDENTIFIER '(' ')' ';' -> ^(TASK_DECLARATION T_VOID IDENTIFIER)
	| declaration_specifiers {$Type::type = $declaration_specifiers.tree;} init_declarator_list ';' -> init_declarator_list
	;

declaration_specifiers
	: CONST? type_specifier
	;

init_declarator_list
	: (d=init_declarator -> ^(VAR_DECLARATION {$Type::type} $d)) (',' d=init_declarator -> $init_declarator_list ^(VAR_DECLARATION {$Type::type} $d))*
	;

init_declarator
	: (declarator -> declarator) ('=' initializer -> $init_declarator ^(INITIALIZER initializer))?
	;

type_specifier
	: VOID -> T_VOID
	| SUB -> T_VOID
	| CHAR -> T_S8
	| UNSIGNED CHAR -> T_U8
	| BOOL -> T_U8
	| BYTE -> T_U8
	| SHORT -> T_S16
	| INT -> T_S16
	| UNSIGNED INT -> T_U16
	| LONG -> T_S32
	| UNSIGNED LONG -> T_U32
	| FLOAT -> T_FLOAT
	| STRING -> T_STRING
	| MUTEX -> T_MUTEX
	| type_id
	;

type_id
    :   { isTypeName(input.LT(1).getText()) }? IDENTIFIER -> { translateType($IDENTIFIER.text) }
//		{System.out.println($IDENTIFIER.text+" is a type");}
    ;

enum_declaration
    : ENUM ((n=IDENTIFIER -> T_U32) {typeTranslation.put($n.text, $enum_declaration.tree);})? '{' enum_declaration_list '}' ';' -> 
    ;

enum_declaration_list
scope {int value;}
@init {$enum_declaration_list::value = 0;}
    : enum_declarator (',' enum_declarator)*
    ;

enum_declarator
    : n=IDENTIFIER ('=' (v=DECIMAL_LITERAL | v=HEX_LITERAL) {$enum_declaration_list::value = Integer.decode($v.text).intValue();})?
    {enumValues.put($n.text, new Integer($enum_declaration_list::value++));}
    ;

struct_definition
options {k=3;}
	: (	(TYPEDEF STRUCT '{' struct_declaration_list '}' n=IDENTIFIER ';'
		| STRUCT n=IDENTIFIER '{' struct_declaration_list '}' ';'
		) -> ^(STRUCT $n struct_declaration_list)
	  ) { typeTranslation.put($n.text, $struct_definition.tree); } ->
	;

struct_declaration_list
	: struct_declaration+
	;

struct_declaration
scope Type;
	: type=type_specifier {$Type::type = $type.tree;} struct_declarator_list ';' -> struct_declarator_list
	;

struct_declarator_list
	: (d=declarator -> ^(STRUCT_FIELD {$Type::type} $d)) (',' d=declarator -> $struct_declarator_list ^(STRUCT_FIELD {$Type::type} $d))*
	;

declarator
	: (i=IDENTIFIER -> $i) (declarator_dimensions -> $declarator declarator_dimensions)* ;
	
declarator_dimensions
	: '[' constant? ']' -> ^(DIMENSION constant?)
	;

parameter_list
	: parameter_declaration (',' parameter_declaration)* -> parameter_declaration+
	;

parameter_declaration
	: declaration_specifiers declarator -> ^(VAR_DECLARATION declaration_specifiers declarator)
	;
	
initializer
	: assignment_expression
	| '{' assignment_expression (',' assignment_expression)* '}'
	;

// E x p r e s s i o n s

argument_expression_list
	:   assignment_expression (',' assignment_expression)* -> assignment_expression+
	;

additive_expression
	: (a=multiplicative_expression->$a) ((s='+' | s='-') b=multiplicative_expression -> ^($s $additive_expression $b))*
	;

multiplicative_expression
	: (a=cast_expression->$a) ((s='*' | s='/' | s='%') b=cast_expression -> ^($s $multiplicative_expression $b))*
	;

cast_expression
	: '(' type_specifier ')' unary_expression -> ^(CAST type_specifier unary_expression)
	| unary_expression
	;

unary_expression
	: postfix_expression
	| unary_operator cast_expression -> ^(unary_operator cast_expression)
	;

postfix_expression
	: (a=primary_expression->$a)
		(	(l='[' expression ']' -> ^(DIMENSION_ACCESS $postfix_expression expression))
		|   ('.' i=IDENTIFIER -> ^(FIELD_ACCESS $postfix_expression $i))
		)*
	;

unary_operator
	: '+'
	| '-'
	| '~'
	| '!'
	;

primary_expression
	: (s='++' | s='--') IDENTIFIER -> ^(PRE $s IDENTIFIER)
	| (a=IDENTIFIER -> $a) ((s='++' | s='--') -> ^(POST $s $primary_expression))?
	| IDENTIFIER '(' argument_expression_list? ')' -> ^(FUNC_CALL IDENTIFIER ^(ARGUMENTS argument_expression_list?))
	| constant
	| '(' assignment_expression ')' -> assignment_expression
	;

constant
    :   HEX_LITERAL
    |   DECIMAL_LITERAL
    |	CHARACTER_LITERAL
    |	STRING_LITERAL
    |   FLOAT_LITERAL
    |   TRUE | FALSE
    ;

/////

expression
	: assignment_expression (',' assignment_expression)* -> assignment_expression+
	;

assignment_expression
	: a=postfix_expression s=assignment_operator b=assignment_expression -> ^($s $a $b)
	| conditional_expression
	;

assignment_operator
	: '='
	| '+='
	| '-='
	| '*='
	| '/='
	| '%='
	| '<<='
	| '>>='
	| '&='
	| '|='
	| '^='
	;

conditional_expression
	: (a=logical_or_expression->$a) ('?' b=expression ':' c=expression -> ^(TERNARY $conditional_expression $b $c))?
	;
	
logical_or_expression
	: (a=logical_and_expression->$a) (s='||' b=logical_and_expression -> ^($s $logical_or_expression $b))*
	;

logical_and_expression
	: (a=inclusive_or_expression->$a) (s='&&' b=inclusive_or_expression -> ^($s $logical_and_expression $b))*
	;

inclusive_or_expression
	: (a=exclusive_or_expression->$a) (s='|' b=exclusive_or_expression -> ^($s $inclusive_or_expression $b))*
	;

exclusive_or_expression
	: (a=and_expression->$a) (s='^' b=and_expression -> ^($s $exclusive_or_expression $b))*
	;

and_expression
	: (a=equality_expression->$a) (s='&' b=equality_expression -> ^($s $and_expression $b))*
	;
	
equality_expression
	: (a=relational_expression->$a) ((s='==' | s='!=') b=relational_expression -> ^($s $equality_expression $b))*
	;

relational_expression
	: (a=shift_expression->$a) ((s='<' | s='>' | s='<=' | s='>=') b=shift_expression -> ^($s $relational_expression $b))*
	;

shift_expression
	: (a=additive_expression->$a) ((s='<<' | s='>>') b=additive_expression -> ^($s $shift_expression $b))*
	;

// S t a t e m e n t s

statement
	: labeled_statement
	| compound_statement
	| expression_statement
	| selection_statement
	| iteration_statement
	| jump_statement
	| task_statement
	| declaration
	;

labeled_statement
	: IDENTIFIER ':' statement -> ^(LABEL IDENTIFIER statement)
	;

compound_statement
	: '{' statement_list? '}' -> ^(STATEMENTS statement_list?)
	;

statement_list
	: statement+
	;

expression_statement
	: ';' -> ^(TRUE)
	| expression ';' -> expression
	;

selection_statement
	: IF '(' expression ')' statement selection_else? -> ^(IF expression statement selection_else?)
	| SWITCH '(' expression ')' '{' selection_case+ selection_default? '}' -> ^(SWITCH expression selection_case+ selection_default?)
	;
	
selection_else
	: (options {k=1; backtrack=false;}:ELSE statement) -> ^(ELSE statement)
	;

selection_case
	: CASE constant ':' statement_list -> ^(CASE constant ^(STATEMENTS statement_list))
	;
	
selection_default
	: DEFAULT ':' statement_list -> ^(DEFAULT ^(STATEMENTS statement_list))
	;

iteration_statement
	: (type=WHILE | type=UNTIL | type=REPEAT) '(' expression ')' statement -> ^($type expression statement)
	| DO statement (type=WHILE | type=UNTIL) '(' expression ')' ';' -> ^(DO $type expression statement)
	| FOR '(' a=expression_statement b=expression_statement c=expression? ')' statement -> ^(FOR ^(DO $a) ^(WHILE $b) ^(REPEAT $c) statement)
	;

jump_statement
	: GOTO IDENTIFIER ';' -> ^(GOTO IDENTIFIER)
	| CONTINUE ';' -> ^(CONTINUE)
	| BREAK ';' -> ^(BREAK)
	| RETURN expression? ';' -> ^(RETURN expression?)
	;

task_statement
	: (s=START | s=STOP) IDENTIFIER ';' -> ^($s IDENTIFIER)
	| PRIORITY IDENTIFIER ',' DECIMAL_LITERAL ';' -> ^(PRIORITY IDENTIFIER DECIMAL_LITERAL)
	;




	
BOOL: 		'bool';		BREAK:		'break';	BYTE:		'byte';		CASE:		'case';
CHAR:		'char';		CONST:		'const';	CONTINUE:	'continue';	DEFAULT:	'default';
DO:			'do';		ELSE:		'else';		ENUM:		'enum';		FALSE:		'false';
FLOAT:		'float';	FOR:		'for';		GOTO:		'goto';		IF:			'if';
INLINE:		'inline';	INT:		'int';		LONG:		'long';		MUTEX:		'mutex';
PRIORITY:	'priority';	REPEAT:		'repeat';	RETURN:		'return';	SAFECALL:	'safecall';
SHORT:		'short';	START:		'start';	STOP:		'stop';		STRING:		'string';
STRUCT:		'struct';	SUB:		'sub';		SWITCH:		'switch';	TASK:		'task';
TRUE:		'true';		TYPEDEF:	'typedef';	UNSIGNED:	'unsigned';	UNTIL:		'until';
VOID:		'void';		WHILE:		'while';

PLUSPLUS:	'++';		PLUS:		'+';		MINUSMINUS: '--';		MINUS:		'-';
STAR:		'*';		DIVIDE:		'/';		MOD:		'%';		LSHIFT:		'<<';
RSHIFT:		'>>';		AND:		'&';		OR:			'|';		XOR:		'^';
TILDE:		'~';		NOT:		'!';		ANDAND:		'&&';		OROR:		'||';
EQUAL:		'==';		NOTEQUAL:	'!=';		LESSEQUAL:	'<=';		LESSTHAN:	'<';
GREATEREQUAL:'>=';		GREATERTHAN:'>';		ASSIGN:		'=';		PLUSASSIGN:	'+=';
MINUSASSIGN:'-=';		STARASSIGN:	'*=';		DIVASSIGN:	'/=';		MODASSIGN:	'%=';
LSHIFTASSIGN:'<<=';		RSHIFTASSIGN:'>>=';		ANDASSIGN:	'&=';		ORASSIGN:	'|=';
XORASSIGN:	'^=';

IDENTIFIER
	: LETTER (LETTER|'0'..'9')*
	;
	
fragment
LETTER
	: 'A'..'Z'
	| 'a'..'z'
	| '_'
	;

CHARACTER_LITERAL : '\'' ( EscapeSequence | ~('\''|'\\') ) '\'' ;

STRING_LITERAL : '"' ( EscapeSequence | ~('\\'|'"') )* '"' ;

HEX_LITERAL : '0' ('x'|'X') HexDigit+ ;

DECIMAL_LITERAL : '0'..'9'+ ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

FLOAT_LITERAL
    : ('0'..'9')+ '.' ('0'..'9')* Exponent?
    | '.' ('0'..'9')+ Exponent?
    | ('0'..'9')+ Exponent
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
EscapeSequence
    : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\');

EOL	: ('\r' '\n' | '\r' | '\n') {$channel=HIDDEN;} ;

WHITESPACE  :  (' '|'\t'|'\u000C') {skip();} ;

COMMENT
    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;} ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* EOL {$channel=HIDDEN;} ;

UNK	: . {$channel=HIDDEN; this.compilMessages.add(new WarningOrError($line, $pos , false, "Caractère "+$text+" ignoré car non reconnu."));} ;
