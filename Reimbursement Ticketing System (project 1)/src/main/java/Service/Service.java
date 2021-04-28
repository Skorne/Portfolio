package Service;

import Models.ReimbTicket;
import Models.User;

import java.util.List;

public interface Service {
    public User logIn(String userName, String password);
    public List<ReimbTicket> getTicketList(User user);
    public boolean createNewTicket(User user, ReimbTicket ticket);
    public boolean decideTicket(User user, ReimbTicket ticket);
    public ReimbTicket getTicketByID(int id);
}
