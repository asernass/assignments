package com.ss.uto.entity.flights;

import java.time.LocalDateTime;

public class Flight {
    private Integer id;
    private Route route;
    private Airplane airplane;
    private LocalDateTime departureTime;
    private Integer reservedSeats;
    private Float seatPrice;

    public Flight(Integer id, Route route, Airplane airplane, LocalDateTime departureTime, Integer reservedSeats, Float seatPrice) {
        this.id = id;
        this.route = route;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.reservedSeats = reservedSeats;
        this.seatPrice = seatPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(Float seatPrice) {
        this.seatPrice = seatPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", route=" + route +
                ", airplane=" + airplane +
                ", departureTime=" + departureTime +
                ", reservedSeats=" + reservedSeats +
                ", seatPrice=" + seatPrice +
                '}';
    }
}
