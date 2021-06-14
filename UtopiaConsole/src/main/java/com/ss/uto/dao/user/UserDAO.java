package com.ss.uto.dao.user;

import com.ss.uto.dao.BaseDAO;
import com.ss.uto.entity.user.User;
import com.ss.uto.entity.user.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    /**
     * Adds a User and updates key of the passed User
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addUser(User user) throws SQLException, ClassNotFoundException {
        Integer keyId = saveWithPk("INSERT INTO user (role_id, given_name," +
                        " family_name, username, email, password, phone) VALUES  (?, ?, ?, ?, ?, ?, ?)",
                        new Object[] { user.getRole().getRoleID(), user.getGivenName() , user.getFamilyMame(), user.getUsername(),
                            user.getEmail(), user.getPassword(), user.getPhone() });
        user.setId(keyId);
    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException {
        save("update user set role_id = ?, given_name = ?, family_name = ?, " +
                "username = ?, email = ?, password = ?, phone = ? where id = ?", new Object[] {user.getRole().getRoleID(),
                user.getGivenName(), user.getFamilyMame(), user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getId()});
    }

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        save("DELETE FROM user WHERE id = ?",
                new Object[] {user.getId()});
    }


    public List<User> getUsers() throws SQLException, ClassNotFoundException {
        return read("SELECT * from user", null);
    }

    public User getUserById(Integer id) throws SQLException, ClassNotFoundException {
        List<User> result = read("select * from user where id = ?", new Object[] {id});
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            UserRoleDAO getUserRole = new UserRoleDAO(conn);
            Integer id = rs.getInt("id");
            UserRole userRole = getUserRole.getUserRoleById(rs.getInt("role_id"));
            String givenName = rs.getString("given_name");
            String familyMame = rs.getString("family_name");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String phone = rs.getString("phone");
            users.add(new User(id, userRole, givenName, familyMame, username, email, password, phone));
        }
        return users;
    }
}
