package com.ss.uto.entity.bookings;

import com.ss.uto.entity.flights.Flight;

public class FlightBookings {
    private Booking booking;
    private Flight flight;

    public FlightBookings(Booking booking, Flight flight) {
        this.booking = booking;
        this.flight = flight;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightBookings{" +
                "booking=" + booking +
                ", flight=" + flight +
                '}';
    }
}
