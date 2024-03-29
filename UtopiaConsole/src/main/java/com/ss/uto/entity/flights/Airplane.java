package com.ss.uto.entity.flights;

public class Airplane {
    private Integer id;
    private AirplaneType type;

    public Airplane(Integer id, AirplaneType type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
