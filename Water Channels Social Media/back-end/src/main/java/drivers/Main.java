package drivers;


import Util.HibernateUtil;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        /*
        *  Note ALL front end things should be within a directory that is added as a staticFile within Javalin.create
        * */
        Javalin app = Javalin.create(
                config-> {//config.addStaticFiles("/html-pages/");
                    //config.addStaticFiles("/javascript/");
                    //config.addStaticFiles("/css/");
                }
        ).start(9008);


        //HibernateUtil.closeSession();
    }
}



