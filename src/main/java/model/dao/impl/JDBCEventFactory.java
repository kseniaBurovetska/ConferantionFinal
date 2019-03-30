package model.dao.impl;

import model.dao.DaoFactory;
import model.dao.EventDao;
import model.dao.mapper.EventMapper;
import model.entity.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCEventFactory implements EventDao {

    private Connection connection;

    public JDBCEventFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Event entity) {

    }

    @Override
    public Event findById(int id) {
       return null;
    }

    @Override
    public List<Event> findAll() {
        Map<Integer, Event> events = new HashMap<>();

        final String query = "select * from event";

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            EventMapper eventMapper = new EventMapper();

            while(rs.next()) {
                Event event = eventMapper.extractFromResultSet(rs);
                event = eventMapper.makeUnique(events, event);
            }

            return new ArrayList<>(events.values());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Event event) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
            System.out.println("closing event dao");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
