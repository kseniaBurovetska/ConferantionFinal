package model.dao.mapper;

import model.entity.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EventMapper implements ObjectMapper<Event> {


    @Override
    public Event extractFromResultSet(ResultSet rs) throws SQLException {
        Event event = new Event();

        event.setId(rs.getInt("idevent"));
        event.setName(rs.getString("event.name"));
        event.setDateTime(rs.getTime("time"));
        event.setLocation(rs.getString("location"));

        return event;
    }

    @Override
    public Event makeUnique(Map<Integer, Event> existing, Event entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
