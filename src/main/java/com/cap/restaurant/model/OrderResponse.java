package com.cap.restaurant.model;

import java.util.List;

public class OrderResponse {

    private String status;
    private String sentOn;
    private String statusCode;
    private String transactionID;
    private String msg;
    private List<Order> resValues;

    public OrderResponse(String status, String sentOn, String statusCode, String transactionID, String msg, List<Order> resValues) {
        this.status = status;
        this.sentOn = sentOn;
        this.statusCode = statusCode;
        this.transactionID = transactionID;
        this.msg = msg;
        this.resValues = resValues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSentOn() {
        return sentOn;
    }

    public void setSentOn(String sentOn) {
        this.sentOn = sentOn;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Order> getResValues() {
        return resValues;
    }

    public void setResValues(List<Order> resValues) {
        this.resValues = resValues;
    }

    @Override
    public String toString() {
        return "MenuResponse{" +
                "status='" + status + '\'' +
                ", sentOn='" + sentOn + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", transactionID='" + transactionID + '\'' +
                ", msg='" + msg + '\'' +
                ", resValues=" + resValues +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResponse orderResponse = (OrderResponse) o;
        return status.equals(orderResponse.status) && sentOn.equals(orderResponse.sentOn) && statusCode.equals(orderResponse.statusCode) && transactionID.equals(orderResponse.transactionID) && msg.equals(orderResponse.msg) && resValues.equals(orderResponse.resValues);
    }

}
