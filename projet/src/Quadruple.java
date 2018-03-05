import java.util.ArrayList;
import java.util.Arrays;

public class Quadruple {


    //private ArrayList<String> quad = new ArrayList<>();

    private  String[] quad;
    public Quadruple(String q1, String q2, String q3, String q4) {

       /* quad.add(q1);
        quad.add(q2);
        quad.add(q3);
        quad.add(q4);*/
        quad = new String[4];
        quad[0] = q1;
        quad[1] = q2;
        quad[2] = q3;
        quad[3] = q4;

    }

    public Quadruple(String[] quad) {

        this.quad=quad;

    }
    public String get(int index)
    {
        return quad[index];
    }

    public void set(int index, String q)
    {
        quad[index] = q;
    }

    public Quadruple() {}

    /*public void setQuad(ArrayList<String> quad) {
        this.quad = quad;
    }*/

    /*public ArrayList<String> getQuad() {
        return quad;
    }*/

    /*public void setQuad(String q1, String q2, String q3, String q4) {
        ArrayList<String> quadr = new ArrayList<>();
        quadr.add(q1);
        quadr.add(q2);
        quadr.add(q3);
        quadr.add(q4);
        this.setQuad(quadr);
    }*/

    /*  autre traitement */

   /* public void setQuad(int q , String valeur){
        quad.add(q,valeur);
    }
    public String getQuad(int QC) {
        return quad.get(QC);
    }*/
    /* ----------------
    @Override
    public String toString() {
        return "( " +this.quad.get(0)+
                " , " +this.quad.get(1) +
                " , " +this.quad.get(2) +
                " , " +this.quad.get(3)+" )";

    }*/

    @Override
    public String toString() {
        return "( "+quad[0]+" , "+quad[1]+" , "+quad[2]+" , "+quad[3]+" )";
    }

    public void displayQuadruple(){
        System.out.println();
    }

    public int size(){
        return this.size();
    }
}
