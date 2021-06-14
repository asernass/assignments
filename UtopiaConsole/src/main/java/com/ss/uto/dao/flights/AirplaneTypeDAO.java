package com.ss.uto.dao.flights;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.flights.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {
    public AirplaneTypeDAO(Connection conn) {
        super(conn);
    }

    public void addAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
        Integer keyId = saveWithPk("INSERT INTO airplane_type (max_capacity) VALUES (?)",
                new Object[] { type.getMaxCapacity() });
        type.setAirplaneCode(keyId);
    }

    public void updateAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
        save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?",
                new Object[] {type.getMaxCapacity(), type.getAirplaneCode() });
    }

    public void deleteAirplaneType(AirplaneType type) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airplane_type WHERE id = ?", new Object[] { type.getAirplaneCode() });
    }

    public List<AirplaneType> getAirplaneTypes() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airplane_type", null);
    }

    public AirplaneType getAirplaneTypeById(Integer id) throws SQLException, ClassNotFoundException {
        List<AirplaneType> results = read("SELECT * FROM airplane_type WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<AirplaneType> types = new ArrayList<>();
        while(rs.next()) {
            Integer id = rs.getInt("id");
            Integer max = rs.getInt("max_capacity");
            types.add(new AirplaneType(id, max));
        }
        return types;
    }
}
