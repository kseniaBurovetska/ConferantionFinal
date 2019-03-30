package controller.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute("role", "");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        httpSessionEvent.getSession().setAttribute("role", "");
    }
}
