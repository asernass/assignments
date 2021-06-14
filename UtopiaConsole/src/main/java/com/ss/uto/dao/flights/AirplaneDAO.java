package com.ss.uto.dao.flights;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO extends BaseDAO<Airplane> {
    public AirplaneDAO(Connection conn) {
        super(conn);
    }

    public void addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
        Integer keyId = saveWithPk("INSERT INTO airplane (type_id) VALUES (?)",
                new Object[] { airplane.getType().getAirplaneCode() });
        airplane.setId(keyId);
    }

    public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
        save("UPDATE airplane SET type_id = ? WHERE id = ?", new Object[] {
                airplane.getType().getAirplaneCode(), airplane.getId() });
    }

    public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
        save("DELETE FROM airplane WHERE id = ?", new Object[] { airplane.getId() });
    }

    public List<Airplane> getAirplanes() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM airplane", null);
    }

    public Airplane getAirPlaneById(Integer id) throws SQLException, ClassNotFoundException {
        List<Airplane> results = read("SELECT * FROM airplane WHERE id = ?",
                new Object[] {id});
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {

        List<Airplane> airplanes = new ArrayList<>();
        AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
        while(rs.next()) {
            Integer id =  rs.getInt("id");
            AirplaneType type = airplaneTypeDAO.getAirplaneTypeById(rs.getInt("type_id"));
            if (type !=null) {
                airplanes.add(new Airplane(id, type));
            }
        }
        return airplanes;

    }
}
