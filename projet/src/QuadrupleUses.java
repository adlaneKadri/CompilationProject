import java.util.ArrayList;

public class QuadrupleUses  {

    ArrayList<Quadruple> quadruples = new ArrayList<>();


    public QuadrupleUses() {
    }

    public int addQuadruple(String q1, String q2, String q3, String q4)
    {
        return addQuadruple(new Quadruple(q1,q2,q3,q4));
    }

    public int addQuadruple(Quadruple quaduple)
    {
        quadruples.add(quaduple);
        return quadruples.size()-1;
    }

    /*public String getQuad(int QC , int positionQuad)
    {
        return quadruples.get(QC).getQuad(positionQuad);
    }*/
     /*
    public void setQuad(int QC , int positionQuad, String q) {
            this.quadruples.get(QC).setQuad(positionQuad,q);

    }

    public Quadruple getQuad(int q){
        return quadruples.get(q);
    }
   */

    public Quadruple getQuad(int qc)
    {
        return quadruples.get(qc);
    }
    public int size()
    {
        return quadruples.size();
    }


    public void DisplayQuad() {
        // pour chaque element on le rend un toString et aprés j'affiche
        System.out.println("--------->: QUADRUPLE :<--------\n");
        quadruples.stream().map(Quadruple->" Q"+quadruples.indexOf(Quadruple)+" : | "+Quadruple.toString()+" ").forEach(System.out::println);
        System.out.println("_______________________________\n");

    }
}
