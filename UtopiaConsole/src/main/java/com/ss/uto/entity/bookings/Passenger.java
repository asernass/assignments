package com.ss.uto.entity.bookings;

import java.time.LocalDate;
import java.util.Locale;

public class Passenger {
    private Integer id;
    private Booking booking;
    private String givenName;
    private String familyName;
    private LocalDate dob;
    private String gender;
    private String address;

    public Passenger(Integer id, Booking booking, String givenName, String familyName, LocalDate dob, String gender, String address) {
        this.id = id;
        this.booking = booking;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", booking=" + booking +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
