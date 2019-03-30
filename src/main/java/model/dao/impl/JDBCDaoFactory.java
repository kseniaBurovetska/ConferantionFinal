package model.dao.impl;

import model.dao.DaoFactory;
import model.dao.EventDao;
import model.dao.LectureDao;
import model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public EventDao createEventDao() {
        return new JDBCEventFactory(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new JDBCUserFactory(getConnection());
    }

    @Override
    public LectureDao createLectureDao() {
        return new JDBCLectureFactory(getConnection());
    }

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
