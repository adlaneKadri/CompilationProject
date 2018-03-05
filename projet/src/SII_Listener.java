import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Optional;

class SII_Listener extends TinyLanguage_SIIBaseListener {
    //  private static int undeclared=0;
    private static int defined = 1;
    private TableSymbole ts = new TableSymbole();
    private Erreur erreur = new Erreur();
    private HashMap<ParserRuleContext, String> types = new HashMap<>();
    private Printer printer = new Printer();

    //si y'en a des erreurs syntaxique ou lexicale
    public static Boolean lexerErrorFound =false;

    @Override
    public void exitProgram(TinyLanguage_SIIParser.ProgramContext ctx) {
        if(!lexerErrorFound) {
                if (anySemanticErrors()) {
                    System.out.printf("BRAVO/ NO ERROR DETECTED!");
                    displaySymbolTable("win");
                } else {
                    System.err.println("ERRORS SEMANTIC DETECTED:");

                    displayErrors();
                    displaySymbolTable("lose");

                }
        }else{
            System.err.println("\n\n...ERRORS DETECTED, SEE YOUR CODE AGAIN");
        }
    }

    @Override
    public void exitDeclaration(TinyLanguage_SIIParser.DeclarationContext ctx) {
        //recupérer le Type des variables
        String type = ctx.type().getText();
        // recupérer la Liste des variables du meme type dans 'vars'
        TinyLanguage_SIIParser.VariablesContext vars = ctx.variables();

        for (; vars != null; vars = vars.variables()) {
            String varName = vars.getChild(0).getText();
            Optional<ElementTS> p = ts.LookUP(varName);
            if (p.isPresent()) erreur.Double_def(varName);
            else ts.AddInTS(new ElementTS(varName, type, 1, 0));
        }
    }

    @Override
    public void enterInstruction(TinyLanguage_SIIParser.InstructionContext ctx) {

        //System.out.println(ctx.getParent().getText());
    }

    @Override
    public void exitAffectation(TinyLanguage_SIIParser.AffectationContext ctx) {
        /* ------------------------------------------------------------
                    // HERE TP PRINT THE AFFECT EXPRESSION :
            System.out.println("\t\t\t      " + ctx.getText());
         ------------------------------------------------------------ */

        // Check if nomvariable is declared
        String varName = ctx.NOM_VARIABLE().getText();
        Optional<ElementTS> p = ts.LookUP(varName);
        if (!p.isPresent()) {
            erreur.notDeclared(varName);
        } else {
            // pour recupérer le type du variable
            String type_id = p.get().getType();

            /* -----------------------------------------------------------------
                            //here to print the variable Type :
             System.out.println(" " + ctx.NOM_VARIABLE() + " Type : " + type_id);
             ------------------------------------------------------------------- */

            // maint la variable si elle n'est pas définé ( n'a pas une valeau)  elle sera définie ( aura une valeur )
            p.get().setDefined(1);

                /*Check la compatibilité
                  Pour obtenir la compatibilité de l'expression c'est tt une histoire , a chaque valeur on enregistre le type avec la ccontexte pour ensuite
                  a l'aide} du contexte obtenir le type de la valeur */

            String type_exp = getType(ctx.expression());
            /*------------------------------------------------------------------------
                        //HERE TO PRINT THE EXPRESSIONN WITH ITS TYPE
            System.out.println(" \t " + ctx.expression().getText() + " : " + type_exp);
            ----------------------------------------------------------------------------*/
            if (!typeCompatible(type_id, type_exp).isPresent()) {
                erreur.Type_incompatible(ctx.getText());
            }
        }

        // a la fin d chaque affectation on aura plus besoin de types d expression de cette affection alors on va vider le HASHMAP 'TYPES'

        clearTypeHashMap();

    }

    @Override
    public void exitExpression(TinyLanguage_SIIParser.ExpressionContext ctx) {
        String typeOfExp1 = getType(ctx.expression1());


        // ici : pour traiter le cas d'affectation d'une variable qui n'a pas de valeur , ,  ,   a <- 5+b ;  et b  declarer mais  n'a pas de valeur
        Optional<ElementTS> p = ts.LookUP(ctx.getText());
        if (p.isPresent()) {
            if (p.get().getDefined()==0) erreur.unDefined(p.get().getName());
        }


        //System.out.println("Exp: " + ctx.getChild(0).getText()+ " : "+getType(ctx.expression1()));
        if (ctx.expression() == null) {
            if (typeOfExp1 != null)
                ajouterType(ctx, typeOfExp1);


        } else {
            String typeOfExp = getType(ctx.expression());
                    //  if we have : float opert int || int oper float  : typePriority is :: float  else it return int

                 ajouterType(ctx, typePriority(typeOfExp, typeOfExp1).get());


                 /* Pour affiché les priorité entre deux expression : */
                //System.out.println("Priority betwwen : "+ ctx.expression().getText()+"  , "+ctx.expression1().getText()+" :: "+typePriority(typeOfExp,typeOfExp1).get());


        }

    }


    @Override public void exitExpression1(TinyLanguage_SIIParser.Expression1Context ctx) {

        String typeOfExp1 = getType(ctx.expression1());
        String typeOfExp2 = getType(ctx.expression2());

          // ici : pour traiter le cas d'affectation d'une variable qui n'a pas de valeur , ,  ,   a <- 5+b ;  et b  declarer mais  n'a pas de valeur
        Optional<ElementTS> p = ts.LookUP(ctx.getText());
        if (p.isPresent()) {
            if (p.get().getDefined()==0) erreur.unDefined(p.get().getName());
        }

        if (ctx.expression1() == null) {
            ajouterType(ctx, typeOfExp2);
        } else {
            // System.out.println("Priority betwwen : "+ ctx.expression1().getText()+"  , "+ctx.expression2().getText()+" :: "+typePriority(typeOfExp1,typeOfExp2).get());

            ajouterType(ctx, typePriority(typeOfExp1, typeOfExp2).get());
        }

    }


    @Override
    public void exitExpression2(TinyLanguage_SIIParser.Expression2Context ctx) {

        if (ctx.terme() != null) {
            //System.out.println(" Terme Not Null ->"+ ctx.terme().getText()+" :: "+ getType(ctx.terme()));
            ajouterType(ctx, getType(ctx.terme()));
        } else {
            if (ctx.expression() != null) {
                //System.out.println("( Terme null "+ctx.expression().getText()+"  ) :: " +getType(ctx.expression()));
                ajouterType(ctx, getType(ctx.expression()));
            }
        }
    }

    @Override
    public void exitTerme(TinyLanguage_SIIParser.TermeContext ctx) {
        if ((ctx.NOM_VARIABLE() != null)) {
            //Recuperer le type de l'id et l'ajouter aux types
            // Verifier si la var est declaré ou nn
            String varName = ctx.NOM_VARIABLE().getText();
            Optional<ElementTS> p = ts.LookUP(varName);
            if (p.isPresent()) ajouterType(ctx, p.get().getType());
            else {
                erreur.notDeclared(varName);
                ajouterType(ctx, "NOTYPE");
                }
        } else {
            if (ctx.NOMBRE_ENTIER() == null) ajouterType(ctx, "floatcompil");
            else ajouterType(ctx, "intcompil");
        }
    }

    @Override
    public void exitLecture(TinyLanguage_SIIParser.LectureContext ctx) {
      if (!lexerErrorFound) {
              // recupérer la Liste des variables qu'on veut lire
              TinyLanguage_SIIParser.VariablesContext vars = ctx.variables();

              for (; vars != null; vars = vars.variables()) {
                  String varName = vars.getChild(0).getText();
                  Optional<ElementTS> p = ts.LookUP(varName);
                  if (!p.isPresent()) erreur.notDeclared(varName);
                  else p.get().setDefined(1);
              }
      }
    }

    @Override
    public void exitEcriture(TinyLanguage_SIIParser.EcritureContext ctx) {
       // System.out.println( ctx.print().getText());
    }

    @Override
    public void exitPrint(TinyLanguage_SIIParser.PrintContext ctx) {
        TinyLanguage_SIIParser.VariablesContext vars = ctx.variables();
        // System.out.println(" :: "+ctx.variables().getText());
        for (; vars != null; vars = vars.variables()) {
            String varName = vars.getChild(0).getText();
            //System.out.println(" "+varName);
            Optional<ElementTS> p = ts.LookUP(varName);
            //System.out.println("varsOfPrint = " + vars.getChild(0).getText());

            if (!p.isPresent()) erreur.notDeclared(varName);
            else if (p.get().getDefined() == 0) erreur.unDefined(varName);
        }

        /*
            if(ctx.print()==null) {
            //System.out.println("THE LAST PRINT "+ctx.getChild(0).getText());
            // CASE : print null ie: --->| MESSAGE  | variables |

                    if (ctx.variables() !=null) {
                         // ctx.getText() : --->  | variables
                        // la c'est pour recupérer les variable a printer
                            TinyLanguage_SIIParser.VariablesContext vars = ctx.variables();
                           // System.out.println(" :: "+ctx.variables().getText());
                            for (; vars != null; vars = vars.variables()) {
                                String varName = vars.getChild(0).getText();
                                System.out.println(" "+varName);
                                Optional<ElementTS> p = ts.LookUP(varName);
                                //System.out.println("varsOfPrint = " + vars.getChild(0).getText());

                                if (!p.isPresent()) erreur.notDeclared(varName);
                                else if (p.get().getDefined() == 0) erreur.unDefined(varName);
                            }
                    }
                    // else { // ctx.getText() : --->| MESSAGE  |    et la On fait rien ( le traitement du message : coté syntaxiue }


        }else {
            // Print Not vide ie:--> print ',' variables | print  ',' MESSAGE |
            TinyLanguage_SIIParser.VariablesContext vars = ctx.variables();

            for (; vars != null; vars = vars.variables()) {
                //     System.out.println("varsOfPrint = " + varsOfPrint.getChild(0).getText());
                String varName =         vars.getChild(0).getText();

                System.out.println(" "+varName);
                Optional<ElementTS> p = ts.LookUP(varName);
                if (!p.isPresent()) erreur.notDeclared(varName);
                else if (p.get().getDefined()==0) {erreur.unDefined(varName);}
            }

        }*/
    }

    @Override
    public void exitInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx) {
        //instruction_conditionnelle : 'if' '(' condition ')' 'then' instruction+  instruction_else?  ENDIF ';'

        //System.out.println(" " + ctx.getText());

        /*-------------------------
          instruction est déja traité :
                //System.out.println(" "+ctx.getChild(5).getText());

         -------------------------- */
    }

    @Override
    public void exitInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx) {
    }

    @Override
    public void exitCondition(TinyLanguage_SIIParser.ConditionContext ctx) {
        //condition:  expression comparateur expression

		String typeLeft = getType((ParserRuleContext) ctx.getChild(0));
		String typeRight = getType((ParserRuleContext) ctx.getChild(2));
        //System.out.println("typLeft = " + typeLeft);
        //System.out.println("typRight = " + typeRight);
        if (!typeCompatible(typeLeft,typeRight).isPresent()) erreur.typeConditionincompatible(ctx.getText());

    }

    @Override
    public void exitComparateur(TinyLanguage_SIIParser.ComparateurContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        //erreur.syntax_error(node.getParent().getText());
        //erreur.syntax_error(" Errors ");
        lexerErrorFound = true;
    }


    /****************************** USING THIS METHODS ************************/
    void ajouterType(ParserRuleContext ctx, String type) {
        types.put(ctx, type);
    }

    String getType(ParserRuleContext ctx) {
        return types.get(ctx);
    }

    Optional<String> typeCompatible(String type_id, String type_exp) {
        //  System.out.println("type_id = " + type_id);
        //  System.out.println("type_exp = " + type_exp);

        if (type_id.equals("floatcompil")) return Optional.of("floatcompil");

        if (type_exp.equals("intcompil")) return Optional.of("intcompil");

        if (type_id.equals("intcompil")  && type_exp.equals("floatcompil")) return Optional.empty();

        return Optional.empty();
    }

    Optional<String> typePriority(String type_exp1, String type_exp2) {
        //System.out.println("type_id = " + type_id);
        //System.out.println("type_exp = " + type_exp);
        if (type_exp1.equals("NONTYPE") && type_exp2.equals("NONTYPE")) return Optional.of("NONTYPE");
        if (type_exp1.equals("NONTYPE") && type_exp2.equals("floatcompil")) return Optional.of("floatcompil");
        if (type_exp1.equals("floatcompil") && type_exp2.equals("NONTYPE")) return Optional.of("floatcompil");
        if (type_exp1.equals("NONTYPE") && type_exp2.equals("intcompil")) return Optional.of("intcompil");
        if (type_exp1.equals("intcompil") && type_exp2.equals("NONTYPE")) return Optional.of("intcompil");
        if (type_exp1.equals("floatcompil") || type_exp2.equals("floatcompil")) return Optional.of("floatcompil");
        else return Optional.of("intcompil");
    }

    public boolean anySemanticErrors(){
        return erreur.No_Errors();
    }

    void displayErrors(){
        System.err.println("\n---------------------------->: |ERRORS| :<-------------------------------");
        erreur.Display_Errors();
        System.err.println("_________________________________________________________________________\n");

    }

    void displaySymbolTable(String winORlose){
       if(winORlose.equals("lose"))
            System.err.println("\n-------------------:> [SYMBOL TABLE] <:-------------------");
       else
            System.out.println("\n-------------------:> [SYMBOL TABLE] <:-------------------");

        ts.DisplayTableOfSymbole(winORlose);
    }

    void clearTypeHashMap(){
        types.clear();
    }

    public SII_Listener() {
        this.erreur = erreur;
    }
}

