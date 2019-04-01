package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Optional;

public class Logout implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        Optional<Object> email = Optional.ofNullable(request.getSession().getAttribute("email"));

        email.ifPresent(e -> CommandUtility.unlogUser(request, e.toString()));

        return "redirect:login";
    }
}
