package com.ss.uto.dao.bookings;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.bookings.Passenger;
import com.ss.uto.entity.flights.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO extends BaseDAO<Passenger> {
    public PassengerDAO(Connection conn) {
        super(conn);
    }

    public void addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
        Integer keyId = saveWithPk("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?,?,?,?,?,?)",
                new Object[] { passenger.getBooking().getId(), passenger.getGivenName(), passenger.getFamilyName(), passenger.getDob(),
                        passenger.getGender(), passenger.getAddress() });
        passenger.setId(keyId);
    }

    public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
        save("UPDATE passenger SET booking_id = ?, given_name = ?, family_name= ?, dob = ?, gender = ?, address = ? WHERE id = ?",
                new Object[] { passenger.getBooking().getId(), passenger.getGivenName(), passenger.getFamilyName(), passenger.getDob(),
                        passenger.getGender(), passenger.getAddress(), passenger.getId() });
    }

    public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
        save("DELETE FROM passenger WHERE id = ?", new Object[] { passenger.getId() });
    }

    public List<Passenger> getPassengers() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM passenger", null);
    }

    public Passenger getPassengerById(Integer id) throws SQLException, ClassNotFoundException {
        List<Passenger> results = read("SELECT * FROM flight WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Passenger> passengers = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO(conn);
        while (rs.next()) {

            Integer id = rs.getInt("id");
            Booking booking = bookingDAO.getBookingById(rs.getInt("booking_id"));
            String address = rs.getString("address");
            String lastName = rs.getString("family_name");
            String firstName = rs.getString("given_name");
            LocalDate dob = rs.getDate("dob").toLocalDate();
            String gender = rs.getString("gender");

            passengers.add(new Passenger(id, booking, firstName, lastName, dob, gender, address));
        }
        return passengers;
    }
}
