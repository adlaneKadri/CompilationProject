import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.ArrayList;

public class MainClass {

    private static int channel;

    public static void main(String[] args) throws IOException {



        //pour recuperer le programme a tester

        /*************************************************************************************/
        /*/                 //Programme with errors lexer,                                   //
        /*/           //CharStream file = CharStreams.fromFileName("programLexerTest");      //
        /*/                                                                                  //
        /*/                                                                                  //
        /*/                 // Programme With Semantic errors                                //
        /*/            CharStream file = CharStreams.fromFileName("programSemanticTest");    //
        /*/                                                                                  //
        /*/                                                                                  //
        /*/                     // a programme --> no errors                                 //
        /*/            //CharStream file = CharStreams.fromFileName("programNoErrors");      //
        /*/                                                                                  //
        /************************************************************************************/

        /*
                    on donne le programme a tester comme paramétre a la classe LExer
                                pour quelle le traite lexicalement
         */
        TinyLanguage_SIILexer lexer = new TinyLanguage_SIILexer(file);

        // aprés avoir traiter lexicalement le programme , on aura des token ' mots '
        // pour avoir des token , on a utilisé la classe TokenStream
        TokenStream tokenStream = new CommonTokenStream(lexer);

        // les Token obtneu sont utilisé pour le parser , qui va traité la semantique de notre compilateur
        // Parser a des methode pour chaque No-terminal
        TinyLanguage_SIIParser parser = new TinyLanguage_SIIParser(tokenStream);

        //gestion d'erreur : pour
        //parser.removeErrorListener(ConsoleErrorListener.INSTANCE);


        //ici c'est pour avoir l'axion de notre langage,  'dans notre cas : program'
        TinyLanguage_SIIParser.ProgramContext Axiom = parser.program();

        //walker comme l'indique son nom, he walk and find errors
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        //TinyLanguage_SIIBaseListener listener = new TinyLanguage_SIIBaseListener();
        //treeWalker.walk(listener, Axiom);


        //le traitement d'erreur ici,  notre maniére de traiter les erreurs, classe semantique
        SII_Listener OwnSemanticListenr = new SII_Listener();

        //  maint le WALKER il va utiliser notre sematique et
        // trouver les erreurs qu'on traite dans notre classe SII_Listenr
        treeWalker.walk(OwnSemanticListenr, Axiom);


        QuadG_BaseListener OwnQuadListener = new QuadG_BaseListener();
        treeWalker.walk(OwnQuadListener, Axiom);

        //*************


        //Thanks


    }

}