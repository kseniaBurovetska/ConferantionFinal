package controller.command;

import model.entity.enums.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class CommandUtility {

    static void setUserLogged(HttpServletRequest request, Role role, String email) {
        HttpSession session = request.getSession();
        //ServletContext context = request.getServletContext();

        session.setAttribute("email", email);
        session.setAttribute("role", role);
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String email){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(email::equals)){
            return true;
        }

        loggedUsers.add(email);
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

        return false;
    }
}
