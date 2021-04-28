package DAO;

import Models.ReimbTicket;

import java.util.List;

public interface ReimbDAO {
    public List<ReimbTicket> getTicketList(int userID);
    public List<ReimbTicket> getTicketList();
    public boolean addNewTicket(int userID, ReimbTicket ticket);
    public boolean updateTicket(int ticketID, int userID, String status);
    public ReimbTicket getTicketByID(int id);
}
