package com.ss.uto.entity.bookings;

import com.ss.uto.entity.user.User;

public class BookingUser {
    private Booking booking;
    private User user;

    public BookingUser(Booking booking, User user) {
        this.booking = booking;
        this.user = user;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookingUser{" +
                "booking=" + booking +
                ", user=" + user +
                '}';
    }
}
