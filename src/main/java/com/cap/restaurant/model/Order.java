package com.cap.restaurant.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "orders_rv")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dish_id", nullable = false)
    private Integer dishID;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "client_address", nullable = false)
    private String clientAddress;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "alteration_date", nullable = false)
    private Date alterationDate;

    @PrePersist
    public void onCreate(){
        status = "ORDER_CREATED";
        creationDate = new Date();
        alterationDate = new Date();
    }

    public Date getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(Date alterationDate) {
        this.alterationDate = alterationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDishID() {
        return dishID;
    }

    public void setDishID(Integer dishID) {
        this.dishID = dishID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}