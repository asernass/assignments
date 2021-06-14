package com.ss.uto.dao.bookings;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.dao.user.UserDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.bookings.BookingUser;
import com.ss.uto.entity.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingUserDAO extends BaseDAO<BookingUser> {

    public BookingUserDAO(Connection conn) {
        super(conn);
    }

    public void addBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
        save("INSERT INTO booking_user VALUES (?, ?)",
                new Object[] {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
    }

    public void updateBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
        save("UPDATE booking_user SET booking_id = ? WHERE user_id = ?",
                new Object[] {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
    }

    public List<BookingUser> getBookingUsers() throws SQLException, ClassNotFoundException {
        return read("SELECT * FROM booking_user", null);
    }

    public List<BookingUser> getBookingUserByUser(User user) throws SQLException, ClassNotFoundException {
        return read("SELECT * FROM booking_user WHERE user_id = ?",
                new Object[] {user.getId()});
    }

    public void deleteBookingUser(BookingUser bookingUser) throws SQLException, ClassNotFoundException {
        save("DELETE FROM booking_user WHERE user_id = ?",
                new Object[] {bookingUser.getUser().getId()});
    }

    @Override
    public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingUser> bookingUsers = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO(conn);
        UserDAO userDAO = new UserDAO(conn);
        while (rs.next()) {
            Booking booking = bookingDAO.getBookingById(rs.getInt("booking_id"));
            User user = userDAO.getUserById(rs.getInt("user_id"));
            if (user != null && booking != null) {
                bookingUsers.add(new BookingUser(booking, user));
            }
        }
        return bookingUsers;
    }
}
