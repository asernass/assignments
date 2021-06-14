package com.ss.uto.dao.bookings;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.dao.flights.FlightDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.bookings.FlightBookings;
import com.ss.uto.entity.bookings.Passenger;
import com.ss.uto.entity.flights.Flight;
import com.ss.uto.entity.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingsDAO extends BaseDAO<FlightBookings> {
    public FlightBookingsDAO(Connection conn) {
        super(conn);
    }

    public void addFlightBooking(FlightBookings fb) throws ClassNotFoundException, SQLException {
        save("INSERT INTO flight_bookings (flight_id, booking_id) values (?,?)",
                new Object[] { fb.getFlight().getId(), fb.getBooking().getId() });
    }

    public void deleteFlightBooking(FlightBookings fb) throws ClassNotFoundException, SQLException {
        save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?",
                new Object[] { fb.getFlight().getId(), fb.getBooking().getId() });
    }

    public List<FlightBookings> getBookingUsers() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM flight_bookings", null);
    }


    @Override
    public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<FlightBookings> bookings = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO(conn);
        FlightDAO flightDAO = new FlightDAO(conn);
        while (rs.next()) {
            Booking booking = bookingDAO.getBookingById(rs.getInt("booking_id"));
            Flight flight = flightDAO.getFlightById(rs.getInt("flight_id"));
            bookings.add(new FlightBookings(booking, flight));
        }
        return bookings;
    }
}
