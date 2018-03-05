grammar TinyLanguage_SII;

program : 'Compil' NOM_PROGRAME '('  ')' '{' declaration+ 'start' instruction+ '}'
;

declaration : type  variables ';'
;

type : 'intcompil'  | 'floatcompil'
;

variables :  NOM_VARIABLE',' variables |  NOM_VARIABLE
;

instruction : affectation  | lecture | ecriture | instruction_conditionnelle
;

affectation : NOM_VARIABLE '='  expression ';'
;


expression : expression  op1 expression1 | expression1
;

op1: '+'| '-'
;

expression1: expression1 op2 expression2 | expression2
;

op2: '*' |'/'
;
expression2: '('expression ')' | terme
;

terme : NOM_VARIABLE | NOMBRE_ENTIER | NOMBRE_REEL
;

lecture :  'scancompil' '(' variables ')' ';'
;

ecriture:  'printcompil' '(' print ')' ';'
;

print: MESSAGE  |variables|  MESSAGE ',' print |variables ',' print|
;

instruction_conditionnelle : 'if' '(' condition ')' 'then' instruction+  instruction_else?  ENDIF ';'
;

instruction_else : 'else' instruction+
;

condition:  expression comparateur expression
;

comparateur : '<' | '>' | '==' | '<=' | '>=' | '!='
;


NOM_PROGRAME : [A-Z][a-zA-Z0-9]*
;
ENDIF:'endif'
;
NOM_VARIABLE : [a-zA-Z][a-zA-Z0-9]*
;
NOMBRE_ENTIER : [0]|[1-9][0-9]*
;
NOMBRE_REEL:([0]|[1-9][0-9]*)'.'[0-9]*[1-9] | [1-9][0-9]*
;

MESSAGE : '"'(~["]|'\\"')*'"'
;


COMMENT : '/*' .*? '*/' -> channel(HIDDEN)
;

LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
;


WS : [ \t\n\r]+ -> channel(HIDDEN)
;





