package controller;

import io.javalin.http.Context;
import models.User;
import service.UserService;
import service.UserServiceImpl;

public class UserController {
    private static UserService userServiceLayer = new UserServiceImpl();
    UserController(){

    }
    /** Logs out a User by setting ctx.sessionAttribute("currentUser") equal to null*/
        public void logout(Context ctx){
            User currUser = ctx.sessionAttribute("currentUser");
            currUser  = null;
            ctx.sessionAttribute("currentUser", currUser);
            ctx.redirect("/");
        }

    /**
     * -Creates a new user by calling the UserService interface's createUser method.
     *
     * @param context
     * @author Nick Haselden
     */
    public void createUser(Context context){
        User user = context.bodyAsClass(User.class);
        userServiceLayer.createUser(user);
        context.json("New Account Created").status(201);
    }
}
