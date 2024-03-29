package com.ss.uto.service;

import com.ss.uto.dao.bookings.BookingDAO;
import com.ss.uto.dao.bookings.BookingUserDAO;
import com.ss.uto.dao.bookings.FlightBookingsDAO;
import com.ss.uto.dao.bookings.PassengerDAO;
import com.ss.uto.dao.flights.AirplaneDAO;
import com.ss.uto.dao.flights.AirportDAO;
import com.ss.uto.dao.flights.FlightDAO;
import com.ss.uto.dao.flights.RouteDAO;
import com.ss.uto.dao.user.UserDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.bookings.BookingUser;
import com.ss.uto.entity.bookings.FlightBookings;
import com.ss.uto.entity.bookings.Passenger;
import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.Airport;
import com.ss.uto.entity.flights.Flight;
import com.ss.uto.entity.flights.Route;
import com.ss.uto.entity.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    ConnectionUtil connectionUtil = new ConnectionUtil();

    public User validateTraveler(Integer id) {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            User user = userDAO.getUserById(id);
            if (user == null) {
                return null;
            } else if (!user.getRole().getRoleName().equals("Traveller")) {
                return null;
            } else {
                return user;
            }
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<User> getAllTravelers() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            return userDAO.getUsers().stream().filter(user -> user.getRole().getRoleID() == 3).collect(Collectors.toList());
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public void addFlight(Flight flight) {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            flightDAO.addFlight(flight);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List<Route> getAllRoutes() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            RouteDAO routeDAO = new RouteDAO(conn);
            return routeDAO.getRoutes();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Airplane> getAllAirplanes() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            AirplaneDAO airplaneDAO = new AirplaneDAO(conn);
            return airplaneDAO.getAirplanes();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Passenger> getAllPassengers() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            PassengerDAO passengerDAO = new PassengerDAO(conn);
            return passengerDAO.getPassengers();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Booking> getAllBookings() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
             BookingDAO bookingDAO = new BookingDAO(conn);
            return bookingDAO.getBookings();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Airport> getAllAirports() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            AirportDAO airportDAO = new AirportDAO(conn);
            return airportDAO.getAirports();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Flight> getAllFlights() {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            FlightDAO flightDAO = new FlightDAO(conn);
            return flightDAO.getFlights();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Flight> flightsAvailable() {
        return getAllFlights().stream().filter(flight -> flight.getAirplane().getType().getMaxCapacity()
        - flight.getReservedSeats() > 0).collect(Collectors.toList());
    }

    public void addBookingToUser(Flight flight, User user) {
        Connection conn = null;
        try {
            flight.setReservedSeats(flight.getReservedSeats() + 1);
            conn = connectionUtil.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            FlightBookingsDAO flightBookingsDAO  = new FlightBookingsDAO(conn);
            BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
            Booking booking = new Booking(0, true, "Conf" + (int) (Math.random() * 99999 + 1));
            bookingDAO.addBooking(booking);
            BookingUser bookingUser = new BookingUser(booking, user);
            bookingUserDAO.addBookingUser(bookingUser);
            FlightBookings flightBookings = new FlightBookings(booking, flight);
            flightBookingsDAO.addFlightBooking(flightBookings);

            //update flight table
            FlightDAO flightDAO = new FlightDAO(conn);
            flightDAO.updateFlight(flight);
            conn.commit();
        } catch (Exception e) {
            System.out.println("Could not add Booking, rollBack");
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List<Booking> getBookingsOfUser(User user) {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            return bookingDAO.getBookingsByUser(user);
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public void deleteBooking(Booking booking) {
        Connection conn = null;
        try {
            conn = connectionUtil.getConnection();
            BookingDAO bookingDAO = new BookingDAO(conn);
            bookingDAO.deleteBooking(booking);
            conn.commit();
        } catch (Exception e) {
            System.out.println("Could not delete.");
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
