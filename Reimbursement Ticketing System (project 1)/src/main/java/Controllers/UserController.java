package Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import Models.LoginInfo;
import Models.User;
import Service.Service;
import Service.ServiceImpl;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class UserController {

    Javalin app;

    public UserController(){

    }


    public static void logIn(Context context){
        String username= context.formParam("username");
        String password= context.formParam("password");
        LoginInfo userinfo = new LoginInfo(username, password);

        Service service = new ServiceImpl();
        User user = service.logIn(userinfo.getUsername(), userinfo.getPassword());
        if(user==null){
            context.redirect("/index");
            return;
        }

        context.sessionAttribute("currentUser", user);
        if(user.getRole().equals("Employee")) {
            context.redirect("/ticketViewer.html");
        }
        if(user.getRole().equals(("Manager"))){
            context.redirect(("/managerTickerViewer.html"));
        }

    }

    public static void logOut(Context context){
        System.out.println("logout handler fired");
        context.sessionAttribute("currentUser", null);
        User user = context.sessionAttribute("currentUser");
        System.out.println(user);
    }

}
