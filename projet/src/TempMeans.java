public class TempMeans {
 public     Quadruple quad;

 public     String q1;
 public     String q2;
 public     String q3;
 public     String q4;

    public TempMeans(Quadruple quad, String q1, String q2, String q3, String q4) {
        this.quad = quad;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
    }

    public TempMeans() {
    }

        @Override
        public String toString() {
        return "" +
                " " + quad.toString()+
                " , ----------------------------- -------------------->( " + q1 + " , "+q2+ " , "+q3+ " , "+q4+ " ) ";
    }


}
