package model.dao.impl;

import model.dao.LectureDao;
import model.entity.Lecture;

import java.sql.Connection;
import java.util.List;

public class JDBCLectureFactory implements LectureDao {

    private Connection connection;

    public JDBCLectureFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Lecture entity) {

    }

    @Override
    public Lecture findById(int id) {
        return null;
    }

    @Override
    public List<Lecture> findAll() {
        return null;
    }

    @Override
    public void update(Lecture lecture) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
