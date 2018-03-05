import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.ArrayList;

public class Code_obj {
    private Quadruple quad;
    private String inst="";

    private final static String MOV="MOV";
    private final static String INC="INC";
    private final static String DEC="DEC";
    private final static String ADD="ADD";
    private final static String SUB="SUB";
    private final static String MUL="MUL";
    private final static String DIV="DIV";

    private final static String CMP="CMP";
    private final static String JMP="JMP"; // just jump
    private final static String JB="JB";
    private final static String JBE="JBE"; // below or equal
    private final static String JG="JG";
    private final static String JGE="JGE"; // greater or equal
    private final static String JZ="JZ";
    private final static String JNZ="JNZ"; // below or equal


 /*
    private final static String IF="IF";
    private final static String THEN="THEN";
    private final static String ENDIF="ENDIF";
    private final static String ELSE="ELSE";
*/

    private final static String AX="AX";
    private final static String BX="BX";

    private ArrayList<Integer> branchements=new ArrayList<>();



    public Code_obj(QuadrupleUses tabQuad) {

    // Premier parcours pour connaitre l'emplacement des etiquettes
        for (int j=0;j<tabQuad.size();j++) {
            quad=tabQuad.getQuad(j);
            if (quad.get(0).startsWith("B")) {// C'est un branchement
                branchements.add(Integer.parseInt(quad.get(1)));
            }

        }


        for (int i=0;i<tabQuad.size();i++) {

         quad=tabQuad.getQuad(i);
         // On ajoute l'etiq si elle correspond à un branchement
         if (branchements.contains(i))
         {inst=inst+"ETIQ"+String.valueOf(i)+":\n\t\t\t\t\t\t";}

         switch (quad.get(0)) {
             case "+": inst=inst+MOV+" "+AX+","+quad.get(1)+"\n\t\t\t\t\t\t";
                       inst=inst+ ADD+" "+AX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                       inst=inst+MOV+ " "+quad.get(3)+","+AX+"\n\t\t\t\t\t\t";


             break;

             case "-": inst=inst+MOV+" "+AX+","+quad.get(1)+"\n\t\t\t\t\t\t";
                       inst=inst+ SUB+" "+AX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                       inst=inst+MOV+" "+ quad.get(3)+","+AX+"\n\t\t\t\t\t\t";

             break;

             case "*": inst=inst+MOV+" "+AX+","+quad.get(1)+"\n\t\t\t\t\t\t";
                       inst=inst+ MUL+" "+AX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                       inst=inst+MOV+ quad.get(3)+","+AX+"\n\t\t\t\t\t\t";


             break;

             case "/": inst=inst+MOV+" "+AX+","+quad.get(1)+"\n\t\t\t\t\t\t";
                       inst=inst+ DIV+" "+AX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                       inst=inst+MOV+ quad.get(3)+","+AX+"\n\t\t\t\t\t\t";


             break;

             case "=": inst=inst+MOV+" "+AX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                       inst=inst+MOV+" "+quad.get(3)+","+AX+"\n\t\t\t\t\t\t";


             break;

             case "BR":inst=inst+JMP+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";


             break;

             case "BP":  inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                         inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                         inst=inst+CMP+" "+AX+","+BX+"\n\t\t\t\t\t\t";
                         inst=inst+JG+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";


             break;

             case "BPZ": inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                         inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                         inst=inst+CMP+" "+AX+","+BX+"\n\t\t\t\t\t\t";
                         inst=inst+JGE+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";



                 break;

             case "BM": inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                        inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                        inst=inst+CMP+" "+AX+","+BX+"\n\t\t\t\t\t\t";
                        inst=inst+JB+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";



                 break;

             case"BMZ": inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                        inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                        inst=inst+CMP+" "+AX+","+BX+"\n";
                        inst=inst+JBE+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";



                 break;


             case "BZ": inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                        inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                        inst=inst+CMP+" "+AX+","+BX+"\n";
                        inst=inst+JZ+" ETIQ "+quad.get(1)+"\n";



                 break;

             case "BNZ": inst=inst+MOV+" "+AX+","+quad.get(3)+"\n\t\t\t\t\t\t";
                         inst=inst+MOV+" "+BX+","+quad.get(2)+"\n\t\t\t\t\t\t";
                         inst=inst+CMP+" "+AX+","+BX+"\n\t\t\t\t\t\t";
                         inst=inst+JNZ+" ETIQ "+quad.get(1)+"\n\t\t\t\t\t\t";



                 break;



         }


     }

    }



    public void  Display_Code_Obj() {
        System.out.println("\n\n\n\n\n");

        System.out.println("\n-------------------:> [OBJECT CODE] <:-------------------\n");
        System.out.println("\t\t\t\t\t\t"+inst);
        System.out.println("___________________________________________________________\n\n");



    }



}
