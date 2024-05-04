package net.javaguides.springboot.model;
import jakarta.persistence.*;
@Entity
@Table(name = "payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;
    @Column(name = "sender_id")
    private long sender_id;
    @Column (name = "recipient_id")
    private long recipient_id;
    @Column(name = "date")
    private String date;
    @Column(name = "payment_status")
    private String payment_status;
    @Column(name = "amount")
    private int amount;

    public Payment() {
    }

    public Payment(long recipientID, long senderID, String date, String paymentStatus, int amount){
        super();
    }

    public Payment(long payment_id, long recipient_id, long sender_id, String date, String payment_status, int amount) {
        this.payment_id = payment_id;
        this.recipient_id = recipient_id;
        this.sender_id = sender_id;
        this.date = date;
        this.payment_status = payment_status;
        this.amount = amount;
    }

    public long getRecipientID() {
        return recipient_id;
    }

    public void setRecipientID(long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public long getSenderID() {
        return sender_id;
    }

    public void setSenderID(long sender_id) {
        this.sender_id = sender_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentStatus() {
        return payment_status;
    }

    public void setPaymentStatus(String payment_status) {
        this.payment_status = payment_status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
