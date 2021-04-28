package dao;

import Util.HibernateUtil;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class UserDaoImpl implements UserDao{
    /**
     * Creates new user in DB, pass in all user info except ID
     * @param newUser All info except ID, that's generated in the DB.
     */
    @Override
    public void createUser(User newUser) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(newUser);

        transaction.commit();
    }

    /**
     * Returns all users as a list
     * @return all users
     */
    @Override
    public List<User> readAllUsers() {

        Session session = HibernateUtil.getSession();

        List<User> allUsers = session.createQuery("from User", User.class).list();
        return allUsers;
    }

    /**
     * Returns a specific user chosen by ID
     * @param id target user's ID
     * @return the user with the matching ID
     */
    @Override
    public User readUser(int id) {
        Session session = HibernateUtil.getSession();

        User user = session.get(User.class, id);

        return user;
    }

    /**
     * Returns user with that name. If none found, returns null. Prints out if no user found
     * @param username Username to be found
     * @return 1st user by that name (should be unique), or null if none found.
     */
    @Override
    public User readUser(String username) {
        Session session = HibernateUtil.getSession();

        List<User> user = session.createQuery
                ("from User where username = '"+username+"';", User.class).list();
        if(user.get(0) != null)
        return user.get(0);

        else {
            System.out.println("User not found");
            return null;
        }
    }

    /**
     * Replaces old user data in the DB with new user data given as input. Id should never change!
     * @param user The new data
     */
    @Override
    public void updateUserContents(User user) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);
        transaction.commit();
    }

    /**
     * Deletes chosen user
     * @param user Full user object
     */
    @Override
    public void deleteUser(User user) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
    }
}
