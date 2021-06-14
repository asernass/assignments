package com.ss.uto.entity.bookings;

public class BookingPayment {
    private Booking booking;
    private String stripeId;
    private Boolean refunded;

    public BookingPayment(Booking booking, String stripeId, Boolean refunded) {
        this.booking = booking;
        this.stripeId = stripeId;
        this.refunded = refunded;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    @Override
    public String toString() {
        return "BookingPayment{" +
                "booking=" + booking +
                ", stripeId='" + stripeId + '\'' +
                ", refunded=" + refunded +
                '}';
    }
}
