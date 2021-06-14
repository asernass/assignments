package com.ss.uto.entity.bookings;

public class Booking {
    private Integer id;
    private Boolean isActive;
    private String confirmationCode;

    public Booking(Integer id, Boolean isActive, String confirmationCode) {
        this.id = id;
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", confirmationCode='" + confirmationCode + '\'' +
                '}';
    }
}
