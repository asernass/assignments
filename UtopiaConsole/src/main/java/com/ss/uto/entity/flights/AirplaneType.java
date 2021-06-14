package com.ss.uto.entity.flights;

public class AirplaneType {
    private Integer airplaneCode;
    private Integer maxCapacity;

    public AirplaneType(Integer airplaneCode, Integer maxCapacity) {
        this.airplaneCode = airplaneCode;
        this.maxCapacity = maxCapacity;
    }

    public Integer getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(Integer airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "AirplaneType{" +
                "airplaneCode=" + airplaneCode +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
