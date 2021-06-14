package com.ss.uto.dao.bookings;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends BaseDAO<Booking> {

    public BookingDAO(Connection conn) {
        super(conn);
    }

    public void addBooking(Booking booking) throws SQLException, ClassNotFoundException {
        Integer keyId = saveWithPk("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
                new Object[] {booking.getActive(), booking.getConfirmationCode()});
        booking.setId(keyId);
    }

    public void updateBooking(Booking booking) throws SQLException, ClassNotFoundException {
        save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?",
                new Object[] {booking.getActive(), booking.getConfirmationCode(), booking.getId()});
    }

    public List<Booking> getBookings() throws SQLException, ClassNotFoundException {
        return read("SELECT * FROM booking", null);
    }

    public Booking getBookingById(Integer id) throws SQLException, ClassNotFoundException {
        List<Booking> results = read("SELECT * FROM booking WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    public List<Booking> getBookingsByUser(User user) throws SQLException, ClassNotFoundException {
         return read("SELECT * FROM booking WHERE id IN (SELECT " +
                "booking_id FROM booking_user WHERE user_id = ?)", new Object[] {user.getId()});
    }

    public void deleteBooking(Booking booking) throws SQLException, ClassNotFoundException {
        save("DELETE FROM booking WHERE id = ?",
                new Object[] {booking.getId()});
    }

    @Override
    public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Boolean isActive = rs.getBoolean("is_active");
            String confCode = rs.getString("confirmation_code");
            bookings.add(new Booking(id, isActive, confCode));
        }
        return bookings;
    }
}
