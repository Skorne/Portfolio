package Service;

import DAO.ReimbDAO;
import DAO.ReimbDAOImpl;
import DAO.UsersDAO;
import Models.ReimbTicket;
import Models.User;
import DAO.UsersDAOImpl;

import java.util.List;

public class ServiceImpl implements Service{

    /**@param userName username
     * @param password password
     * @return User object or null if creds invalid
     */
    @Override
    public User logIn(String userName, String password) {
        UsersDAO userDAO= new UsersDAOImpl();
        List<String> info= userDAO.logIn(userName);

        if(info==null){
            return null;
        }
        if(!password.equals(info.get(0))) {
            //log invalid login
            return null;
        }

        return new User(Integer.parseInt(info.get(5)), info.get(1),
                info.get(3), info.get(2));
    }

    /**@param user current user
     * @return list of all ReimbTickets user has access to view
     */
    @Override
    public List<ReimbTicket> getTicketList(User user) {
        ReimbDAO reimbDAO= new ReimbDAOImpl();

        if(user.getRole().equals("Manager")){
            return reimbDAO.getTicketList();
        }
        if(user.getRole().equals("Employee")){
            return reimbDAO.getTicketList(user.getUserID());
        }
        //log error
        return null;
    }

    /**@param ticket ticket to be added
     * @return true if added
     */
    @Override
    public boolean createNewTicket(User user, ReimbTicket ticket) {
        ReimbDAO reimbDAO= new ReimbDAOImpl();
        return reimbDAO.addNewTicket(user.getUserID(), ticket);
    }

    /**@param ticket ticket to be decided
     * @param user current user
     * @return true if successfully updated
     */
    @Override
    public boolean decideTicket(User user, ReimbTicket ticket) {
        ReimbDAO reimbDAO= new ReimbDAOImpl();
        return reimbDAO.updateTicket(ticket.getTicketID(), user.getUserID(), ticket.getStatus());
    }

    /**@param id ticket id
     * @return ticket with associated ID
     */
    @Override
    public ReimbTicket getTicketByID(int id){
        ReimbDAO reimbDAO= new ReimbDAOImpl();
        return reimbDAO.getTicketByID(id);
    }
}
