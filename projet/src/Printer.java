import java.util.ArrayList;

public class Printer {

    /*//TypeOfErrors
     static final String WARNINGS = new String("WARNINGS");
     static final String IMPORTANT_COMMENTS = new String("IMPORTANTCOMMENTS");
     static final String RANDOM_COMMENTS =new String("RANDOMCOMMENTS") ;
     static final String COMPILER_TEXTS = new String("COMPILERTEXTS");
     static final String MORE_INFORMATIONS = new String("MOREINFORMATIONS");
     static final String ERROR = new String("ERROR");
    static final String TYPEINCOMPATIBLE = new String("ERROR");

    //Where we find these errors
     static final String Semantic = "SEMANTIC_ERRORS";
     static final String Quad = "QUAD_GENRATION";

     //
     ArrayList<String> problem = new ArrayList<>();
     ArrayList<String> whereThisProblem = new ArrayList<>();



*/

    public Printer() {
    }



    public void PrinteMessage(String text, String Semantique_quadruplé)
    {
        //if((problemType & problem) != 0 && (whereThisProblem & Semantique_quadruplé) != 0)
            System.out.println(Semantique_quadruplé + " : \n " + ": " +text+" \n------------------");
    }

}
