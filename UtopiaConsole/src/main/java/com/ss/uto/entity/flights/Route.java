package com.ss.uto.entity.flights;

public class Route {
    private Integer id;
    private Airport origin, destination;

    public Route(Integer id, Airport origin, Airport destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
