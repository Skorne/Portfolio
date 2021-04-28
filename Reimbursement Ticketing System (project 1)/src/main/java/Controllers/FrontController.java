package Controllers;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class FrontController {
    Javalin app;
    Dispatcher dispatcher;

    public FrontController(Javalin app){
        this.app= app;
        app.before("/api/*", FrontController::checkAllRequests);
                
                
        dispatcher= new Dispatcher(app);
    }

    private static void checkAllRequests(Context context) {
        if(context.sessionAttribute("currentUser")== null){
            System.out.println("not logged in");
            context.redirect("/index.html");
        }
    }
}