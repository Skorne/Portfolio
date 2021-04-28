import Controllers.FrontController;
import io.javalin.Javalin;

public class MainDriver {
    public static void main(String[] args) {
        Javalin app= Javalin.create(

                config-> {
                    config.addStaticFiles("/html-pages");
                    config.addStaticFiles("/CSS");
                    config.addStaticFiles("/Java-Script");
                }
        ).start(9336);
        FrontController fc= new FrontController(app);
    }
}
