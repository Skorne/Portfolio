package Models;

import java.sql.Time;
import java.sql.Timestamp;

public class ReimbTicket {
    private int ticketID;
    private double amount;
    private String submitTime;
    private String resolveTime;
    private String description;
    private String author;
    private String resolvedBy;
    private String status;
    private String reimbType;

    public ReimbTicket(int ticketID, double amount, String submitTime, String resolveTime, String description,
                       String author, String resolvedBy, String status, String reimbType) {
        this.ticketID = ticketID;
        this.amount = amount;
        this.submitTime = submitTime;
        this.resolveTime = resolveTime;
        this.description = description;
        this.author = author;
        this.resolvedBy = resolvedBy;
        this.status = status;
        this.reimbType = reimbType;
    }

    public ReimbTicket(double amount, String description, String reimbType) {
        this.amount = amount;
        this.description = description;
        this.reimbType = reimbType;
    }

    public ReimbTicket() {
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public void setResolveTime(String resolveTime) {
        this.resolveTime = resolveTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public String getResolveTime() {
        return resolveTime;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public int getTicketID(){
        return ticketID;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTicketID(int id) {this.ticketID=id;}

    @Override
    public String toString() {
        return "ReimbTicket{" +
                "ticketID=" + ticketID +
                ", amount=" + amount +
                ", submitTime=" + submitTime +
                ", resolveTime=" + resolveTime +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", resolvedBy='" + resolvedBy + '\'' +
                ", status='" + status + '\'' +
                ", reimbType='" + reimbType + "'" +
                "}\n";

    }
}
