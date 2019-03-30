package model.dao.mapper;

import model.entity.Lecture;
import model.entity.enums.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LectureMapper implements ObjectMapper<Lecture> {

    @Override
    public Lecture extractFromResultSet(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();

        lecture.setId(rs.getInt("idlecture"));
        lecture.setTopic(rs.getString("topic"));
        lecture.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));

        return lecture;
    }

    @Override
    public Lecture makeUnique(Map<Integer, Lecture> existing, Lecture entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
