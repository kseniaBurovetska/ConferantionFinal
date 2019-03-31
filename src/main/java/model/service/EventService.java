package model.service;

import model.dao.DaoFactory;
import model.dao.EventDao;
import model.entity.Event;

import java.util.List;

public class EventService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    /*public List<Event> getAllEvents() {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findAll();
        }

    }*/

    public List<Event> getUpcomingEvents(){
        try (EventDao dao = daoFactory.createEventDao()){
            return dao.getUpcomingEvents();
        }
    }

}
