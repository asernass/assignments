package com.ss.uto.dao.flights;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.Airport;
import com.ss.uto.entity.flights.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO extends BaseDAO<Route> {
    public RouteDAO(Connection conn) {
        super(conn);
    }

    public void addRoute(Route route) throws ClassNotFoundException, SQLException {
        Integer keyId = saveWithPk("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)",
                new Object[] { route.getOrigin().getAirportCode(), route.getDestination().getAirportCode() });
        route.setId(keyId);
    }

    public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
        save("UPDATE route SET origin_id = ?, destination_id = ? WHERE id = ?", new Object[] {
                route.getOrigin().getAirportCode(), route.getDestination().getAirportCode(), route.getId() });
    }

    public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
        save("DELETE FROM route WHERE id = ?", new Object[] { route.getId() });
    }

    public List<Route> getRoutes() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM route", null);
    }

    public Route getRouteById(Integer id) throws SQLException, ClassNotFoundException {
        List<Route> results = read("SELECT * FROM route WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    public List<Route> getRoutesByAirport(String airportCode) throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM route WHERE origin_id = ? OR destination_id = ?",
                new Object[] {airportCode, airportCode});
    }

    @Override
    public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Route> routes = new ArrayList<>();
        AirportDAO airportDAO = new AirportDAO(conn);
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Airport origin = airportDAO.getAirportByCodeId(rs.getString("origin_id"));
            Airport destination = airportDAO.getAirportByCodeId(rs.getString("destination_id"));
            if (origin !=null && destination !=null) {
                routes.add(new Route(id, origin, destination));
            }
        }
        return routes;
    }
}
