package com.ss.uto.dao.bookings;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.bookings.BookingPayment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {
    public BookingPaymentDAO(Connection conn) {
        super(conn);
    }


    public void addBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
        save("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?,?,?)",
                new Object[] { payment.getBooking().getId(), payment.getStripeId(), payment.getRefunded() });
    }

    public void updateBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
        save("UPDATE booking_payment SET stripe_id = ?, refunded = ? WHERE booking_id = ?",
                new Object[] {payment.getStripeId(), payment.getRefunded(), payment.getBooking().getId() });
    }

    public void deleteBookingPayment(BookingPayment payment) throws ClassNotFoundException, SQLException {
        save("DELETE FROM booking_payment where booking_id = ?", new Object[] { payment.getBooking().getId() });
    }

    public List<BookingPayment> getBookingPayments() throws ClassNotFoundException, SQLException {
        return read("select * from booking_payment", null);
    }

    @Override
    public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<BookingPayment> payments = new ArrayList<>();
        BookingDAO bookingDAO = new BookingDAO(conn);
        while(rs.next()) {
            Booking booking = bookingDAO.getBookingById(rs.getInt("booking_id"));
            String stripe = rs.getString("stripe_id");
            Boolean refunded = rs.getBoolean("refunded");
            payments.add(new BookingPayment(booking, stripe, refunded));

        }
        return payments;
    }

}
