package model.dao.impl;

import model.dao.UserDao;
import model.dao.mapper.UserMapper;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCUserFactory implements UserDao {

    private Connection connection;

    public JDBCUserFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> result = Optional.empty();

        String query = "SELECT * FROM user WHERE email = ?";

        try(PreparedStatement ps = connection.prepareCall(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            UserMapper userMapper = new UserMapper();

            if (rs.next()) {
                result = Optional.of(userMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
