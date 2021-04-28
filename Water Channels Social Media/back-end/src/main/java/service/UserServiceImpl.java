package service;

import dao.UserDaoImpl;
import models.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDaoImpl userDao = new UserDaoImpl();

    /**
     * Creates new user in DB, pass in all user info except ID
     * @param newUser All info except ID, that's generated in the DB.
     */
    @Override
    public void createUser(User newUser) {
        userDao.createUser(newUser);
    }

    /**
     * Returns all users as a list
     * @return all users
     */
    @Override
    public List<User> readAllUsers() {

        return userDao.readAllUsers();
    }

    /**
     * Returns a specific user chosen by ID
     * @param id target user's ID
     * @return the user with the matching ID
     */
    @Override
    public User readUser(int id) {
        return userDao.readUser(id);
    }

    /**
     * Returns user with that name. If none found, returns null. Prints out if no user found
     * @param username Username to be found
     * @return 1st user by that name (should be unique), or null if none found.
     */
    @Override
    public User readUser(String username) {
        return userDao.readUser(username);
    }

    /**
     * Replaces old user data in the DB with new user data given as input. Id should never change!
     * @param user The new data
     */
    @Override
    public void updateUserContents(User user) {
        userDao.updateUserContents(user);
    }

    /**
     * Deletes chosen user
     * @param user Full user object
     */
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
