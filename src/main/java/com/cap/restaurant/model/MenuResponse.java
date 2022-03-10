package com.cap.restaurant.model;

import java.util.List;

public class MenuResponse {

    private String status;
    private String sentOn;
    private String statusCode;
    private String transactionID;
    private String msg;
    private List<Menu> resValues;

    public MenuResponse(String status, String sentOn, String statusCode, String transactionID, String msg, List<Menu> resValues) {
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

    public List<Menu> getResValues() {
        return resValues;
    }

    public void setResValues(List<Menu> resValues) {
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
        MenuResponse menuResponse = (MenuResponse) o;
        return status.equals(menuResponse.status) && sentOn.equals(menuResponse.sentOn) && statusCode.equals(menuResponse.statusCode) && transactionID.equals(menuResponse.transactionID) && msg.equals(menuResponse.msg) && resValues.equals(menuResponse.resValues);
    }

}
