package com.ss.uto.dao.user;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.user.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO extends BaseDAO<UserRole> {

    public UserRoleDAO(Connection conn) {
        super(conn);
    }

    public void addUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
        Integer keyId = saveWithPk("INSERT INTO user_role (name) VALUES (?)",
                new Object[] {userRole.getRoleName()});
        userRole.setRoleID(keyId);
    }

    public void updateUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
        save("UPDATE user_role SET name = ? WHERE id = ?",
                new Object[] {userRole.getRoleName(), userRole.getRoleID()});
    }

    public void deleteUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
        save("DELETE FROM user_role WHERE id = ?",
                new Object[] {userRole.getRoleID()});
    }

    public List<UserRole> getUserRoles() throws SQLException, ClassNotFoundException {
        return read("SELECT * from user_role", null);
    }

    public UserRole getUserRoleById(Integer id) throws SQLException, ClassNotFoundException {
        List<UserRole> result = read("SELECT * FROM user_role where id = ?", new Object[] {id});
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<UserRole> roles = new ArrayList<>();
        while (rs.next()) {
            Integer roleId = rs.getInt("id");
            String role = rs.getString("name");
            roles.add(new UserRole(roleId, role));
        }
        return roles;
    }
}
