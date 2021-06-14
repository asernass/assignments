package com.ss.uto.dao.flights;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.Flight;
import com.ss.uto.entity.flights.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends BaseDAO<Flight> {

    public FlightDAO(Connection conn) {
        super(conn);
    }

    public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
        Integer keyId = saveWithPk("INSERT INTO flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?,?,?,?,?)",
                new Object[] { flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice() });
        flight.setId(keyId);
    }

    public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
        save("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
                flight.getRoute().getId(), flight.getAirplane().getId(), flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
    }

    public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
        save("DELETE FROM flight WHERE id = ?", new Object[] { flight.getId() });
    }

    public List<Flight> getFlights() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM flight", null);
    }

    public Flight getFlightById(Integer id) throws SQLException, ClassNotFoundException {
        List<Flight> results = read("SELECT * FROM flight WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Flight> flights = new ArrayList<>();
        RouteDAO routeDAO = new RouteDAO(conn);
        AirplaneDAO airplaneDAO = new AirplaneDAO(conn);
        while (rs.next()) {
            Integer id = rs.getInt("id");
            LocalDateTime time = rs.getTimestamp("departure_time").toLocalDateTime();
            Integer reserved = rs.getInt("reserved_seats");
            Float price = rs.getFloat("seat_price");
            Route route = routeDAO.getRouteById(rs.getInt("route_id"));
            Airplane airplane = airplaneDAO.getAirPlaneById(rs.getInt("airplane_id"));
            flights.add(new Flight(id, route, airplane, time, reserved, price));
        }
        return flights;
    }
}
