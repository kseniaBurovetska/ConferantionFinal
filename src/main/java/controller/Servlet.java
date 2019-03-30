package controller;

import controller.command.*;
import model.service.EventService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class Servlet extends HttpServlet {

    private HashMap<String, Command> commands = new HashMap<String, Command>();

    @Override
    public void init() throws ServletException {
        EventService eventService = new EventService();
        getServletContext().setAttribute("events", eventService.getAllEvents());

        commands.put("viewAll", new ViewAll());
        commands.put("registration", new Registration());
        commands.put("login", new Login());

        commands.put("moderator", new Moderator());
        commands.put("speaker", new Speaker());
        commands.put("visitor", new Visitor());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = (req.getParameter("firstName"));
        String lastName = (req.getParameter("lastName"));
        String login = (req.getParameter("regLogin"));
        String email = (req.getParameter("email"));

        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String path = req.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        Command command = commands.getOrDefault(path, new Login());

        System.out.println(path);

        String page = command.execute(req);
        if (page.contains("redirect")) {
            resp.sendRedirect(page.replace("redirect:", ""));
            System.out.println(page.replace("redirect:", ""));
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }

}
