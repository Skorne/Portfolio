package Controllers;

import Models.ReimbTicket;
import Models.User;
import Service.Service;
import Service.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
import java.util.Objects;

public class TicketController {

    public TicketController(){

    }

    public static void getTickets(Context context){
        Service service= new ServiceImpl();
        User user= context.sessionAttribute("currentUser");

        List<ReimbTicket> ticketList= service.getTicketList(user);
        context.json(ticketList);
    }

    public static void createNewTicket(Context context){
        Service service= new ServiceImpl();

        String amount= context.formParam("Amount");
        String description= context.formParam("description");
        String type= context.formParam("TypeRadioButton");

        User user= context.sessionAttribute("currentUser");

        ReimbTicket ticket= new ReimbTicket(Double.parseDouble(amount), description, type);
        service.createNewTicket(context.sessionAttribute("currentUser"), ticket);
        context.redirect("/ticketViewer.html");
    }

    public static void decideTicket(Context context){
        Service service= new ServiceImpl();

        int ticketID= Integer.parseInt(Objects.requireNonNull(context.formParam("ticketID")));
        String ticketStatus= Objects.requireNonNull(context.formParam("decision"));

        ReimbTicket ticket= service.getTicketByID(ticketID);
        ticket.setStatus(ticketStatus);
        service.decideTicket(context.sessionAttribute("currentUser"), ticket);
        context.redirect("/managerTickerViewer.html");
    }
}
