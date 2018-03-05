import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class QuadG_BaseListener extends TinyLanguage_SIIBaseListener{


    QuadrupleUses tabQuad = new QuadrupleUses();
    Quadruple quad;
    Pile pile = new Pile();
    private int compteurTEMPS = 0;     // NUM DU TEMPORAIRE UTILISE DANS LES QUADS
    private  Code_obj code_obj;


    /* CES DEUX ETAPES SONT EN PLUS : */
    ArrayList<TempMeans> quadTable =  new ArrayList<>(); //   TempMeans :    ( + , temp1 , temp2 , temp3 )  ------> ( + , valeur(temp1) , valeur(temp2) , valeur(temp3) )
    private HashMap<String, String> valeur = new HashMap<>();  // POUR RECUPERER LE CONTENU DU temp'i'
    /* ---- */

    private int sauv_condition ;
    private int sauv_conditionDeb=0;

    /* <-----------------------------------------------: START CODING :----------------------------------------------> */

    @Override
    public void exitProgram(TinyLanguage_SIIParser.ProgramContext ctx) {
        tabQuad.addQuadruple(new Quadruple("END",""+(tabQuad.size()+1)," " ," "));
        if (!SII_Listener.lexerErrorFound){
        /* Affichage des Quadruple : */
        displayQuadruple();

         /* Affichage du code objet : */
        code_obj= new Code_obj(tabQuad);
        code_obj.Display_Code_Obj();


        /* if u can't understand what 'temp [i] '  means ,  use  this method :*/
         displayQuadrupleWithShowingTempMeaning();}
    }

    @Override
    public void exitAffectation(TinyLanguage_SIIParser.AffectationContext ctx) {
       // System.out.println(ctx.getText());   // c'est pour afficher les affectations ;
        String idf = ctx.getChild(0).getText();
        String resultatAFF = pile.depiler();
        tabQuad.addQuadruple(new Quadruple("=","",resultatAFF,idf));

        /* - ICI  JUSTE  POUR DES TRAITEMENT SUPlEMENTAIRE : POUR MONTRER LA VALEUR CONTENANT temp'i' - */
        String expression = ctx.expression().getText();
        if (getVal(ctx.expression().getText()) != null)  expression = getVal(ctx.expression().getText());
        TempMeans a = new TempMeans(new Quadruple("=","",resultatAFF,idf),"="," ", expression,idf);
        quadTable.add(a);
        /* ----------------------------------------------------------------------------------------------- */


        // a la fin de chaque affectation on doit vider la pile :
        pile.ViderPile(); // nn obligatoire car la pile sera deja vide
    }
    
    @Override
    public void exitExpression(TinyLanguage_SIIParser.ExpressionContext ctx) {

        if(ctx.expression() != null)
        {
            String temp = "Temp"+(++compteurTEMPS);

            String expVal = pile.depiler();
            String exp1Val = pile.depiler();

            tabQuad.addQuadruple(new Quadruple(ctx.op1().getText(),expVal,exp1Val,temp));
            pile.empiler(temp);


             /* - ICI  JUSTE  POUR DES TRAITEMENT SUPLUMENTAIRE : POUR MONTRER LA VALEUR CONTENANT temp'i' - */
            String NexpVal = expVal ;
            String Nexp1Val =exp1Val ;
            if (getVal(exp1Val) != null)  Nexp1Val = getVal(exp1Val);
            if (getVal(expVal)!= null) NexpVal =getVal(expVal);
            TempMeans a = new TempMeans(new Quadruple(ctx.op1().getText(),expVal,exp1Val,temp),
                    ctx.op1().getText(),Nexp1Val,NexpVal,ctx.expression().getText() +""+ctx.op1().getText()+""+ctx.expression1().getText());
            quadTable.add(a); // ON RAJOUTE UN TUPLE DE TYPE 'TempMean'  QUI MONTRE APRES CE QUI temp CONTIENT
            addVal(temp,ctx.getText()); // POUR RECUPER LE CONTENU DES  temps

            /* ----------------------------------------------------------------------------------------- */
         }


        // tabQuad.addQuadruple(quad);
    }

    @Override
    public void exitExpression1(TinyLanguage_SIIParser.Expression1Context ctx) {

        if(ctx.expression1() != null)
        {
            String temp = "Temp"+(++compteurTEMPS);

            String expVal = pile.depiler();
            String exp1Val = pile.depiler();

            tabQuad.addQuadruple(new Quadruple(ctx.op2().getText(),expVal,exp1Val,temp));
            pile.empiler(temp);


             /* - ICI  JUSTE  POUR DES TRAITEMENT SUPLUMENTAIRE : POUR MONTRER LA VALEUR CONTENANT temp'i' - */
            String NexpVal = expVal ;
            String Nexp1Val =exp1Val ;
            if (getVal(exp1Val) != null)  Nexp1Val = getVal(exp1Val);
            if (getVal(expVal)!= null) NexpVal =getVal(expVal);
            TempMeans a = new TempMeans(new Quadruple(ctx.op2().getText(),expVal,exp1Val,temp),
                    ctx.op2().getText(),Nexp1Val,NexpVal,ctx.expression1().getText() +""+ctx.op2().getText()+""+ctx.expression2().getText());
            quadTable.add(a); // ON RAJOUTE UN TUPLE DE TYPE 'TempMean'  QUI MONTRE APRES CE QUI temp CONTIENT
            addVal(temp,ctx.getText());   // POUR RECUPER LE CONTENU DES  temps
            /* -----------------------------------------------------------------*/
        }

    }


    @Override
    public void exitExpression2(TinyLanguage_SIIParser.Expression2Context ctx) {
         // On empile le dernier element de l'expression
        if( ctx.terme()!=null) {
            pile.empiler(ctx.terme().getText());
        }else {
            if (ctx.expression() != null) {
                pile.empiler(ctx.expression().getText());
            }
        }
    }

    @Override
    public void exitCondition(TinyLanguage_SIIParser.ConditionContext ctx) {
        String exp1Val = pile.depiler();
        String expVal = pile.depiler();


                if(ctx.getChild(1).getText().equals("<"))  {
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BGE","",expVal,exp1Val));
                }
                if(ctx.getChild(1).getText().equals("<=")){
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BG","",expVal,exp1Val));
                }
                if(ctx.getChild(1).getText().equals(">")){
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BLE","",expVal,exp1Val));
                }
                if(ctx.getChild(1).getText().equals(">=")){
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BL","",expVal,exp1Val));
                }
                if(ctx.getChild(1).getText().equals("==")){
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BNE","",expVal,exp1Val));
                }
                if(ctx.getChild(1).getText().equals("!=")){
                    sauv_condition = tabQuad.addQuadruple(new Quadruple("BE","",expVal,exp1Val));
                }

                if (sauv_conditionDeb==0)sauv_conditionDeb=sauv_condition;
    }

    @Override 
    public void exitInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx) {

        tabQuad.getQuad(sauv_condition).set(1,""+(tabQuad.size()));


    }

    @Override public void enterInstruction_conditionnelle(TinyLanguage_SIIParser.Instruction_conditionnelleContext ctx) {
        //System.out.println(ctx.condition().getText());
    }



    @Override
    public void enterInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx) {
        sauv_condition = tabQuad.addQuadruple("BR","","","");
        tabQuad.getQuad(sauv_condition).set(1,""+(tabQuad.size()+1));

        if (sauv_conditionDeb !=0 )
           if (tabQuad.getQuad(sauv_conditionDeb).get(1).equals(""))
               tabQuad.getQuad(sauv_conditionDeb).set(1,""+(tabQuad.size()));

    }

    @Override
    public void exitInstruction_else(TinyLanguage_SIIParser.Instruction_elseContext ctx) {


    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    /******************* SOME METHOD WE USED ******************/

    public  void displayQuadruple(){
        tabQuad.DisplayQuad();
    }

    public void displayQuadrupleWithShowingTempMeaning(){
        System.out.println("----------------------->: QUADRUPLE WITH TEMP MEANS :<-------------------------\n");
        quadTable.stream().map(elem->"| "+elem.toString()+" ").forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------\n");
    }

    void addVal(String expression, String val) {
        valeur.put(expression, val);
    }

    String getVal(String expression) {
        return valeur.get(expression);
    }
}