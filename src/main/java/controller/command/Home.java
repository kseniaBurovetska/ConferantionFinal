package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Home implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        Optional<Object> role = Optional.ofNullable(request.getSession().getAttribute("role"));

        return role.map(o -> "redirect:"+o.toString().toLowerCase()).orElse("redirect:login");

    }
}
