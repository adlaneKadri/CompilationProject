import java.util.ArrayList;
import java.util.Optional;

public class TableSymbole {

    private ArrayList<ElementTS> TS = new ArrayList<>();


    public void AddInTS(ElementTS E) {
        TS.add(E);
    }

    public Optional<ElementTS> LookUP(String name) {
        return  TS.stream().filter(e -> e.getName().equals(name)).findFirst();
    }

    public void DisplayTableOfSymbole(String winORlose) {

        if(winORlose.equals("lose")) {

                // pour chaque element on le rend un toString et aprés j'affiche
                System.err.println("______________________________________________________\n" +
                        "|" +
                        "  name   " +
                        " |  declared " +
                        " |  defined " +
                        " |     type        " +
                        '|' +
                        "\n______________________________________________________");
                TS.stream().map(ElementTS::toString).forEach(System.err::println);
                System.err.println("______________________________________________________\n");
        }else{
                // pour chaque element on le rend un toString et aprés j'affiche
                System.out.println("______________________________________________________\n" +
                        "|" +
                        "  name   " +
                        " |  declared " +
                        " |  defined " +
                        " |     type        " +
                        '|' +
                        "\n______________________________________________________");
                TS.stream().map(ElementTS::toString).forEach(System.out::println);
                System.out.println("______________________________________________________\n");
        }
    }
}
