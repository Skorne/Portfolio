package DAO;

import Models.ReimbTicket;
import io.javalin.http.util.JsonEscapeUtil;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbDAOImpl implements ReimbDAO{
    public static String url =
            "jdbc:postgresql://database-chan.cz2dcuuxy0ge.us-west-2.rds.amazonaws.com/ERS";
    public static String username = "adminuser";
    public static String password = "p4ssw0rd";


    /**@param userID user's id number
     * @return list of items to be turned into ticket objects
     * [amount, desc, author, status, type]
     * to be used for employee level access
     */
    @Override
    public List<ReimbTicket> getTicketList(int userID) {
        try(
                Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, \n" +
                    "r.reimb_description, u.user_first_name, ersu.user_first_name, s.reimb_status, t.reimb_type\n" +
                    "FROM ers_reimbursement r \n" +
                    "JOIN ers_users u ON r.reimb_author = u.ers_user_id\n" +
                    "LEFT JOIN ers_users ersu ON r.reimb_resolver = ersu.ers_user_id \n" +
                    "JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id \n" +
                    "JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id\n" +
                    "WHERE r.reimb_author = ? " +
                    "ORDER BY r.reimb_id";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);

            ResultSet rs= ps.executeQuery();
            List<ReimbTicket> output = new ArrayList<>();
            while(rs.next()){
                output.add(new ReimbTicket(
                        rs.getInt(1),
                        rs.getDouble(2),
                        String.valueOf(rs.getTimestamp(3)),
                        String.valueOf(rs.getTimestamp(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }

            return output;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**@return list of items to be turned into ticket objects
     * [amount, desc, author, status, type]
     * to be used for manager level access
     */
    @Override
    public List<ReimbTicket> getTicketList() {
        try(
                Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, \n" +
                    "r.reimb_description, u.user_first_name, ersu.user_first_name, s.reimb_status, t.reimb_type\n" +
                    "FROM ers_reimbursement r \n" +
                    "JOIN ers_users u ON r.reimb_author = u.ers_user_id\n" +
                    "LEFT JOIN ers_users ersu ON r.reimb_resolver = ersu.ers_user_id \n" +
                    "JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id \n" +
                    "JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id\n" +
                    "ORDER BY r.reimb_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs= ps.executeQuery();
            List<ReimbTicket> output = new ArrayList<>();
            while(rs.next()) {
                output.add(new ReimbTicket(
                        rs.getInt(1),
                        rs.getDouble(2),
                        String.valueOf(rs.getTimestamp(3)),
                        String.valueOf(rs.getTimestamp(4)),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }

            return output;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**@param userID user's id number
     * @param ticket ticket object being added
     * @return true if successful
     */
    @Override
    public boolean addNewTicket(int userID, ReimbTicket ticket) {
        try(
                Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="INSERT INTO ers_reimbursement \n" +
                    "(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)\n" +
                    "VALUES (?, current_timestamp, ?, ?, \n" +
                    "(SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status= 'Pending'),\n" +
                    "(SELECT reimb_type_id FROM ers_reimbursement_type WHERE reimb_type= ?))";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ticket.getAmount());
            ps.setString(2, ticket.getDescription());
            ps.setInt(3, userID);
            ps.setString(4, ticket.getReimbType());

            ps.executeUpdate();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**@param ticketID ticket being updated's ID
     * @param userID user's ID who is updating
     * @param status updated status
     * @return true if successfully updated
     */
    @Override
    public boolean updateTicket(int ticketID, int userID, String status) {
        try(
                Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="UPDATE ers_reimbursement \n" +
                    "SET reimb_resolver = ?, reimb_resolved=  current_timestamp, \n" +
                    "reimb_status_id = (SELECT reimb_status_id FROM ers_reimbursement_status WHERE reimb_status= ?)\n" +
                    "WHERE reimb_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setString(2, status);
            ps.setInt(3, ticketID);

            ps.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**@param id ticket ID
     * @return ticket with associated ID
     */
    @Override
    public ReimbTicket getTicketByID(int id){
        try(Connection conn = DriverManager.getConnection(url, this.username, this.password)){

            String sql ="SELECT r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, \n" +
                    "r.reimb_description, u.user_first_name, ersu.user_first_name, s.reimb_status, t.reimb_type\n" +
                    "FROM ers_reimbursement r \n" +
                    "JOIN ers_users u ON r.reimb_author = u.ers_user_id\n" +
                    "LEFT JOIN ers_users ersu ON r.reimb_resolver = ersu.ers_user_id \n" +
                    "JOIN ers_reimbursement_status s ON r.reimb_status_id = s.reimb_status_id \n" +
                    "JOIN ers_reimbursement_type t ON r.reimb_type_id = t.reimb_type_id\n" +
                    "WHERE reimb_id =?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs= ps.executeQuery();
            rs.next();
            return new ReimbTicket(
                    rs.getInt(1),
                    rs.getDouble(2),
                    String.valueOf(rs.getTimestamp(3)),
                    String.valueOf(rs.getTimestamp(4)),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9));

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
