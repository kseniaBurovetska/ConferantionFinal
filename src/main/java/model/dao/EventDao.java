package model.dao;

import model.entity.Event;

import java.util.List;

public interface EventDao extends GenericDao<Event> {

    List<Event> getUpcomingEvents();

}
