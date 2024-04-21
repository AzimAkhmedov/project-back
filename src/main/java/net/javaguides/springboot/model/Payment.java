package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentID;
    @Column(name = "recipientID")
    private long recipientID;
    @Column(name = "senderID")
    private long senderID;
    @Column(name = "date")
    private String date;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Column(name = "amount")
    private int amount;

    public Payment() {
    }

    public Payment(long recipientID, long senderID, String date, String paymentStatus, int amount){
        super();
    }

    public Payment(long paymentID, long recipientID, long senderID, String date, String paymentStatus, int amount) {
        this.paymentID = paymentID;
        this.recipientID = recipientID;
        this.senderID = senderID;
        this.date = date;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public long getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(long recipientID) {
        this.recipientID = recipientID;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(long senderID) {
        this.senderID = senderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
