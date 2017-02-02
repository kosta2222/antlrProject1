/**
 * Created by papa on 03.02.2017.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
class Main
{
    public static void main (String[] args)
    {

//String input = "public static void main(String[] args) { }";
        InputStream is=System.in;
        Reader r=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(r);
        String st="";
        System.out.println("REPL input:");
        while(!st.equals("q")){
            try{
                st=br.readLine();
            }catch(Exception e)
            {

                System.out.println("Error: "+e);
            }


            CharStream cs = new ANTLRInputStream(st);
            testLexer lexer = new testLexer(cs);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            testParser parser = new testParser(tokens);
            if(!st.equals("q")){
                ParseTree tree = parser.r(); // begin parsing at r rule
// print LISP-style tree
                /*System.out.println(tree.toStringTree(parser));*/

                testBaseVisitorImpl visitor = new testBaseVisitorImpl();


                 visitor.visit(tree);
                /*System.out.println("Result: " + result);*/
            }


        }
    }
}