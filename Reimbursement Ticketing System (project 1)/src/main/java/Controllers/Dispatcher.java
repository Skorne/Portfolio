package Controllers;

import io.javalin.Javalin;
import org.eclipse.jetty.util.DateCache;

public class Dispatcher {

    public Dispatcher(Javalin app){
        setupPaths(app);
    }

    public static void setupPaths(Javalin app){
        app.post("/api", UserController::logIn);
        app.get("/api/logout", UserController::logOut);
        app.get("/api/ticketlist", TicketController::getTickets);
        app.get("/api/managerTicketList", TicketController::getTickets);
        app.post("/api/ticketlist/update",
                TicketController::decideTicket);
        app.post("/api/ticketlist/create", TicketController::createNewTicket);
    }
}
