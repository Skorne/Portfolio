package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsersDAOImpl implements UsersDAO{

    public static String url =
            "jdbc:postgresql://database-chan.cz2dcuuxy0ge.us-west-2.rds.amazonaws.com/ERS";
    public static String username = "adminuser";
    public static String password = "p4ssw0rd";
    //final static Logger loggy = Logger.getLogger(UsersDAOImpl.class);


    /**@param userName user name
     * @return [password, username, userRole, firstname, lastname, userID]
     */
    @Override
    public List<String> logIn(String userName) {
        try(
                Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="SELECT eu.ers_password, eu.ers_username, eur.user_role, " +
                    "user_first_name, user_last_name, ers_user_id\n" +
                    "FROM ers_users eu JOIN ers_user_roles eur \n" +
                    "ON eu.ers_user_id = eur.ers_user_role_id \n" +
                    "WHERE ers_username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userName);


            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                List<String> output = new ArrayList<>();
                output.add(rs.getString(1));
                output.add(rs.getString(2));
                output.add(rs.getString(3));
                output.add(rs.getString(4));
                output.add(rs.getString(5));
                output.add(Integer.toString(rs.getInt(6)));
                return output;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
