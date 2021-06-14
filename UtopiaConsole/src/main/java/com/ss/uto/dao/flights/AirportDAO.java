package com.ss.uto.dao.flights;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.Airport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO extends BaseDAO<Airport> {
    public AirportDAO(Connection conn) {
        super(conn);
    }

    public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
        save("INSERT INTO airport (iata_id, city) VALUES (?, ?)",
                new Object[] { airport.getAirportCode(), airport.getCity() });
    }

    public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
        save("UPDATE airport SET city = ? WHERE iata_id = ?", new Object[] {
                airport.getCity(), airport.getAirportCode() });
    }

    public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airport where iata_id = ?", new Object[] { airport.getAirportCode() });
    }

    public List<Airport> getAirports() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airport", null);
    }

    public Airport getAirportByCodeId(String id) throws SQLException, ClassNotFoundException {
        List<Airport> results = read("SELECT * FROM airport WHERE iata_id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<Airport> airports = new ArrayList<>();
        while(rs.next()) {
            String airportCode = rs.getString("iata_id");
            String city = rs.getString("city");
            airports.add(new Airport(airportCode, city));
        }
        return airports;
    }
}
