import java.util.ArrayList;

public class Erreur {
    private final static String DOUBLE_DEF = "DOUBLE DECLARATION DE LA VARIABLE : ";
    private final static String INCOMPATIBILITE_TYPE = "INCOMPATIBLITE DE TYPE DANS L'EXPRESSION: ";
    private final static String UNDECLARED_ID = "VARIABLE NON DECLARER : ";
    private final static String SYNTAX_ERROR = "ERREUR SYNTAXIQUE : ";
    private final static String UNDEFINED = "VARIABLE N'A PAS DE VALEUR : ";
    private final static String INCOMPATIBILITE_TYPE_OF_CONDITION = "INCOMPATIBLITE DE TYPE DANS LA CONDITION : ";
    private ArrayList<String> listeErreur;


    public Erreur() {
        listeErreur = new ArrayList<>();
    }

    void Double_def(String var) {
       if (!listeErreur.contains(DOUBLE_DEF + var))
            listeErreur.add(DOUBLE_DEF + var);
    }

    void unDefined(String var) {
        if (!listeErreur.contains(UNDEFINED + var))
            listeErreur.add(UNDEFINED + var);
    }

    void syntax_error(String var) {
        if (!listeErreur.contains(SYNTAX_ERROR + var))
            listeErreur.add(SYNTAX_ERROR + var);
    }

    void Type_incompatible(String exp) {
        if (!listeErreur.contains(INCOMPATIBILITE_TYPE + exp))
            listeErreur.add(INCOMPATIBILITE_TYPE + exp);
    }

    void typeConditionincompatible(String exp) {
        if (!listeErreur.contains(INCOMPATIBILITE_TYPE_OF_CONDITION + exp))
            listeErreur.add(INCOMPATIBILITE_TYPE_OF_CONDITION + exp);
    }

    void notDeclared(String var) {
        if (!listeErreur.contains(UNDECLARED_ID + var))
        listeErreur.add(UNDECLARED_ID + var);
    }

    public boolean No_Errors() {
        return listeErreur.isEmpty();
    }

    public void Display_Errors() {
        listeErreur.
                stream().
                map(error -> "Error N°" + listeErreur.indexOf(error) + " : " + error).
                forEach(System.err::println);
    }
}



