package model.dao.mapper;

import model.entity.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TimeZone;

public class EventMapper implements ObjectMapper<Event> {


    @Override
    public Event extractFromResultSet(ResultSet rs) throws SQLException {
        Event event = new Event();

        event.setId(rs.getInt("idevent"));
        event.setName(rs.getString("event.name"));

        LocalDateTime localDateTime = LocalDateTime.of(rs.getDate("time").toLocalDate(),
                rs.getTime("time").toLocalTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

        event.setDateTime(localDateTime.format(formatter));
        event.setLocation(rs.getString("location"));

        return event;
    }

    @Override
    public Event makeUnique(Map<Integer, Event> existing, Event entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
