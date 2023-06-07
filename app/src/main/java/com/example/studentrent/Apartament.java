package com.example.studentrent;

import java.io.Serializable;

public class Apartament implements Serializable {
    String address;
    String m2Size;
    String bedrooms;
    String contactPhoneNumber;
    String contactEmail;
    String prize;

    String comments;

    public static class piso {
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getM2Size() {
        return m2Size;
    }

    public void setM2Size(String m2Size) {
        this.m2Size = m2Size;
    }


    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}