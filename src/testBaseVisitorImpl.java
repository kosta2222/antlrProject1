import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.System.exit;

/**
 * Created by papa on 03.02.2017.
 */
public class testBaseVisitorImpl extends testBaseVisitor<Void> {
    @Override
    public Void visitR(testParser.RContext ctx) {
        Date d=new Date();
        SimpleDateFormat sdf=null;
        Locale l1=new Locale("russian");
        int n= 0;
        try {
            n = Integer.parseInt(ctx.ID().getText());
        } catch (NumberFormatException e) {
            System.out.println("Nepravilniy indificator");
            exit(1);
        }
        if (n==1) {

          sdf=new SimpleDateFormat("dd MM yyyy",l1);
          String s1=sdf.format(d);

            System.out.println(s1);
        }else if(n==2){
           /* try {
                n = Integer.parseInt(ctx.ID().getText());
            } catch (NumberFormatException e) {
                System.out.println("Nepravilniy indificator");
                exit(1);
            }*/

            System.out.println("Perehali v Rossiu:2005 year");
        }
        return null;
    }
}
