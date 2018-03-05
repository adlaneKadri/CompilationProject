public class ElementTS {

    private  String type ;
    private  String name ;
    private  int declared ;
    private  int defined ;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getDeclared() {
        return declared;
    }

    public int getDefined() {
        return defined;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeclared(int declared) {
        this.declared = declared;
    }

    public void setDefined(int defined) {
        this.defined = defined;
    }

    public ElementTS(String name,String type , int declared, int defined) {
        this.type = type;
        this.name = name;
        this.declared = declared;
        this.defined = defined;
    }

    public  ElementTS(){

    }

    @Override
    public String toString() {
        return "|" +
                " name:'" + name + '\'' +
                " | declared:" + declared +
                " | defined:" + defined +
                " | type:'" + type + '\'' +
                '|';
    }

}

