package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class Logout implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        String email = (String)request.getSession().getAttribute("email");

        if(email != null){
            HashSet<String> loggedUsers = (HashSet<String>)
                    request.getSession().getServletContext().getAttribute("loggedUsers");

            loggedUsers.remove(email);
            request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);
        }

        return "redirect:login";
    }
}
